package com.mpewpazi.android.awaljunisidang.Fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
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
import android.widget.TextView;

import com.mpewpazi.android.awaljunisidang.DataFetcher;
import com.mpewpazi.android.awaljunisidang.DataPusher;
import com.mpewpazi.android.awaljunisidang.DrawerFormActivity;
import com.mpewpazi.android.awaljunisidang.Form.FormGalpal8;
import com.mpewpazi.android.awaljunisidang.Form.SingleForm;
import com.mpewpazi.android.awaljunisidang.FormGalpal8PagerActivity;
import com.mpewpazi.android.awaljunisidang.R;
import com.mpewpazi.android.awaljunisidang.database.DhSchema;
import com.mpewpazi.android.awaljunisidang.dummy.DummyMaker;
import com.mpewpazi.android.awaljunisidang.model.KualifikasiSurvey;
import com.mpewpazi.android.awaljunisidang.model.MenuCheckingGalpal;
import com.mpewpazi.android.awaljunisidang.model.SingleMenuChecking;

import java.util.List;

/**
 * Created by mpewpazi on 5/27/16.
 */
public class ListFormGalpal8Fragment extends SingleFragment {
    private final static String EXTRA_KUALIFIKASISURVEY_FORMGALPAL8="extra_kualifikasisurvey_form_galpal8";
    private final static String EXTRA_ID_FORMGALPAL8="extra_id_form_galpal8";


    private List<FormGalpal8> mFormGalpal8s;

    private RecyclerView mFormGalpal8RecyclerView;
    private FormGalpal8Adapter mAdapter;
    private DummyMaker mDummyMaker;


    private KualifikasiSurvey mKualifikasiSurvey;

    private List<SingleForm> mGalpalForms;
    private MenuCheckingGalpal mMenuCheckingGalpal;

    private Button mSubmitButton;

    public ListFormGalpal8Fragment (){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

        mDummyMaker=DummyMaker.get(getContext());
        mKualifikasiSurvey=mDummyMaker.getKualifikasiSurvey(DrawerFormActivity.kualifikasiSurveyId);
        mGalpalForms=mDummyMaker.getGalpalForms();
        mMenuCheckingGalpal=mDummyMaker.getMenuCheckingGalpal(DrawerFormActivity.kualifikasiSurveyId,FormGalpal8.kode);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_form_galpal_peralatan_list, container, false);

        TextView mJudulTextView=(TextView)view.findViewById(R.id.galpal_peralatan_judul_list);
        FormGalpal8 formGalpal8=new FormGalpal8();
        mJudulTextView.setText(formGalpal8.getNamaForm());

        if(mKualifikasiSurvey.getStatus()==1||mKualifikasiSurvey.getStatus()==3||mKualifikasiSurvey.getStatus()==4){
            setViewEnabledFalse(view);
        }

        mFormGalpal8RecyclerView = (RecyclerView) view.findViewById(R.id.form_galpal_peralatan_recycler_view);


        //recycler view butuh layoutmanager untuk mempossionig item di screen
        //ada banyak macam layout manager, kalau linear itu untuk vertikal posisioningnya
        //kedepanya ada gridLayoutManager
        mFormGalpal8RecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        Log.d("updateG","true");
        updateUI();

        mSubmitButton=(Button)view.findViewById(R.id.galpal_peralatan_btn_submit);
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
        mFormGalpal8s=mDummyMaker.getFormGalpal8s(DrawerFormActivity.kualifikasiSurveyId);

        //if (mAdapter == null) {
        mAdapter = new FormGalpal8Adapter(mFormGalpal8s);
        mFormGalpal8RecyclerView.setAdapter(mAdapter);
        if(mFormGalpal8s.size()>0){
            mMenuCheckingGalpal.setFill(true);
        }else{
            mMenuCheckingGalpal.setFill(false);
        }
        mDummyMaker.addMenuCheckingGalpal(mMenuCheckingGalpal);
        mCustomClickListener.clickListener();
        Log.d("updateGui","true");
        //} else {

