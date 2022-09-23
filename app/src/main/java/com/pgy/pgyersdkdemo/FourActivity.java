package com.pgy.pgyersdkdemo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.pgy.pgyersdkdemo.databinding.ActivityMain4Binding;


/**
 * @describe
 * @author: Caoxy
 * @date: 6/7/21
 */
public class FourActivity extends BaseActivity<ActivityMain4Binding> {

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewBinding.btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(FourActivity.this,AnrActivity.class);
//                startActivity(intent);
                finish();
            }
        });
        viewBinding.btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sum = 0;
                for (int i = 1; i < 100001; i++) {
                    sum = sum + i;
                }
                ((TextView)findViewById(R.id.tvData)).setText("1+2+3……+99+100="+sum);
            }
        });
    }
}
