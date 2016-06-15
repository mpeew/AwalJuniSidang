package com.mpewpazi.android.awaljunisidang.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.mpewpazi.android.awaljunisidang.R;
import com.mpewpazi.android.awaljunisidang.formModel.FormKompal3c;
import com.mpewpazi.android.awaljunisidang.fragment.FormKompal3cFragment;
import com.mpewpazi.android.awaljunisidang.database.DummyMaker;

import java.util.List;
import java.util.UUID;

/**
 * Created by mpewpazi on 5/11/16.
 */
public class FormKompal3cPagerActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private List<FormKompal3c> mFormKompal3cs;

    private final static String EXTRA_KUALIFIKASISURVEY_FORMKOMPAL3C="extra_kualifikasisurvey_form_kompal3c";
    private final static String EXTRA_ID_FORMKOMPAL3C="extra_id_form_kompal3c";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_kompal3c_pager);

        final int kualifikasiSurveyId=getIntent().getIntExtra(EXTRA_KUALIFIKASISURVEY_FORMKOMPAL3C,0);
        UUID formKompal3cId=(UUID)getIntent().getSerializableExtra(EXTRA_ID_FORMKOMPAL3C);

        mViewPager=(ViewPager)findViewById(R.id.activity_formkompal3c_pager_view_pager);


        mFormKompal3cs= DummyMaker.get(this).getFormKompal3cs(kualifikasiSurveyId);

        FragmentManager fragmentManager=getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentPagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                FormKompal3c formKompal3c=mFormKompal3cs.get(position);
                return FormKompal3cFragment.newInstance(formKompal3c.getIdSistemBerproduksi(),kualifikasiSurveyId);
            }

            @Override
            public int getCount() {
                return mFormKompal3cs.size();
            }
        });


        //by default pageradapter show the first item, to change it look at below code
        for(int i=0;i<mFormKompal3cs.size();i++){
            if(mFormKompal3cs.get(i).getIdSistemBerproduksi().equals(formKompal3cId)){
                mViewPager.setCurrentItem(i);
                break;
            }

        }

        //UNTUK melimit jumlah page yang diload
        //mViewPager.setOffscreenPageLimit(2);


    }
}
