package com.nyartech.ringtone_plugin;

import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.app.Service;
import android.os.IBinder;
import android.provider.Settings;

public class RingtonePlayingService extends Service
{
    static Ringtone ringtone;

    @Override
    public IBinder onBind(Intent intent)
    {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        if(ringtone != null) 
            ringtone.stop();
        else
            ringtone = RingtoneManager.getRingtone(this, Settings.System.DEFAULT_RINGTONE_URI);

        ringtone.play();

        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy()
    {
        ringtone.stop();
    }
}