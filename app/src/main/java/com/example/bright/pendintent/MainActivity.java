package com.example.bright.pendintent;

import android.Manifest;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    WifiManager wifiManager;
    List scannedResult;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView2);
        wifiManager = (WifiManager)getApplicationContext().getSystemService(WIFI_SERVICE);
        scannedResult = new ArrayList();
    }

    public void doProcess(View view) {
        if (scannedResult.size() > 0){
            scannedResult.clear();
        }
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
                    1);

            if (wifiManager.isWifiEnabled()){
                Toast.makeText(getApplicationContext(), "on", Toast.LENGTH_SHORT).show();
                new AsyncTask<Void, String, String>(){
                    @Override
                    protected String doInBackground(Void... voids) {
                        List<ScanResult> scanResultList = wifiManager.getScanResults();
                        for (int i = 0; i < scanResultList.size(); i++){
                            scannedResult.add(scanResultList.get(i).SSID+"\n");
                        }
                        return scannedResult.toString();
                    }

                    @Override
                    protected void onPostExecute(String s) {
                        textView.setText(s);
                    }
                }.execute();
            }
            else{
                wifiManager.setWifiEnabled(true);
                new AsyncTask<Void, String, String>(){
                    @Override
                    protected String doInBackground(Void... voids) {
                        List<ScanResult> scanResultList = wifiManager.getScanResults();
                        for (int i = 0; i < scanResultList.size(); i++){
                            scannedResult.add(scanResultList.get(i).SSID+"\n");
                        }
                        return scannedResult.toString();
                    }

                    @Override
                    protected void onPostExecute(String s) {
                        textView.setText(s);
                    }
                }.execute();
            }
        }else{
            if (wifiManager.isWifiEnabled()){
                Toast.makeText(getApplicationContext(), "on", Toast.LENGTH_SHORT).show();
                new AsyncTask<Void, String, String>(){
                    @Override
                    protected String doInBackground(Void... voids) {
                        List<ScanResult> scanResultList = wifiManager.getScanResults();
                        for (int i = 0; i < scanResultList.size(); i++){
                            scannedResult.add(scanResultList.get(i).SSID+"\n");
                        }
                        return scannedResult.toString();
                    }

                    @Override
                    protected void onPostExecute(String s) {
                        textView.setText(s);
                    }
                }.execute();
            }
            else{
                wifiManager.setWifiEnabled(true);
                new AsyncTask<Void, String, String>(){
                    @Override
                    protected String doInBackground(Void... voids) {
                        List<ScanResult> scanResultList = wifiManager.getScanResults();
                        for (int i = 0; i < scanResultList.size(); i++){
                            scannedResult.add(scanResultList.get(i).SSID+"\n");
                        }
                        return scannedResult.toString();
                    }

                    @Override
                    protected void onPostExecute(String s) {
                        textView.setText(s);
                    }
                }.execute();
            }
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                           int[] grantResults) {
        if (requestCode == 1
                && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            if (wifiManager.isWifiEnabled()){
                textView.setText("");
                new AsyncTask<Void, String, String>(){
                    @Override
                    protected String doInBackground(Void... voids) {
                        List<ScanResult> scanResultList = wifiManager.getScanResults();
                        for (int i = 0; i < scanResultList.size(); i++){
                            scannedResult.add(scanResultList.get(i).SSID+"\n");
                        }
                        return scannedResult.toString();
                    }

                    @Override
                    protected void onPostExecute(String s) {
                        textView.setText(s);
                    }
                }.execute();
            }
            else{
                wifiManager.setWifiEnabled(true);
                new AsyncTask<Void, String, String>(){
                    @Override
                    protected String doInBackground(Void... voids) {
                        List<ScanResult> scanResultList = wifiManager.getScanResults();
                        for (int i = 0; i < scanResultList.size(); i++){
                            scannedResult.add(scanResultList.get(i).SSID+"\n");
                        }
                        return scannedResult.toString();
                    }

                    @Override
                    protected void onPostExecute(String s) {
                        textView.setText(s);
                    }
                }.execute();
            }
        }
    }
}
