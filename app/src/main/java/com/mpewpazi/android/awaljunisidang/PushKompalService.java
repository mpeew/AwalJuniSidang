package com.mpewpazi.android.awaljunisidang;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.util.Log;

import com.mpewpazi.android.awaljunisidang.Form.FormKompal3a;
import com.mpewpazi.android.awaljunisidang.Form.FormKompal3b;
import com.mpewpazi.android.awaljunisidang.Form.FormKompal3c;
import com.mpewpazi.android.awaljunisidang.Form.FormKompal3d;
import com.mpewpazi.android.awaljunisidang.dummy.DummyMaker;
import com.mpewpazi.android.awaljunisidang.model.MenuCheckingKompal;

import java.util.List;

/**
 * Created by mpewpazi on 5/29/16.
 */
public class PushKompalService extends IntentService {
    private static final String TAG="PushKompalService";
    private static final int POLL_INTERVAL = 1000 * 60 * 1; // 15 menit

    public static Intent newIntent(Context context){
        return new Intent(context,PushKompalService.class);
    }

    public static void setServiceAlarm(Context context,boolean isOn){
        Intent i=PushKompalService.newIntent(context);
        PendingIntent pi=PendingIntent.getService(context,0,i,0);

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
        Intent i = PushKompalService.newIntent(context);
        PendingIntent pi = PendingIntent
                .getService(context, 0, i, PendingIntent.FLAG_NO_CREATE);
        return pi != null;
    }


    public PushKompalService() {
        super(TAG);
    }


    @Override
    protected void onHandleIntent(Intent intent) {
        Log.i(TAG,"Push Kompal Service Is Running" );
        if(!new ConnectionDetector(this).isConnectingToInternet()){
            return;
        }

        DummyMaker dummyMaker=DummyMaker.get(this);
        List<FormKompal3a> formKompal3as=dummyMaker.getFormKompal3as();
        List<FormKompal3b> formKompal3bs=dummyMaker.getFormKompal3bs();
        List<FormKompal3c> formKompal3cs=dummyMaker.getFormKompal3cs();
        List<FormKompal3d> formKompal3ds=dummyMaker.getFormKompal3ds();
        List<MenuCheckingKompal> menuCheckingKompals=dummyMaker.getMenuCheckingKompals();


        for(FormKompal3a formKompal3a:formKompal3as) {
            new DataPusher().makePostRequestFK3a(formKompal3a);
            //update id yang dapet dari server
            dummyMaker.addFormKompal3a(formKompal3a);
        }
        for(FormKompal3b formKompal3b:formKompal3bs) {
            new DataPusher().makePostRequestFK3b(formKompal3b);
            dummyMaker.addFormKompal3b(formKompal3b);
        }
        for(FormKompal3c formKompal3c:formKompal3cs) {
            new DataPusher().makePostRequestFK3c(formKompal3c);
            dummyMaker.addFormKompal3c(formKompal3c);
        }
        for(FormKompal3d formKompal3d:formKompal3ds) {
            new DataPusher().makePostRequestFK3d(formKompal3d);
            dummyMaker.addFormKompal3d(formKompal3d);
        }
        for(MenuCheckingKompal menuCheckingKompal:menuCheckingKompals){
            new DataPusher().makePostRequestMenuCheckingKompal(menuCheckingKompal);
        }

        setServiceAlarm(this,false);
    }


}
