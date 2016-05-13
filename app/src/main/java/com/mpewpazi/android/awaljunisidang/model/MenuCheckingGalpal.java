package com.mpewpazi.android.awaljunisidang.model;

import java.util.UUID;

/**
 * Created by mpewpazi on 5/11/16.
 */
public class MenuCheckingGalpal extends SingleMenuChecking{
    private UUID idMenuCheckingGalpal;


    public UUID getIdMenuCheckingGalpal() {
        return idMenuCheckingGalpal;
    }

    public MenuCheckingGalpal(){
        idMenuCheckingGalpal=UUID.randomUUID();
    }

    public MenuCheckingGalpal(UUID uuid){
        idMenuCheckingGalpal=uuid;
    }


}
