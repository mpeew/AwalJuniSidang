package com.mpewpazi.android.awaljunisidang;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.mpewpazi.android.awaljunisidang.Form.FormGalpal9;
import com.mpewpazi.android.awaljunisidang.Fragment.FormGalpal9Fragment;
import com.mpewpazi.android.awaljunisidang.dummy.DummyMaker;

import java.util.List;
import java.util.UUID;

/**
 * Created by mpewpazi on 5/27/16.
 */
public class FormGalpal9PagerActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private List<FormGalpal9> mFormGalpal9s;

    private final static String EXTRA_KUALIFIKASISURVEY_FORMGALPAL9="extra_kualifikasisurvey_form_galpal9";
    private final static String EXTRA_ID_FORMGALPAL9="extra_id_form_galpal9";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_galpal_peralatan_pager);

        final int kualifikasiSurveyId=getIntent().getIntExtra(EXTRA_KUALIFIKASISURVEY_FORMGALPAL9,0);
        UUID formGalpal9Id=(UUID)getIntent().getSerializableExtra(EXTRA_ID_FORMGALPAL9);

        mViewPager=(ViewPager)findViewById(R.id.activity_formgalpal_peralatan_pager_view_pager);


        mFormGalpal9s= DummyMaker.get(this).getFormGalpal9s(kualifikasiSurveyId);

        FragmentManager fragmentManager=getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentPagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                FormGalpal9 formGalpal9=mFormGalpal9s.get(position);
                return FormGalpal9Fragment.newInstance(formGalpal9.getIdPeralatanKerjaProduksiKontruksi(),kualifikasiSurveyId);
            }

            @Override
            public int getCount() {
                return mFormGalpal9s.size();
            }
        });


        //by default pageradapter show the first item, to change it look at below code
        for(int i=0;i<mFormGalpal9s.size();i++){
            if(mFormGalpal9s.get(i).getIdPeralatanKerjaProduksiKontruksi().equals(formGalpal9Id)){
                mViewPager.setCurrentItem(i);
                break;
            }

        }

        //UNTUK melimit jumlah page yang diload
        //mViewPager.setOffscreenPageLimit(2);


    }
}
