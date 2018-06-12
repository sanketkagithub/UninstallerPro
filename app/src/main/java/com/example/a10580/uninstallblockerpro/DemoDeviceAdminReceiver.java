package com.example.a10580.uninstallblockerpro;

import android.app.admin.DeviceAdminReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.util.Log;

/*import com.nischinttechnologies.n4e.target.receivers.ServiceReceiver;
import com.nischinttechnologies.n4e.target.service.AppUninstallIntentService;
import com.nischinttechnologies.n4e.target.utils.TargetUtils;
import com.nischinttechnologies.n4e.util.Constants;*/

/**
 * This is the component that is responsible for actual device administration. It becomes the receiver when a policy is applied.
 * It is important that we subclass DeviceAdminReceiver class here and to implement its only required method onEnabled().
 */
public class DemoDeviceAdminReceiver extends DeviceAdminReceiver {

    private final String TAG = "DemoDeviceAdminReceiver";

    /**
     * Called when this application is approved to be a device administrator.
     */
    @Override
    public void onEnabled(Context context, Intent intent) {
        super.onEnabled(context, intent);

        Log.d(TAG, "onEnabled");
    }

    /**
     * Called when this application is no longer the device administrator.
     */
    @Override
    public void onDisabled(final Context context, Intent intent) {
        super.onDisabled(context, intent);
        Intent intent1 = new Intent(context,LockActivity.class);
        context.startActivity(intent1);


        // Handle device admin disabled scenario for devices from Lollipop onwards.
        // If uninstall action from inside N4E app don't do anything.
       /* if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP && !TargetUtils.getUninstallActionStatus(context) &&
            TargetUtils.isTargetActivated(context)) {
            Intent mIntent = new Intent(context, DeviceAdminPersistentActivity.class);
            mIntent.setFlags(Intent.FLAG_FROM_BACKGROUND | Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(mIntent);
            ServiceReceiver serviceReceiver = new ServiceReceiver();
            serviceReceiver.restartRunningServices(context);

            //Make API call to inform server of uninstall request from outside N4E app.
            Intent uninstallIntent = new Intent(context, AppUninstallIntentService.class);
            uninstallIntent.setAction(Constants.UNINSTALL_REQUEST);
            context.startService(uninstallIntent);

            // TODO to track whether the device admin was re-enabled or the app was uninstalled by repeatedly trying to
            // override the block screen. To send a "installed" call to server in case re enabled.
            // Init a handler which runs the AppNotUninstalledIntentService to update the server that the app is still
            // installed after some time: 4 mins
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (context == null) {
                        return;
                    }
                    Intent intent = new Intent(context, AppUninstallIntentService.class);
                    intent.setAction(Constants.INSTALLED);
                    context.startService(intent);
                }
            }, 240000);
        }
        Log.d(TAG, "onDisabled");*/
        Log.d(TAG, "onDisabled");



    }

    @Override
    public void onPasswordChanged(Context context, Intent intent) {
        super.onPasswordChanged(context, intent);
        Log.d(TAG, "onPasswordChanged");
    }

    @Override
    public void onPasswordFailed(Context context, Intent intent) {
        super.onPasswordFailed(context, intent);
        Log.d(TAG, "onPasswordFailed");
    }

    @Override
    public void onPasswordSucceeded(Context context, Intent intent) {
        super.onPasswordSucceeded(context, intent);
        Log.d(TAG, "onPasswordSucceeded");
    }

    @Override
    public CharSequence onDisableRequested(Context context, Intent intent) {
        Log.d(TAG, "onDisableRequested");
        return context.getResources().getString(R.string.device_admin_disable_alert);
    }
}
