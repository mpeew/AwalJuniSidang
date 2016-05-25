package com.mpewpazi.android.awaljunisidang.Fragment;

import android.content.DialogInterface;
import android.content.Intent;
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

import com.mpewpazi.android.awaljunisidang.DrawerFormActivity;
import com.mpewpazi.android.awaljunisidang.Form.FormKompal3d;
import com.mpewpazi.android.awaljunisidang.Form.SingleForm;
import com.mpewpazi.android.awaljunisidang.FormKompal3dPagerActivity;
import com.mpewpazi.android.awaljunisidang.R;
import com.mpewpazi.android.awaljunisidang.dummy.DummyMaker;
import com.mpewpazi.android.awaljunisidang.model.KualifikasiSurvey;
import com.mpewpazi.android.awaljunisidang.model.MenuCheckingKompal;

import java.util.List;

/**
 * Created by mpewpazi on 5/10/16.
 */
public class ListFormKompal3dFragment extends SingleFragment {
    private final static String EXTRA_KUALIFIKASISURVEY_FORMKOMPAL3D="extra_kualifikasisurvey_form_kompal3d";
    private final static String EXTRA_ID_FORMKOMPAL3D="extra_id_form_kompal3d";


    private List<FormKompal3d> mFormKompal3ds;

    private RecyclerView mFormKompal3dRecyclerView;
    private FormKompal3dAdapter mAdapter;
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
        mMenuCheckingKompal=mDummyMaker.getMenuCheckingKompal(DrawerFormActivity.kualifikasiSurveyId,FormKompal3d.kode);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_form_kompal3d_list, container, false);
        if(mKualifikasiSurvey.getStatus()==1||mKualifikasiSurvey.getStatus()==3||mKualifikasiSurvey.getStatus()==4){
            setViewEnabledFalse(view);
        }

        mFormKompal3dRecyclerView = (RecyclerView) view.findViewById(R.id.form_kompal3d_recycler_view);
        mSubmitButton=(Button)view.findViewById(R.id.kompal3d_btn_submit);

        //recycler view butuh layoutmanager untuk mempossionig item di screen
        //ada banyak macam layout manager, kalau linear itu untuk vertikal posisioningnya
        //kedepanya ada gridLayoutManager
        mFormKompal3dRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        if(mMenuCheckingKompal.isComplete()){
            mSubmitButton.setText(R.string.belum_lengkap);
            mSubmitButton.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
        }
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mMenuCheckingKompal.isComplete()){
                    mMenuCheckingKompal.setComplete(true);
                    mKualifikasiSurvey.setProgress(mKualifikasiSurvey.getProgress()+100/mKompalForms.size());
                    mSubmitButton.setText(R.string.belum_lengkap);
                    mSubmitButton.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
                }else{
                    mMenuCheckingKompal.setComplete(false);
                    mKualifikasiSurvey.setProgress(mKualifikasiSurvey.getProgress()-100/mKompalForms.size());
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
        mFormKompal3ds=mDummyMaker.getFormKompal3ds(DrawerFormActivity.kualifikasiSurveyId);
        mAdapter = new FormKompal3dAdapter(mFormKompal3ds);
        mFormKompal3dRecyclerView.setAdapter(mAdapter);
        if(mFormKompal3ds.size()>0){
            mMenuCheckingKompal.setFill(true);
        }else{
            mMenuCheckingKompal.setFill(false);
        }
        mDummyMaker.addMenuCheckingKompal(mMenuCheckingKompal);
        mCustomClickListener.clickListener();
    }


    private class FormKompal3dHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mNoTextView;
        private TextView mJenisStandarTextView;
        private TextView mKeteranganTextView;
        private ImageButton mDeleteButton;

        private FormKompal3d mFormKompal3d;

        public void bindFormKompal3d(final FormKompal3d formKompal3d, int no) {
            mFormKompal3d = formKompal3d;
            mJenisStandarTextView.setText(mFormKompal3d.getJenisStandarMutu());
            mKeteranganTextView.setText(mFormKompal3d.getKeterangan());
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
                            DummyMaker.get(getActivity()).deleteFormKompal3d(formKompal3d);
                            updateUI();
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

        public FormKompal3dHolder(View itemView) {
            //setiap ada yang masuk ke super , reference setiap wideget dibuat oleh parent
            super(itemView);
            itemView.setOnClickListener(this);

            mNoTextView=(TextView)itemView.findViewById(R.id.list_item_kompal3d_no);
            mJenisStandarTextView = (TextView) itemView.findViewById(R.id.list_item_kompal3d_jenis_standar);
            mKeteranganTextView = (TextView) itemView.findViewById(R.id.list_item_kompal3d_keterangan);
            mDeleteButton=(ImageButton) itemView.findViewById(R.id.list_item_kompal3d_delete);


        }


        @Override
        public void onClick(View v) {
            Intent intent=new Intent(getActivity(),FormKompal3dPagerActivity.class);
            intent.putExtra(EXTRA_ID_FORMKOMPAL3D,mFormKompal3d.getIdStandarMutu());
            intent.putExtra(EXTRA_KUALIFIKASISURVEY_FORMKOMPAL3D,mFormKompal3d.getKualifikasiSurveyId());
            startActivity(intent);
        }
    }

    private class FormKompal3dAdapter extends RecyclerView.Adapter<FormKompal3dHolder> {
        private List<FormKompal3d> mFormKompal3ds;

        public FormKompal3dAdapter(List<FormKompal3d> formKompal3ds) {
            mFormKompal3ds = formKompal3ds;
        }

        @Override
        public FormKompal3dHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater
                    .inflate(R.layout.list_item_form_kompal3d, parent, false);
            return new FormKompal3dHolder(view);
        }

        @Override
        public void onBindViewHolder(FormKompal3dHolder holder, int position) {
            FormKompal3d formKompal3d = mFormKompal3ds.get(position);
            holder.bindFormKompal3d(formKompal3d,position+1);
        }

        @Override
        public int getItemCount() {
            return mFormKompal3ds.size();
        }

        public void setData(List<FormKompal3d> formKompal3ds){
            mFormKompal3ds=formKompal3ds;
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
                FormKompal3d formKompal3d=new FormKompal3d();
                formKompal3d.setKualifikasiSurveyId(DrawerFormActivity.kualifikasiSurveyId);
                DummyMaker.get(getActivity()).addFormKompal3d(formKompal3d);
                Intent intent=new Intent(getActivity(),FormKompal3dPagerActivity.class);
                intent.putExtra(EXTRA_ID_FORMKOMPAL3D,formKompal3d.getIdStandarMutu());
                intent.putExtra(EXTRA_KUALIFIKASISURVEY_FORMKOMPAL3D,formKompal3d.getKualifikasiSurveyId());
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
