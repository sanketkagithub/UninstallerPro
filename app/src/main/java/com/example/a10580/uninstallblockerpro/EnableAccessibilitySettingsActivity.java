package com.example.a10580.uninstallblockerpro;

import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class EnableAccessibilitySettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enable_accessibility_settings);
    }

    public void go(View view)
    {
        openAccessibilitySettings();
      //  handleEnableAction();
    }

    private void openAccessibilitySettings() {
        String manufacturer = Build.MANUFACTURER;
        if ("xiaomi".equalsIgnoreCase(manufacturer) && Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            startActivity(new Intent(Settings.ACTION_SETTINGS));
        } else {
            startActivity(new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS));
        }
    }


/*
    private void handleEnableAction() {
        if (!TargetUtils.isNischintAccessibilityEnabled(getApplicationContext())) {
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                        checkAccessibilityStatus();
                    } catch (Exception e) {

                    }
                }
            }, 0);
        }
    }*/
}
