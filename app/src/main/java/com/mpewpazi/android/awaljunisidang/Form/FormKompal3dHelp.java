package com.mpewpazi.android.awaljunisidang.Form;

import com.mpewpazi.android.awaljunisidang.Fragment.ListFormKompal3dFragment;
import com.mpewpazi.android.awaljunisidang.Fragment.SingleFragment;

/**
 * Created by mpewpazi on 5/10/16.
 */
public class FormKompal3dHelp extends SingleForm {
    private int formKompal3dHelpId;

    @Override
    public String getNamaForm() {
        return "Standar Mutu";
    }

    @Override
    public SingleFragment getFragment() {
        return new ListFormKompal3dFragment();
    }

    public int getFormKompal3dHelpId() {
        return formKompal3dHelpId;
    }

    public void setFormKompal3dHelpId(int formKompal3dHelpId) {
        this.formKompal3dHelpId = formKompal3dHelpId;
    }
}
