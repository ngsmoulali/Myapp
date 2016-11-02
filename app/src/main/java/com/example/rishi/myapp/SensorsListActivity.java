package com.example.rishi.myapp;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class SensorsListActivity extends AppCompatActivity {
    private SensorManager mSensorManager;
    private TextView tvList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensors_list);
        tvList=(TextView)findViewById(R.id.tvList);
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> deviceSensors = mSensorManager.getSensorList(Sensor.TYPE_ALL);
        StringBuilder info=new StringBuilder();
        for(Sensor sensor:deviceSensors){
            info.append("\n\n Name "+sensor.getName()+" Type "+sensor.getType()+" Vendor "+sensor.getVendor());
            tvList.setText(info);
        }
    }
}
