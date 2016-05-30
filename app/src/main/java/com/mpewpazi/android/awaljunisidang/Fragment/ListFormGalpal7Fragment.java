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

import com.mpewpazi.android.awaljunisidang.ConnectionDetector;
import com.mpewpazi.android.awaljunisidang.DataFetcher;
import com.mpewpazi.android.awaljunisidang.DataPusher;
import com.mpewpazi.android.awaljunisidang.DrawerFormActivity;
import com.mpewpazi.android.awaljunisidang.Form.FormGalpal7;
import com.mpewpazi.android.awaljunisidang.Form.SingleForm;
import com.mpewpazi.android.awaljunisidang.FormGalpal7PagerActivity;
import com.mpewpazi.android.awaljunisidang.PushGalpalService;
import com.mpewpazi.android.awaljunisidang.R;
import com.mpewpazi.android.awaljunisidang.dummy.DummyMaker;
import com.mpewpazi.android.awaljunisidang.model.KualifikasiSurvey;
import com.mpewpazi.android.awaljunisidang.model.MenuCheckingGalpal;
import com.mpewpazi.android.awaljunisidang.model.SingleMenuChecking;

import java.util.List;

/**
 * Created by mpewpazi on 5/27/16.
 */
public class ListFormGalpal7Fragment extends SingleFragment {
    private final static String EXTRA_KUALIFIKASISURVEY_FORMGALPAL7="extra_kualifikasisurvey_form_galpal7";
    private final static String EXTRA_ID_FORMGALPAL7="extra_id_form_galpal7";


    private List<FormGalpal7> mFormGalpal7s;

    private RecyclerView mFormGalpal7RecyclerView;
    private FormGalpal7Adapter mAdapter;
    private DummyMaker mDummyMaker;


    private KualifikasiSurvey mKualifikasiSurvey;

    private List<SingleForm> mGalpalForms;
    private MenuCheckingGalpal mMenuCheckingGalpal;

    private Button mSubmitButton;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

