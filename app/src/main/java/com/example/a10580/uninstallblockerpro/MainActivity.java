package com.example.a10580.uninstallblockerpro;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE = 0;
    ComponentName mAdminName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void enableDeAd(View view)
    {            mAdminName = new ComponentName(this, DemoDeviceAdminReceiver.class);

        //  HomeActivity.isFirstUsageState=true;
//                    TargetUtils.setActivateDeviceAdminActionStatus(DeviceAdminActivity.this, true);
        Intent intent = new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
        intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, mAdminName);
        intent.putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION,
                "Click on Activate button to secure your application.");
        startActivityForResult(intent, REQUEST_CODE);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // If Nischint Accessibility Settings is not enabled, start EnableAccessibilitySettingsActivity.
        //if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
           // if (!TargetUtils.isNischintAccessibilityEnabled(getApplicationContext())) {
                Intent mIntent = new Intent(getApplicationContext(), EnableAccessibilitySettingsActivity.class);
                mIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                mIntent.putExtra("childActivation", true);
                startActivity(mIntent);
            }
        /*}else {
            Intent mIntent = new Intent(getApplicationContext(), HomeActivity.class);
            startActivity(mIntent);
            finish();
        }*/
    }








