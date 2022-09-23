package com.pgy.pgyersdkdemo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


/**
 * @describe
 * @author: Caoxy
 * @date: 5/24/21
 */
public class SplashActivity extends AppCompatActivity {
    private int textTime = 0;
    private int maxTime = 5;
    private TextView tvMsg,tvStartMsg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        tvMsg = findViewById(R.id.tvMsg);
        tvStartMsg = findViewById(R.id.tvStartMsg);
        mHandler.post(runnable);
//        PACApplication.getTestDataBack().setTextView(tvMsg);
    }
    private Handler mHandler = new Handler();
    private  Runnable runnable = new Runnable() {
        @Override
        public void run() {
            mHandler.postDelayed(this,1000);//一秒钟循环计时一次
            textTime  = maxTime --;
            String s = String.valueOf(textTime);
            tvMsg.setText("还剩"+s+"进入主页");             //显示时间倒计时
            if(textTime == 4){
//                PushMsgBean appInitEndTimeushMsgBean = PgyHttpRequest.getInstance().getAppInitEndTimeushMsgBean();
//                if(appInitEndTimeushMsgBean != null){
//                    tvStartMsg.setText(JsonUtils.toJSONString(appInitEndTimeushMsgBean));
//                }

            }
            if (textTime == 0){
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }
    };

}
