package com.mpewpazi.android.awaljunisidang;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.mpewpazi.android.awaljunisidang.Form.SingleForm;
import com.mpewpazi.android.awaljunisidang.dummy.DummyMaker;
import com.mpewpazi.android.awaljunisidang.model.KualifikasiSurvey;

import java.util.ArrayList;
import java.util.List;

public class DrawerFormActivity extends ActionBarActivity {

    private static final String EXTRA_ID_SURVEY="test";


    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;

    //untuk merubah kembali nama aplikasi
    private String mActivityTitle;

    private KualifikasiSurvey mKualifikasiSurvey;


    private List<String> mNamaFormList;
    private List<Fragment> mFragmentList;


    public static int kualifikasiSurveyId;

    private DummyMaker mDummyMaker;

    private List<SingleForm> mGalpalForms;
    private List<SingleForm> mKompalForms;


    //array adapter untuk list item di drawer
    private ArrayAdapter<String> mArrayAdapter;

    private ActionBarDrawerToggle mDrawerToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //FormGalpalDBHelper dbHelper=new FormGalpalDBHelper(this);
        //int x=dbHelper.numberOfRows(BaseDBHelper.FORM_GALPAL1_TABLE_NAME);

        //Toast.makeText(this,String.valueOf(x),Toast.LENGTH_SHORT).show();


        //ambil extra
        kualifikasiSurveyId=getIntent().getIntExtra(EXTRA_ID_SURVEY,0);

        mDummyMaker=DummyMaker.get(this);
        mKualifikasiSurvey=mDummyMaker.getKualifikasiSurvey(kualifikasiSurveyId);



        //cari data dari dari surveyAssignation sesuai dengan id yang dari extra
        mGalpalForms= mDummyMaker.getGalpalForms(kualifikasiSurveyId);
        mKompalForms= mDummyMaker.getKompalForms(kualifikasiSurveyId);

        Toast.makeText(this,String.valueOf(kualifikasiSurveyId),Toast.LENGTH_SHORT).show();

        mNamaFormList=new ArrayList<>();
        for(int i=0;i<mGalpalForms.size();i++){
            mNamaFormList.add(mGalpalForms.get(i).getNamaForm());
        }
        for(int i=0;i<mKompalForms.size();i++){
            mNamaFormList.add(mKompalForms.get(i).getNamaForm());
        }

        // fragmen dimasukan kedalam list untuk dimunculkan dilayar
        mFragmentList=new ArrayList<>();
        for(int i=0;i<mGalpalForms.size();i++){
            mFragmentList.add(mGalpalForms.get(i).getFragment());
        }
        for(int i=0;i<mKompalForms.size();i++){
            mFragmentList.add(mKompalForms.get(i).getFragment());
        }


        //munculkan fragmen 0
       // Fragment fragment=new FormGalpal1Fragment();
        Fragment fragment=mFragmentList.get(0);
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit();



        mDrawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
        mDrawerList=(ListView)findViewById(R.id.nav_list_view);
        mActivityTitle=getTitle().toString();

        addDrawerItems();
        setupDrawer();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(mKualifikasiSurvey.getPerusahaan().getNamaPerusahaan());
        //getSupportActionBar().setHomeButtonEnabled(true);


    }

    private void addDrawerItems(){
        //String[] titleItemDrawerArray={"Identitas Umum Perusahaan","Identitas Umum Galangan","Tinjauan Wilayah Maritim","Faktor-Faktor Produksi","Legalitas Perusahaan"};
        mArrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mNamaFormList);
        mDrawerList.setAdapter(mArrayAdapter);
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
    }

    private void setupDrawer(){
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.drawer_open, R.string.drawer_close) {

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
               // getSupportActionBar().setTitle(mKualifikasiSurvey.getJenisObjekSurvey());
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                getSupportActionBar().setTitle(mKualifikasiSurvey.getPerusahaan().getNamaPerusahaan());
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };

        mDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }

    }

    private void selectItem(int position) {

        Fragment fragment = null;

        switch (position) {
            case 0:
                fragment = mFragmentList.get(0);
                break;
            case 1:
                fragment = mFragmentList.get(1);
                break;
            case 2:
                fragment = mFragmentList.get(2);
                break;
            case 3:
                fragment = mFragmentList.get(3);
                break;


            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit();

            mDrawerList.setItemChecked(position, true);
            mDrawerList.setSelection(position);
           // getSupportActionBar().setTitle("Form 1");
            mDrawerLayout.closeDrawer(mDrawerList);

        } else {
            Log.e("DrawerFormActivity", "Error in creating fragment");
        }
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
}
