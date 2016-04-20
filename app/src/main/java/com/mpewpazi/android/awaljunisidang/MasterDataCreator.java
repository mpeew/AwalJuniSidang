package com.mpewpazi.android.awaljunisidang;

import com.mpewpazi.android.awaljunisidang.masterData.Propinsi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mpewpazi on 4/12/16.
 */
public class MasterDataCreator {
    private static MasterDataCreator sMasterDataCreator;
    private List<Propinsi> mPropinsis;


    public static MasterDataCreator get(){
        if(sMasterDataCreator==null){
            sMasterDataCreator=new MasterDataCreator();
        }
        return sMasterDataCreator;
    }

    private MasterDataCreator(){
        mPropinsis=new ArrayList<>();
        Propinsi propinsi=new Propinsi();
        propinsi.setId(1);
        propinsi.setKodeBps(11);
        propinsi.setNama("Nangroe Aceh Darussalam");
        propinsi.setKodeiso("ID-AC");
        propinsi.setIbukota("Banda Aceh");
        propinsi.setPulau("Sumatra");
        mPropinsis.add(propinsi);

        Propinsi propinsia=new Propinsi();
        propinsia.setId(2);
        propinsia.setKodeBps(11);
        propinsia.setNama("Sumatra Barat");
        propinsia.setKodeiso("ID-AC");
        propinsia.setIbukota("Banda Aceh");
        propinsia.setPulau("Sumatra");
        mPropinsis.add(propinsia);

        Propinsi propinsib=new Propinsi();
        propinsib.setId(3);
        propinsib.setKodeBps(11);
        propinsib.setNama("DKI Jakarta");
        propinsib.setKodeiso("ID-AC");
        propinsib.setIbukota("Banda Aceh");
        propinsib.setPulau("Sumatra");

    }

    public List<Propinsi> getPropinsis() {
        return mPropinsis;
    }

}
