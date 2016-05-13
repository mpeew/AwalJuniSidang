package com.mpewpazi.android.awaljunisidang.model;

import java.util.UUID;

/**
 * Created by mpewpazi on 5/11/16.
 */
public class MenuCheckingKompal extends SingleMenuChecking {
    private UUID idMenuCheckingKompal;


    public UUID getIdMenuCheckingKompal() {
        return idMenuCheckingKompal;
    }

    public MenuCheckingKompal(){
       idMenuCheckingKompal=UUID.randomUUID();
   }

    public MenuCheckingKompal(UUID uuid){
        idMenuCheckingKompal=uuid;
    }


}
