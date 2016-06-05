package com.mpewpazi.android.awaljunisidang.Fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import com.mpewpazi.android.awaljunisidang.Form.FormKompal3b;
import com.mpewpazi.android.awaljunisidang.Form.SingleForm;
import com.mpewpazi.android.awaljunisidang.FormKompal3bPagerActivity;
import com.mpewpazi.android.awaljunisidang.PushKompalService;
import com.mpewpazi.android.awaljunisidang.R;
import com.mpewpazi.android.awaljunisidang.dummy.DummyMaker;
import com.mpewpazi.android.awaljunisidang.model.KualifikasiSurvey;
import com.mpewpazi.android.awaljunisidang.model.MenuCheckingKompal;
import com.mpewpazi.android.awaljunisidang.model.SingleMenuChecking;

import java.util.List;

/**
 * Created by mpewpazi on 5/10/16.
 */
public class ListFormKompal3bFragment extends SingleFragment {
    private final static String EXTRA_KUALIFIKASISURVEY_FORMKOMPAL3B="extra_kualifikasisurvey_form_kompal3b";
    private final static String EXTRA_ID_FORMKOMPAL3B="extra_id_form_kompal3b";


    private List<FormKompal3b> mFormKompal3bs;

    private RecyclerView mFormKompal3bRecyclerView;
    private FormKompal3bAdapter mAdapter;
    private DummyMaker mDummyMaker;

    private MenuCheckingKompal mMenuCheckingKompal;
    private KualifikasiSurvey mKualifikasiSurvey;
    private List<SingleForm> mKompalForms;


    private Button mSubmitButton;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

