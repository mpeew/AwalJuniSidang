package com.mpewpazi.android.awaljunisidang;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.mpewpazi.android.awaljunisidang.Fragment.FormGalpal1Fragment;
import com.mpewpazi.android.awaljunisidang.Fragment.FormGalpal3Fragment;
import com.mpewpazi.android.awaljunisidang.Fragment.FormGalpal4Fragment;
import com.mpewpazi.android.awaljunisidang.Fragment.ListFormGalpal10Fragment;
import com.mpewpazi.android.awaljunisidang.Fragment.ListFormGalpal11Fragment;
import com.mpewpazi.android.awaljunisidang.Fragment.ListFormGalpal6Fragment;
import com.mpewpazi.android.awaljunisidang.Fragment.ListFormGalpal7Fragment;
import com.mpewpazi.android.awaljunisidang.Fragment.ListFormGalpal8Fragment;
import com.mpewpazi.android.awaljunisidang.Fragment.ListFormGalpal9Fragment;
import com.mpewpazi.android.awaljunisidang.Fragment.ListFormGalpalFotoFragment;
import com.mpewpazi.android.awaljunisidang.Fragment.ListFormKompal3aFragment;
import com.mpewpazi.android.awaljunisidang.Fragment.ListFormKompal3bFragment;
import com.mpewpazi.android.awaljunisidang.Fragment.ListFormKompal3cFragment;
import com.mpewpazi.android.awaljunisidang.Fragment.ListFormKompal3dFragment;
import com.mpewpazi.android.awaljunisidang.Fragment.SingleFragment;
import com.mpewpazi.android.awaljunisidang.dummy.DummyMaker;
import com.mpewpazi.android.awaljunisidang.model.KualifikasiSurvey;
import com.mpewpazi.android.awaljunisidang.model.Perusahaan;
import com.mpewpazi.android.awaljunisidang.model.SingleMenuChecking;

import java.util.List;

public class DrawerFormActivity extends ActionBarActivity implements CustomClickListener {

    private static final String EXTRA_ID_SURVEY="test";


    private DrawerLayout mDrawerLayout;
    private ListView mDrawerListView;
    private ActionBarDrawerToggle mDrawerToggle;

    private CharSequence mDrawerTitle;
    private CharSequence mTitle;

    public static CustomDrawerAdapter mAdapter;


    private KualifikasiSurvey mKualifikasiSurvey;
    public static int kualifikasiSurveyId;
    private DummyMaker mDummyMaker;
    private List<SingleMenuChecking> mMenuCheckingSingles;

    private boolean isGalpalIndustri;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        kualifikasiSurveyId=getIntent().getIntExtra(EXTRA_ID_SURVEY,0);

        mDummyMaker=DummyMaker.get(this);
        mKualifikasiSurvey=mDummyMaker.getKualifikasiSurvey(kualifikasiSurveyId);

        mDrawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
        mDrawerListView=(ListView) findViewById(R.id.nav_list_view);

        GalKomSharedPreference.setPositionClicked(getApplicationContext(),0);
        mDrawerListView.setItemChecked(GalKomSharedPreference.getPositionClicked(getApplicationContext()),true);


        addDrawerItems();
        mDrawerListView.setOnItemClickListener(new DrawerItemClickListener(isGalpalIndustri));


        //munculkan fragmen 0
       // Fragment fragment=new FormGalpal1Fragment();
        Log.i("Coba","Test");
        if(isGalpalIndustri) {
            SelectItemGalpal(0);
        }else{
            SelectItemKompal(0);
        }




        setupDrawer();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(mDummyMaker.getPerusahaan(mKualifikasiSurvey.getPerusahaanId()).getNamaPerusahaan());



    }

    private void addDrawerItems(){
        if(mDummyMaker.getPerusahaan(mKualifikasiSurvey.getPerusahaanId()).getIndustri().equals(Perusahaan.industriGalpal)){
            mMenuCheckingSingles=mDummyMaker.getMenuCheckingGalpals(kualifikasiSurveyId);
            isGalpalIndustri=true;
        }else{
            mMenuCheckingSingles=mDummyMaker.getMenuCheckingKompals(kualifikasiSurveyId);
            isGalpalIndustri=false;
        }

        mAdapter=new CustomDrawerAdapter(DrawerFormActivity.this,R.layout.list_item_single_form,mMenuCheckingSingles,isGalpalIndustri);
        mDrawerListView.setAdapter(mAdapter);
        mDrawerListView.setItemChecked(GalKomSharedPreference.getPositionClicked(getApplicationContext()),true);
        mDrawerListView.smoothScrollToPosition(GalKomSharedPreference.getPositionClicked(getApplicationContext()));

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
        if (id == R.id.menu_logout) {
            GalKomSharedPreference.setLoggedIn(getApplicationContext(),false);
            Intent i = new Intent(this, LoginActivity.class);
            // Closing all the Activities
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);
            mDummyMaker.deleteGalpalFormsMenus();
            mDummyMaker.deleteKompalFormsMenus();
            mDummyMaker.deleteKualifikasiSurveys();
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

    public void SelectItemGalpal(int position){
        SingleFragment fragment=null;
        Bundle args=new Bundle();
        switch (position){
            case 0:
                fragment= new FormGalpal1Fragment();
                break;
            case 1:
                fragment= new FormGalpal3Fragment();
                break;
            case 2:
                fragment= new ListFormGalpalFotoFragment();
                break;
            case 3:
                fragment= new FormGalpal4Fragment();
                break;
            case 4:
                fragment= new ListFormGalpal6Fragment();
                break;
            case 5:
                fragment= new ListFormGalpal7Fragment();
                break;
            case 6:
                fragment= new ListFormGalpal8Fragment();
                break;
            case 7:
                fragment= new ListFormGalpal9Fragment();
                break;
            case 8:
                fragment= new ListFormGalpal10Fragment();
                break;
            case 9:
                fragment= new ListFormGalpal11Fragment();
                break;
            default:
                break;
        }
        fragment.setCustomClickListener(this);
        FragmentManager frgManager = getSupportFragmentManager();
        frgManager.beginTransaction().replace(R.id.fragment_container, fragment)
                .commit();

        mDrawerListView.setItemChecked(position, true);
        GalKomSharedPreference.setPositionClicked(getApplicationContext(),position);
        //setTitle(dataList.get(possition).getItemName());
        mDrawerLayout.closeDrawer(mDrawerListView);
    }

    public void SelectItemKompal(int position){
        SingleFragment fragment=null;
        switch (position){
            case 0:
                fragment= new ListFormKompal3aFragment();
                break;
            case 1:
                fragment= new ListFormKompal3bFragment();
                break;
            case 2:
                fragment= new ListFormKompal3cFragment();
                break;
            case 3:
                fragment= new ListFormKompal3dFragment();
                break;
        }

        fragment.setCustomClickListener(this);
        FragmentManager frgManager = getSupportFragmentManager();
        frgManager.beginTransaction().replace(R.id.fragment_container, fragment)
                .commit();

        mDrawerListView.setItemChecked(position, true);
        GalKomSharedPreference.setPositionClicked(getApplicationContext(),position);
        //setTitle(dataList.get(possition).getItemName());
        mDrawerLayout.closeDrawer(mDrawerListView);
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        private boolean isGalpalIndustri;

        private DrawerItemClickListener(boolean isGalpalIndustri){
            this.isGalpalIndustri=isGalpalIndustri;
        }

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
           if(isGalpalIndustri) {
               SelectItemGalpal(position);
           }else{
               SelectItemKompal(position);
           }

        }
    }






}
