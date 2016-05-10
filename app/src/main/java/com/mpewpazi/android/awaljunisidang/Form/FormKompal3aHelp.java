package com.mpewpazi.android.awaljunisidang.Form;

import android.support.v4.app.Fragment;

import com.mpewpazi.android.awaljunisidang.Fragment.ListFormKompal3aFragment;

/**
 * Created by mpewpazi on 5/10/16.
 */
public class FormKompal3aHelp extends SingleForm {
    private int idFormKompal3aHelp;

    public int getIdFormKompal3aHelp() {
        return idFormKompal3aHelp;
    }

    public void setIdFormKompal3aHelp(int idFormKompal3aHelp) {
        this.idFormKompal3aHelp = idFormKompal3aHelp;
    }

    @Override
    public Fragment getFragment() {
        return new ListFormKompal3aFragment();
    }

    @Override
    public String getNamaForm() {
        return "Jenis dan Kapasitas Produksi";
    }
}
