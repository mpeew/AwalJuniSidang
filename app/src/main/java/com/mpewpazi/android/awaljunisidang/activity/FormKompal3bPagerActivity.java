package com.mpewpazi.android.awaljunisidang.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.mpewpazi.android.awaljunisidang.R;
import com.mpewpazi.android.awaljunisidang.database.DummyMaker;
import com.mpewpazi.android.awaljunisidang.formModel.FormKompal3b;
import com.mpewpazi.android.awaljunisidang.fragment.FormKompal3bFragment;

import java.util.List;
import java.util.UUID;

/**
 * Created by mpewpazi on 5/11/16.
 */
public class FormKompal3bPagerActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private List<FormKompal3b> mFormKompal3bs;

    private final static String EXTRA_KUALIFIKASISURVEY_FORMKOMPAL3B="extra_kualifikasisurvey_form_kompal3b";
    private final static String EXTRA_ID_FORMKOMPAL3B="extra_id_form_kompal3b";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_kompal3b_pager);

        final int kualifikasiSurveyId=getIntent().getIntExtra(EXTRA_KUALIFIKASISURVEY_FORMKOMPAL3B,0);
        UUID formKompal3bId=(UUID)getIntent().getSerializableExtra(EXTRA_ID_FORMKOMPAL3B);

        mViewPager=(ViewPager)findViewById(R.id.activity_formkompal3b_pager_view_pager);


        mFormKompal3bs= DummyMaker.get(this).getFormKompal3bs(kualifikasiSurveyId);

        FragmentManager fragmentManager=getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentPagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                FormKompal3b formKompal3b=mFormKompal3bs.get(position);
                return FormKompal3bFragment.newInstance(formKompal3b.getIdjumlahProduksi(),kualifikasiSurveyId);
            }

            @Override
            public int getCount() {
                return mFormKompal3bs.size();
            }
        });


        //by default pageradapter show the first item, to change it look at below code
        for(int i=0;i<mFormKompal3bs.size();i++){
            if(mFormKompal3bs.get(i).getIdjumlahProduksi().equals(formKompal3bId)){
                mViewPager.setCurrentItem(i);
                break;
            }

        }

        //UNTUK melimit jumlah page yang diload
        //mViewPager.setOffscreenPageLimit(2);


    }
}
