package com.mpewpazi.android.awaljunisidang.Form;

import com.mpewpazi.android.awaljunisidang.Fragment.ListFormGalpal6Fragment;
import com.mpewpazi.android.awaljunisidang.Fragment.SingleFragment;

/**
 * Created by mpewpazi on 5/10/16.
 */
public class FormGalpal6Help extends SingleForm {
    private int idFormGalpal6Help;

    public int getIdFormGalpal6Help() {
        return idFormGalpal6Help;
    }

    public void setIdFormGalpal6Help(int idFormGalpal6Help) {
        this.idFormGalpal6Help = idFormGalpal6Help;
    }

    @Override
    public SingleFragment getFragment() {
        return new ListFormGalpal6Fragment();
    }

    @Override
    public String getNamaForm() {
        return "Peralatan Kerja Luar Ruang Cranes";
    }
}