        // reload all the item in he list
        //Log.d("updateGui","else");
        //mAdapter.setData(mFormGalpal8s);
        //mAdapter.notifyDataSetChanged();
        //}
    }

    private class FormGalpal8Holder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mNoTextView;
        private TextView mJenisMesinTextView;
        private TextView mMerekTextView;
        private ImageButton mDeleteButton;

        private FormGalpal8 mFormGalpal8;

        public void bindFormGalpal8(final FormGalpal8 formGalpal8, int no) {
            mFormGalpal8 = formGalpal8;
            mJenisMesinTextView.setText(mFormGalpal8.getJenisMesin());
            mMerekTextView.setText(mFormGalpal8.getMerek());
            mNoTextView.setText(String.valueOf(no));
            if(mKualifikasiSurvey.getStatus()==1||mKualifikasiSurvey.getStatus()==3||mKualifikasiSurvey.getStatus()==4){
                mDeleteButton.setVisibility(View.GONE);
            }
            mDeleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder alertDialogBuilder=new AlertDialog.Builder(getActivity());
                    alertDialogBuilder.setMessage("Apakah anda yakin akan menghapus kolom ini");

                    alertDialogBuilder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            DummyMaker.get(getActivity()).deleteFormGalpal8(formGalpal8);
                            updateUI();
                            new DeleteTask(formGalpal8.getFormServerId()).execute();
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

        public FormGalpal8Holder(View itemView) {
            //setiap ada yang masuk ke super , reference setiap wideget dibuat oleh parent
            super(itemView);
            itemView.setOnClickListener(this);

            mNoTextView=(TextView)itemView.findViewById(R.id.list_item_galpal_peralatan_no);
            mJenisMesinTextView = (TextView) itemView.findViewById(R.id.list_item_galpal_peralatan_jenis_mesin);
            mMerekTextView = (TextView) itemView.findViewById(R.id.list_item_galpal_peralatan_merek);
            mDeleteButton=(ImageButton) itemView.findViewById(R.id.list_item_galpal_peralatan_delete);


        }


        @Override
        public void onClick(View v) {
            Intent intent=new Intent(getActivity(),FormGalpal8PagerActivity.class);
            intent.putExtra(EXTRA_ID_FORMGALPAL8,mFormGalpal8.getIdPeralatanKerjaProdMesin());
            intent.putExtra(EXTRA_KUALIFIKASISURVEY_FORMGALPAL8,mFormGalpal8.getKualifikasiSurveyId());
            startActivity(intent);
        }
    }

    private class FormGalpal8Adapter extends RecyclerView.Adapter<FormGalpal8Holder> {
        private List<FormGalpal8> mFormGalpal8s;

        public FormGalpal8Adapter(List<FormGalpal8> formGalpal8s) {
            mFormGalpal8s = formGalpal8s;
        }

        @Override
        public FormGalpal8Holder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater
                    .inflate(R.layout.list_item_form_galpal_peralatan, parent, false);

            return new FormGalpal8Holder(view);
        }

        @Override
        public void onBindViewHolder(FormGalpal8Holder holder, int position) {
            FormGalpal8 formGalpal8 = mFormGalpal8s.get(position);
            holder.bindFormGalpal8(formGalpal8,position+1);
        }

        @Override
        public int getItemCount() {
            return mFormGalpal8s.size();
        }

        public void setData(List<FormGalpal8> formGalpal8s){
            mFormGalpal8s=formGalpal8s;
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        if(mKualifikasiSurvey.getStatus()==0||mKualifikasiSurvey.getStatus()==2){
            inflater.inflate(R.menu.fragment_form_list, menu);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_item_new_crime:
                FormGalpal8 formGalpal8=new FormGalpal8();
                formGalpal8.setKualifikasiSurveyId(DrawerFormActivity.kualifikasiSurveyId);
                DummyMaker.get(getActivity()).addFormGalpal8(formGalpal8);
                Intent intent=new Intent(getActivity(),FormGalpal8PagerActivity.class);
                intent.putExtra(EXTRA_ID_FORMGALPAL8,formGalpal8.getIdPeralatanKerjaProdMesin());
                intent.putExtra(EXTRA_KUALIFIKASISURVEY_FORMGALPAL8,formGalpal8.getKualifikasiSurveyId());
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if(mKualifikasiSurvey.getStatus()==0||mKualifikasiSurvey.getStatus()==2||!mMenuCheckingGalpal.isVerified()){
            new PushTask(mFormGalpal8s,mMenuCheckingGalpal).execute();
        }
    }

    private class PushTask extends AsyncTask<Void,Void,List<FormGalpal8>> {
        private List<FormGalpal8> mFormGalpal8s;
        private SingleMenuChecking mSingleMenuChecking;

        public PushTask(List<FormGalpal8> formGalpal8s, SingleMenuChecking singleMenuChecking){
            mFormGalpal8s=formGalpal8s;
            mSingleMenuChecking=singleMenuChecking;
        }

        @Override
        protected List<FormGalpal8> doInBackground(Void... params) {
            if(mFormGalpal8s.size()>0) {
                for (FormGalpal8 formGalpal8 : mFormGalpal8s) {
                    new DataPusher().makePostRequestFG8(formGalpal8, DataFetcher.FG8ENDPOINT, DhSchema.FG8PeralatanKerjaProduksiMesinTable.Cols.ID_F1_PERALATAN_KERJA_PROD_MESIN_SERVER);
                }
            }
            new DataPusher().makePostRequestMenuCheckingGalpal((MenuCheckingGalpal) mSingleMenuChecking);
            return mFormGalpal8s;
        }

        @Override
        protected void onPostExecute(List<FormGalpal8> formGalpal8s) {
            for(FormGalpal8 formGalpal8:formGalpal8s) {
                DummyMaker.get(getActivity()).addFormGalpal8(formGalpal8);
            }
        }
    }

    private class DeleteTask extends AsyncTask<Void,Void,Void> {
        private int mIdForm;

        public DeleteTask(int idForm){
            mIdForm=idForm;
        }

        @Override
        protected Void doInBackground(Void... params) {
            new DataFetcher().deleteForm(mIdForm,DataFetcher.DELETEFG8ENDPOINT);
            return null;
        }
    }

}
