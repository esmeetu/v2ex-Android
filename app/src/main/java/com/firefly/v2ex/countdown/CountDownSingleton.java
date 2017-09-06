package com.firefly.v2ex.countdown;


import android.os.Handler;
import android.os.Message;

public class CountDownSingleton {

    private static CountDownSingleton cdInstance;

    private int value;

    private TimerListener timerListener;

    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    value ++;
                    if (timerListener != null) {
                        timerListener.onTimeChange(value);
                    }
                    handler.sendEmptyMessageDelayed(0, 1000);
                    break;
            }
            return false;
        }
    });

    public static CountDownSingleton getInstance() {
        if (cdInstance == null) {
            synchronized (CountDownSingleton.class) {
                if (cdInstance == null) {
                    cdInstance = new CountDownSingleton();
                }
            }
        }
        return cdInstance;
    }

    public CountDownSingleton() {
        handler.sendEmptyMessage(0);
    }

    public void setTimerListener(TimerListener timerListener) {
        this.timerListener = timerListener;
    }
}
