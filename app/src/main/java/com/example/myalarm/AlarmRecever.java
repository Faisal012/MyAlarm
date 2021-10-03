package com.example.myalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Vibrator;
import android.widget.Toast;

public class AlarmRecever extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Vibrator vibrator=(Vibrator)context.getSystemService(context.VIBRATOR_SERVICE);
        vibrator.vibrate(4000);
        Toast.makeText(context,"Wake up! wake up!",Toast.LENGTH_SHORT).show();
        Uri alarmUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        if(alarmUri==null){
            alarmUri=RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        }
        Ringtone ringtone=RingtoneManager.getRingtone(context,alarmUri);
        ringtone.play();
    }
}
