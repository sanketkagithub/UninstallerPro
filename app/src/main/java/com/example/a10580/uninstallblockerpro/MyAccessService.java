package com.example.a10580.uninstallblockerpro;

import android.accessibilityservice.AccessibilityService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

import java.util.logging.Handler;

public class MyAccessService extends AccessibilityService {
    int chc;
    long lastTimeofCall = 0L;
    long lastTimeofUpdate = 0L;
    long threshold_time = 10000;

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {

        Log.e("AccessibilityEvent","******AccessibilityEvent***********");

        try {

            final AccessibilityNodeInfo accessibilityNodeInfo = getRootInActiveWindow();
            if (accessibilityNodeInfo != null)
                chc = accessibilityNodeInfo.getChildCount();

            Log.e("childCount", " **** " + chc);


            for (int i = 0; i < chc; i++) {

                AccessibilityNodeInfo accessibilityNodeInfo1 = accessibilityNodeInfo.getChild(i);

                String classNameCheck = String.valueOf(accessibilityNodeInfo1.getClassName());
                String testCheck = String.valueOf(accessibilityNodeInfo1.getText());
                String packNameCheck = String.valueOf(accessibilityNodeInfo1.getPackageName());
                String actionListCheck = String.valueOf(accessibilityNodeInfo1.getActionList());

                Log.e("classNameCheck", classNameCheck);
                Log.e("testCheck", testCheck);

                    //if (testCheck.equals("IsPro")) {
                    if (testCheck.equals("PocPro")) {
                        lastTimeofCall = System.currentTimeMillis();
                        if (lastTimeofCall - lastTimeofUpdate > threshold_time) {

                        /* new android.os.Handler().postDelayed(new Runnable() {
                             @Override
                             public void run() {*/
                            createNischintNotification("fdsfd","fddf","dhjh");
                            accessibilityNodeInfo.performAction(AccessibilityNodeInfo.ACTION_CLICK);

                          /*   }
                         },4000);*/

                            //accessibilityNodeInfo1.performAction(AccessibilityNodeInfo.ACTION_CLEAR_FOCUS);
                            //accessibilityNodeInfo1.performAction(AccessibilityNodeInfo.ACTION_CLEAR_SELECTION);
                          //  accessibilityNodeInfo1.performAction(AccessibilityNodeInfo.ACTION_COLLAPSE);
                          //  accessibilityNodeInfo1.performAction(AccessibilityNodeInfo.ACTION_SELECT);
                            showLock(testCheck);
                            lastTimeofUpdate = System.currentTimeMillis();
                        }
                }

                Log.e("packNameCheck", packNameCheck);
                Log.e("actionListCheck", actionListCheck);


            }

            Log.e("childCount", accessibilityNodeInfo.getChildCount() + " **** ");
            Log.e("childCount", accessibilityNodeInfo.getChildCount() + " **** ");
            Log.e("childCount", accessibilityNodeInfo.getChildCount() + " **** ");
            Log.e("childCount", accessibilityNodeInfo.getChildCount() + " **** ");


        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }


    /**
     * @param
     */
    public void createNischintNotification(String ticker, String contentTitle, String contentText) {
        try {


            Context context = getApplicationContext();
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context
                    .NOTIFICATION_SERVICE);

            //addOreoNotificationChannel(notificationManager);

          /*  Intent notificationIntent = new Intent(context, HomeActivity.class);
            PendingIntent pendingIntent;
            // changing new Intent() to notificationIntent
            pendingIntent = PendingIntent.getActivity(context, 2, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
         */  // Bitmap icon = BitmapFactory.decodeResource(context.getResources(), R.dr);
            NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
            Notification notification = builder
                    .setTicker(ticker)
                    .setWhen(System.currentTimeMillis())
                    .setContentTitle(contentTitle)
                    .setContentText(contentText)
                    .setAutoCancel(true)
                    .setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_LIGHTS).build();
            notificationManager.notify(323267, notification);
        } catch (Exception e) {
            // DO Nothing
        }

    }


    private void showLock(String testCheck) {

           /* Intent intent = new Intent(this,LockActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);*/


        Intent startMain = new Intent(Intent.ACTION_MAIN);
        startMain.addCategory(Intent.CATEGORY_HOME);
        startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(startMain);
        }

    @Override
    public void onInterrupt() {

    }
}
