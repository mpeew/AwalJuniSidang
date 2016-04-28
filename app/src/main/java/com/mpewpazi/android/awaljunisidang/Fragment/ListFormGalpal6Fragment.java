package com.mpewpazi.android.awaljunisidang.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mpewpazi.android.awaljunisidang.DrawerFormActivity;
import com.mpewpazi.android.awaljunisidang.Form.FormGalpal6;
import com.mpewpazi.android.awaljunisidang.Form.FormGalpal6List;
import com.mpewpazi.android.awaljunisidang.FormGalpal6PagerActivity;
import com.mpewpazi.android.awaljunisidang.R;
import com.mpewpazi.android.awaljunisidang.dummy.DummyMaker;

import java.util.List;

/**
 * Created by mpewpazi on 4/22/16.
 */
public class ListFormGalpal6Fragment extends Fragment {
    private final static String NAMA_FORM="Peralatan Ruang Kerja Luar Ruang Cranes";
    private final static String EXTRA_KUALIFIKASISURVEY_FORMGALPAL6="extra_kualifikasisurvey_form_galpal6";
    private final static String EXTRA_ID_FORMGALPAL6="extra_id_form_galpal6";


    private List<FormGalpal6> mFormGalpal6s;

    private FormGalpal6List mFormGalpal6List;
    private RecyclerView mFormGalpal6RecyclerView;
    private FormGalpal6Adapter mAdapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_form_galpal6_list, container, false);

        mFormGalpal6RecyclerView = (RecyclerView) view.findViewById(R.id.form_galpal6_recycler_view);

        //recycler view butuh layoutmanager untuk mempossionig item di screen
        //ada banyak macam layout manager, kalau linear itu untuk vertikal posisioningnya
        //kedepanya ada gridLayoutManager
        mFormGalpal6RecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    @Override
    public void onStart() {
        super.onStart();
        updateUI();
    }

    private void updateUI() {
        mFormGalpal6List=(FormGalpal6List) DummyMaker.get(getActivity()).
                getGalpalForm(DrawerFormActivity.kualifikasiSurveyId,NAMA_FORM);

        mFormGalpal6s=mFormGalpal6List.getFormGalpal6s();

        if (mAdapter == null) {
            mAdapter = new FormGalpal6Adapter(mFormGalpal6s);
            mFormGalpal6RecyclerView.setAdapter(mAdapter);
        } else {

           // reload all the item in he list
            mAdapter.setData(mFormGalpal6s);
            mAdapter.notifyDataSetChanged();
        }
    }

    private class FormGalpal6Holder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mJenisMesinTextView;
        private TextView mTahunPembuatanTextView;

        private FormGalpal6 mFormGalpal6;

        public void bindFormGalpal6(FormGalpal6 formGalpal6) {
            mFormGalpal6 = formGalpal6;
            mJenisMesinTextView.setText(mFormGalpal6.getJenisMesin());
            mTahunPembuatanTextView.setText(String.valueOf(mFormGalpal6.getTahunPembuatan()));

        }

        public FormGalpal6Holder(View itemView) {
            //setiap ada yang masuk ke super , reference setiap wideget dibuat oleh parent
            super(itemView);
            itemView.setOnClickListener(this);

            mJenisMesinTextView = (TextView) itemView.findViewById(R.id.list_item_galpal6_jenis_mesin);
            mTahunPembuatanTextView = (TextView) itemView.findViewById(R.id.list_item_galpal6_tahun_pembuatan);



        }


        @Override
        public void onClick(View v) {
              Intent intent=new Intent(getActivity(),FormGalpal6PagerActivity.class);
              intent.putExtra(EXTRA_ID_FORMGALPAL6,mFormGalpal6.getUUID());
              intent.putExtra(EXTRA_KUALIFIKASISURVEY_FORMGALPAL6,mFormGalpal6.getKualifikasiSurvey().getKualifikasiSurveyId());
              startActivity(intent);
        }
    }

    private class FormGalpal6Adapter extends RecyclerView.Adapter<FormGalpal6Holder> {
        private List<FormGalpal6> mFormGalpal6s;

        public FormGalpal6Adapter(List<FormGalpal6> formGalpal6s) {
            mFormGalpal6s = formGalpal6s;
        }

        @Override
        public FormGalpal6Holder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater
                    .inflate(R.layout.list_item_form_galpal6, parent, false);
            return new FormGalpal6Holder(view);
        }

        @Override
        public void onBindViewHolder(FormGalpal6Holder holder, int position) {
            FormGalpal6 formGalpal6 = mFormGalpal6s.get(position);
            holder.bindFormGalpal6(formGalpal6);
        }

        @Override
        public int getItemCount() {
            return mFormGalpal6s.size();
        }

        public void setData(List<FormGalpal6> formGalpal6s){
            mFormGalpal6s=formGalpal6s;
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
                FormGalpal6 formGalpal6=new FormGalpal6();
                mFormGalpal6List=(FormGalpal6List) DummyMaker.get(getActivity()).
                        getGalpalForm(DrawerFormActivity.kualifikasiSurveyId,NAMA_FORM);
                mFormGalpal6List.addFormGalpal6(formGalpal6,DummyMaker.get(getActivity()).getKualifikasiSurvey(DrawerFormActivity.kualifikasiSurveyId));
                Intent intent=new Intent(getActivity(),FormGalpal6PagerActivity.class);
                intent.putExtra(EXTRA_ID_FORMGALPAL6,formGalpal6.getUUID());
                //intent.putExtra(EXTRA_KUALIFIKASISURVEY_FORMGALPAL6,mFormGalpal6.getKualifikasiSurvey().getKualifikasiSurveyId());
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



}