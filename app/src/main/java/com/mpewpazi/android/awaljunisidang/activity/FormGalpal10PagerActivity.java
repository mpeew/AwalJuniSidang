package com.mpewpazi.android.awaljunisidang.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.mpewpazi.android.awaljunisidang.R;
import com.mpewpazi.android.awaljunisidang.formModel.FormGalpal10;
import com.mpewpazi.android.awaljunisidang.fragment.FormGalpal10Fragment;
import com.mpewpazi.android.awaljunisidang.database.DummyMaker;

import java.util.List;
import java.util.UUID;

/**
 * Created by mpewpazi on 5/27/16.
 */
public class FormGalpal10PagerActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private List<FormGalpal10> mFormGalpal10s;

    private final static String EXTRA_KUALIFIKASISURVEY_FORMGALPAL10="extra_kualifikasisurvey_form_galpal10";
    private final static String EXTRA_ID_FORMGALPAL10="extra_id_form_galpal10";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_galpal_peralatan_pager);

        final int kualifikasiSurveyId=getIntent().getIntExtra(EXTRA_KUALIFIKASISURVEY_FORMGALPAL10,0);
        UUID formGalpal10Id=(UUID)getIntent().getSerializableExtra(EXTRA_ID_FORMGALPAL10);

        mViewPager=(ViewPager)findViewById(R.id.activity_formgalpal_peralatan_pager_view_pager);


        mFormGalpal10s= DummyMaker.get(this).getFormGalpal10s(kualifikasiSurveyId);

        FragmentManager fragmentManager=getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentPagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                FormGalpal10 formGalpal10=mFormGalpal10s.get(position);
                return FormGalpal10Fragment.newInstance(formGalpal10.getIdPeralatanKerjaProdElektrikal(),kualifikasiSurveyId);
            }

            @Override
            public int getCount() {
                return mFormGalpal10s.size();
            }
        });


        //by default pageradapter show the first item, to change it look at below code
        for(int i=0;i<mFormGalpal10s.size();i++){
            if(mFormGalpal10s.get(i).getIdPeralatanKerjaProdElektrikal().equals(formGalpal10Id)){
                mViewPager.setCurrentItem(i);
                break;
            }

        }

        //UNTUK melimit jumlah page yang diload
        //mViewPager.setOffscreenPageLimit(2);


    }
}
