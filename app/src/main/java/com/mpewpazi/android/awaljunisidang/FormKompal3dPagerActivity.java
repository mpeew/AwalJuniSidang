package com.mpewpazi.android.awaljunisidang;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.mpewpazi.android.awaljunisidang.Form.FormKompal3d;
import com.mpewpazi.android.awaljunisidang.Fragment.FormKompal3dFragment;
import com.mpewpazi.android.awaljunisidang.dummy.DummyMaker;

import java.util.List;
import java.util.UUID;

/**
 * Created by mpewpazi on 5/11/16.
 */
public class FormKompal3dPagerActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private List<FormKompal3d> mFormKompal3ds;

    private final static String EXTRA_KUALIFIKASISURVEY_FORMKOMPAL3D="extra_kualifikasisurvey_form_kompal3d";
    private final static String EXTRA_ID_FORMKOMPAL3D="extra_id_form_kompal3d";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_kompal3d_pager);

        final int kualifikasiSurveyId=getIntent().getIntExtra(EXTRA_KUALIFIKASISURVEY_FORMKOMPAL3D,0);
        UUID formKompal3dId=(UUID)getIntent().getSerializableExtra(EXTRA_ID_FORMKOMPAL3D);

        mViewPager=(ViewPager)findViewById(R.id.activity_formkompal3d_pager_view_pager);


        mFormKompal3ds= DummyMaker.get(this).getFormKompal3ds(kualifikasiSurveyId);

        FragmentManager fragmentManager=getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentPagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                FormKompal3d formKompal3d=mFormKompal3ds.get(position);
                return FormKompal3dFragment.newInstance(formKompal3d.getIdStandarMutu(),kualifikasiSurveyId);
            }

            @Override
            public int getCount() {
                return mFormKompal3ds.size();
            }
        });


        //by default pageradapter show the first item, to change it look at below code
        for(int i=0;i<mFormKompal3ds.size();i++){
            if(mFormKompal3ds.get(i).getIdStandarMutu().equals(formKompal3dId)){
                mViewPager.setCurrentItem(i);
                break;
            }

        }

        //UNTUK melimit jumlah page yang diload
        //mViewPager.setOffscreenPageLimit(2);


    }
}
