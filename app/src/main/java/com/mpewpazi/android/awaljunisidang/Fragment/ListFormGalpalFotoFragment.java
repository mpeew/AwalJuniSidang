package com.mpewpazi.android.awaljunisidang.Fragment;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.mpewpazi.android.awaljunisidang.AndroidMultiPartEntity;
import com.mpewpazi.android.awaljunisidang.DataFetcher;
import com.mpewpazi.android.awaljunisidang.DataPusher;
import com.mpewpazi.android.awaljunisidang.DrawerFormActivity;
import com.mpewpazi.android.awaljunisidang.Form.FormGalpalFoto;
import com.mpewpazi.android.awaljunisidang.Form.SingleForm;
import com.mpewpazi.android.awaljunisidang.FormGalpalFotoPagerActivity;
import com.mpewpazi.android.awaljunisidang.R;
import com.mpewpazi.android.awaljunisidang.dummy.DummyMaker;
import com.mpewpazi.android.awaljunisidang.model.KualifikasiSurvey;
import com.mpewpazi.android.awaljunisidang.model.MenuCheckingGalpal;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mpewpazi on 6/2/16.
 */
public class ListFormGalpalFotoFragment extends SingleFragment {
    private final static String EXTRA_KUALIFIKASISURVEY_FORMGALPALFOTO="extra_kualifikasisurvey_form_galpal_foto";
    private final static String EXTRA_ID_FORMGALPALFOTO="extra_id_form_galpal_foto";
    private static final int REQUEST_SELECT_FILE=1;
    private static final int REQUEST_PHOTO=2;
    public static final int progress_bar_type = 0;
    private ProgressDialog pDialog;

    private List<FormGalpalFoto> mFormGalpalFotos;

    private RecyclerView mFormGalpalFotoRecyclerView;
    private FormGalpalFotoAdapter mAdapter;
    private DummyMaker mDummyMaker;

    private MenuCheckingGalpal mMenuCheckingGalpal;
    private KualifikasiSurvey mKualifikasiSurvey;
    private List<SingleForm> mGalpalForms;
    private Button mSubmitButton;

    private File mPhotoFile;
    private FormGalpalFoto mFormGalpalFoto;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

