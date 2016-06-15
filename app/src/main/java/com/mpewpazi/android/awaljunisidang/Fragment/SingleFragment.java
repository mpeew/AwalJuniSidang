package com.mpewpazi.android.awaljunisidang.fragment;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;

import com.mpewpazi.android.awaljunisidang.tools.CustomClickListener;
import com.mpewpazi.android.awaljunisidang.tools.DataFetcher;
import com.mpewpazi.android.awaljunisidang.tools.DataPusher;
import com.mpewpazi.android.awaljunisidang.activity.DrawerFormActivity;
import com.mpewpazi.android.awaljunisidang.formModel.FormGalpal1;
import com.mpewpazi.android.awaljunisidang.formModel.FormGalpal10;
import com.mpewpazi.android.awaljunisidang.formModel.FormGalpal11;
import com.mpewpazi.android.awaljunisidang.formModel.FormGalpal3;
import com.mpewpazi.android.awaljunisidang.formModel.FormGalpal4;
import com.mpewpazi.android.awaljunisidang.formModel.FormGalpal6;
import com.mpewpazi.android.awaljunisidang.formModel.FormGalpal7;
import com.mpewpazi.android.awaljunisidang.formModel.FormGalpal8;
import com.mpewpazi.android.awaljunisidang.formModel.FormGalpal9;
import com.mpewpazi.android.awaljunisidang.formModel.FormGalpalFoto;
import com.mpewpazi.android.awaljunisidang.formModel.FormKompal3a;
import com.mpewpazi.android.awaljunisidang.formModel.FormKompal3b;
import com.mpewpazi.android.awaljunisidang.formModel.FormKompal3c;
import com.mpewpazi.android.awaljunisidang.formModel.FormKompal3d;
import com.mpewpazi.android.awaljunisidang.formModel.SingleForm;
import com.mpewpazi.android.awaljunisidang.tools.GalKomSharedPreference;
import com.mpewpazi.android.awaljunisidang.tools.PictureUtils;
import com.mpewpazi.android.awaljunisidang.database.DummyMaker;
import com.mpewpazi.android.awaljunisidang.modelExtras.KualifikasiSurvey;
import com.mpewpazi.android.awaljunisidang.modelExtras.MenuCheckingGalpal;
import com.mpewpazi.android.awaljunisidang.modelExtras.MenuCheckingKompal;
import com.mpewpazi.android.awaljunisidang.modelExtras.Perusahaan;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mpewpazi on 5/10/16.
 */
