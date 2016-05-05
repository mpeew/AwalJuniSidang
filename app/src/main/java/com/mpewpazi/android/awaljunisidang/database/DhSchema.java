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
            public static final String PROGRESS="progress";
        }
    }

    //FORM GALPAL 1 TABEL
    public static final class FG1PerusahaanIdentitasTable{
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
            public static final String STATUS_SENT = "status_sent";
            public static final String CREATED_DATE = "created_date";
            public static final String CREATED_USER = "created_user";
            public static final String CREATED_IP_ADDRESS = "created_ip_address";
            public static final String MODIFIED_DATE = "modified_date";
            public static final String MODIFIED_USER = "modified_user";
            public static final String MODIFIED_IP_ADDRESS = "modified_ip_address";
        }
    }

    //FORM GALPAL 2 TABLE BELOMM

    //FORM GALPAL 3 TABEL
    public static final class FG3GalanganKapalTable{
        public static final String NAME="galangan_kapal";
        public static final class Cols{
            public static final String ID_GALANGAN_KAPAL = "id_galangan_kapal";
            public static final String NAMA_GALANGAN = "nama_galangan";
            public static final String KATEGORI_GALANGAN="kategori_galangan";
            public static final String IS_NEW_BUILDING="is_new_building";
            public static final String IS_REPAIR="is_repair";
            public static final String ID_KUALIFIKASI_SURVEY = "id_kualifikasi_survey";
            public static final String ID_PERUSAHAAN="id_perusahaan";
            public static final String NOMOR_DOCK="nomor_dock";
            public static final String ALAMAT_GALANGAN = "alamat_galangan";
            public static final String JALAN_DESA_GALANGAN="jalan_desa_galangan";
            public static final String KELURAHAN_GALANGAN="kelurahan_galangan";
            public static final String KECAMATAN_GALANGAN="kecamatan_galangan";
            public static final String ID_KABUPATEN_GALANGAN="id_kabupaten_galangan";
            public static final String ID_PROPINSI_GALANGAN="id_propinsi_galangan";
            public static final String TELEPON_GALANGAN = "telepon_galangan";
            public static final String FAX_GALANGAN = "fax_galangan";
            public static final String KODE_POS_GALANGAN="kode_pos_galangan";
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
            public static final String CP_NAMA="cp_nama";
            public static final String CP_NO="cp_no";
            public static final String CP_JABATAN="cp_jabatan";
            public static final String CP_EMAIL="cp_email";
            public static final String CREATED_DATE = "created_date";
            public static final String CREATED_USER = "created_user";
            public static final String CREATED_IP_ADDRESS = "created_ip_address";
            public static final String MODIFIED_DATE = "modified_date";
            public static final String MODIFIED_USER = "modified_user";
            public static final String MODIFIED_IP_ADDRESS = "modified_ip_address";
        }
    }

    //formgalpal4 table
    public static final class FG4TinjauanAreaTable{
        public static final String NAME="f1_tinjauan_area";
        public static final class Cols{
            public static final String ID_F1_TINJAUAN_AREA = "id";
            public static final String ID_KUALIFIKASI_SURVEY="id_kualifikasi_survey";
            public static final String ID_PERIODE="id_periode";
            public static final String ID_MST_JARAK_KEDALAMAN = "id_mst_jarak_kedalaman";
            public static final String ID_MST_AIR_PELAYARAN = "is_mst_air_pelayaran";
            public static final String ID_MST_PASANG_SURUT = "id_mst_pasang_surut";
            public static final String ID_MST_ARUS = "id_mst_arus";
            public static final String ID_MST_GELOMBANG = "id_mst_gelombang";
            public static final String PANJANG_WATERFRONT = "panjang_waterfront";
            public static final String LUAS_LAHAN = "luas_lahan";
            public static final String KETERSEDIAAN_LAHAN = "ketersediaan_lahan";
            public static final String LAHAN_PRODUKTIF = "lahan_produktif";
            public static final String LAHAN_PEMUKIMAN = "lahan_pemukiman";
            public static final String PASANG_SURUT="pasang_surut";
            public static final String DAYA_DUKUNG = "daya_dukung";
            public static final String KELANDAIAAN = "kelandaian";
            public static final String DEKAT_JALAN = "dekat_jalan";
            public static final String KOTA = "kota";
            public static final String INTERKONEKSI_ANGKUTAN = "interkoneksi_angkutan";
            public static final String NILAI_EKONOMI = "nilai_ekonomi";
            public static final String PERKEMBANGAN_WILAYAH = "perkembangan_wilayah";
            public static final String RUTWR = "rutwr";
            public static final String CREATED_DATE = "created_date";
            public static final String CREATED_USER = "created_user";
            public static final String CREATED_IP_ADDRESS = "created_ip_address";
            public static final String MODIFIED_DATE = "modified_date";
            public static final String MODIFIED_USER = "modified_user";
            public static final String MODIFIED_IP_ADDRESS = "modified_ip_address";
        }
    }

    //FORM GALPAL5
    public static final class FG5FaktorProduksiTable{
        public static final String NAME="f1_faktor_produksi";
        public static final class Cols{
            public static final String ID_F1_FAKTOR_PRODUKSI="id_f1_faktor_produksi";
            public static final String ID_KUALIFIKASI_SURVEY="id_kualifikasi_survey";
            public static final String ID_PERIODE="id_periode";
            public static final String BAHAN_BAKU="bahan_baku";
            public static final String TIPE_BAHAN_BAKU="tipe_bahan_baku";
            public static final String MESIN_SISTEM_ELEKTRIKAL="mesin_sistem_elektrikal";
            public static final String PERLENGKAPAN_KAPAL="perlengkapan_kapal";
            public static final String CREATED_DATE = "created_date";
            public static final String CREATED_USER = "created_user";
            public static final String CREATED_IP_ADDRESS = "created_ip_address";
            public static final String MODIFIED_DATE = "modified_date";
            public static final String MODIFIED_USER = "modified_user";
            public static final String MODIFIED_IP_ADDRESS = "modified_ip_address";

        }
    }

    //FORM GALPAL6
    public static final class FG6PeralatanKerjaLuarCraneTable {
        public static final String NAME="f1_peralatan_kerja_lr_crane";
        public static final class Cols{
            public static final String ID_F1_PERALATAN_KERJA_LR_CRANE="id_f1_peralatan_kerja_lr_crane";
            public static final String ID_KUALIFIKASI_SURVEY="id_kualifikasi_survey";
            public static final String ID_PERIODE="id_periode";
            public static final String JENIS_MESIN="jenis_mesin";
            public static final String TAHUN_PEMBUATAN="tahun_pembuatan";
            public static final String MERK="merk";
            public static final String KAPASAITAS_TERPASANG="kapasitas_terpasang";
            public static final String SATUAN_KAPASITAS_TERPASANG="satuan_kapasitas_terpasang";
            public static final String KAPASITAS_TERPAKAI="kapasitas_terpakai";
            public static final String SATUAN_KAPASITAS_TERPAKAI="satuan_kapastas_terpakai";
            public static final String DIMENSI="dimensi";
            public static final String JUMLAH="jumlah";
            public static final String KONDISI="kondisi";
            public static final String LOKASI="lokasi";
            public static final String STATUS="status";
            public static final String CREATED_DATE = "created_date";
            public static final String CREATED_USER = "created_user";
            public static final String CREATED_IP_ADDRESS = "created_ip_address";
            public static final String MODIFIED_DATE = "modified_date";
            public static final String MODIFIED_USER = "modified_user";
            public static final String MODIFIED_IP_ADDRESS = "modified_ip_address";

        }
    }

    //FORM GALPAL6List
    public static final class FG6ListPeralatanKerjaLuarCraneTable {
        public static final String NAME="f1_peralatan_kerja_lr_crane_list";
        public static final class Cols{
            public static final String ID_F1_PERALATAN_KERJA_LR_CRANE_LIST="id_f1_peralatan_kerja_lr_crane_list";
            public static final String ID_KUALIFIKASI_SURVEY="id_kualifikasi_survey";
            public static final String STATUS_SENT = "status_sent";
        }
    }

    //FORM GALPAL 7
    public static final class FG7PeralatanKerjaLuarTugboatTable {
        public static final String NAME="f1_peralatan_kerja_lr_tug";
        public static final class Cols{
            public static final String ID_F1_PERALATAN_KERJA_LR_TUG="id_f1_peralatan_kerja_lr_tug";
            public static final String ID_KUALIFIKASI_SURVEY="id_kualifikasi_survey";
            public static final String ID_PERIODE="id_periode";
            public static final String JENIS_MESIN="jenis_mesin";
            public static final String TAHUN_PEMBUATAN="tahun_pembuatan";
            public static final String MERK="merk";
            public static final String KAPASAITAS_TERPASANG="kapasitas_terpasang";
            public static final String SATUAN_KAPASITAS_TERPASANG="satuan_kapasitas_terpasang";
            public static final String KAPASITAS_TERPAKAI="kapasitas_terpakai";
            public static final String SATUAN_KAPASITAS_TERPAKAI="satuan_kapastas_terpakai";
            public static final String DIMENSI="dimensi";
            public static final String JUMLAH="jumlah";
            public static final String KONDISI="kondisi";
            public static final String LOKASI="lokasi";
            public static final String STATUS="status";
            public static final String CREATED_DATE = "created_date";
            public static final String CREATED_USER = "created_user";
            public static final String CREATED_IP_ADDRESS = "created_ip_address";
            public static final String MODIFIED_DATE = "modified_date";
            public static final String MODIFIED_USER = "modified_user";
            public static final String MODIFIED_IP_ADDRESS = "modified_ip_address";

        }
    }

    //FORM GALPAL 8
    public static final class FG8PeralatanKerjaProduksiMesinTable {
        public static final String NAME="f1_peralatan_kerja_prod_mesin";
        public static final class Cols{
            public static final String ID_F1_PERALATAN_KERJA_PROD_MESIN="id_f1_peralatan_kerja_prod_mesin";
            public static final String ID_KUALIFIKASI_SURVEY="id_kualifikasi_survey";
            public static final String ID_PERIODE="id_periode";
            public static final String JENIS_MESIN="jenis_mesin";
            public static final String TAHUN_PEMBUATAN="tahun_pembuatan";
            public static final String MERK="merk";
            public static final String KAPASAITAS_TERPASANG="kapasitas_terpasang";
            public static final String SATUAN_KAPASITAS_TERPASANG="satuan_kapasitas_terpasang";
            public static final String KAPASITAS_TERPAKAI="kapasitas_terpakai";
            public static final String SATUAN_KAPASITAS_TERPAKAI="satuan_kapastas_terpakai";
            public static final String DIMENSI="dimensi";
            public static final String JUMLAH="jumlah";
            public static final String KONDISI="kondisi";
            public static final String LOKASI="lokasi";
            public static final String STATUS="status";
            public static final String CREATED_DATE = "created_date";
            public static final String CREATED_USER = "created_user";
            public static final String CREATED_IP_ADDRESS = "created_ip_address";
            public static final String MODIFIED_DATE = "modified_date";
            public static final String MODIFIED_USER = "modified_user";
            public static final String MODIFIED_IP_ADDRESS = "modified_ip_address";
        }
    }

    //FORM GALPAL 9
    public static final class FG9PeralatanKerjaProduksiKontruksi {
        public static final String NAME="f1_peralatan_kerja_prod_kontruksi";
        public static final class Cols{
            public static final String ID_F1_PERALATAN_KERJA_PRODUKSI_KONTRUKSI="id_f1_peralatan_kerja_prod_kontruksi";
            public static final String ID_KUALIFIKASI_SURVEY="id_kualifikasi_survey";
            public static final String ID_PERIODE="id_periode";
            public static final String JENIS_MESIN="jenis_mesin";
            public static final String TAHUN_PEMBUATAN="tahun_pembuatan";
            public static final String MERK="merk";
            public static final String KAPASAITAS_TERPASANG="kapasitas_terpasang";
            public static final String SATUAN_KAPASITAS_TERPASANG="satuan_kapasitas_terpasang";
            public static final String KAPASITAS_TERPAKAI="kapasitas_terpakai";
            public static final String SATUAN_KAPASITAS_TERPAKAI="satuan_kapastas_terpakai";
            public static final String DIMENSI="dimensi";
            public static final String JUMLAH="jumlah";
            public static final String KONDISI="kondisi";
            public static final String LOKASI="lokasi";
            public static final String STATUS="status";
            public static final String CREATED_DATE = "created_date";
            public static final String CREATED_USER = "created_user";
            public static final String CREATED_IP_ADDRESS = "created_ip_address";
            public static final String MODIFIED_DATE = "modified_date";
            public static final String MODIFIED_USER = "modified_user";
            public static final String MODIFIED_IP_ADDRESS = "modified_ip_address";

        }
    }

    //FORM GALPAL 10
    public static final class FG10PeralatanKerjaProduksiElektrikalMekanikal {
        public static final String NAME="f1_peralatan_kerja_prod_elmek";
        public static final class Cols{
            public static final String ID_F1_PERALATAN_KERJA_PRODUKSI_ELMEK="id_f1_peralatan_kerja_prod_elmek";
            public static final String ID_KUALIFIKASI_SURVEY="id_kualifikasi_survey";
            public static final String ID_PERIODE="id_periode";
            public static final String JENIS_MESIN="jenis_mesin";
            public static final String TAHUN_PEMBUATAN="tahun_pembuatan";
            public static final String MERK="merk";
            public static final String KAPASAITAS_TERPASANG="kapasitas_terpasang";
            public static final String SATUAN_KAPASITAS_TERPASANG="satuan_kapasitas_terpasang";
            public static final String KAPASITAS_TERPAKAI="kapasitas_terpakai";
            public static final String SATUAN_KAPASITAS_TERPAKAI="satuan_kapastas_terpakai";
            public static final String DIMENSI="dimensi";
            public static final String JUMLAH="jumlah";
            public static final String KONDISI="kondisi";
            public static final String LOKASI="lokasi";
            public static final String STATUS="status";
            public static final String CREATED_DATE = "created_date";
            public static final String CREATED_USER = "created_user";
            public static final String CREATED_IP_ADDRESS = "created_ip_address";
            public static final String MODIFIED_DATE = "modified_date";
            public static final String MODIFIED_USER = "modified_user";
            public static final String MODIFIED_IP_ADDRESS = "modified_ip_address";

        }
    }

    //FORM GALPAL 11
    public static final class FG11PeralatanKerjaProduksiPengecatan {
        public static final String NAME="f1_peralatan_kerja_prod_cat";
        public static final class Cols{
            public static final String ID_F1_PERALATAN_KERJA_PRODUKSI_CAT="id_f1_peralatan_kerja_prod_cat";
            public static final String ID_KUALIFIKASI_SURVEY="id_kualifikasi_survey";
            public static final String ID_PERIODE="id_periode";
            public static final String JENIS_MESIN="jenis_mesin";
            public static final String TAHUN_PEMBUATAN="tahun_pembuatan";
            public static final String MERK="merk";
            public static final String KAPASAITAS_TERPASANG="kapasitas_terpasang";
            public static final String SATUAN_KAPASITAS_TERPASANG="satuan_kapasitas_terpasang";
            public static final String KAPASITAS_TERPAKAI="kapasitas_terpakai";
            public static final String SATUAN_KAPASITAS_TERPAKAI="satuan_kapastas_terpakai";
            public static final String DIMENSI="dimensi";
            public static final String JUMLAH="jumlah";
            public static final String KONDISI="kondisi";
            public static final String LOKASI="lokasi";
            public static final String STATUS="status";
            public static final String CREATED_DATE = "created_date";
            public static final String CREATED_USER = "created_user";
            public static final String CREATED_IP_ADDRESS = "created_ip_address";
            public static final String MODIFIED_DATE = "modified_date";
            public static final String MODIFIED_USER = "modified_user";
            public static final String MODIFIED_IP_ADDRESS = "modified_ip_address";

        }
    }

    //FORM GALPAL 12
    public static final class FG12PeralatanKerjaProduksiInterior {
        public static final String NAME="f1_peralatan_kerja_produksi_interior";
        public static final class Cols{
            public static final String ID_F1_PERALATAN_KERJA_PRODUKSI_INTERIOR="id_f1_peralatan_kerja_prod_interior";
            public static final String ID_KUALIFIKASI_SURVEY="id_kualifikasi_survey";
            public static final String ID_PERIODE="id_periode";
            public static final String JENIS_MESIN="jenis_mesin";
            public static final String TAHUN_PEMBUATAN="tahun_pembuatan";
            public static final String MERK="merk";
            public static final String KAPASAITAS_TERPASANG="kapasitas_terpasang";
            public static final String SATUAN_KAPASITAS_TERPASANG="satuan_kapasitas_terpasang";
            public static final String KAPASITAS_TERPAKAI="kapasitas_terpakai";
            public static final String SATUAN_KAPASITAS_TERPAKAI="satuan_kapastas_terpakai";
            public static final String DIMENSI="dimensi";
            public static final String JUMLAH="jumlah";
            public static final String KONDISI="kondisi";
            public static final String LOKASI="lokasi";
            public static final String STATUS="status";
            public static final String CREATED_DATE = "created_date";
            public static final String CREATED_USER = "created_user";
            public static final String CREATED_IP_ADDRESS = "created_ip_address";
            public static final String MODIFIED_DATE = "modified_date";
            public static final String MODIFIED_USER = "modified_user";
            public static final String MODIFIED_IP_ADDRESS = "modified_ip_address";

        }
    }

    //FORM GALPAL 13
    public static final class FG13PeralatanKerjaAreaDock {
        public static final String NAME="f1_peralatan_kerja_area_dock";
        public static final class Cols{
            public static final String ID_F1_PERALATAN_KERJA_AREA_DOCK="id_f1_peralatan_kerja_area_dock";
            public static final String ID_KUALIFIKASI_SURVEY="id_kualifikasi_survey";
            public static final String ID_PERIODE="id_periode";
            public static final String JENIS_MESIN="jenis_mesin";
            public static final String TAHUN_PEMBUATAN="tahun_pembuatan";
            public static final String MERK="merk";
            public static final String KAPASAITAS_TERPASANG="kapasitas_terpasang";
            public static final String SATUAN_KAPASITAS_TERPASANG="satuan_kapasitas_terpasang";
            public static final String KAPASITAS_TERPAKAI="kapasitas_terpakai";
            public static final String SATUAN_KAPASITAS_TERPAKAI="satuan_kapastas_terpakai";
            public static final String DIMENSI="dimensi";
            public static final String JUMLAH="jumlah";
            public static final String KONDISI="kondisi";
            public static final String LOKASI="lokasi";
            public static final String STATUS="status";
            public static final String CREATED_DATE = "created_date";
            public static final String CREATED_USER = "created_user";
            public static final String CREATED_IP_ADDRESS = "created_ip_address";
            public static final String MODIFIED_DATE = "modified_date";
            public static final String MODIFIED_USER = "modified_user";
            public static final String MODIFIED_IP_ADDRESS = "modified_ip_address";

        }
    }

    //FORM GALPAL 14
    public static final class FG14PeralatanKerjaDramaga {
        public static final String NAME="f1_peralatan_kerja_dramaga";
        public static final class Cols{
            public static final String ID_F1_PERALATAN_KERJA_DRAMAGA="id_f1_peralatan_kerja_dramaga";
            public static final String ID_KUALIFIKASI_SURVEY="id_kualifikasi_survey";
            public static final String ID_PERIODE="id_periode";
            public static final String JENIS_MESIN="jenis_mesin";
            public static final String TAHUN_PEMBUATAN="tahun_pembuatan";
            public static final String MERK="merk";
            public static final String KAPASAITAS_TERPASANG="kapasitas_terpasang";
            public static final String SATUAN_KAPASITAS_TERPASANG="satuan_kapasitas_terpasang";
            public static final String KAPASITAS_TERPAKAI="kapasitas_terpakai";
            public static final String SATUAN_KAPASITAS_TERPAKAI="satuan_kapastas_terpakai";
            public static final String DIMENSI="dimensi";
            public static final String JUMLAH="jumlah";
            public static final String KONDISI="kondisi";
            public static final String LOKASI="lokasi";
            public static final String STATUS="status";
            public static final String CREATED_DATE = "created_date";
            public static final String CREATED_USER = "created_user";
            public static final String CREATED_IP_ADDRESS = "created_ip_address";
            public static final String MODIFIED_DATE = "modified_date";
            public static final String MODIFIED_USER = "modified_user";
            public static final String MODIFIED_IP_ADDRESS = "modified_ip_address";

        }
    }

    //form galpal 15
    public static final class FG15PeralatanKerjaNavigasi {
        public static final String NAME="f1_peralatan_kerja_navigasi";
        public static final class Cols{
            public static final String ID_F1_PERALATAN_KERJA_NAVIGASI="id_f1_peralatan_kerja_navigasi";
            public static final String ID_KUALIFIKASI_SURVEY="id_kualifikasi_survey";
            public static final String ID_PERIODE="id_periode";
            public static final String JENIS_MESIN="jenis_mesin";
            public static final String TAHUN_PEMBUATAN="tahun_pembuatan";
            public static final String MERK="merk";
            public static final String KAPASAITAS_TERPASANG="kapasitas_terpasang";
            public static final String SATUAN_KAPASITAS_TERPASANG="satuan_kapasitas_terpasang";
            public static final String KAPASITAS_TERPAKAI="kapasitas_terpakai";
            public static final String SATUAN_KAPASITAS_TERPAKAI="satuan_kapastas_terpakai";
            public static final String DIMENSI="dimensi";
            public static final String JUMLAH="jumlah";
            public static final String KONDISI="kondisi";
            public static final String LOKASI="lokasi";
            public static final String STATUS="status";
            public static final String CREATED_DATE = "created_date";
            public static final String CREATED_USER = "created_user";
            public static final String CREATED_IP_ADDRESS = "created_ip_address";
            public static final String MODIFIED_DATE = "modified_date";
            public static final String MODIFIED_USER = "modified_user";
            public static final String MODIFIED_IP_ADDRESS = "modified_ip_address";

        }
    }

    //FORM GALPAL 16
    public static final class FG16OrganisasiLahanParkir {
        public static final String NAME="f1_organisasi_lahan_parkir";
        public static final class Cols{
            public static final String ID_F1_ORGANISASI_LAHAN_PARKIR="id_f1_organisasi_lahan_parkir";
            public static final String ID_KUALIFIKASI_SURVEY="id_kualifikasi_survey";
            public static final String ID_PERIODE="id_periode";
            public static final String NAMA_TEMPAT="nama_tempat";
            public static final String LUAS="luas";
            public static final String DIMENSI="dimensi";
            public static final String KAPASAITAS="kapasitas";
            public static final String OPERASIONAL="operasional";
            public static final String JARAK="jarak";
            public static final String CREATED_DATE = "created_date";
            public static final String CREATED_USER = "created_user";
            public static final String CREATED_IP_ADDRESS = "created_ip_address";
            public static final String MODIFIED_DATE = "modified_date";
            public static final String MODIFIED_USER = "modified_user";
            public static final String MODIFIED_IP_ADDRESS = "modified_ip_address";

        }
    }

    //FORM GALPAL 17
    public static final class FG17OrganisasiOpenStorage {
        public static final String NAME="f1_organisasi_open_storage";
        public static final class Cols{
            public static final String ID_F1_ORGANISASI_LAHAN_PARKIR="id_f1_organisasi_open_storage";
            public static final String ID_KUALIFIKASI_SURVEY="id_kualifikasi_survey";
            public static final String ID_PERIODE="id_periode";
            public static final String NAMA_TEMPAT="nama_tempat";
            public static final String LUAS="luas";
            public static final String DIMENSI="dimensi";
            public static final String KAPASAITAS="kapasitas";
            public static final String OPERASIONAL="operasional";
            public static final String JARAK="jarak";
            public static final String CREATED_DATE = "created_date";
            public static final String CREATED_USER = "created_user";
            public static final String CREATED_IP_ADDRESS = "created_ip_address";
            public static final String MODIFIED_DATE = "modified_date";
            public static final String MODIFIED_USER = "modified_user";
            public static final String MODIFIED_IP_ADDRESS = "modified_ip_address";

        }
    }


    //FORM GALPAL 18
    public static final class FG18OrganisasiRuangPergudangan {
        public static final String NAME="f1_organisasi_pergudangan";
        public static final class Cols{
            public static final String ID_F1_ORGANISASI_PERGUDANGAN="id_f1_organisasi_pergudangan";
            public static final String ID_KUALIFIKASI_SURVEY="id_kualifikasi_survey";
            public static final String ID_PERIODE="id_periode";
            public static final String NAMA_TEMPAT="nama_tempat";
            public static final String LUAS="luas";
            public static final String DIMENSI="dimensi";
            public static final String KAPASAITAS="kapasitas";
            public static final String OPERASIONAL="operasional";
            public static final String JARAK="jarak";
            public static final String CREATED_DATE = "created_date";
            public static final String CREATED_USER = "created_user";
            public static final String CREATED_IP_ADDRESS = "created_ip_address";
            public static final String MODIFIED_DATE = "modified_date";
            public static final String MODIFIED_USER = "modified_user";
            public static final String MODIFIED_IP_ADDRESS = "modified_ip_address";

        }
    }

    //FORM GALPAL 19
    public static final class FG19OrganisasiRuangBengkel {
        public static final String NAME="f1_organisasi_bengkel";
        public static final class Cols{
            public static final String ID_F1_ORGANISASI_BENGKEL="id_f1_organisasi_bengkel";
            public static final String ID_KUALIFIKASI_SURVEY="id_kualifikasi_survey";
            public static final String ID_PERIODE="id_periode";
            public static final String NAMA_TEMPAT="nama_tempat";
            public static final String LUAS="luas";
            public static final String DIMENSI="dimensi";
            public static final String KAPASAITAS="kapasitas";
            public static final String OPERASIONAL="operasional";
            public static final String JARAK="jarak";
            public static final String CREATED_DATE = "created_date";
            public static final String CREATED_USER = "created_user";
            public static final String CREATED_IP_ADDRESS = "created_ip_address";
            public static final String MODIFIED_DATE = "modified_date";
            public static final String MODIFIED_USER = "modified_user";
            public static final String MODIFIED_IP_ADDRESS = "modified_ip_address";

        }
    }

    //FORM GALPAL 20
    public static final class FG20OrganisasiRuangPengelola {
        public static final String NAME="f1_organisasi_ruang_pengelola";
        public static final class Cols{
            public static final String ID_F1_ORGANISASI_RUANG_PENGELOLA="id_f1_organisasi_ruang_pengelola";
            public static final String ID_KUALIFIKASI_SURVEY="id_kualifikasi_survey";
            public static final String ID_PERIODE="id_periode";
            public static final String NAMA_TEMPAT="nama_tempat";
            public static final String LUAS="luas";
            public static final String DIMENSI="dimensi";
            public static final String KAPASAITAS="kapasitas";
            public static final String OPERASIONAL="operasional";
            public static final String JARAK="jarak";
            public static final String CREATED_DATE = "created_date";
            public static final String CREATED_USER = "created_user";
            public static final String CREATED_IP_ADDRESS = "created_ip_address";
            public static final String MODIFIED_DATE = "modified_date";
            public static final String MODIFIED_USER = "modified_user";
            public static final String MODIFIED_IP_ADDRESS = "modified_ip_address";

        }
    }

    //FORM GALPAL 21
    public static final class FG21OrganisasiRuangDocking {
        public static final String NAME="f1_organisasi_ruang_docking";
        public static final class Cols{
            public static final String ID_F1_ORGANISASI_RUANG_DOCKING="id_f1_organisasi_ruang_docking";
            public static final String ID_KUALIFIKASI_SURVEY="id_kualifikasi_survey";
            public static final String ID_PERIODE="id_periode";
            public static final String NAMA_TEMPAT="nama_tempat";
            public static final String LUAS="luas";
            public static final String DIMENSI="dimensi";
            public static final String KAPASAITAS="kapasitas";
            public static final String SATUAN_KAPASITAS="satuan_kapasitas";
            public static final String OPERASIONAL="operasional";
            public static final String FASILITAS="fasilitas";
            public static final String CREATED_DATE = "created_date";
            public static final String CREATED_USER = "created_user";
            public static final String CREATED_IP_ADDRESS = "created_ip_address";
            public static final String MODIFIED_DATE = "modified_date";
            public static final String MODIFIED_USER = "modified_user";
            public static final String MODIFIED_IP_ADDRESS = "modified_ip_address";

        }
    }

    //FORM GALPAL 22
    public static final class FG22OrganisasiRuangService {
        public static final String NAME="f1_organisasi_ruang_service";
        public static final class Cols{
            public static final String ID_F1_ORGANISASI_RUANG_SERVICE="id_f1_organisasi_ruang_service";
            public static final String ID_KUALIFIKASI_SURVEY="id_kualifikasi_survey";
            public static final String ID_PERIODE="id_periode";
            public static final String NAMA_TEMPAT="nama_tempat";
            public static final String LUAS="luas";
            public static final String DIMENSI="dimensi";
            public static final String KAPASAITAS="kapasitas";
            public static final String OPERASIONAL="operasional";
            public static final String JARAK="jarak";
            public static final String CREATED_DATE = "created_date";
            public static final String CREATED_USER = "created_user";
            public static final String CREATED_IP_ADDRESS = "created_ip_address";
            public static final String MODIFIED_DATE = "modified_date";
            public static final String MODIFIED_USER = "modified_user";
            public static final String MODIFIED_IP_ADDRESS = "modified_ip_address";

        }
    }

    //FORM GALPAL 23
    public static final class FG23OrganisasiRuangPenunjang {
        public static final String NAME="f1_organisasi_ruang_penunjang";
        public static final class Cols{
            public static final String ID_F1_ORGANISASI_RUANG_PENUNJANG="id_f1_organisasi_ruang_penunjang";
            public static final String ID_KUALIFIKASI_SURVEY="id_kualifikasi_survey";
            public static final String ID_PERIODE="id_periode";
            public static final String NAMA_TEMPAT="nama_tempat";
            public static final String LUAS="luas";
            public static final String DIMENSI="dimensi";
            public static final String KAPASAITAS="kapasitas";
            public static final String STATUS="status";
            public static final String JARAK="jarak";
            public static final String CREATED_DATE = "created_date";
            public static final String CREATED_USER = "created_user";
            public static final String CREATED_IP_ADDRESS = "created_ip_address";
            public static final String MODIFIED_DATE = "modified_date";
            public static final String MODIFIED_USER = "modified_user";
            public static final String MODIFIED_IP_ADDRESS = "modified_ip_address";

        }
    }

    //FORM GALPAL 24
    public static final class FG24OrganisasiRuangPengelolaanLimbah {
        public static final String NAME="f1_organisasi_ruang_limbah";
        public static final class Cols{
            public static final String ID_F1_ORGANISASI_RUANG_LIMBAH="id_f1_organisasi_ruang_limbah";
            public static final String ID_KUALIFIKASI_SURVEY="id_kualifikasi_survey";
            public static final String ID_PERIODE="id_periode";
            public static final String NAMA_TEMPAT="nama_tempat";
            public static final String LUAS="luas";
            public static final String DIMENSI="dimensi";
            public static final String KAPASAITAS="kapasitas";
            public static final String OPERASIONAL="operasional";
            public static final String DAUR_ULANG="daur_ulang";
            public static final String PEMBUANGAN="pembuangan";
            public static final String CREATED_DATE = "created_date";
            public static final String CREATED_USER = "created_user";
            public static final String CREATED_IP_ADDRESS = "created_ip_address";
            public static final String MODIFIED_DATE = "modified_date";
            public static final String MODIFIED_USER = "modified_user";
            public static final String MODIFIED_IP_ADDRESS = "modified_ip_address";

        }
    }

    //FORM GALPAL 25
    public static final class FG25OrganisasiRuangKegiatanLuar {
        public static final String NAME="f1_organisasi_ruang_luar";
        public static final class Cols{
            public static final String ID_F1_ORGANISASI_RUANG_LUAR="id_f1_organisasi_ruang_luar";
            public static final String ID_KUALIFIKASI_SURVEY="id_kualifikasi_survey";
            public static final String ID_PERIODE="id_periode";
            public static final String NAMA_TEMPAT="nama_tempat";
            public static final String LUAS="luas";
            public static final String DIMENSI="dimensi";
            public static final String KAPASAITAS="kapasitas";
            public static final String OPERASIONAL="operasional";
            public static final String JARAK="jarak";
            public static final String CREATED_DATE = "created_date";
            public static final String CREATED_USER = "created_user";
            public static final String CREATED_IP_ADDRESS = "created_ip_address";
            public static final String MODIFIED_DATE = "modified_date";
            public static final String MODIFIED_USER = "modified_user";
            public static final String MODIFIED_IP_ADDRESS = "modified_ip_address";

        }
    }

    //FORM KOMPAL1


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
