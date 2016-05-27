package com.mpewpazi.android.awaljunisidang;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.mpewpazi.android.awaljunisidang.Form.FormGalpal7;
import com.mpewpazi.android.awaljunisidang.Fragment.FormGalpal7Fragment;
import com.mpewpazi.android.awaljunisidang.dummy.DummyMaker;

import java.util.List;
import java.util.UUID;

/**
 * Created by mpewpazi on 5/27/16.
 */
public class FormGalpal7PagerActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private List<FormGalpal7> mFormGalpal7s;

    private final static String EXTRA_KUALIFIKASISURVEY_FORMGALPAL7="extra_kualifikasisurvey_form_galpal7";
    private final static String EXTRA_ID_FORMGALPAL7="extra_id_form_galpal7";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_galpal_peralatan_pager);

        final int kualifikasiSurveyId=getIntent().getIntExtra(EXTRA_KUALIFIKASISURVEY_FORMGALPAL7,0);
        UUID formGalpal7Id=(UUID)getIntent().getSerializableExtra(EXTRA_ID_FORMGALPAL7);

        mViewPager=(ViewPager)findViewById(R.id.activity_formgalpal_peralatan_pager_view_pager);


        mFormGalpal7s= DummyMaker.get(this).getFormGalpal7s(kualifikasiSurveyId);

        FragmentManager fragmentManager=getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentPagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                FormGalpal7 formGalpal7=mFormGalpal7s.get(position);
                return FormGalpal7Fragment.newInstance(formGalpal7.getIdPeralatanKerjaTugboat(),kualifikasiSurveyId);
            }

            @Override
            public int getCount() {
                return mFormGalpal7s.size();
            }
        });


        //by default pageradapter show the first item, to change it look at below code
        for(int i=0;i<mFormGalpal7s.size();i++){
            if(mFormGalpal7s.get(i).getIdPeralatanKerjaTugboat().equals(formGalpal7Id)){
                mViewPager.setCurrentItem(i);
                break;
            }

        }

        //UNTUK melimit jumlah page yang diload
        //mViewPager.setOffscreenPageLimit(2);


    }
}
