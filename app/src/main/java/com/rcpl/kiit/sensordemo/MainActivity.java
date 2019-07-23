package com.rcpl.kiit.sensordemo;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Collection;

public class MainActivity extends AppCompatActivity implements SensorEventListener{
    TextView t;
    RelativeLayout r;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t=findViewById(R.id.tv);
        r=findViewById(R.id.rl);
        //getSystemService used to call sensor,camera,blutooth
        SensorManager sm=(SensorManager)getSystemService(SENSOR_SERVICE);
        //int i=Sensor.TYPE_ORIENTATION;
        int i=Sensor.TYPE_PROXIMITY;
        Sensor s=sm.getDefaultSensor(i);
        //getDefaultSensor use to call type of sensor present in mobile
        sm.registerListener(this,s,sm.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        float []data=event.values;
        /*int z=(int)data[0];
        int y=(int)data[1];

        int x=(int)data[2];

        String st="ORIENTATION SENSOR";
        st=st+"\nPITCH ="+x;
        st=st+"\nROLL ="+y;
        st=st+"\nAZIMUTH ="+z;
        t.setText(st);

        r.setBackgroundColor(Color.rgb((int) x,(int) y,(int) z));*/

        float object_distance=data[0];
        if (object_distance==0)
        {
            r.setBackgroundColor(Color.RED);
        }
        else
        {
            r.setBackgroundColor(Color.BLUE);

        }



    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
