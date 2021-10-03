package com.example.myalarm;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    TimePicker alarmTimePicker;
    AlarmManager alarmManager;
    PendingIntent pendingIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        alarmTimePicker=(TimePicker)findViewById(R.id.timePicker);
        alarmManager=(AlarmManager)getSystemService(ALARM_SERVICE);
    }

    public void onToggleClicked(View view) {
        long time;
        if(((ToggleButton) view).isChecked()) {
            Toast.makeText(this,"ALARM ON",Toast.LENGTH_SHORT).show();
            Calendar calender=Calendar.getInstance();
            calender.set(Calendar.HOUR_OF_DAY,alarmTimePicker.getCurrentHour());
            calender.set(Calendar.MINUTE,alarmTimePicker.getCurrentMinute());
            Intent intent= new Intent(this,AlarmRecever.class);
            pendingIntent=PendingIntent.getBroadcast(this,0,intent,0);
            time=(calender.getTimeInMillis()-(calender.getTimeInMillis()%60000));
            if(System.currentTimeMillis()>time){
                if(calender.AM_PM==0){
                    time=time+(1000*60*60*12);
                }
                else{
                    time=time+(1000*60*60*12);
                }
            }
            alarmManager.setRepeating(alarmManager.RTC_WAKEUP,time,10000,pendingIntent);
        }
        else{
            alarmManager.cancel(pendingIntent);
            Toast.makeText(this,"ALARM OFF",Toast.LENGTH_SHORT).show();
        }
    }
}