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
import com.mpewpazi.android.awaljunisidang.Form.FormGalpal9;
import com.mpewpazi.android.awaljunisidang.Form.SingleForm;
import com.mpewpazi.android.awaljunisidang.FormGalpal9PagerActivity;
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
public class ListFormGalpal9Fragment extends SingleFragment {
    private final static String EXTRA_KUALIFIKASISURVEY_FORMGALPAL9="extra_kualifikasisurvey_form_galpal9";
    private final static String EXTRA_ID_FORMGALPAL9="extra_id_form_galpal9";


    private List<FormGalpal9> mFormGalpal9s;

    private RecyclerView mFormGalpal9RecyclerView;
    private FormGalpal9Adapter mAdapter;
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
        mMenuCheckingGalpal=mDummyMaker.getMenuCheckingGalpal(DrawerFormActivity.kualifikasiSurveyId,FormGalpal9.kode);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_form_galpal_peralatan_list, container, false);

        TextView mJudulTextView=(TextView)view.findViewById(R.id.galpal_peralatan_judul_list);
        FormGalpal9 formGalpal9=new FormGalpal9();
        mJudulTextView.setText(formGalpal9.getNamaForm());

        if(mKualifikasiSurvey.getStatus()==1||mKualifikasiSurvey.getStatus()==3||mKualifikasiSurvey.getStatus()==4){
            setViewEnabledFalse(view);
        }

        mFormGalpal9RecyclerView = (RecyclerView) view.findViewById(R.id.form_galpal_peralatan_recycler_view);


        //recycler view butuh layoutmanager untuk mempossionig item di screen
        //ada banyak macam layout manager, kalau linear itu untuk vertikal posisioningnya
        //kedepanya ada gridLayoutManager
        mFormGalpal9RecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
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
        mFormGalpal9s=mDummyMaker.getFormGalpal9s(DrawerFormActivity.kualifikasiSurveyId);

        //if (mAdapter == null) {
        mAdapter = new FormGalpal9Adapter(mFormGalpal9s);
        mFormGalpal9RecyclerView.setAdapter(mAdapter);
        if(mFormGalpal9s.size()>0){
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
        //mAdapter.setData(mFormGalpal9s);
        //mAdapter.notifyDataSetChanged();
        //}
    }

    private class FormGalpal9Holder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mNoTextView;
        private TextView mJenisMesinTextView;
        private TextView mMerekTextView;
        private ImageButton mDeleteButton;

        private FormGalpal9 mFormGalpal9;

        public void bindFormGalpal9(final FormGalpal9 formGalpal9, int no) {
            mFormGalpal9 = formGalpal9;
            mJenisMesinTextView.setText(mFormGalpal9.getJenisMesin());
            mMerekTextView.setText(mFormGalpal9.getMerek());
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
                            DummyMaker.get(getActivity()).deleteFormGalpal9(formGalpal9);
                            updateUI();
                            new DeleteTask(formGalpal9.getFormServerId()).execute();
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

        public FormGalpal9Holder(View itemView) {
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
            Intent intent=new Intent(getActivity(),FormGalpal9PagerActivity.class);
            intent.putExtra(EXTRA_ID_FORMGALPAL9,mFormGalpal9.getIdPeralatanKerjaProduksiKontruksi());
            intent.putExtra(EXTRA_KUALIFIKASISURVEY_FORMGALPAL9,mFormGalpal9.getKualifikasiSurveyId());
            startActivity(intent);
        }
    }

    private class FormGalpal9Adapter extends RecyclerView.Adapter<FormGalpal9Holder> {
        private List<FormGalpal9> mFormGalpal9s;

        public FormGalpal9Adapter(List<FormGalpal9> formGalpal9s) {
            mFormGalpal9s = formGalpal9s;
        }

        @Override
        public FormGalpal9Holder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater
                    .inflate(R.layout.list_item_form_galpal_peralatan, parent, false);

            return new FormGalpal9Holder(view);
        }

        @Override
        public void onBindViewHolder(FormGalpal9Holder holder, int position) {
            FormGalpal9 formGalpal9 = mFormGalpal9s.get(position);
            holder.bindFormGalpal9(formGalpal9,position+1);
        }

        @Override
        public int getItemCount() {
            return mFormGalpal9s.size();
        }

        public void setData(List<FormGalpal9> formGalpal9s){
            mFormGalpal9s=formGalpal9s;
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
                FormGalpal9 formGalpal9=new FormGalpal9();
                formGalpal9.setKualifikasiSurveyId(DrawerFormActivity.kualifikasiSurveyId);
                DummyMaker.get(getActivity()).addFormGalpal9(formGalpal9);
                Intent intent=new Intent(getActivity(),FormGalpal9PagerActivity.class);
                intent.putExtra(EXTRA_ID_FORMGALPAL9,formGalpal9.getIdPeralatanKerjaProduksiKontruksi());
                intent.putExtra(EXTRA_KUALIFIKASISURVEY_FORMGALPAL9,formGalpal9.getKualifikasiSurveyId());
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
            new PushTask(mFormGalpal9s,mMenuCheckingGalpal).execute();
        }
    }

    private class PushTask extends AsyncTask<Void,Void,List<FormGalpal9>> {
        private List<FormGalpal9> mFormGalpal9s;
        private SingleMenuChecking mSingleMenuChecking;

        public PushTask(List<FormGalpal9> formGalpal9s, SingleMenuChecking singleMenuChecking){
            mFormGalpal9s=formGalpal9s;
            mSingleMenuChecking=singleMenuChecking;
        }

        @Override
        protected List<FormGalpal9> doInBackground(Void... params) {
            if(mFormGalpal9s.size()>0) {
                for (FormGalpal9 formGalpal9 : mFormGalpal9s) {
                    new DataPusher().makePostRequestFG9(formGalpal9, DataFetcher.FG9ENDPOINT, DhSchema.FG9PeralatanKerjaProduksiKontruksi.Cols.ID_F1_PERALATAN_KERJA_PRODUKSI_KONTRUKSI_SERVER);
                }
            }
            new DataPusher().makePostRequestMenuCheckingGalpal((MenuCheckingGalpal) mSingleMenuChecking);
            return mFormGalpal9s;
        }

        @Override
        protected void onPostExecute(List<FormGalpal9> formGalpal9s) {
            for(FormGalpal9 formGalpal9:formGalpal9s) {
                DummyMaker.get(getActivity()).addFormGalpal9(formGalpal9);
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
            new DataFetcher().deleteForm(mIdForm,DataFetcher.DELETEFG9ENDPOINT);
            return null;
        }
    }

}
