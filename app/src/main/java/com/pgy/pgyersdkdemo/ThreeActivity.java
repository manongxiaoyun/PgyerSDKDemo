package com.pgy.pgyersdkdemo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.pgy.pgyersdkdemo.databinding.ActivityMain3Binding;
import com.pgyer.pgyersdk.PgyerSDKManager;
import com.pgyer.pgyersdk.callback.CheckoutCallBack;
import com.pgyer.pgyersdk.callback.CheckoutVersionCallBack;
import com.pgyer.pgyersdk.model.CheckSoftModel;

public class ThreeActivity extends BaseActivity<ActivityMain3Binding> {

    private static final String TAG = "TAG_ThreeActivity";
    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewBinding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        viewBinding.btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PgyerSDKManager.checkSoftwareUpdate(ThreeActivity.this);
            }
        });

        viewBinding.btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PgyerSDKManager.checkSoftwareUpdate(ThreeActivity.this, new CheckoutVersionCallBack() {
                    @Override
                    public void onSuccess(CheckSoftModel model) {
                        viewBinding.tvShow.setText("返回数据："+JsonUtils.toJSONString(model));
                    }

                    @Override
                    public void onFail(String error) {
                        viewBinding.tvShow.setText("请求失败："+error);
                    }
                });
            }
        });

        viewBinding.btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PgyerSDKManager.checkVersionUpdate(ThreeActivity.this, new CheckoutCallBack() {
                    @Override
                    public void onNewVersionExist(CheckSoftModel model) {
                        viewBinding.tvShow.setText("有新版本："+JsonUtils.toJSONString(model));

                    }

                    @Override
                    public void onNonentityVersionExist(String error) {
                        viewBinding.tvShow.setText("无新版本"+error);
                    }

                    @Override
                    public void onFail(String error) {
                        viewBinding.tvShow.setText("请求失败："+error);
                    }
                });
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
}
