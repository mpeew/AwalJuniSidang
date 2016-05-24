package com.mpewpazi.android.awaljunisidang.Fragment;

import android.support.v4.app.Fragment;

import com.mpewpazi.android.awaljunisidang.CustomClickListener;

/**
 * Created by mpewpazi on 5/10/16.
 */
public class SingleFragment extends Fragment {
    protected CustomClickListener mCustomClickListener;


    public void setCustomClickListener(CustomClickListener customClickListener){
        mCustomClickListener=customClickListener;
    }

}
