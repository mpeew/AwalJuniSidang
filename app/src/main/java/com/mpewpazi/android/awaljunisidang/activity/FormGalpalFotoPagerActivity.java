package com.mpewpazi.android.awaljunisidang.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.mpewpazi.android.awaljunisidang.R;
import com.mpewpazi.android.awaljunisidang.formModel.FormGalpalFoto;
import com.mpewpazi.android.awaljunisidang.fragment.FormGalpalFotoFragment;
import com.mpewpazi.android.awaljunisidang.database.DummyMaker;

import java.util.List;
import java.util.UUID;

/**
 * Created by mpewpazi on 6/2/16.
 */
public class FormGalpalFotoPagerActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private List<FormGalpalFoto> mFormGalpalFotos;

    private final static String EXTRA_KUALIFIKASISURVEY_FORMGALPAL_FOTO="extra_kualifikasisurvey_form_galpal_foto";
    private final static String EXTRA_ID_FORMGALPAL_FOTO="extra_id_form_galpal_foto";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_galpal_foto_pager);

        final int kualifikasiSurveyId=getIntent().getIntExtra(EXTRA_KUALIFIKASISURVEY_FORMGALPAL_FOTO,0);
        UUID formGalpalFotoId=(UUID)getIntent().getSerializableExtra(EXTRA_ID_FORMGALPAL_FOTO);
        Log.i("FormGalpalFotoPage",String.valueOf(kualifikasiSurveyId));
        mViewPager=(ViewPager)findViewById(R.id.activity_form_galpal_foto_pager_view_pager);


        mFormGalpalFotos= DummyMaker.get(this).getFormGalpalFotos(kualifikasiSurveyId);

        FragmentManager fragmentManager=getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentPagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                FormGalpalFoto formGalpalFoto=mFormGalpalFotos.get(position);
                return FormGalpalFotoFragment.newInstance(formGalpalFoto.getIdFotoGalangan(),kualifikasiSurveyId);
            }

            @Override
            public int getCount() {
                return mFormGalpalFotos.size();
            }
        });


        //by default pageradapter show the first item, to change it look at below code
        for(int i=0;i<mFormGalpalFotos.size();i++){
            if(mFormGalpalFotos.get(i).getIdFotoGalangan().equals(formGalpalFotoId)){
                mViewPager.setCurrentItem(i); Log.i("TESTA","TESTA");
                break;
            }

        }

        //UNTUK melimit jumlah page yang diload
        //mViewPager.setOffscreenPageLimit(2);
        Log.i("TEST","TEST");

    }
}
