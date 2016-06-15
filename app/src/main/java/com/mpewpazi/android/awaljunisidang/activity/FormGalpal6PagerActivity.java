package com.mpewpazi.android.awaljunisidang.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.mpewpazi.android.awaljunisidang.R;
import com.mpewpazi.android.awaljunisidang.formModel.FormGalpal6;
import com.mpewpazi.android.awaljunisidang.fragment.FormGalpal6Fragment;
import com.mpewpazi.android.awaljunisidang.database.DummyMaker;

import java.util.List;
import java.util.UUID;

/**
 * Created by mpewpazi on 4/25/16.
 */
public class FormGalpal6PagerActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private List<FormGalpal6> mFormGalpal6s;

    private final static String EXTRA_KUALIFIKASISURVEY_FORMGALPAL6="extra_kualifikasisurvey_form_galpal6";
    private final static String EXTRA_ID_FORMGALPAL6="extra_id_form_galpal6";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_galpal_peralatan_pager);

        final int kualifikasiSurveyId=getIntent().getIntExtra(EXTRA_KUALIFIKASISURVEY_FORMGALPAL6,0);
        UUID formGalpal6Id=(UUID)getIntent().getSerializableExtra(EXTRA_ID_FORMGALPAL6);

        mViewPager=(ViewPager)findViewById(R.id.activity_formgalpal_peralatan_pager_view_pager);


        mFormGalpal6s= DummyMaker.get(this).getFormGalpal6s(kualifikasiSurveyId);

        FragmentManager fragmentManager=getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentPagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                FormGalpal6 formGalpal6=mFormGalpal6s.get(position);
                return FormGalpal6Fragment.newInstance(formGalpal6.getIdPeralatanKerjaCrane(),kualifikasiSurveyId);
            }

            @Override
            public int getCount() {
                return mFormGalpal6s.size();
            }
        });


        //by default pageradapter show the first item, to change it look at below code
        for(int i=0;i<mFormGalpal6s.size();i++){
            if(mFormGalpal6s.get(i).getIdPeralatanKerjaCrane().equals(formGalpal6Id)){
                mViewPager.setCurrentItem(i);
                break;
            }

        }

        //UNTUK melimit jumlah page yang diload
        //mViewPager.setOffscreenPageLimit(2);


    }

}