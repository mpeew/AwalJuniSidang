package com.mpewpazi.android.awaljunisidang.Form;

import com.mpewpazi.android.awaljunisidang.Fragment.ListFormKompal3bFragment;
import com.mpewpazi.android.awaljunisidang.Fragment.SingleFragment;

/**
 * Created by mpewpazi on 5/10/16.
 */
public class FormKompal3bHelp extends SingleForm{
    private int formKompal3bHelpId;


    @Override
    public String getNamaForm() {
        return "Jumlah dan Nilai Produksi 4 Tahun Terakhir";
    }

    @Override
    public SingleFragment getFragment() {
        return new ListFormKompal3bFragment();
    }

    public int getFormKompal3bHelpId() {
        return formKompal3bHelpId;
    }

    public void setFormKompal3bHelpId(int formKompal3bHelpId) {
        this.formKompal3bHelpId = formKompal3bHelpId;
    }
}
