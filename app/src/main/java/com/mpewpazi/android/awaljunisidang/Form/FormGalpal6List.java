package com.mpewpazi.android.awaljunisidang.Form;

import android.support.v4.app.Fragment;

import com.mpewpazi.android.awaljunisidang.Fragment.ListFormGalpal6Fragment;

/**
 * Created by mpewpazi on 4/22/16.
 */
public class FormGalpal6List extends SingleForm {
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getNamaForm() {
        return "Peralatan Ruang Kerja Luar Ruang Cranes";
    }

    @Override
    public Fragment getFragment() {
        return new ListFormGalpal6Fragment();
    }


}
