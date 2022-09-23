package com.pgy.pgyersdkdemo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.pgy.pgyersdkdemo.databinding.ActivityAnrBinding;


/**
 * @describe
 * @author: Caoxy
 * @date: 2021/6/22
 */
public class AnrActivity extends BaseActivity<ActivityAnrBinding>{
    private final Object _mutex = new Object();
    int duration = 4;
    private static void Sleep() {
        try {
            Thread.sleep(8 * 1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void InfiniteLoop() {
        int i = 0;
        //noinspection InfiniteLoopStatement
        while (true) {
            i++;
        }
    }

    public class LockerThread extends Thread {

        LockerThread() {
            setName("APP: Locker");
        }

        @Override
        public void run() {
            synchronized (_mutex) {
                //noinspection InfiniteLoopStatement
                while (true)
                    Sleep();
            }
        }
    }

    private void _deadLock() {
        new LockerThread().start();

        new Handler().postDelayed(new Runnable() {
            @Override public void run() {
                synchronized (_mutex) {
                    Log.e("ANR-Failed", "There should be a dead lock before this message");
                }
            }
        }, 1000);
    }

    private int mode = 0;
    private boolean crash = true;

    @SuppressLint({"SetTextI18n", "NewApi"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Button minAnrDurationButton = viewBinding.minAnrDuration;
        minAnrDurationButton.setText(duration + " seconds");
        minAnrDurationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                minAnrDurationButton.setText(4 + " seconds");
            }
        });

        final Button reportModeButton = viewBinding.reportMode;
        reportModeButton.setText("All threads");
        reportModeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mode = (mode + 1) % 3;
                switch (mode) {
                    case 0:
                        reportModeButton.setText("All threads");
//                        application.anrWatchDog.setReportAllThreads();
                        break ;
                    case 1:
                        reportModeButton.setText("Main thread only");
//                        application.anrWatchDog.setReportMainThreadOnly();
                        break ;
                    case 2:
                        reportModeButton.setText("Filtered");
//                        application.anrWatchDog.setReportThreadNamePrefix("APP:");
                        break ;
                }
            }
        });

        final Button behaviourButton = viewBinding.behaviour;
        behaviourButton.setText("Crash");
        behaviourButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crash = !crash;
                if (crash) {
                    behaviourButton.setText("Crash");
//                    application.anrWatchDog.setANRListener(null);
                } else {
                    behaviourButton.setText("Silent");
//                    application.anrWatchDog.setANRListener(application.silentListener);
                }
            }
        });

        viewBinding.threadSleep.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Sleep();
            }
        });

        viewBinding.infiniteLoop.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                InfiniteLoop();
            }
        });

        findViewById(R.id.deadlock).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                _deadLock();
            }
        });

    }
}
