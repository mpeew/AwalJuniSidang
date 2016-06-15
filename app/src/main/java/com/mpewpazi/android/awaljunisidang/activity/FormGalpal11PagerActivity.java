package com.mpewpazi.android.awaljunisidang.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.mpewpazi.android.awaljunisidang.R;
import com.mpewpazi.android.awaljunisidang.formModel.FormGalpal11;
import com.mpewpazi.android.awaljunisidang.fragment.FormGalpal11Fragment;
import com.mpewpazi.android.awaljunisidang.database.DummyMaker;

import java.util.List;
import java.util.UUID;

/**
 * Created by mpewpazi on 5/27/16.
 */
public class FormGalpal11PagerActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private List<FormGalpal11> mFormGalpal11s;

    private final static String EXTRA_KUALIFIKASISURVEY_FORMGALPAL11="extra_kualifikasisurvey_form_galpal11";
    private final static String EXTRA_ID_FORMGALPAL11="extra_id_form_galpal11";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_galpal_peralatan_pager);

        final int kualifikasiSurveyId=getIntent().getIntExtra(EXTRA_KUALIFIKASISURVEY_FORMGALPAL11,0);
        UUID formGalpal11Id=(UUID)getIntent().getSerializableExtra(EXTRA_ID_FORMGALPAL11);

        mViewPager=(ViewPager)findViewById(R.id.activity_formgalpal_peralatan_pager_view_pager);


        mFormGalpal11s= DummyMaker.get(this).getFormGalpal11s(kualifikasiSurveyId);

        FragmentManager fragmentManager=getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentPagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                FormGalpal11 formGalpal11=mFormGalpal11s.get(position);
                return FormGalpal11Fragment.newInstance(formGalpal11.getIdPeralatanKerjaProdPengecatan(),kualifikasiSurveyId);
            }

            @Override
            public int getCount() {
                return mFormGalpal11s.size();
            }
        });


        //by default pageradapter show the first item, to change it look at below code
        for(int i=0;i<mFormGalpal11s.size();i++){
            if(mFormGalpal11s.get(i).getIdPeralatanKerjaProdPengecatan().equals(formGalpal11Id)){
                mViewPager.setCurrentItem(i);
                break;
            }

        }

        //UNTUK melimit jumlah page yang diload
        //mViewPager.setOffscreenPageLimit(2);


    }
}
