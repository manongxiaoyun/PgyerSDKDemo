package com.pgy.pgyersdkdemo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;

import com.pgy.pgyersdkdemo.databinding.ActivityMain2Binding;
import com.pgyer.pgyersdk.PgyerSDKManager;
//import com.pgyer.pgyersdk.callback.PgyHttpRequestCallback;
//import com.pgyer.pgyersdk.msgtask.MsgCollector;

public class TowActivity extends BaseActivity<ActivityMain2Binding> {
    private static final String TAG = "TAG_TowActivity";

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewBinding.tvShow.setMovementMethod(ScrollingMovementMethod.getInstance());

        viewBinding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        viewBinding.btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TowActivity.this, FourActivity.class);
                startActivity(intent);
            }
        });

        viewBinding.btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int a = 1/0;
                } catch (Exception e) {
                    Log.d("pgyer-->",
                            "open logcat process failed. message: " + e.getMessage());
                    PgyerSDKManager.reportException(e);
//                    viewBinding.tvShow.setText(JsonUtils.toJSONString(MsgCollector.getInstance().getMsgList()));
                }

            }
        });

        viewBinding.btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = 1/0;
            }
        });
        viewBinding.btnD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int a = 1/0;
                } catch (Exception e) {
                    Log.d("pgyer-->",
                            "open logcat process failed. message: " + e.getMessage());
                    PgyerSDKManager.caughtRealTimeException(e,null);
//                    PgyerSDKManager.caughtRealTimeException(e, new PgyHttpRequestCallback() {
//                        @Override
//                        public void onSuccess(String response) {
//                            viewBinding.tvShow.setText("上报成功");
//                        }
//
//                        @Override
//                        public void onFail(Exception e) {
//                            viewBinding.tvShow.setText("上报失败："+e.toString());
//                        }
//                    });
//                    viewBinding.tvShow.setText(JsonUtils.toJSONString(MsgCollector.getInstance().getMsgList()));
                }
            }
        });
//        PACApplication.getTestDataBack().setTextView(tvShow);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"到onStart方法了---------->>>>>");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG,"到onRestart方法了---------->>>>>");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"到onPause方法了---------->>>>>");
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"到onStop方法了---------->>>>>");
//        tvShow.setText(JsonUtils.toJSONString(MsgCollector.getInstance().getMsgList()));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"到onDestroy方法了---------->>>>>");
    }
}
