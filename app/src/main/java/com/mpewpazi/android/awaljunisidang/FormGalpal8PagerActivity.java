package com.mpewpazi.android.awaljunisidang;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.mpewpazi.android.awaljunisidang.Form.FormGalpal8;
import com.mpewpazi.android.awaljunisidang.Fragment.FormGalpal8Fragment;
import com.mpewpazi.android.awaljunisidang.dummy.DummyMaker;

import java.util.List;
import java.util.UUID;

/**
 * Created by mpewpazi on 5/27/16.
 */
public class FormGalpal8PagerActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private List<FormGalpal8> mFormGalpal8s;

    private final static String EXTRA_KUALIFIKASISURVEY_FORMGALPAL8="extra_kualifikasisurvey_form_galpal8";
    private final static String EXTRA_ID_FORMGALPAL8="extra_id_form_galpal8";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_galpal_peralatan_pager);

        final int kualifikasiSurveyId=getIntent().getIntExtra(EXTRA_KUALIFIKASISURVEY_FORMGALPAL8,0);
        UUID formGalpal8Id=(UUID)getIntent().getSerializableExtra(EXTRA_ID_FORMGALPAL8);

        mViewPager=(ViewPager)findViewById(R.id.activity_formgalpal_peralatan_pager_view_pager);


        mFormGalpal8s= DummyMaker.get(this).getFormGalpal8s(kualifikasiSurveyId);

        FragmentManager fragmentManager=getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentPagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                FormGalpal8 formGalpal8=mFormGalpal8s.get(position);
                return FormGalpal8Fragment.newInstance(formGalpal8.getIdPeralatanKerjaProdMesin(),kualifikasiSurveyId);
            }

            @Override
            public int getCount() {
                return mFormGalpal8s.size();
            }
        });


        //by default pageradapter show the first item, to change it look at below code
        for(int i=0;i<mFormGalpal8s.size();i++){
            if(mFormGalpal8s.get(i).getIdPeralatanKerjaProdMesin().equals(formGalpal8Id)){
                mViewPager.setCurrentItem(i);
                break;
            }

        }

        //UNTUK melimit jumlah page yang diload
        //mViewPager.setOffscreenPageLimit(2);


    }
}
