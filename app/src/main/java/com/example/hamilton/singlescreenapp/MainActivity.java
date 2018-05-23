package com.example.hamilton.singlescreenapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.net.Uri;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_ASK_PERMISSIONS = 1;  // can be an integer between 0 and 255

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void dialPhone(View view) {

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // Permission not granted in Manifest so request permission
            ActivityCompat.requestPermissions(this, new String[]
                    {android.Manifest.permission.CALL_PHONE}, REQUEST_CODE_ASK_PERMISSIONS);
            return;
        } else {
            // Permission has been granted in Manifest so dial a number
            Intent callIntent = new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse("tel:7042543430"));
            startActivity(callIntent);
        }
    }

    public void addressLocation(View view) {
        Uri gmmIntentUri = Uri.parse("geo:28.0061004,-82.5827588");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        if (mapIntent.resolveActivity(getPackageManager()) != null) {

            // Attempt to start an activity that can handle the Intent
            startActivity(mapIntent);
        }
    }
}