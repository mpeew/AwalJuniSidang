package com.mpewpazi.android.awaljunisidang.formModel;

import java.util.UUID;

/**
 * Created by mpewpazi on 6/2/16.
 */
public class FormGalpalFoto extends SingleForm {
    private UUID idFotoGalangan;
    private int idPeriode;
    private String namaFoto="";
    private String fotoGalangan;
    private String fotoUrl;
    private String imagePath;
    private boolean fetchFromServer;
    public static final int kode=4;
    public static final String kodeAsync="FGFOTO";

    public FormGalpalFoto(){
        this(UUID.randomUUID());
    }

    public FormGalpalFoto(UUID id){
        idFotoGalangan=id;
    }

    public UUID getIdFotoGalangan() {
        return idFotoGalangan;
    }

    public String getFotoUrl() {
        return fotoUrl;
    }

    public void setFotoUrl(String fotoUrl) {
        this.fotoUrl = fotoUrl;
    }

    public boolean isFetchFromServer() {
        return fetchFromServer;
    }

    public void setFetchFromServer(boolean fetchFromServer) {
        this.fetchFromServer = fetchFromServer;
    }

    public int getIdPeriode() {
        return idPeriode;
    }

    public void setIdPeriode(int idPeriode) {
        this.idPeriode = idPeriode;
    }

    public String getNamaFoto() {
        return namaFoto;
    }

    public void setNamaFoto(String namaFoto) {
        this.namaFoto = namaFoto;
    }

    public String getFotoGalangan() {
        return fotoGalangan;
    }

    public void setFotoGalangan(String fotoGalangan) {
        this.fotoGalangan = fotoGalangan;
    }

    public String getPhotoFileName(){
        return "IMG_FOTO_GALPAL_"+String.valueOf(getIdFotoGalangan())+".jpg";
    }


    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public int getKodeForm() {
        return kode;
    }

    @Override
    public String getKodeAsync() {
        return kodeAsync;
    }
}
