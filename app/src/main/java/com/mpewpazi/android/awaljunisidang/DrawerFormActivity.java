package com.mpewpazi.android.awaljunisidang;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mpewpazi.android.awaljunisidang.Form.SingleForm;
import com.mpewpazi.android.awaljunisidang.Fragment.SingleFragment;
import com.mpewpazi.android.awaljunisidang.dummy.DummyMaker;
import com.mpewpazi.android.awaljunisidang.model.KualifikasiSurvey;
import com.mpewpazi.android.awaljunisidang.model.MenuCheckingGalpal;
import com.mpewpazi.android.awaljunisidang.model.SingleMenuChecking;

import java.util.List;

public class DrawerFormActivity extends ActionBarActivity implements CustomClickListener {

    private static final String EXTRA_ID_SURVEY="test";


    private DrawerLayout mDrawerLayout;
   // private ListView mDrawerList;
    private RecyclerView mDrawerRecyclerView;
    public static SingleFormAdapter mAdapter;
//a
    //untuk merubah kembali nama aplikasi
    private String mActivityTitle;

    private KualifikasiSurvey mKualifikasiSurvey;


    private List<String> mNamaFormList;
    private List<Fragment> mFragmentList;


    public static int kualifikasiSurveyId;

    private DummyMaker mDummyMaker;

    private List<SingleForm> mSingleForms;
    private List<SingleMenuChecking> mMenuCheckingSingles;




    //array adapter untuk list item di drawer
    private ArrayAdapter<String> mArrayAdapter;

    private ActionBarDrawerToggle mDrawerToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        kualifikasiSurveyId=getIntent().getIntExtra(EXTRA_ID_SURVEY,0);

        mDummyMaker=DummyMaker.get(this);
        mKualifikasiSurvey=mDummyMaker.getKualifikasiSurvey(kualifikasiSurveyId);

        mDrawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
        mDrawerRecyclerView=(RecyclerView)findViewById(R.id.nav_recycler_view);
        mDrawerRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        addDrawerItems();


        //munculkan fragmen 0
       // Fragment fragment=new FormGalpal1Fragment();
        SingleFragment fragment=mSingleForms.get(0).getFragment();
        fragment.setCustomClickListener(this);
        fragment.setIdMenu(0);
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit();





        mActivityTitle=getTitle().toString();


        setupDrawer();


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(mDummyMaker.getPerusahaan(mKualifikasiSurvey.getPerusahaanId()).getNamaPerusahaan());



    }

    private void addDrawerItems(){
        if(mDummyMaker.getPerusahaan(mKualifikasiSurvey.getPerusahaanId()).getIndustri().equals("Galangan Kapal")){
            mSingleForms=mDummyMaker.getGalpalForms();
            for(SingleForm singleForm:mSingleForms){
                MenuCheckingGalpal menuCheckingGalpal=mDummyMaker.getMenuCheckingGalpal(kualifikasiSurveyId,singleForm.getKodeForm());
            }
            mMenuCheckingSingles=mDummyMaker.getMenuCheckingGalpals(kualifikasiSurveyId);
        }else{
            mSingleForms=mDummyMaker.getKompalForms();
            mMenuCheckingSingles=mDummyMaker.getMenuCheckingKompals(kualifikasiSurveyId);
        }



        mAdapter=new SingleFormAdapter(mSingleForms,mMenuCheckingSingles,this);
        mDrawerRecyclerView.setAdapter(mAdapter);

    }

    private void setupDrawer(){
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.drawer_open, R.string.drawer_close) {

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
               // getSupportActionBar().setTitle(mKualifikasiSurvey.getJenisObjekSurvey());
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
                //mAdapter.notifyDataSetChanged();

            }

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                getSupportActionBar().setTitle(mDummyMaker.getPerusahaan(mKualifikasiSurvey.getPerusahaanId()).getNamaPerusahaan());
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };

        mDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }





    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        // Activate the navigation drawer toggle
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void clickListener() {
        addDrawerItems();
    }

    private class SingleFormHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView mNoTextView;
        private TextView mTittleTextView;
        private ImageView mStatusFillTextView;
        private ImageView mStatusCompleteTextView;
        private ImageView mStatusVerifiedTextView;
        private CustomClickListener mCustomClickListener;

        private SingleForm mSingleForm;
        private SingleMenuChecking mMenuCheckingSingle;

        public void bindSingleForm(SingleForm singleForm, SingleMenuChecking menuChecking, int no){
            mSingleForm=singleForm;
            mMenuCheckingSingle=menuChecking;
            mTittleTextView.setText(mSingleForm.getNamaForm());
            //mStatusTextView.setText("-");
            mNoTextView.setText(String.valueOf(no));
            if(mMenuCheckingSingle.isFill()){
                mStatusFillTextView.setImageResource(R.drawable.ok_icon);
            }
            if(mMenuCheckingSingle.isComplete()){
                mStatusCompleteTextView.setImageResource(R.drawable.ok_icon);
            }
            if(mMenuCheckingSingle.isVerified()){
                mStatusVerifiedTextView.setImageResource(R.drawable.ok_icon);
            }

        }

        public SingleFormHolder(View itemView,CustomClickListener customClickListener) {
            //setiap ada yang masuk ke super , reference setiap wideget dibuat oleh parent
            super(itemView);
            itemView.setOnClickListener(this);

            mNoTextView=(TextView) itemView.findViewById(R.id.list_item_single_form_no);
            mTittleTextView=(TextView) itemView.findViewById(R.id.list_item_single_form_title);
            mStatusFillTextView=(ImageView) itemView.findViewById(R.id.list_item_single_form_status_fill);
            mStatusCompleteTextView=(ImageView) itemView.findViewById(R.id.list_item_single_form_status_complete);
            mStatusVerifiedTextView=(ImageView)itemView.findViewById(R.id.list_item_single_form_status_verified);

            mCustomClickListener=customClickListener;


        }



        @Override
        public void onClick(View v) {
            SingleFragment fragment=mSingleForm.getFragment();
            fragment.setCustomClickListener(mCustomClickListener);
            fragment.setIdMenu(getPosition());
            if (fragment != null) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit();
                mDrawerLayout.closeDrawer(mDrawerRecyclerView);

            } else {
                Log.e("DrawerFormActivity", "Error in creating fragment");
            }
        }
    }

    private class SingleFormAdapter extends RecyclerView.Adapter<SingleFormHolder>{
        private List<SingleForm> mSingleForms;
        private CustomClickListener mCustomClickListener;
        private List<SingleMenuChecking> mMenuCheckingSingles;
        public SingleFormAdapter(List<SingleForm> singleForms,List<SingleMenuChecking> menuCheckingGalpals,CustomClickListener customClickListener){
            mMenuCheckingSingles=menuCheckingGalpals;
            mSingleForms=singleForms;
            mCustomClickListener=customClickListener;
        }

        @Override
        public SingleFormHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(DrawerFormActivity.this);
            View view = layoutInflater
                    .inflate(R.layout.list_item_single_form, parent, false);
            return new SingleFormHolder(view,mCustomClickListener);
        }
        @Override
        public void onBindViewHolder(SingleFormHolder holder, int position) {
            SingleForm singleForm = mSingleForms.get(position);
            SingleMenuChecking menuCheckingGalpal=mMenuCheckingSingles.get(position);
            holder.bindSingleForm(singleForm,menuCheckingGalpal,position+1);
        }
        @Override
        public int getItemCount() {
            return mSingleForms.size();
        }


    }


}
