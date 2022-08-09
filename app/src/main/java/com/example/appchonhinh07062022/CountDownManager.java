package com.example.appchonhinh07062022;

import android.os.CountDownTimer;
import android.util.Log;

/**
 * Created by pphat on 8/9/2022.
 */
public class CountDownManager extends CountDownTimer {

    public static OnListenCountDown listenCountDown;
    private final long interval;

    public CountDownManager(long millisInFuture, long countDownInterval) {
        super(millisInFuture, countDownInterval);
        interval = countDownInterval;
    }

    @Override
    public void onTick(long l) {
        if (listenCountDown != null && l > interval) listenCountDown.onTick(l);
    }

    @Override
    public void onFinish() {
        listenCountDown.onFinish();
    }

    public static void setOnListenerCountDown(OnListenCountDown onListenCountDown) {
        listenCountDown = onListenCountDown;
    }

    interface OnListenCountDown {
        void onTick(long currentTime);
        void onFinish();
    }
}