        mDummyMaker=DummyMaker.get(getContext());
        mKualifikasiSurvey=mDummyMaker.getKualifikasiSurvey(DrawerFormActivity.kualifikasiSurveyId);
        mKompalForms=mDummyMaker.getKompalForms();
        mMenuCheckingKompal=mDummyMaker.getMenuCheckingKompal(DrawerFormActivity.kualifikasiSurveyId,FormKompal3b.kode);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_form_kompal3b_list, container, false);
        if(mKualifikasiSurvey.getStatus()==1||mKualifikasiSurvey.getStatus()==3||mKualifikasiSurvey.getStatus()==4){
            setViewEnabledFalse(view);
        }

        mFormKompal3bRecyclerView = (RecyclerView) view.findViewById(R.id.form_kompal3b_recycler_view);
        mSubmitButton = (Button) view.findViewById(R.id.kompal3b_btn_submit);

        //recycler view butuh layoutmanager untuk mempossionig item di screen
        //ada banyak macam layout manager, kalau linear itu untuk vertikal posisioningnya
        //kedepanya ada gridLayoutManager
        mFormKompal3bRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        if (mMenuCheckingKompal.isComplete()) {
            mSubmitButton.setText(R.string.belum_lengkap);
            mSubmitButton.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
        }
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mMenuCheckingKompal.isComplete()) {
                    mMenuCheckingKompal.setComplete(true);
                    mKualifikasiSurvey.setProgress(mKualifikasiSurvey.getProgress() + 100 / mKompalForms.size());
                    mSubmitButton.setText(R.string.belum_lengkap);
                    mSubmitButton.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
                } else {
                    mMenuCheckingKompal.setComplete(false);
                    mKualifikasiSurvey.setProgress(mKualifikasiSurvey.getProgress() - 100 / mKompalForms.size());
                    mSubmitButton.setText(R.string.lengkap);
                    mSubmitButton.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
                }

                mDummyMaker.addMenuCheckingKompal(mMenuCheckingKompal);
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
        mFormKompal3bs=mDummyMaker.getFormKompal3bs(DrawerFormActivity.kualifikasiSurveyId);
        mAdapter = new FormKompal3bAdapter(mFormKompal3bs);
        mFormKompal3bRecyclerView.setAdapter(mAdapter);
        if(mFormKompal3bs.size()>0){
            mMenuCheckingKompal.setFill(true);
        }else{
            mMenuCheckingKompal.setFill(false);
        }
        mDummyMaker.addMenuCheckingKompal(mMenuCheckingKompal);
        mCustomClickListener.clickListener();
    }


    private class FormKompal3bHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mNoTextView;
        private TextView mJenisProdukTextView;
        private TextView mJumlahProduk2014TextView;
        private ImageButton mDeleteButton;

        private FormKompal3b mFormKompal3b;

        public void bindFormKompal3b(final FormKompal3b formKompal3b, int no) {
            mFormKompal3b = formKompal3b;
            mJenisProdukTextView.setText(String.valueOf(mFormKompal3b.getJenisProdukId()));
            mJumlahProduk2014TextView.setText(String.valueOf(mFormKompal3b.getJumlahProdThn4()));
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
                            DummyMaker.get(getActivity()).deleteFormKompal3b(formKompal3b);
                            updateUI();
                            new DeleteTask(formKompal3b.getFormServerId()).execute();
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

        public FormKompal3bHolder(View itemView) {
            //setiap ada yang masuk ke super , reference setiap wideget dibuat oleh parent
            super(itemView);
            itemView.setOnClickListener(this);

            mNoTextView=(TextView)itemView.findViewById(R.id.list_item_kompal3b_no);
            mJenisProdukTextView = (TextView) itemView.findViewById(R.id.list_item_kompal3b_jenis_produk);
            mJumlahProduk2014TextView = (TextView) itemView.findViewById(R.id.list_item_kompal3b_jumlah_prod_2014);
            mDeleteButton=(ImageButton)itemView.findViewById(R.id.list_item_kompal3b_delete);


        }


        @Override
        public void onClick(View v) {
            Intent intent=new Intent(getActivity(),FormKompal3bPagerActivity.class);
            intent.putExtra(EXTRA_ID_FORMKOMPAL3B,mFormKompal3b.getIdjumlahProduksi());
            intent.putExtra(EXTRA_KUALIFIKASISURVEY_FORMKOMPAL3B,mFormKompal3b.getKualifikasiSurveyId());
            startActivity(intent);
        }
    }

    private class FormKompal3bAdapter extends RecyclerView.Adapter<FormKompal3bHolder> {
        private List<FormKompal3b> mFormKompal3bs;

        public FormKompal3bAdapter(List<FormKompal3b> formKompal3bs) {
            mFormKompal3bs = formKompal3bs;
        }

        @Override
        public FormKompal3bHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater
                    .inflate(R.layout.list_item_form_kompal3b, parent, false);
            return new FormKompal3bHolder(view);
        }

        @Override
        public void onBindViewHolder(FormKompal3bHolder holder, int position) {
            FormKompal3b formKompal3b = mFormKompal3bs.get(position);
            holder.bindFormKompal3b(formKompal3b,position+1);
        }

        @Override
        public int getItemCount() {
            return mFormKompal3bs.size();
        }

        public void setData(List<FormKompal3b> formKompal3bs){
            mFormKompal3bs=formKompal3bs;
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        if(mKualifikasiSurvey.getStatus()==0||mKualifikasiSurvey.getStatus()==2 && !mMenuCheckingKompal.isVerified()){
            inflater.inflate(R.menu.fragment_form_list, menu);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_item_new_crime:
                FormKompal3b formKompal3b=new FormKompal3b();
                formKompal3b.setKualifikasiSurveyId(DrawerFormActivity.kualifikasiSurveyId);
                DummyMaker.get(getActivity()).addFormKompal3b(formKompal3b);
                Intent intent=new Intent(getActivity(),FormKompal3bPagerActivity.class);
                intent.putExtra(EXTRA_ID_FORMKOMPAL3B,formKompal3b.getIdjumlahProduksi());
                intent.putExtra(EXTRA_KUALIFIKASISURVEY_FORMKOMPAL3B,formKompal3b.getKualifikasiSurveyId());
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if(mKualifikasiSurvey.getStatus()==0||mKualifikasiSurvey.getStatus()==2 && !mMenuCheckingKompal.isVerified()){
            if(!new ConnectionDetector(getActivity()).isConnectingToInternet()){
                PushKompalService.setServiceAlarm(getActivity(),true);
            }else {
                new PushTask(mFormKompal3bs, mMenuCheckingKompal).execute();
            }
        }
    }

    private class PushTask extends AsyncTask<Void,Void,List<FormKompal3b>> {
        private List<FormKompal3b> mFormKompal3bs;
        private SingleMenuChecking mSingleMenuChecking;

        public PushTask(List<FormKompal3b> formKompal3bs, SingleMenuChecking singleMenuChecking){
            mFormKompal3bs=formKompal3bs;
            mSingleMenuChecking=singleMenuChecking;
        }

        @Override
        protected List<FormKompal3b> doInBackground(Void... params) {
            if(mFormKompal3bs.size()>0) {
                for (FormKompal3b formKompal3b : mFormKompal3bs) {
                    new DataPusher().makePostRequestFK3b(formKompal3b);
                }
            }
            new DataPusher().makePostRequestMenuCheckingKompal((MenuCheckingKompal) mSingleMenuChecking);
            return mFormKompal3bs;
        }

        @Override
        protected void onPostExecute(List<FormKompal3b> formKompal3bs) {
            for(FormKompal3b formKompal3b:formKompal3bs) {
                DummyMaker.get(getActivity()).addFormKompal3b(formKompal3b);
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
            new DataFetcher().deleteForm(mIdForm,DataFetcher.DELETEFK3bENDPOINT);
            return null;
        }
    }
}
