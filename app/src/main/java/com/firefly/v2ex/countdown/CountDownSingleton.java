package com.firefly.v2ex.countdown;


import android.os.Handler;
import android.os.Message;

public class CountDownSingleton {

    private static CountDownSingleton cdInstance;

    private final int value = 12;

    private TimerListener timerListener;

    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
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
        test("");
    }

    public void test(String object) {

    }

    public void test(CharSequence object) {

    }
}