public class SingleFragment extends Fragment {
    protected CustomClickListener mCustomClickListener;
    protected Context mContext;
    protected BroadcastReceiver clientReceiver;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext=getActivity();
        setRetainInstance(true);
    }

    public void setCustomClickListener(CustomClickListener customClickListener){
        mCustomClickListener=customClickListener;
    }

    protected void setViewEnabledFalse(View view) {

        if (view instanceof LinearLayout) {
            LinearLayout viewGroup = (LinearLayout) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View child = viewGroup.getChildAt(i);
                setViewEnabledFalse(child);
            }
        }else if (view instanceof ScrollView) {
            ScrollView viewGroup = (ScrollView) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View child = viewGroup.getChildAt(i);
                setViewEnabledFalse(child);
            }
        }else if (view instanceof CardView) {
            CardView viewGroup = (CardView) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View child = viewGroup.getChildAt(i);
                setViewEnabledFalse(child);
            }
        }else if (view instanceof RecyclerView) {
            RecyclerView viewGroup = (RecyclerView) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View child = viewGroup.getChildAt(i);
                setViewEnabledFalse(child);
            }
        }else if (view instanceof TextInputLayout) {
            TextInputLayout viewGroup = (TextInputLayout) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View child = viewGroup.getChildAt(i);
                setViewEnabledFalse(child);
            }
        }else if (view instanceof EditText) {
            view.setEnabled(false);
            view.setFocusable(false);
        }else if (view instanceof Button) {
            view.setVisibility(View.GONE);
        }else if (view instanceof ImageButton) {
            view.setVisibility(View.GONE);
        }else if (view instanceof Spinner) {
            view.setEnabled(false);
        }
    }

    protected void setViewNote(KualifikasiSurvey mKualifikasiSurvey, SingleForm singleForm){
        if(mKualifikasiSurvey.getStatus()==2 && !singleForm.getNote().equals("-")){
            AlertDialog.Builder alertDialogBuilder=new AlertDialog.Builder(getActivity());
            alertDialogBuilder.setMessage("Komentar :  " +singleForm.getNote());

            alertDialogBuilder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
    }

    protected void updatePhotoView(FormGalpalFoto formGalpalFoto, ImageView mPhotoView){
        if(formGalpalFoto.getImagePath()==null){
            mPhotoView.setImageDrawable(null);
        }else{
            Bitmap bitmap= PictureUtils.getScaledBitmap(formGalpalFoto.getImagePath(),getActivity());
            mPhotoView.setImageBitmap(bitmap);
        }
    }

    protected class PushGalpalsTask extends AsyncTask<Void,Void,Void> {
        private ProgressDialog mProgressDialog1;
        @Override
        protected void onPreExecute() {
            mProgressDialog1=new ProgressDialog(getActivity());
            mProgressDialog1.setMessage("Syncing .....");
            mProgressDialog1.show();
        }

        @Override
        protected Void doInBackground(Void... params) {
            DummyMaker dummyMaker=DummyMaker.get(getActivity());
            List<FormGalpal1> formGalpal1s=dummyMaker.getFormGalpal1s();
            List<FormGalpal3> formGalpal3s=dummyMaker.getFormGalpal3s();
            List<FormGalpal4> formGalpal4s=dummyMaker.getFormGalpal4s();
            List<FormGalpal6> formGalpal6s=dummyMaker.getFormGalpal6s();
            List<FormGalpal7> formGalpal7s=dummyMaker.getFormGalpal7s();
            List<FormGalpal8> formGalpal8s=dummyMaker.getFormGalpal8s();
            List<FormGalpal9> formGalpal9s=dummyMaker.getFormGalpal9s();
            List<FormGalpal10> formGalpal10s=dummyMaker.getFormGalpal10s();
            List<FormGalpal11> formGalpal11s=dummyMaker.getFormGalpal11s();
            List<MenuCheckingGalpal> menuCheckingGalpals=dummyMaker.getMenuCheckingGalpals();


            for(FormGalpal1 formGalpal1:formGalpal1s) {
                new DataPusher(GalKomSharedPreference.getUserId(getActivity()),GalKomSharedPreference.getPassword(getActivity())).makePostRequestFG1(formGalpal1);
            }
            for(FormGalpal3 formGalpal3:formGalpal3s) {
                new DataPusher(GalKomSharedPreference.getUserId(getActivity()),GalKomSharedPreference.getPassword(getActivity())).makePostRequestFG3(formGalpal3);
            }
            for(FormGalpal4 formGalpal4:formGalpal4s) {
                new DataPusher(GalKomSharedPreference.getUserId(getActivity()),GalKomSharedPreference.getPassword(getActivity())).makePostRequestFG4(formGalpal4);
            }
            for(FormGalpal6 formGalpal6:formGalpal6s) {
                new DataPusher(GalKomSharedPreference.getUserId(getActivity()), GalKomSharedPreference.getPassword(getActivity())).makePostRequestFG6(formGalpal6);
                //update id yang dapet dari server
                dummyMaker.addFormGalpal6(formGalpal6);
            }
            for(FormGalpal7 formGalpal7:formGalpal7s) {
                new DataPusher(GalKomSharedPreference.getUserId(getActivity()),GalKomSharedPreference.getPassword(getActivity())).makePostRequestFG7(formGalpal7);
                dummyMaker.addFormGalpal7(formGalpal7);
            }
            for(FormGalpal8 formGalpal8:formGalpal8s) {
                new DataPusher(GalKomSharedPreference.getUserId(getActivity()),GalKomSharedPreference.getPassword(getActivity())).makePostRequestFG8(formGalpal8);
                dummyMaker.addFormGalpal8(formGalpal8);
            }
            for(FormGalpal9 formGalpal9:formGalpal9s) {
                new DataPusher(GalKomSharedPreference.getUserId(getActivity()),GalKomSharedPreference.getPassword(getActivity())).makePostRequestFG9(formGalpal9);
                dummyMaker.addFormGalpal9(formGalpal9);
            }
            for(FormGalpal10 formGalpal10:formGalpal10s) {
                new DataPusher(GalKomSharedPreference.getUserId(getActivity()),GalKomSharedPreference.getPassword(getActivity())).makePostRequestFG10(formGalpal10);
                dummyMaker.addFormGalpal10(formGalpal10);
            }
            for(FormGalpal11 formGalpal11:formGalpal11s) {
                new DataPusher(GalKomSharedPreference.getUserId(getActivity()),GalKomSharedPreference.getPassword(getActivity())).makePostRequestFG11(formGalpal11);
                dummyMaker.addFormGalpal11(formGalpal11);
            }
            for(MenuCheckingGalpal menuCheckingGalpal:menuCheckingGalpals){
                new DataPusher(GalKomSharedPreference.getUserId(getActivity()),GalKomSharedPreference.getPassword(getActivity())).makePostRequestMenuCheckingGalpal(menuCheckingGalpal);
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            mProgressDialog1.dismiss();
        }
    }

    private class FetchFormsTask extends AsyncTask<Void,Void,List<SingleForm>> {
        private List<KualifikasiSurvey> mKualifikasiSurveys;
        private List<SingleForm> mSingleForms=new ArrayList<>();
        DummyMaker mDummyMaker=DummyMaker.get(getActivity());
        ProgressDialog mProgressDialog2;

        private FetchFormsTask(){
            mKualifikasiSurveys=mDummyMaker.getKualifikasiSurveys();
        }

        @Override
        protected void onPreExecute() {
            mProgressDialog2=new ProgressDialog(getActivity());
            mProgressDialog2.setMessage("Syncing .....");
            mProgressDialog2.show();
        }

        @Override
        protected List<SingleForm> doInBackground(Void... params) {
            for(KualifikasiSurvey kualifikasiSurvey:mKualifikasiSurveys) {
                String jenisIndustri=mDummyMaker.getPerusahaan(kualifikasiSurvey.getPerusahaanId()).getIndustri();
                if(jenisIndustri.equals(Perusahaan.industriGalpal)) {
                    mSingleForms.addAll(new DataFetcher().fetchFormGalpals(String.valueOf(kualifikasiSurvey.getKualifikasiSurveyId())));
                }else{
                    mSingleForms.addAll(new DataFetcher().fetchFormKompals(String.valueOf(kualifikasiSurvey.getKualifikasiSurveyId())));
                }
            }
            return mSingleForms;
        }



        @Override
        protected void onPostExecute(List<SingleForm> singleForms) {
            for(SingleForm singleForm:singleForms){
                switch(singleForm.getKodeAsync()){
                    case FormGalpal1.kodeAsync:
                        DummyMaker.get(getActivity()).addFormGalpal1((FormGalpal1)singleForm);
                        break;
                    case FormGalpal3.kodeAsync:
                        DummyMaker.get(getActivity()).addFormGalpal3((FormGalpal3)singleForm);
                        break;
                    case FormGalpal4.kodeAsync:
                        DummyMaker.get(getActivity()).addFormGalpal4((FormGalpal4)singleForm);
                        break;
                    case FormGalpal6.kodeAsync:
                        DummyMaker.get(getActivity()).addFormGalpal6Server((FormGalpal6)singleForm);
                        break;
                    case FormGalpal7.kodeAsync:
                        DummyMaker.get(getActivity()).addFormGalpal7Server((FormGalpal7)singleForm);
                        break;
                    case FormGalpal8.kodeAsync:
                        DummyMaker.get(getActivity()).addFormGalpal8Server((FormGalpal8)singleForm);
                        break;
                    case FormGalpal9.kodeAsync:
                        DummyMaker.get(getActivity()).addFormGalpal9Server((FormGalpal9)singleForm);
                        break;
                    case FormGalpal10.kodeAsync:
                        DummyMaker.get(getActivity()).addFormGalpal10Server((FormGalpal10)singleForm);
                        break;
                    case FormGalpal11.kodeAsync:
                        DummyMaker.get(getActivity()).addFormGalpal11Server((FormGalpal11)singleForm);
                        break;
                    case FormGalpalFoto.kodeAsync:
                        DummyMaker.get(getActivity()).addFormGalpalFotoServer((FormGalpalFoto) singleForm);
                        break;
                    case FormKompal3a.kodeAsync:
                        DummyMaker.get(getActivity()).addFormKompal3aServer((FormKompal3a)singleForm);
                        break;
                    case FormKompal3b.kodeAsync:
                        DummyMaker.get(getActivity()).addFormKompal3bServer((FormKompal3b)singleForm);
                        break;
                    case FormKompal3c.kodeAsync:
                        DummyMaker.get(getActivity()).addFormKompal3cServer((FormKompal3c)singleForm);
                        break;
                    case FormKompal3d.kodeAsync:
                        DummyMaker.get(getActivity()).addFormKompal3dServer((FormKompal3d)singleForm);
                        break;
                }
            }
            mProgressDialog2.dismiss();

        }
    }

    protected class PushKompalsTask extends AsyncTask<Void,Void,Void> {
        private ProgressDialog mProgressDialog3;
        @Override
        protected void onPreExecute() {
            mProgressDialog3=new ProgressDialog(getActivity());
            mProgressDialog3.setMessage("Syncing .....");
            mProgressDialog3.show();
        }

        @Override
        protected Void doInBackground(Void... params) {
            DummyMaker dummyMaker=DummyMaker.get(getActivity());
            List<FormKompal3a> formKompal3as=dummyMaker.getFormKompal3as();
            List<FormKompal3b> formKompal3bs=dummyMaker.getFormKompal3bs();
            List<FormKompal3c> formKompal3cs=dummyMaker.getFormKompal3cs();
            List<FormKompal3d> formKompal3ds=dummyMaker.getFormKompal3ds();
            List<MenuCheckingKompal> menuCheckingKompals=dummyMaker.getMenuCheckingKompals();


            for(FormKompal3a formKompal3a:formKompal3as) {
                new DataPusher(GalKomSharedPreference.getUserId(getActivity()),GalKomSharedPreference.getPassword(getActivity())).makePostRequestFK3a(formKompal3a);
                //update id yang dapet dari server
                dummyMaker.addFormKompal3a(formKompal3a);
            }
            for(FormKompal3b formKompal3b:formKompal3bs) {
                new DataPusher(GalKomSharedPreference.getUserId(getActivity()),GalKomSharedPreference.getPassword(getActivity())).makePostRequestFK3b(formKompal3b);
                dummyMaker.addFormKompal3b(formKompal3b);
            }
            for(FormKompal3c formKompal3c:formKompal3cs) {
                new DataPusher(GalKomSharedPreference.getUserId(getActivity()),GalKomSharedPreference.getPassword(getActivity())).makePostRequestFK3c(formKompal3c);
                dummyMaker.addFormKompal3c(formKompal3c);
            }
            for(FormKompal3d formKompal3d:formKompal3ds) {
                new DataPusher(GalKomSharedPreference.getUserId(getActivity()),GalKomSharedPreference.getPassword(getActivity())).makePostRequestFK3d(formKompal3d);
                dummyMaker.addFormKompal3d(formKompal3d);
            }
            for(MenuCheckingKompal menuCheckingKompal:menuCheckingKompals){
                new DataPusher(GalKomSharedPreference.getUserId(getActivity()),GalKomSharedPreference.getPassword(getActivity())).makePostRequestMenuCheckingKompal(menuCheckingKompal);
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            mProgressDialog3.dismiss();
        }


    }

    @Override
    public void onStart() {
        super.onStart();
        IntentFilter intent=new IntentFilter();
        KualifikasiSurvey kualifikasiSurvey=DummyMaker.get(getActivity()).getKualifikasiSurvey(DrawerFormActivity.kualifikasiSurveyId);
        Perusahaan perusahaan=DummyMaker.get(getActivity()).getPerusahaan(kualifikasiSurvey.getPerusahaanId());
        if(perusahaan.getIndustri().equals(Perusahaan.industriGalpal)) {
            intent.addAction("galpal_conflict_intent");
            clientReceiver = new BroadcastReceiver() {
                @Override
                public void onReceive(Context context, Intent intent) {
                    AlertDialog.Builder alertDialogBuilder=new AlertDialog.Builder(getActivity());
                    alertDialogBuilder.setMessage("Terdapat perbedaan data antara data yang terdapat di server dan di handphone, data mana yang mau anda terima ?  ");
                    alertDialogBuilder.setPositiveButton("Data Mereka", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            new FetchFormsTask().execute();
                        }
                    });
                    alertDialogBuilder.setNegativeButton("Data Handphone", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            new PushGalpalsTask().execute();
                        }
                    });

                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();
                }
            };
            getActivity().registerReceiver(clientReceiver, intent);
        }else{
            intent.addAction("kompal_conflict_intent");
            clientReceiver = new BroadcastReceiver() {
                @Override
                public void onReceive(Context context, Intent intent) {
                    AlertDialog.Builder alertDialogBuilder=new AlertDialog.Builder(getActivity());
                    alertDialogBuilder.setMessage("Terdapat perbedaan data antara data yang terdapat di server dan di handphone, data mana yang mau anda terima ?  ");
                    alertDialogBuilder.setPositiveButton("Data Mereka", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            new FetchFormsTask().execute();
                        }
                    });
                    alertDialogBuilder.setNegativeButton("Data Handphone", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            new PushKompalsTask().execute();
                        }
                    });

                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();
                }
            };
            getActivity().registerReceiver(clientReceiver, intent);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        getActivity().unregisterReceiver(clientReceiver);
    }

   /* protected List<SingleForm> showConflictDataAlert(String hasil, final SingleForm singleForm){
        final boolean isPostiviePressed;
        if (hasil.equals("Conflict")){
            AlertDialog.Builder alertDialogBuilder=new AlertDialog.Builder(getActivity());
            alertDialogBuilder.setMessage("Terdapat perbedaan data antara data yang terdapat di server dan di handphone, data mana yang mau anda terima ?  ");

            alertDialogBuilder.setPositiveButton("Data Mereka", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    isPostiviePressed=true;
                    return new DataFetcher().fetchFormGalpals(String.valueOf(singleForm.getKualifikasiSurveyId()));
                }
            });
            alertDialogBuilder.setNegativeButton("Data Handphone", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
    }*/

}
