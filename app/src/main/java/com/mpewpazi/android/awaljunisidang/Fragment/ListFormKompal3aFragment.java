package com.mpewpazi.android.awaljunisidang.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
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
import android.widget.TextView;

import com.mpewpazi.android.awaljunisidang.DrawerFormActivity;
import com.mpewpazi.android.awaljunisidang.Form.FormKompal3a;
import com.mpewpazi.android.awaljunisidang.R;
import com.mpewpazi.android.awaljunisidang.dummy.DummyMaker;

import java.util.List;

/**
 * Created by mpewpazi on 5/10/16.
 */
public class ListFormKompal3aFragment extends Fragment {
    private final static String EXTRA_KUALIFIKASISURVEY_FORMKOMPAL3A="extra_kualifikasisurvey_form_kompal3a";
    private final static String EXTRA_ID_FORMKOMPAL3A="extra_id_form_kompal3a";


    private List<FormKompal3a> mFormKompal3as;

    private RecyclerView mFormKompal3aRecyclerView;
    private FormKompal3aAdapter mAdapter;
    private DummyMaker mDummyMaker;

    private Button mSubmitButton;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_form_kompal3a_list, container, false);


        mFormKompal3aRecyclerView = (RecyclerView) view.findViewById(R.id.form_kompal3a_recycler_view);
        mSubmitButton=(Button)view.findViewById(R.id.kompal3a_btn_submit);

        //recycler view butuh layoutmanager untuk mempossionig item di screen
        //ada banyak macam layout manager, kalau linear itu untuk vertikal posisioningnya
        //kedepanya ada gridLayoutManager
        mFormKompal3aRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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


       // mFormKompal3as=mDummyMaker.getFormKompal3as(DrawerFormActivity.kualifikasiSurveyId);

        //if (mAdapter == null) {
        mAdapter = new FormKompal3aAdapter(mFormKompal3as);
        mFormKompal3aRecyclerView.setAdapter(mAdapter);
        Log.d("updateGui","true");
        //} else {

        // reload all the item in he list
        //Log.d("updateGui","else");
        //mAdapter.setData(mFormKompal3as);
        //mAdapter.notifyDataSetChanged();
        //}
    }

    private class FormKompal3aHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mNoTextView;
        private TextView mJenisProduksiTextView;
        private TextView mKapasitasProduksiTextView;

        private FormKompal3a mFormKompal3a;

        public void bindFormKompal3a(FormKompal3a formKompal3a,int no) {
            mFormKompal3a = formKompal3a;
            mJenisProduksiTextView.setText(mFormKompal3a.getJenisProduksi());
            mKapasitasProduksiTextView.setText(mFormKompal3a.getKapasitasProduksi());
            mNoTextView.setText(String.valueOf(no));

        }

        public FormKompal3aHolder(View itemView) {
            //setiap ada yang masuk ke super , reference setiap wideget dibuat oleh parent
            super(itemView);
            itemView.setOnClickListener(this);

            mNoTextView=(TextView)itemView.findViewById(R.id.list_item_kompal3a_no);
            mJenisProduksiTextView = (TextView) itemView.findViewById(R.id.list_item_kompal3a_jenis_produksi);
            mKapasitasProduksiTextView = (TextView) itemView.findViewById(R.id.list_item_kompal3a_kapasitas_produksi);



        }


        @Override
        public void onClick(View v) {
            //Intent intent=new Intent(getActivity(),FormKompal3aPagerActivity.class);
           // intent.putExtra(EXTRA_ID_FORMKOMPAL3A,mFormKompal3a.getIdPeralatanKerjaCrane());
            //intent.putExtra(EXTRA_KUALIFIKASISURVEY_FORMKOMPAL3A,mFormKompal3a.getKualifikasiSurveyId());
           // startActivity(intent);
        }
    }

    private class FormKompal3aAdapter extends RecyclerView.Adapter<FormKompal3aHolder> {
        private List<FormKompal3a> mFormKompal3as;

        public FormKompal3aAdapter(List<FormKompal3a> formKompal3as) {
            mFormKompal3as = formKompal3as;
        }

        @Override
        public FormKompal3aHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater
                    .inflate(R.layout.list_item_form_kompal3a, parent, false);
            return new FormKompal3aHolder(view);
        }

        @Override
        public void onBindViewHolder(FormKompal3aHolder holder, int position) {
            FormKompal3a formKompal3a = mFormKompal3as.get(position);
            holder.bindFormKompal3a(formKompal3a,position+1);
        }

        @Override
        public int getItemCount() {
            return mFormKompal3as.size();
        }

        public void setData(List<FormKompal3a> formKompal3as){
            mFormKompal3as=formKompal3as;
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
                FormKompal3a formKompal3a=new FormKompal3a();
                formKompal3a.setIdKualifikasiSurvey(DrawerFormActivity.kualifikasiSurveyId);
                DummyMaker.get(getActivity()).addFormKompal3a(formKompal3a);
                //Intent intent=new Intent(getActivity(),FormKompal3aPagerActivity.class);
               // intent.putExtra(EXTRA_ID_FORMKOMPAL3A,formKompal3a.getIdJenisKapasitasProduksi());
              //  intent.putExtra(EXTRA_KUALIFIKASISURVEY_FORMKOMPAL3A,formKompal3a.getIdKualifikasiSurvey());
              //  startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
