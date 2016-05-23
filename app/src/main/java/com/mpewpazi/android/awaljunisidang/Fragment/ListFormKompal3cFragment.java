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
import com.mpewpazi.android.awaljunisidang.Form.FormKompal3c;
import com.mpewpazi.android.awaljunisidang.Form.SingleForm;
import com.mpewpazi.android.awaljunisidang.FormKompal3cPagerActivity;
import com.mpewpazi.android.awaljunisidang.R;
import com.mpewpazi.android.awaljunisidang.dummy.DummyMaker;
import com.mpewpazi.android.awaljunisidang.model.KualifikasiSurvey;
import com.mpewpazi.android.awaljunisidang.model.MenuCheckingKompal;

import java.util.List;

/**
 * Created by mpewpazi on 5/10/16.
 */
public class ListFormKompal3cFragment extends SingleFragment {
    private final static String EXTRA_KUALIFIKASISURVEY_FORMKOMPAL3C="extra_kualifikasisurvey_form_kompal3c";
    private final static String EXTRA_ID_FORMKOMPAL3C="extra_id_form_kompal3c";


    private List<FormKompal3c> mFormKompal3cs;

    private RecyclerView mFormKompal3cRecyclerView;
    private FormKompal3cAdapter mAdapter;
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
        mMenuCheckingKompal=mDummyMaker.getMenuCheckingKompal(DrawerFormActivity.kualifikasiSurveyId,idMenu);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_form_kompal3c_list, container, false);


        mFormKompal3cRecyclerView = (RecyclerView) view.findViewById(R.id.form_kompal3c_recycler_view);
        mSubmitButton=(Button)view.findViewById(R.id.kompal3c_btn_submit);

        //recycler view butuh layoutmanager untuk mempossionig item di screen
        //ada banyak macam layout manager, kalau linear itu untuk vertikal posisioningnya
        //kedepanya ada gridLayoutManager
        mFormKompal3cRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

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
        mFormKompal3cs=mDummyMaker.getFormKompal3cs(DrawerFormActivity.kualifikasiSurveyId);
        mAdapter = new FormKompal3cAdapter(mFormKompal3cs);
        mFormKompal3cRecyclerView.setAdapter(mAdapter);
        if(mFormKompal3cs.size()>0){
            mMenuCheckingKompal.setFill(true);
        }else{
            mMenuCheckingKompal.setFill(false);
        }
        mDummyMaker.addMenuCheckingKompal(mMenuCheckingKompal);
        mCustomClickListener.clickListener();
    }


    private class FormKompal3cHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mNoTextView;
        private TextView mNamaProdukTextView;
        private TextView mSistemProduksiTextView;
        private ImageButton mDeleteButton;

        private FormKompal3c mFormKompal3c;

        public void bindFormKompal3c(final FormKompal3c formKompal3c, int no) {
            mFormKompal3c = formKompal3c;
            mNamaProdukTextView.setText(mFormKompal3c.getNamaProduk());
            mSistemProduksiTextView.setText(String.valueOf(mFormKompal3c.getSistemProduksi()));
            mNoTextView.setText(String.valueOf(no));
            mDeleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder alertDialogBuilder=new AlertDialog.Builder(getActivity());
                    alertDialogBuilder.setMessage("Apakah anda yakin akan menghapus kolom ini");

                    alertDialogBuilder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            DummyMaker.get(getActivity()).deleteFormKompal3c(formKompal3c);
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

        public FormKompal3cHolder(View itemView) {
            //setiap ada yang masuk ke super , reference setiap wideget dibuat oleh parent
            super(itemView);
            itemView.setOnClickListener(this);

            mNoTextView=(TextView)itemView.findViewById(R.id.list_item_kompal3c_no);
            mNamaProdukTextView = (TextView) itemView.findViewById(R.id.list_item_kompal3c_nama_produk);
            mSistemProduksiTextView = (TextView) itemView.findViewById(R.id.list_item_kompal3c_sistem_produksi);
            mDeleteButton=(ImageButton)itemView.findViewById(R.id.list_item_kompal3c_delete);


        }


        @Override
        public void onClick(View v) {
            Intent intent=new Intent(getActivity(),FormKompal3cPagerActivity.class);
            intent.putExtra(EXTRA_ID_FORMKOMPAL3C,mFormKompal3c.getIdSistemBerproduksi());
            intent.putExtra(EXTRA_KUALIFIKASISURVEY_FORMKOMPAL3C,mFormKompal3c.getKualifikasiSurveyId());
            startActivity(intent);
        }
    }

    private class FormKompal3cAdapter extends RecyclerView.Adapter<FormKompal3cHolder> {
        private List<FormKompal3c> mFormKompal3cs;

        public FormKompal3cAdapter(List<FormKompal3c> formKompal3cs) {
            mFormKompal3cs = formKompal3cs;
        }

        @Override
        public FormKompal3cHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater
                    .inflate(R.layout.list_item_form_kompal3c, parent, false);
            return new FormKompal3cHolder(view);
        }

        @Override
        public void onBindViewHolder(FormKompal3cHolder holder, int position) {
            FormKompal3c formKompal3c = mFormKompal3cs.get(position);
            holder.bindFormKompal3c(formKompal3c,position+1);
        }

        @Override
        public int getItemCount() {
            return mFormKompal3cs.size();
        }

        public void setData(List<FormKompal3c> formKompal3cs){
            mFormKompal3cs=formKompal3cs;
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_form_list, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_item_new_crime:
                FormKompal3c formKompal3c=new FormKompal3c();
                formKompal3c.setKualifikasiSurveyId(DrawerFormActivity.kualifikasiSurveyId);
                DummyMaker.get(getActivity()).addFormKompal3c(formKompal3c);
                Intent intent=new Intent(getActivity(),FormKompal3cPagerActivity.class);
                intent.putExtra(EXTRA_ID_FORMKOMPAL3C,formKompal3c.getIdSistemBerproduksi());
                intent.putExtra(EXTRA_KUALIFIKASISURVEY_FORMKOMPAL3C,formKompal3c.getKualifikasiSurveyId());
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
