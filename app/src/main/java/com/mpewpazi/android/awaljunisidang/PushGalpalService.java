package com.mpewpazi.android.awaljunisidang;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.util.Log;

import com.mpewpazi.android.awaljunisidang.Form.FormGalpal1;
import com.mpewpazi.android.awaljunisidang.Form.FormGalpal10;
import com.mpewpazi.android.awaljunisidang.Form.FormGalpal11;
import com.mpewpazi.android.awaljunisidang.Form.FormGalpal3;
import com.mpewpazi.android.awaljunisidang.Form.FormGalpal4;
import com.mpewpazi.android.awaljunisidang.Form.FormGalpal6;
import com.mpewpazi.android.awaljunisidang.Form.FormGalpal7;
import com.mpewpazi.android.awaljunisidang.Form.FormGalpal8;
import com.mpewpazi.android.awaljunisidang.Form.FormGalpal9;
import com.mpewpazi.android.awaljunisidang.Form.SingleForm;
import com.mpewpazi.android.awaljunisidang.dummy.DummyMaker;
import com.mpewpazi.android.awaljunisidang.model.MenuCheckingGalpal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mpewpazi on 5/29/16.
 */
public class PushGalpalService extends IntentService {
    private static final String TAG="PushGalpalService";
    private static final int POLL_INTERVAL = 1000 * 60 * 1; // 15 menit
    private static final int GALPAL_PUSH_REQUEST_CODE=0;

    public static Intent newIntent(Context context){
        return new Intent(context,PushGalpalService.class);
    }

    public static void setServiceAlarm(Context context,boolean isOn){
        Intent i=PushGalpalService.newIntent(context);
        PendingIntent pi=PendingIntent.getService(context,GALPAL_PUSH_REQUEST_CODE,i,0);

        AlarmManager alarmManager=(AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        if(isOn){
            alarmManager.setInexactRepeating(AlarmManager.ELAPSED_REALTIME, SystemClock.elapsedRealtime()
                    ,POLL_INTERVAL,pi);
        }else{
            alarmManager.cancel(pi);
            pi.cancel();
        }
    }

    public static boolean isServiceAlarmOn(Context context) {
        Intent i = PushGalpalService.newIntent(context);
        PendingIntent pi = PendingIntent
                .getService(context, GALPAL_PUSH_REQUEST_CODE, i, PendingIntent.FLAG_NO_CREATE);
        return pi != null;
    }


    public PushGalpalService() {
        super(TAG);
    }


    @Override
    protected void onHandleIntent(Intent intent) {

        Log.i(TAG,"Push Galpal Service Is Running" );
        if(!new ConnectionDetector(this).isConnectingToInternet()){
            return;
        }
        DummyMaker dummyMaker=DummyMaker.get(this);
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
        List<SingleForm> conflictForms=new ArrayList<>();


        for(FormGalpal1 formGalpal1:formGalpal1s) {
            new DataPusher(GalKomSharedPreference.getUserId(getApplicationContext()),GalKomSharedPreference.getPassword(getApplicationContext())).makePostRequestFG1(formGalpal1);
        }
        for(FormGalpal3 formGalpal3:formGalpal3s) {
            new DataPusher(GalKomSharedPreference.getUserId(getApplicationContext()),GalKomSharedPreference.getPassword(getApplicationContext())).makePostRequestFG3(formGalpal3);
        }
        for(FormGalpal4 formGalpal4:formGalpal4s) {
            new DataPusher(GalKomSharedPreference.getUserId(getApplicationContext()),GalKomSharedPreference.getPassword(getApplicationContext())).makePostRequestFG4(formGalpal4);
        }
        for(FormGalpal6 formGalpal6:formGalpal6s) {
            if(new DataPusher().isConflictRequest(formGalpal6,DataPusher.urlCheckPostFG6)){
                conflictForms.add(formGalpal6);
                Log.i("Sync","dalem");
            }else {
                new DataPusher(GalKomSharedPreference.getUserId(getApplicationContext()), GalKomSharedPreference.getPassword(getApplicationContext())).makePostRequestFG6(formGalpal6);
                //update id yang dapet dari server
                dummyMaker.addFormGalpal6(formGalpal6);
            }

        }
        for(FormGalpal7 formGalpal7:formGalpal7s) {
            if(new DataPusher().isConflictRequest(formGalpal7,DataPusher.urlCheckPostFG7)){
                conflictForms.add(formGalpal7);
            }else {
                new DataPusher(GalKomSharedPreference.getUserId(getApplicationContext()), GalKomSharedPreference.getPassword(getApplicationContext())).makePostRequestFG7(formGalpal7);
                dummyMaker.addFormGalpal7(formGalpal7);
            }
        }
        for(FormGalpal8 formGalpal8:formGalpal8s) {
            if(new DataPusher().isConflictRequest(formGalpal8,DataPusher.urlCheckPostFG8)){
                conflictForms.add(formGalpal8);
            }else {
                new DataPusher(GalKomSharedPreference.getUserId(getApplicationContext()), GalKomSharedPreference.getPassword(getApplicationContext())).makePostRequestFG8(formGalpal8);
                dummyMaker.addFormGalpal8(formGalpal8);
            }
        }
        for(FormGalpal9 formGalpal9:formGalpal9s) {
            if(new DataPusher().isConflictRequest(formGalpal9,DataPusher.urlCheckPostFG9)){
                conflictForms.add(formGalpal9);
            }else {
                new DataPusher(GalKomSharedPreference.getUserId(getApplicationContext()), GalKomSharedPreference.getPassword(getApplicationContext())).makePostRequestFG9(formGalpal9);
                dummyMaker.addFormGalpal9(formGalpal9);
            }
        }
        for(FormGalpal10 formGalpal10:formGalpal10s) {
            if(new DataPusher().isConflictRequest(formGalpal10,DataPusher.urlCheckPostFG10)){
                conflictForms.add(formGalpal10);
            }else {
                new DataPusher(GalKomSharedPreference.getUserId(getApplicationContext()), GalKomSharedPreference.getPassword(getApplicationContext())).makePostRequestFG10(formGalpal10);
                dummyMaker.addFormGalpal10(formGalpal10);
            }
        }
        for(FormGalpal11 formGalpal11:formGalpal11s) {
            if(new DataPusher().isConflictRequest(formGalpal11,DataPusher.urlCheckPostFG11)){
                conflictForms.add(formGalpal11);
            }else {
                new DataPusher(GalKomSharedPreference.getUserId(getApplicationContext()), GalKomSharedPreference.getPassword(getApplicationContext())).makePostRequestFG11(formGalpal11);
                dummyMaker.addFormGalpal11(formGalpal11);
            }
        }
        for(MenuCheckingGalpal menuCheckingGalpal:menuCheckingGalpals){
            if (conflictForms.size()==0) {
                new DataPusher(GalKomSharedPreference.getUserId(getApplicationContext()), GalKomSharedPreference.getPassword(getApplicationContext())).makePostRequestMenuCheckingGalpal(menuCheckingGalpal);
            }
        }

        if(conflictForms.size()>0){
            Intent intentNotification=new Intent("galpal_conflict_intent");
            intentNotification.setAction("galpal_conflict_intent");
            sendBroadcast(intentNotification);
        }

        setServiceAlarm(this,false);
    }


}
