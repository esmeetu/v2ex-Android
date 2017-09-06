package com.firefly.v2ex.countdown;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;

/**
 * Created by jason on 9/6/17.
 */

public class CountDownService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        CountDownSingleton.getInstance().setTimerListener(new TimerListener() {
            @Override
            public void onTimeChange(int currentValue) {
                Intent intent =new Intent("countDown");
                intent.putExtra("value", currentValue);
                sendBroadcast(intent);
            }
        });
    }

}
