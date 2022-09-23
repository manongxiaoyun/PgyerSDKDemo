package com.pgy.pgyersdkdemo;

import android.app.Application;

import com.pgyer.pgyersdk.PgyerSDKManager;
import com.pgyer.pgyersdk.pgyerenum.Features;

/**
 * @describe
 * @author: Caoxy
 * @date: 2022/4/27
 */
public class MyAppliccation extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initPgyerSDK(this);
    }

    /**
     * 初始化蒲公英SDK
     * @param application
     */
    private static void initPgyerSDK(MyAppliccation application){

        new PgyerSDKManager.Init()
                .setContext(application) //设置上下问对象
                .setApiKey("")
                .setFrontJSToken("")
                .enable(Features.APP_LAUNCH_TIME)
                .enable(Features.CHECK_UPDATE)
                .start();
    }
}