        mDummyMaker=DummyMaker.get(getContext());
        mKualifikasiSurvey=mDummyMaker.getKualifikasiSurvey(DrawerFormActivity.kualifikasiSurveyId);
        mGalpalForms=mDummyMaker.getGalpalForms();
        mMenuCheckingGalpal=mDummyMaker.getMenuCheckingGalpal(DrawerFormActivity.kualifikasiSurveyId,FormGalpalFoto.kode);
        mFormGalpalFotos=mDummyMaker.getFormGalpalFotos(DrawerFormActivity.kualifikasiSurveyId);
        new DownloadFileFromURL(mFormGalpalFotos).execute();



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_form_galpal_foto_list, container, false);
        if(mKualifikasiSurvey.getStatus()==1||mKualifikasiSurvey.getStatus()==3||mKualifikasiSurvey.getStatus()==4){
            setViewEnabledFalse(view);
        }

        mFormGalpalFotoRecyclerView = (RecyclerView) view.findViewById(R.id.form_galpal_foto_recycler_view);
        mSubmitButton=(Button)view.findViewById(R.id.galpal_foto_btn_submit);

        //recycler view butuh layoutmanager untuk mempossionig item di screen
        //ada banyak macam layout manager, kalau linear itu untuk vertikal posisioningnya
        //kedepanya ada gridLayoutManager
        mFormGalpalFotoRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));

        updateUI();

        if(mMenuCheckingGalpal.isComplete()){
            mSubmitButton.setText(R.string.belum_lengkap);
            mSubmitButton.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
        }
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mMenuCheckingGalpal.isComplete()){
                    mMenuCheckingGalpal.setComplete(true);
                    mKualifikasiSurvey.setProgress(mKualifikasiSurvey.getProgress()+100/mGalpalForms.size());
                    mSubmitButton.setText(R.string.belum_lengkap);
                    mSubmitButton.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
                }else{
                    mMenuCheckingGalpal.setComplete(false);
                    mKualifikasiSurvey.setProgress(mKualifikasiSurvey.getProgress()-100/mGalpalForms.size());
                    mSubmitButton.setText(R.string.lengkap);
                    mSubmitButton.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
                }

                mDummyMaker.addMenuCheckingGalpal(mMenuCheckingGalpal);
                mDummyMaker.addKualifikasiSurvey(mKualifikasiSurvey);
                mCustomClickListener.clickListener();



            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }


    private void updateUI() {
        mDummyMaker=DummyMaker.get(getActivity());
        mFormGalpalFotos=mDummyMaker.getFormGalpalFotos(DrawerFormActivity.kualifikasiSurveyId);
        mAdapter = new FormGalpalFotoAdapter(mFormGalpalFotos);
        mFormGalpalFotoRecyclerView.setAdapter(mAdapter);
        if(mFormGalpalFotos.size()>0){
            mMenuCheckingGalpal.setFill(true);
        }else{
            mMenuCheckingGalpal.setFill(false);
        }
        mDummyMaker.addMenuCheckingGalpal(mMenuCheckingGalpal);
        mCustomClickListener.clickListener();
    }


    private class FormGalpalFotoHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mJudulTextView;
        private ImageView mFotoImageView;
        private ImageButton mDeleteButton;

        private FormGalpalFoto mFormGalpalFoto;

        public void bindFormGalpalFoto(final FormGalpalFoto formGalpalFoto) {
            mFormGalpalFoto = formGalpalFoto;
            mJudulTextView.setText(mFormGalpalFoto.getNamaFoto());
            updatePhotoView(mFormGalpalFoto,mFotoImageView);
            if(mKualifikasiSurvey.getStatus()==1||mKualifikasiSurvey.getStatus()==3||mKualifikasiSurvey.getStatus()==4){
                mDeleteButton.setVisibility(View.GONE);
            }
            mDeleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder alertDialogBuilder=new AlertDialog.Builder(getActivity());
                    alertDialogBuilder.setMessage("Apakah anda yakin akan menghapus Foto Ini");

                    alertDialogBuilder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            DummyMaker.get(getActivity()).deleteFormGalpalFoto(formGalpalFoto);
                            updateUI();
                            new DeleteTask(formGalpalFoto.getFormServerId()).execute();
                        }
                    });
                    alertDialogBuilder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });

                    alertDialogBuilder.show();
                }
            });
        }

        public FormGalpalFotoHolder(View itemView) {
            //setiap ada yang masuk ke super , reference setiap wideget dibuat oleh parent
            super(itemView);
            itemView.setOnClickListener(this);

            mJudulTextView=(TextView)itemView.findViewById(R.id.list_item_galpal_foto_judul);
            mFotoImageView=(ImageView)itemView.findViewById(R.id.list_item_galpal_foto_image_view);
            mDeleteButton=(ImageButton) itemView.findViewById(R.id.list_item_galpal_foto_delete);
        }


        @Override
        public void onClick(View v) {
            Intent intent=new Intent(getActivity(),FormGalpalFotoPagerActivity.class);
            intent.putExtra(EXTRA_ID_FORMGALPALFOTO,mFormGalpalFoto.getIdFotoGalangan());
            Log.i("List",String.valueOf(mFormGalpalFoto.getKualifikasiSurveyId()));
            intent.putExtra(EXTRA_KUALIFIKASISURVEY_FORMGALPALFOTO,mFormGalpalFoto.getKualifikasiSurveyId());
            startActivity(intent);
        }
    }

    private class FormGalpalFotoAdapter extends RecyclerView.Adapter<FormGalpalFotoHolder> {
        private List<FormGalpalFoto> mFormGalpalFotos;

        public FormGalpalFotoAdapter(List<FormGalpalFoto> formGalpalFotos) {
            mFormGalpalFotos = formGalpalFotos;
        }

        @Override
        public FormGalpalFotoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater
                    .inflate(R.layout.list_item_form_galpal_foto, parent, false);
            return new FormGalpalFotoHolder(view);
        }

        @Override
        public void onBindViewHolder(FormGalpalFotoHolder holder, int position) {
            FormGalpalFoto formGalpalFoto = mFormGalpalFotos.get(position);
            holder.bindFormGalpalFoto(formGalpalFoto);
        }

        @Override
        public int getItemCount() {
            return mFormGalpalFotos.size();
        }

        public void setData(List<FormGalpalFoto> formGalpalFotos){
            mFormGalpalFotos=formGalpalFotos;
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        if(mKualifikasiSurvey.getStatus()==0||mKualifikasiSurvey.getStatus()==2 && !mMenuCheckingGalpal.isVerified()){
            inflater.inflate(R.menu.fragment_form_list, menu);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_item_new_crime:
                final CharSequence[] items = { "Take Photo", "Choose from Library",
                        "Cancel" };

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Add Photo!");
                builder.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int item) {
                        if (items[item].equals("Take Photo")) {
                            Intent captureImage=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                            mFormGalpalFoto=new FormGalpalFoto();
                            mFormGalpalFoto.setKualifikasiSurveyId(DrawerFormActivity.kualifikasiSurveyId);
                            mPhotoFile=mDummyMaker.getPhotoFile(mFormGalpalFoto);
                            Uri uri=Uri.fromFile(mPhotoFile);
                            captureImage.putExtra(MediaStore.EXTRA_OUTPUT,uri);
                            startActivityForResult(captureImage, REQUEST_PHOTO);
                        } else if (items[item].equals("Choose from Library")) {
                            Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                            intent.setType("image/*");
                            mFormGalpalFoto=new FormGalpalFoto();
                            mFormGalpalFoto.setKualifikasiSurveyId(DrawerFormActivity.kualifikasiSurveyId);
                            startActivityForResult(Intent.createChooser(intent, "Select File"), REQUEST_SELECT_FILE);
                        } else if (items[item].equals("Cancel")) {
                            dialog.dismiss();
                        }
                    }
                });
                builder.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        /*if(mKualifikasiSurvey.getStatus()==0||mKualifikasiSurvey.getStatus()==2 && !mMenuCheckingGalpal.isVerified()){
            if(!new ConnectionDetector(getActivity()).isConnectingToInternet()){
                PushGalpalService.setServiceAlarm(getActivity(),true);
            }else {
                new PushTask(mFormGalpalFotos, mMenuCheckingGalpal).execute();
            }
        }*/
    }





    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode!= Activity.RESULT_OK){
            return;
        }
        if (requestCode==REQUEST_PHOTO){
            mFormGalpalFoto.setImagePath(mPhotoFile.getPath());
            mFormGalpalFoto.setFotoGalangan(mFormGalpalFoto.getPhotoFileName());
            mDummyMaker.addFormGalpalFoto(mFormGalpalFoto);
            updateUI();
            Intent intent=new Intent(getActivity(),FormGalpalFotoPagerActivity.class);
            intent.putExtra(EXTRA_ID_FORMGALPALFOTO,mFormGalpalFoto.getIdFotoGalangan());
            intent.putExtra(EXTRA_KUALIFIKASISURVEY_FORMGALPALFOTO,mFormGalpalFoto.getKualifikasiSurveyId());
            startActivity(intent);

        }else if(requestCode==REQUEST_SELECT_FILE){
            Uri selectedImageUri = data.getData();
            String[] projection = { MediaStore.MediaColumns.DATA };
            Cursor cursor = getActivity().getContentResolver().query(selectedImageUri, projection, null, null, null);
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
            cursor.moveToFirst();
            mFormGalpalFoto.setImagePath(cursor.getString(column_index));
            String filename=mFormGalpalFoto.getImagePath().substring(mFormGalpalFoto.getImagePath().lastIndexOf("/")+1);
            mFormGalpalFoto.setNamaFoto(filename);
            mDummyMaker.addFormGalpalFoto(mFormGalpalFoto);
            cursor.close();
            updateUI();
            Intent intent=new Intent(getActivity(),FormGalpalFotoPagerActivity.class);
            intent.putExtra(EXTRA_ID_FORMGALPALFOTO,mFormGalpalFoto.getIdFotoGalangan());
            intent.putExtra(EXTRA_KUALIFIKASISURVEY_FORMGALPALFOTO,mFormGalpalFoto.getKualifikasiSurveyId());
            startActivity(intent);

        }
    }






    /**
     * Background Async Task to download file
     * */
    class DownloadFileFromURL extends AsyncTask<Void, String, List<FormGalpalFoto>> {
        ProgressDialog mProgressDialog = new ProgressDialog(getActivity());
        List<FormGalpalFoto> mFormGalpalFotos;

        public DownloadFileFromURL(List<FormGalpalFoto> formGalpalFotosa) {
            mFormGalpalFotos = formGalpalFotosa;
        }

        /**
         * Before starting background thread
         * Show Progress Bar Dialog
         */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressDialog.setMessage("Donwloading Images. Please Wait ....");
            mProgressDialog.setIndeterminate(false);
            mProgressDialog.setMax(100);
            mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            mProgressDialog.setCancelable(true);
            mProgressDialog.show();
        }

        /**
         * Downloading file in background thread
         */
        @Override
        protected List<FormGalpalFoto> doInBackground(Void... params) {
            int count;
            List<FormGalpalFoto> formGalpalFotosClean=new ArrayList<>();
            try {

                for(FormGalpalFoto formGalpalFoto:mFormGalpalFotos){
                    if(formGalpalFoto.getImagePath()==null){
                        formGalpalFotosClean.add(formGalpalFoto);
                    }
                }
                for(FormGalpalFoto formGalpalFoto:formGalpalFotosClean) {
                    URL url = new URL(formGalpalFoto.getFotoUrl());
                    URLConnection conection = url.openConnection();
                    conection.connect();
                    // this will be useful so that you can show a tipical 0-100% progress bar
                    int lenghtOfFile = conection.getContentLength();

                    // download the file
                    InputStream input = new BufferedInputStream(url.openStream(), 8192);

                    // Output stream
                    OutputStream output = new FileOutputStream("/sdcard/" + formGalpalFoto.getFotoGalangan());


                    byte data[] = new byte[1024];

                    long total = 0;

                    while ((count = input.read(data)) != -1) {
                        total += count;
                        // publishing the progress....
                        // After this onProgressUpdate will be called
                        publishProgress("" + (int) ((total * 100) / lenghtOfFile));

                        // writing data to file
                        output.write(data, 0, count);
                    }

                    // flushing output
                    output.flush();

                    // closing streams
                    output.close();
                    input.close();
                }

            } catch (Exception e) {
                Log.e("Error: ", e.getMessage());
            }

            return formGalpalFotosClean;
        }

        /**
         * Updating progress bar
         */
        protected void onProgressUpdate(String... progress) {
            // setting progress percentage
            mProgressDialog.setProgress(Integer.parseInt(progress[0]));
        }

        /**
         * After completing background task
         * Dismiss the progress dialog
         **/
        @Override
        protected void onPostExecute(List<FormGalpalFoto> formGalpalFotos) {
            // dismiss the dialog after the file was downloaded


            // Displaying downloaded image into image view
            // Reading image path from sdcard
            for(FormGalpalFoto formGalpalFoto:formGalpalFotos) {
                String imagePath = Environment.getExternalStorageDirectory().toString() + "/" + formGalpalFoto.getFotoGalangan();
                // setting downloaded into image view
                formGalpalFoto.setImagePath(imagePath);
                DummyMaker.get(getActivity()).addFormGalpalFoto(formGalpalFoto);
            }
            mProgressDialog.dismiss();
            updateUI();
           // my_image.setImageDrawable(Drawable.createFromPath(imagePath));
        }
    }

    /**
     * Uploading the file to server
     * */
    private class UploadFileToServer extends AsyncTask<Void, Integer, List<FormGalpalFoto>> {
        ProgressDialog mProgressDialog = new ProgressDialog(getActivity());
        private List<FormGalpalFoto> mFormGalpalFotoUploads;

        public UploadFileToServer(List<FormGalpalFoto> formGalpalFotos){
            mFormGalpalFotoUploads=new ArrayList<>();
            for(FormGalpalFoto formGalpalFoto:formGalpalFotos){
                if(!mFormGalpalFoto.isFetchFromServer()){
                    //biar yang sudah di upload tidak diupload kembali
                    formGalpalFoto.setFetchFromServer(true);
                    mFormGalpalFotoUploads.add(formGalpalFoto);
                }
            }
            //mFormGalpalFotoUploads=formGalpalFotos;
        }

        @Override
        protected void onPreExecute() {
            // setting progress bar to zero
           // progressBar.setProgress(0);
            mProgressDialog.setMessage("Donwloading Images. Please Wait ....");
            mProgressDialog.setIndeterminate(false);
            mProgressDialog.setMax(100);
            mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            mProgressDialog.setCancelable(true);
            mProgressDialog.show();
            super.onPreExecute();
        }

        @Override
        protected void onProgressUpdate(Integer... progress) {
            // Making progress bar visible
            //progressBar.setVisibility(View.VISIBLE);
            mProgressDialog.setProgress(progress[0]);
            // updating progress bar value
           // progressBar.setProgress(progress[0]);

            // updating percentage value
            //txtPercentage.setText(String.valueOf(progress[0]) + "%");
        }

        @Override
        protected List<FormGalpalFoto> doInBackground(Void... params) {
            if(mFormGalpalFotoUploads.size()>0) {
                for (FormGalpalFoto formGalpalFoto : mFormGalpalFotoUploads) {
                    new DataPusher().makePostRequestFGFoto(formGalpalFoto);
                    uploadFile(formGalpalFoto.getImagePath());
                }
            }
            return mFormGalpalFotoUploads;
        }

        @SuppressWarnings("deprecation")
        private Void uploadFile(String filePath) {
            String responseString = null;

            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost(DataPusher.urlPostFGFoto);

            try {
                AndroidMultiPartEntity entity = new AndroidMultiPartEntity(
                        new AndroidMultiPartEntity.ProgressListener() {

                            @Override
                            public void transferred(long num) {
                                //publishProgress((int) ((num / (float) totalSize) * 100));
                            }
                        });

                File sourceFile = new File(filePath);

                // Adding file data to http body
                entity.addPart("image", new FileBody(sourceFile));

                // Extra parameters if you want to pass to server
               /* entity.addPart("website",
                        new StringBody("www.androidhive.info"));
                entity.addPart("email", new StringBody("abc@gmail.com"));*/

                //totalSize = entity.getContentLength();
                httppost.setEntity(entity);

                // Making server call
                HttpResponse response = httpclient.execute(httppost);
                HttpEntity r_entity = response.getEntity();

                int statusCode = response.getStatusLine().getStatusCode();
                if (statusCode == 200) {
                    // Server response
                    responseString = EntityUtils.toString(r_entity);
                } else {
                    responseString = "Error occurred! Http Status Code: "
                            + statusCode;
                }

            } catch (ClientProtocolException e) {
                responseString = e.toString();
            } catch (IOException e) {
                responseString = e.toString();
            }

            return null;

        }

        @Override
        protected void onPostExecute(List<FormGalpalFoto> formGalpalFotos) {
            Log.e("Upload Foto", "Response from server: " );

            // showing the server response in an alert dialog
            //showAlert(result);
            for(FormGalpalFoto formGalpalFoto:formGalpalFotos){
                DummyMaker.get(getActivity()).addFormGalpalFoto(formGalpalFoto);
            }
            mProgressDialog.dismiss();
        }

    }

    /**
     * Method to show alert dialog
     * */
    private void showAlert(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(message).setTitle("Response from Servers")
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // do nothing
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }

    private class DeleteTask extends AsyncTask<Void,Void,Void> {
        private int mIdForm;

        public DeleteTask(int idForm){
            mIdForm=idForm;
        }

        @Override
        protected Void doInBackground(Void... params) {
            new DataFetcher().deleteForm(mIdForm,DataFetcher.DELETEFGFotoENDPOINT);
            return null;
        }
    }
}
