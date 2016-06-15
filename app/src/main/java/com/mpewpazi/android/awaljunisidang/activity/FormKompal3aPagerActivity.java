package com.mpewpazi.android.awaljunisidang.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.mpewpazi.android.awaljunisidang.R;
import com.mpewpazi.android.awaljunisidang.formModel.FormKompal3a;
import com.mpewpazi.android.awaljunisidang.fragment.FormKompal3aFragment;
import com.mpewpazi.android.awaljunisidang.database.DummyMaker;

import java.util.List;
import java.util.UUID;

/**
 * Created by mpewpazi on 5/11/16.
 */
public class FormKompal3aPagerActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private List<FormKompal3a> mFormKompal3as;

    private final static String EXTRA_KUALIFIKASISURVEY_FORMKOMPAL3A="extra_kualifikasisurvey_form_kompal3a";
    private final static String EXTRA_ID_FORMKOMPAL3A="extra_id_form_kompal3a";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_kompal3a_pager);

        final int kualifikasiSurveyId=getIntent().getIntExtra(EXTRA_KUALIFIKASISURVEY_FORMKOMPAL3A,0);
        UUID formKompal3aId=(UUID)getIntent().getSerializableExtra(EXTRA_ID_FORMKOMPAL3A);

        mViewPager=(ViewPager)findViewById(R.id.activity_formkompal3a_pager_view_pager);


        mFormKompal3as= DummyMaker.get(this).getFormKompal3as(kualifikasiSurveyId);

        FragmentManager fragmentManager=getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentPagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                FormKompal3a formKompal3a=mFormKompal3as.get(position);
                return FormKompal3aFragment.newInstance(formKompal3a.getIdJenisKapasitasProduksi(),kualifikasiSurveyId);
            }

            @Override
            public int getCount() {
                return mFormKompal3as.size();
            }
        });


        //by default pageradapter show the first item, to change it look at below code
        for(int i=0;i<mFormKompal3as.size();i++){
            if(mFormKompal3as.get(i).getIdJenisKapasitasProduksi().equals(formKompal3aId)){
                mViewPager.setCurrentItem(i);
                break;
            }

        }

        //UNTUK melimit jumlah page yang diload
        //mViewPager.setOffscreenPageLimit(2);


    }
}