        mDummyMaker=DummyMaker.get(getContext());
        mKualifikasiSurvey=mDummyMaker.getKualifikasiSurvey(DrawerFormActivity.kualifikasiSurveyId);
        mGalpalForms=mDummyMaker.getGalpalForms();
        mMenuCheckingGalpal=mDummyMaker.getMenuCheckingGalpal(DrawerFormActivity.kualifikasiSurveyId,FormGalpal7.kode);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_form_galpal_peralatan_list, container, false);
        TextView mJudulTextView=(TextView)view.findViewById(R.id.galpal_peralatan_judul_list);
        FormGalpal7 formGalpal7=new FormGalpal7();
        mJudulTextView.setText(formGalpal7.getNamaForm());

        if(mKualifikasiSurvey.getStatus()==1||mKualifikasiSurvey.getStatus()==3||mKualifikasiSurvey.getStatus()==4){
            setViewEnabledFalse(view);
        }

        mFormGalpal7RecyclerView = (RecyclerView) view.findViewById(R.id.form_galpal_peralatan_recycler_view);


        //recycler view butuh layoutmanager untuk mempossionig item di screen
        //ada banyak macam layout manager, kalau linear itu untuk vertikal posisioningnya
        //kedepanya ada gridLayoutManager
        mFormGalpal7RecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
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
        mFormGalpal7s=mDummyMaker.getFormGalpal7s(DrawerFormActivity.kualifikasiSurveyId);

        //if (mAdapter == null) {
        mAdapter = new FormGalpal7Adapter(mFormGalpal7s);
        mFormGalpal7RecyclerView.setAdapter(mAdapter);
        if(mFormGalpal7s.size()>0){
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
        //mAdapter.setData(mFormGalpal7s);
        //mAdapter.notifyDataSetChanged();
        //}
    }

    private class FormGalpal7Holder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mNoTextView;
        private TextView mJenisMesinTextView;
        private TextView mMerekTextView;
        private ImageButton mDeleteButton;

        private FormGalpal7 mFormGalpal7;

        public void bindFormGalpal7(final FormGalpal7 formGalpal7, int no) {
            mFormGalpal7 = formGalpal7;
            mJenisMesinTextView.setText(mFormGalpal7.getJenisPeralatan());
            mMerekTextView.setText(mFormGalpal7.getMerek());
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
                            DummyMaker.get(getActivity()).deleteFormGalpal7(formGalpal7);
                            updateUI();
                            new DeleteTask(formGalpal7.getFormServerId()).execute();
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

        public FormGalpal7Holder(View itemView) {
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
            Intent intent=new Intent(getActivity(),FormGalpal7PagerActivity.class);
            intent.putExtra(EXTRA_ID_FORMGALPAL7,mFormGalpal7.getIdPeralatanKerjaTugboat());
            intent.putExtra(EXTRA_KUALIFIKASISURVEY_FORMGALPAL7,mFormGalpal7.getKualifikasiSurveyId());
            startActivity(intent);
        }
    }

    private class FormGalpal7Adapter extends RecyclerView.Adapter<FormGalpal7Holder> {
        private List<FormGalpal7> mFormGalpal7s;

        public FormGalpal7Adapter(List<FormGalpal7> formGalpal7s) {
            mFormGalpal7s = formGalpal7s;
        }

        @Override
        public FormGalpal7Holder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater
                    .inflate(R.layout.list_item_form_galpal_peralatan, parent, false);

            return new FormGalpal7Holder(view);
        }

        @Override
        public void onBindViewHolder(FormGalpal7Holder holder, int position) {
            FormGalpal7 formGalpal7 = mFormGalpal7s.get(position);
            holder.bindFormGalpal7(formGalpal7,position+1);
        }

        @Override
        public int getItemCount() {
            return mFormGalpal7s.size();
        }

        public void setData(List<FormGalpal7> formGalpal7s){
            mFormGalpal7s=formGalpal7s;
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
                FormGalpal7 formGalpal7=new FormGalpal7();
                formGalpal7.setKualifikasiSurveyId(DrawerFormActivity.kualifikasiSurveyId);
                DummyMaker.get(getActivity()).addFormGalpal7(formGalpal7);
                Intent intent=new Intent(getActivity(),FormGalpal7PagerActivity.class);
                intent.putExtra(EXTRA_ID_FORMGALPAL7,formGalpal7.getIdPeralatanKerjaTugboat());
                intent.putExtra(EXTRA_KUALIFIKASISURVEY_FORMGALPAL7,formGalpal7.getKualifikasiSurveyId());
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
            if(!new ConnectionDetector(getActivity()).isConnectingToInternet()){
                PushGalpalService.setServiceAlarm(getActivity(),true);
            }else {
                new PushTask(mFormGalpal7s, mMenuCheckingGalpal).execute();
            }
        }
    }

    private class PushTask extends AsyncTask<Void,Void,List<FormGalpal7>> {
        private List<FormGalpal7> mFormGalpal7s;
        private SingleMenuChecking mSingleMenuChecking;

        public PushTask(List<FormGalpal7> formGalpal7s, SingleMenuChecking singleMenuChecking){
            mFormGalpal7s=formGalpal7s;
            mSingleMenuChecking=singleMenuChecking;
        }

        @Override
        protected List<FormGalpal7> doInBackground(Void... params) {
            if(mFormGalpal7s.size()>0) {
                for (FormGalpal7 formGalpal7 : mFormGalpal7s) {
                    new DataPusher().makePostRequestFG7(formGalpal7);
                }
            }
            new DataPusher().makePostRequestMenuCheckingGalpal((MenuCheckingGalpal) mSingleMenuChecking);
            return mFormGalpal7s;
        }

        @Override
        protected void onPostExecute(List<FormGalpal7> formGalpal7s) {
            for(FormGalpal7 formGalpal7:formGalpal7s) {
                DummyMaker.get(getActivity()).addFormGalpal7(formGalpal7);
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
            new DataFetcher().deleteForm(mIdForm, DataFetcher.DELETEFG7ENDPOINT);
            return null;
        }
    }

}
