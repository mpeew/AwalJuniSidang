package com.mpewpazi.android.awaljunisidang.Form;

import android.support.v4.app.Fragment;

import com.mpewpazi.android.awaljunisidang.Fragment.ListFormKompal3cFragment;

/**
 * Created by mpewpazi on 5/10/16.
 */
public class FormKompal3cHelp extends SingleForm {
    private int idFormKompal3cHelp;

    @Override
    public String getNamaForm() {
        return "Sistem Berproduksi";
    }

    @Override
    public Fragment getFragment() {
        return new ListFormKompal3cFragment();
    }

    public int getIdFormKompal3cHelp() {
        return idFormKompal3cHelp;
    }

    public void setIdFormKompal3cHelp(int idFormKompal3cHelp) {
        this.idFormKompal3cHelp = idFormKompal3cHelp;
    }
}
