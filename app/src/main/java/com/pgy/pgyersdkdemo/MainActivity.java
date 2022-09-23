package com.pgy.pgyersdkdemo;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import com.pgy.pgyersdkdemo.databinding.ActivityMainBinding;
import com.pgyer.pgyersdk.PgyerSDKManager;

import java.util.List;

public class MainActivity extends BaseActivity<ActivityMainBinding> {
    private static final String TAG = "TAG_TowActivity";
    private TextView tvMsg;
    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        List<String> list = null;
        viewBinding.tvMsg.setMovementMethod(ScrollingMovementMethod.getInstance());
        viewBinding.tvMsg.setTextColor(getResources().getColor(R.color.colorAccent));

        viewBinding.btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TowActivity.class);
                startActivity(intent);
            }
        });
        viewBinding.btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ThreeActivity.class);
                startActivity(intent);
            }
        });
        viewBinding.btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                UserInfoBean userInfoBean = new UserInfoBean();
//                userInfoBean.setUserId("ceshi_001");
//                userInfoBean.setUserName("测试001");
////                tvMsg.setText(JsonUtils.toJSONString(userInfoBean));
//                PgyerSDKManager.setUserData(JsonUtils.toJSONString(userInfoBean));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                String params = "[{\"currentURL\":\"com.pgyer.analytics.MainActivity@cb65551\",\"viewPort\":{\"r\":2.75,\"f\":42.503994,\"w\":1080,\"h\":2110},\"clientID\":\"ffff016817022c88637e3b05043bdf64\",\"data\":{\"detail\":{\"hide\":5320,\"fps\":57.837574},\"message\":1025},\"currentRoute\":\"com.pgyer.analytics.MainActivity\",\"deviceData\":{\"isRoot\":false,\"isPortrait\":true,\"appversion\":\"7.0\",\"appversioncode\":7,\"freeDiskSpace\":92444729344,\"ostype\":\"Android\",\"deviceID\":\"7fdcfb35370973a07c72b3f0eb40cf06\",\"network\":3,\"freeRam\":1559117824,\"appname\":\"com.pgyer.analytics\",\"name\":\"Redmi\",\"model\":\"M2003J15SC\",\"brand\":\"Redmi\"},\"refererRoute\":\"com.pgyer.analytics.SplashActivity\",\"messageID\":\"ffff017a51a0d691f3dae634d7850242\",\"userAgent\":\"Mozilla\\/5.0 (Linux; Android 10; M2003J15SC Build\\/QP1A.190711.020; wv) AppleWebKit\\/537.36 (KHTML, like Gecko) Version\\/4.0 Chrome\\/83.0.4103.101 Mobile Safari\\/537.36\",\"sessionID\":\"ffff017a51a0bea75013b0777790ea02\",\"refererURL\":\"com.pgyer.analytics.SplashActivity@dcfb49e\",\"type\":1024,\"version\":\"4.2.1\",\"token\":\"1b31e419fc96495c82b1e3058fa401dc\"},{\"currentURL\":\"com.pgyer.analytics.MainActivity@cb65551\",\"viewPort\":{\"r\":2.75,\"f\":42.503994,\"w\":1080,\"h\":2110},\"clientID\":\"ffff016817022c88637e3b05043bdf64\",\"data\":{\"detail\":{\"fps\":42.503994},\"message\":1026},\"currentRoute\":\"com.pgyer.analytics.MainActivity\",\"deviceData\":{\"isRoot\":false,\"isPortrait\":true,\"appversion\":\"7.0\",\"appversioncode\":7,\"freeDiskSpace\":92444729344,\"ostype\":\"Android\",\"deviceID\":\"7fdcfb35370973a07c72b3f0eb40cf06\",\"network\":3,\"freeRam\":1559117824,\"appname\":\"com.pgyer.analytics\",\"name\":\"Redmi\",\"model\":\"M2003J15SC\",\"brand\":\"Redmi\"},\"refererRoute\":\"com.pgyer.analytics.SplashActivity\",\"messageID\":\"ffff017a51a0d773aa7dea2db1f78c3a\",\"userAgent\":\"Mozilla\\/5.0 (Linux; Android 10; M2003J15SC Build\\/QP1A.190711.020; wv) AppleWebKit\\/537.36 (KHTML, like Gecko) Version\\/4.0 Chrome\\/83.0.4103.101 Mobile Safari\\/537.36\",\"sessionID\":\"ffff017a51a0bea75013b0777790ea02\",\"refererURL\":\"com.pgyer.analytics.SplashActivity@dcfb49e\",\"type\":1024,\"version\":\"4.2.1\",\"token\":\"1b31e419fc96495c82b1e3058fa401dc\"}]\n";
//                getServerTiem("POST",params);
//                PACEnv.getBitmap();
            }
        });

//        PACApplication.getTestDataBack().setTextView(tvMsg);
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
    protected void onResume() {
        super.onResume();
//        PgyerSDKManager.checkSoftwareUpdate(this);
//        tvMsg.setText(JsonUtils.toJSONString(MsgCollector.getInstance().getMsgList()));
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"到onPause方法了---------->>>>>");
//        tvMsg.setText(JsonUtils.toJSONString(MsgCollector.getInstance().getMsgList()));
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        PgyerSDKManager.disableAll();
    }
}