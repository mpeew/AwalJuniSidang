package com.mpewpazi.android.awaljunisidang.database;

/**
 * Created by mpewpazi on 4/27/16.
 */
public class DhSchema {

    public static final class UserTable{
        public static final String NAME="users";
        public static final class Cols{
            public static final String USERID="userid";
            public static final String CODE_ID="code_id";
            public static final String TYPE="type";
            public static final String FULL_NAME="full_name";
            public static final String COMPANY_NAME="CompanyName";
            public static final String EMAIL="email";
            public static final String PASSWORD="password";
            public static final String SECURITY_CODE="security_code";
            // masih ada yang belum lengkap cek database sentral
        }
    }

    public static final class PeriodeSurveyTable{
        public static final String NAME="periode_survey";
        public static final class Cols{
            public static final String ID_PERIODE="id_periode";
            public static final String TAHUN_KUALIFIKASI="tahun_kualifikasi";
            public static final String IS_ACTIVE_PERIOD="is_activ_period";
            public static final String IS_DONE="is_done";
            public static final String KETERANGAN="keterangan";

        }
    }

    public static final class SurveyAssignSurveyorTable{
        public static final String NAME="survey_assign_surveyor";
        public static final class Cols{
            public static final String ID_SURVEY_ASSIGN_SURVEYOR="id_survey_assign_surveyor";
            public static final String ID_KUALIFIKASI_SURVEY="id_kualifikasi_survey";
            public static final String USERID="userid";
            public static final String ASSIGN_DATE="assign_date";
            public static final String ASSIGN_BY="assign_by";
        }
    }

    public static final class PerusahaanTable{
        public static final String NAME="perusahaan";
        public static final class Cols{
            public static final String ID_PERUSAHAAN="id_perusahaan";
            public static final String NAMA_PERUSAHAAN="nama_perusahaan";
            public static final String INDUSTRI="industri";
            public static final String IS_ACTIV="is_active";
        }
    }

    public static final class KualifikasiSurveyTable{
        public static final String NAME="kualifikasi_survey";
        public static final class Cols{
            public static final String ID_KUALIFIKASI_SURVEY="id_kualifikasi_survey";
            public static final String ID_PERUSAHAAN="id_perusahaan";
            public static final String ID_PERIODE="id_periode";
            public static final String ID_GALANGAN_KAPAL="id_galangan_kapal";
        }
    }

    //FORM GALPAL 1 TABEL
    public static final class PerusahaanIdentitasTable{
        public static final String NAME="perusahaan_identitas";
        public static final class Cols{
            public static final String ID_PERUSAHAAN_IDENTITAS = "id_perusahaan_identitas";
            public static final String ID_PERUSAHAAN = "id_perusahaan";
            public static final String ID_KUALIFIKASI_SURVEY = "id_kualifikasi_survey";
            public static final String ALAMAT_PERUSAHAAN = "alamat_perusahaan";
            public static final String JALAN_DESA_PERUSAHAAN="jalan_desa_perusahaan";
            public static final String KELURAHAN_PERUSAHAAN="kelurahan_perusahaan";
            public static final String KECAMATAN_PERUSAHAAN="kecamatan_perusahaan";
            public static final String ID_KABUPATEN_PERUSAHAAN="id_kabupaten_perusahaan";
            public static final String ID_PROPINSI_PERUSAHAAN="id_propinsi_perusahaan";
            public static final String TELEPON_PERUSAHAAN = "telepon_perusahaan";
            public static final String FAX_PERUSAHAAN = "fax_perusahaan";
            public static final String KODE_POS_PERUSAHAAN="kode_pos_perusahaan";
            public static final String ALAMAT_PABRIK="alamat_pabrik";
            public static final String JALAN_DESA_PABRIK="jalan_desa_pabrik";
            public static final String KELURAHAN_PABRIK="kelurahan_pabrik";
            public static final String KECAMATAN_PABRIK="kecamatan_pabrik";
            public static final String ID_KABUPATEN_PABRIK="kabupaten_pabrik";
            public static final String ID_PROPINSI_PABRIK="propinsi_pabrik";
            public static final String TELEPON_PABRIK="telepon_pabrik";
            public static final String FAX_PABRIK = "fax_pabrik";
            public static final String KODE_POS_PABRIK="kode_pos_pabrik";
            public static final String ID_MST_LOKASI_PABRIK="id_mst_lokasi_pabrik";
            public static final String LAHAN_PERUNTUKAN="lahan_peruntukan";
            public static final String LUAS_TANAH_PABRIK="luas_tanah_pabrik";
            public static final String NPWP="NPWP";
            public static final String NAMA_PIMPINAN="nama_pimpinan";
            public static final String STATUS_KEPEMILIKAN_USAHA = "status_kepemilikan_usaha";
            public static final String KATEGORI_PERUSAHAAN="kategori_perusahaan";
            public static final String ANGGOTA_ASOSIASI="anggota_asosiasi";
            public static final String WEBSITE="website";
            public static final String CP_NAMA="cp_nama";
            public static final String CP_NO="cp_no";
            public static final String CP_JABATAN="cp_jabatan";
            public static final String CP_EMAIL="cp_email";
            public static final String ID_MST_JENIS_INDUSTRI="id_mst_jenis_industri";
            public static final String LONGITUDE="longitude";
            public static final String LATITUDE="latitude";
            public static final String LINTANG="lintang";
            public static final String LINTANG_DERAJAT="lintang_derajat";
            public static final String LINTANG_MENIT="lintang_menit";
            public static final String LINTANG_DETIK="lintang_Detik";
            public static final String BUJUR="bujur";
            public static final String BUJUR_DERAJAT="bujur_derajat";
            public static final String BUJUR_MENIT="lintang_bujur";
            public static final String BUJUR_DETIK="bujur_detik";
            public static final String CREATED_DATE = "created_date";
            public static final String CREATED_USER = "created_user";
            public static final String CREATED_IP_ADDRESS = "created_ip_address";
            public static final String MODIFIED_DATE = "modified_date";
            public static final String MODIFIED_USER = "modified_user";
            public static final String MODIFIED_IP_ADDRESS = "modified_ip_address";
        }
    }
/*
    public static final class {
        public static final String NAME="";
        public static final class Cols{
            public static final String ="";
            public static final String ="";
            public static final String ="";
            public static final String ="";
            public static final String ="";
            public static final String ="";
            public static final String ="";
            public static final String ="";
            public static final String ="";

        }
    }

    public static final class {
        public static final String NAME="";
        public static final class Cols{
            public static final String ="";
            public static final String ="";
            public static final String ="";
            public static final String ="";
            public static final String ="";
            public static final String ="";
            public static final String ="";
            public static final String ="";
            public static final String ="";

        }
    }*/
}
