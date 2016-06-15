package com.mpewpazi.android.awaljunisidang.service;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;

import com.mpewpazi.android.awaljunisidang.activity.HomePageActivity;
import com.mpewpazi.android.awaljunisidang.tools.ConnectionDetector;
import com.mpewpazi.android.awaljunisidang.tools.DataFetcher;
import com.mpewpazi.android.awaljunisidang.tools.GalKomSharedPreference;
import com.mpewpazi.android.awaljunisidang.modelExtras.Notification;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mpewpazi on 6/1/16.
 */
public class NotificationService extends IntentService {
    private static final String TAG="NotificationService";
    private static final int POLL_INTERVAL = 1000 ; // 15 menit
    private static final int NOTIFICATION_REQUEST_CODE=2;

    private static Context mContext;

    public static Intent newIntent(Context context){
        return new Intent(context,NotificationService.class);
    }

    public static void setServiceAlarm(Context context,boolean isOn){
        Intent i=NotificationService.newIntent(context);
        mContext=context;
        PendingIntent pi=PendingIntent.getService(context,NOTIFICATION_REQUEST_CODE,i,0);

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
        Intent i = NotificationService.newIntent(context);
        PendingIntent pi = PendingIntent
                .getService(context, NOTIFICATION_REQUEST_CODE, i, PendingIntent.FLAG_NO_CREATE);
        return pi != null;
    }


    public NotificationService() {
        super(TAG);
    }


    @Override
    protected void onHandleIntent(Intent intent) {
        Intent intentNotification=new Intent("notification_intent");
        intentNotification.setAction("notification_intent");
        sendBroadcast(intentNotification);

        Log.i(TAG,"Notification Service Is Running" );
        if(!new ConnectionDetector(this).isConnectingToInternet()){
            return;
        }
        List<Notification> notifications=new DataFetcher().fetchNotifications(GalKomSharedPreference.getUserId(getApplicationContext()));
        List<Notification> unReadNotifications=new ArrayList<>();
        for (Notification notification:notifications){
            if (notification.getNotifyStatus().equals("unread")){
                unReadNotifications.add(notification);
                Log.i(TAG,"dalem unread" );
            }
        }
        for (Notification notification:unReadNotifications){
            setNotification(notification);
            //kirim boradcast receiver untuk merubah HomepageActivity dedicated notification

            //this broadcast receiver code ended here ////
            Log.i(TAG,"ada yang error" );
        }

    }

    private void setNotification(Notification notificationModel){
        Intent i=new Intent(this,HomePageActivity.class);
        PendingIntent pi=PendingIntent.getActivity(this,0,i,0);

        android.app.Notification notification = new NotificationCompat.Builder(this)
                .setTicker(notificationModel.getNotifyTitle())
                .setSmallIcon(android.R.drawable.ic_menu_report_image)
                .setContentTitle(notificationModel.getNotifyTitle())
                .setContentText(notificationModel.getNotifyMessage())
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                .setVibrate(new long[] { 1000, 1000})
                .setLights(Color.BLUE, 3000, 3000)
                .setContentIntent(pi)
                .setAutoCancel(true)
                .build();

        NotificationManagerCompat notificationManager =NotificationManagerCompat.from(this);
        notificationManager.notify(notificationModel.getIdNotification(), notification);
    }
}
