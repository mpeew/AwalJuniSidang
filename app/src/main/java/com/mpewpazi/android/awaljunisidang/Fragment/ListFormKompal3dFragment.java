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
import com.mpewpazi.android.awaljunisidang.Form.FormKompal3d;
import com.mpewpazi.android.awaljunisidang.FormKompal3dPagerActivity;
import com.mpewpazi.android.awaljunisidang.R;
import com.mpewpazi.android.awaljunisidang.dummy.DummyMaker;

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

    private Button mSubmitButton;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_form_kompal3d_list, container, false);


        mFormKompal3dRecyclerView = (RecyclerView) view.findViewById(R.id.form_kompal3d_recycler_view);
        mSubmitButton=(Button)view.findViewById(R.id.kompal3d_btn_submit);

        //recycler view butuh layoutmanager untuk mempossionig item di screen
        //ada banyak macam layout manager, kalau linear itu untuk vertikal posisioningnya
        //kedepanya ada gridLayoutManager
        mFormKompal3dRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

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
        mFormKompal3ds=mDummyMaker.getFormKompal3ds(DrawerFormActivity.kualifikasiSurveyId);
        mAdapter = new FormKompal3dAdapter(mFormKompal3ds);
        mFormKompal3dRecyclerView.setAdapter(mAdapter);
    }


    private class FormKompal3dHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mNoTextView;
        private TextView mJenisStandarTextView;
        private TextView mKeteranganTextView;

        private FormKompal3d mFormKompal3d;

        public void bindFormKompal3d(FormKompal3d formKompal3d,int no) {
            mFormKompal3d = formKompal3d;
            mJenisStandarTextView.setText(mFormKompal3d.getJenisStandarMutu());
            mKeteranganTextView.setText(mFormKompal3d.getKeterangan());
            mNoTextView.setText(String.valueOf(no));

        }

        public FormKompal3dHolder(View itemView) {
            //setiap ada yang masuk ke super , reference setiap wideget dibuat oleh parent
            super(itemView);
            itemView.setOnClickListener(this);

            mNoTextView=(TextView)itemView.findViewById(R.id.list_item_kompal3d_no);
            mJenisStandarTextView = (TextView) itemView.findViewById(R.id.list_item_kompal3d_jenis_standar);
            mKeteranganTextView = (TextView) itemView.findViewById(R.id.list_item_kompal3d_keterangan);



        }


        @Override
        public void onClick(View v) {
            Intent intent=new Intent(getActivity(),FormKompal3dPagerActivity.class);
            intent.putExtra(EXTRA_ID_FORMKOMPAL3D,mFormKompal3d.getIdStandarMutu());
            intent.putExtra(EXTRA_KUALIFIKASISURVEY_FORMKOMPAL3D,mFormKompal3d.getIdKualifikasiSurvey());
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
        inflater.inflate(R.menu.fragment_form_list, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_item_new_crime:
                FormKompal3d formKompal3d=new FormKompal3d();
                formKompal3d.setIdKualifikasiSurvey(DrawerFormActivity.kualifikasiSurveyId);
                DummyMaker.get(getActivity()).addFormKompal3d(formKompal3d);
                Intent intent=new Intent(getActivity(),FormKompal3dPagerActivity.class);
                intent.putExtra(EXTRA_ID_FORMKOMPAL3D,formKompal3d.getIdStandarMutu());
                intent.putExtra(EXTRA_KUALIFIKASISURVEY_FORMKOMPAL3D,formKompal3d.getIdKualifikasiSurvey());
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
