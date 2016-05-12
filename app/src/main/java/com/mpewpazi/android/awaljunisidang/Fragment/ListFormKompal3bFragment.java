package com.mpewpazi.android.awaljunisidang.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.mpewpazi.android.awaljunisidang.DrawerFormActivity;
import com.mpewpazi.android.awaljunisidang.Form.FormKompal3b;
import com.mpewpazi.android.awaljunisidang.FormKompal3bPagerActivity;
import com.mpewpazi.android.awaljunisidang.R;
import com.mpewpazi.android.awaljunisidang.dummy.DummyMaker;

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

    private Button mSubmitButton;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_form_kompal3b_list, container, false);


        mFormKompal3bRecyclerView = (RecyclerView) view.findViewById(R.id.form_kompal3b_recycler_view);
        mSubmitButton=(Button)view.findViewById(R.id.kompal3b_btn_submit);

        //recycler view butuh layoutmanager untuk mempossionig item di screen
        //ada banyak macam layout manager, kalau linear itu untuk vertikal posisioningnya
        //kedepanya ada gridLayoutManager
        mFormKompal3bRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

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
        mFormKompal3bs=mDummyMaker.getFormKompal3bs(DrawerFormActivity.kualifikasiSurveyId);
        mAdapter = new FormKompal3bAdapter(mFormKompal3bs);
        mFormKompal3bRecyclerView.setAdapter(mAdapter);
    }


    private class FormKompal3bHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mNoTextView;
        private TextView mJenisProdukTextView;
        private TextView mJumlahProduk2014TextView;

        private FormKompal3b mFormKompal3b;

        public void bindFormKompal3b(FormKompal3b formKompal3b,int no) {
            mFormKompal3b = formKompal3b;
            mJenisProdukTextView.setText(mFormKompal3b.getJenisProduk());
            mJumlahProduk2014TextView.setText(String.valueOf(mFormKompal3b.getJumlahProdThn4()));
            mNoTextView.setText(String.valueOf(no));

        }

        public FormKompal3bHolder(View itemView) {
            //setiap ada yang masuk ke super , reference setiap wideget dibuat oleh parent
            super(itemView);
            itemView.setOnClickListener(this);

            mNoTextView=(TextView)itemView.findViewById(R.id.list_item_kompal3b_no);
            mJenisProdukTextView = (TextView) itemView.findViewById(R.id.list_item_kompal3b_jenis_produk);
            mJumlahProduk2014TextView = (TextView) itemView.findViewById(R.id.list_item_kompal3b_jumlah_prod_2014);



        }


        @Override
        public void onClick(View v) {
            Intent intent=new Intent(getActivity(),FormKompal3bPagerActivity.class);
            intent.putExtra(EXTRA_ID_FORMKOMPAL3B,mFormKompal3b.getIdjumlahProduksi());
            intent.putExtra(EXTRA_KUALIFIKASISURVEY_FORMKOMPAL3B,mFormKompal3b.getIdKualifikasiSurvey());
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
        inflater.inflate(R.menu.fragment_form_list, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_item_new_crime:
                FormKompal3b formKompal3b=new FormKompal3b();
                formKompal3b.setIdKualifikasiSurvey(DrawerFormActivity.kualifikasiSurveyId);
                DummyMaker.get(getActivity()).addFormKompal3b(formKompal3b);
                Intent intent=new Intent(getActivity(),FormKompal3bPagerActivity.class);
                intent.putExtra(EXTRA_ID_FORMKOMPAL3B,formKompal3b.getIdjumlahProduksi());
                intent.putExtra(EXTRA_KUALIFIKASISURVEY_FORMKOMPAL3B,formKompal3b.getIdKualifikasiSurvey());
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}