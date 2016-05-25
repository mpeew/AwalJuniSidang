package com.mpewpazi.android.awaljunisidang.Form;

import com.mpewpazi.android.awaljunisidang.Fragment.ListFormKompal3dFragment;
import com.mpewpazi.android.awaljunisidang.Fragment.SingleFragment;

import java.util.UUID;

/**
 * Created by mpewpazi on 5/6/16.
 */
public class FormKompal3d extends SingleForm {
    private int idStandarMutuServer;
    private UUID idStandarMutu;
    private int idPeriode;
    private String jenisStandarMutu;
    private String keterangan;
    private String note;

    public static final int kode=7;

    public int getIdStandarMutuServer() {
        return idStandarMutuServer;
    }

    public void setIdStandarMutuServer(int idStandarMutuServer) {
        this.idStandarMutuServer = idStandarMutuServer;
    }

    @Override
    public int getKodeForm() {
        return kode;
    }

    @Override
    public String getNamaForm() {
        return "Standar Mutu";
    }

    @Override
    public SingleFragment getFragment() {
        return new ListFormKompal3dFragment();
    }

    public FormKompal3d(){
        this(UUID.randomUUID());
    }

    public FormKompal3d(UUID id){
        idStandarMutu=id;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public UUID getIdStandarMutu() {
        return idStandarMutu;
    }

    public void setIdStandarMutu(UUID idStandarMutu) {
        this.idStandarMutu = idStandarMutu;
    }

    public String getJenisStandarMutu() {
        return jenisStandarMutu;
    }

    public void setJenisStandarMutu(String jenisStandarMutu) {
        this.jenisStandarMutu = jenisStandarMutu;
    }

    public int getIdPeriode() {
        return idPeriode;
    }

    public void setIdPeriode(int idPeriode) {
        this.idPeriode = idPeriode;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
