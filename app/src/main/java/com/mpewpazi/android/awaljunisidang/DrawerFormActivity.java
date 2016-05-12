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

import java.util.List;

public class DrawerFormActivity extends ActionBarActivity implements CustomClickListener {

    private static final String EXTRA_ID_SURVEY="test";


    private DrawerLayout mDrawerLayout;
   // private ListView mDrawerList;
    private RecyclerView mDrawerRecyclerView;
    public static SingleFormAdapter mAdapter;

    //untuk merubah kembali nama aplikasi
    private String mActivityTitle;

    private KualifikasiSurvey mKualifikasiSurvey;


    private List<String> mNamaFormList;
    private List<Fragment> mFragmentList;


    public static int kualifikasiSurveyId;

    private DummyMaker mDummyMaker;

    private List<SingleForm> mGalpalForms;
    private List<SingleForm> mKompalForms;
    private List<MenuCheckingGalpal> mMenuCheckingGalpals;




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

        mGalpalForms= mDummyMaker.getGalpalForms();
        mKompalForms= mDummyMaker.getKompalForms();
        mMenuCheckingGalpals=mDummyMaker.getMenuCheckingGalpals(kualifikasiSurveyId);




        //munculkan fragmen 0
       // Fragment fragment=new FormGalpal1Fragment();
        SingleFragment fragment=mGalpalForms.get(0).getFragment();
        fragment.setCustomClickListener(this);
        fragment.setIdMenu(0);
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit();



        mDrawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
        mDrawerRecyclerView=(RecyclerView)findViewById(R.id.nav_recycler_view);
        mDrawerRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mActivityTitle=getTitle().toString();

        addDrawerItems();
        setupDrawer();


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(mDummyMaker.getPerusahaan(mKualifikasiSurvey.getPerusahaanId()).getNamaPerusahaan());



    }

    private void addDrawerItems(){
        mAdapter=new SingleFormAdapter(mGalpalForms,mMenuCheckingGalpals,this);
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
        mGalpalForms=mDummyMaker.getGalpalForms();
        mMenuCheckingGalpals=mDummyMaker.getMenuCheckingGalpals(kualifikasiSurveyId);
        mAdapter=new SingleFormAdapter(mGalpalForms,mMenuCheckingGalpals,this);
        mDrawerRecyclerView.setAdapter(mAdapter);
    }

    private class SingleFormHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView mNoTextView;
        private TextView mTittleTextView;
        private ImageView mStatusTextView;
        private CustomClickListener mCustomClickListener;

        private SingleForm mSingleForm;
        private MenuCheckingGalpal mMenuCheckingGalpal;

        public void bindSingleForm(SingleForm singleForm, MenuCheckingGalpal menuCheckingGalpal, int no){
            mSingleForm=singleForm;
            mMenuCheckingGalpal=menuCheckingGalpal;
            mTittleTextView.setText(mSingleForm.getNamaForm());
            //mStatusTextView.setText("-");
            mNoTextView.setText(String.valueOf(no));
            if(mMenuCheckingGalpal.isComplete()){
                mStatusTextView.setImageResource(R.drawable.ok_icon);
            }

        }

        public SingleFormHolder(View itemView,CustomClickListener customClickListener) {
            //setiap ada yang masuk ke super , reference setiap wideget dibuat oleh parent
            super(itemView);
            itemView.setOnClickListener(this);

            mNoTextView=(TextView) itemView.findViewById(R.id.list_item_single_form_no);
            mTittleTextView=(TextView) itemView.findViewById(R.id.list_item_single_form_title);
            mStatusTextView=(ImageView) itemView.findViewById(R.id.list_item_single_form_status);

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
        private List<MenuCheckingGalpal> mMenuCheckingGalpals;
        public SingleFormAdapter(List<SingleForm> singleForms,List<MenuCheckingGalpal> menuCheckingGalpals,CustomClickListener customClickListener){
            mMenuCheckingGalpals=menuCheckingGalpals;
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
            MenuCheckingGalpal menuCheckingGalpal=mMenuCheckingGalpals.get(position);
            holder.bindSingleForm(singleForm,menuCheckingGalpal,position+1);
        }
        @Override
        public int getItemCount() {
            return mSingleForms.size();
        }


    }

    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
        mAdapter.notifyDataSetChanged();
    }
}
