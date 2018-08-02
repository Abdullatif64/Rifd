package com.example.abdll.mn;

import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    // Define GPS Tracker.
    private GpsTracker gpsTracker;

    // Variables.
    double lon, lat;
    int countFilledEditTexts = 0;
    Button confirmButton;
    EditText IDEditText, phoneNumberEditText, descEditText;

    // Activity Life Cycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get location permission.
        try {
            if (ContextCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED ) {
                ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, 101);
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        // Define UI properties.
        confirmButton = (Button) findViewById(R.id.confirmButton);
        confirmButton.setEnabled(false);
        IDEditText= (EditText) findViewById(R.id.IDEditText) ;
        phoneNumberEditText= (EditText)findViewById(R.id.phoneNumberEditText) ;
        descEditText= (EditText)findViewById(R.id.DescEditText);

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //getLocation();
                System.out.print(String.format("%s %s %s %f %f", IDEditText.getText(),
                        phoneNumberEditText.getText(),
                        descEditText.getText(),
                        lon, lat));
            }
        });

        setUpEditTexts();


    }


    private void getLocation(){
        gpsTracker = new GpsTracker(MainActivity.this);
        if(gpsTracker.canGetLocation()){
            double latitude = gpsTracker.getLatitude();
            double longitude = gpsTracker.getLongitude();
            lon = longitude;
            lat = latitude;
        }else{
            gpsTracker.showSettingsAlert();
        }
    }

    private void setUpEditTexts() {
        IDEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().trim().length() != 0) {
                    countFilledEditTexts++;
                } else {
                    countFilledEditTexts--;
                }

                if (countFilledEditTexts == 3) {
                    confirmButton.setEnabled(true);
                } else {
                    confirmButton.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        phoneNumberEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().trim().length() != 0) {
                    countFilledEditTexts++;
                } else {
                    countFilledEditTexts--;
                }

                if (countFilledEditTexts == 3) {
                    confirmButton.setEnabled(true);
                } else {
                    confirmButton.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        descEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().trim().length() != 0) {
                    countFilledEditTexts++;
                } else {
                    countFilledEditTexts--;
                }

                if (countFilledEditTexts == 3) {
                    confirmButton.setEnabled(true);
                } else {
                    confirmButton.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }
}