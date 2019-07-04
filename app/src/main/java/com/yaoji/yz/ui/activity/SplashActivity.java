package com.yaoji.yz.ui.activity;

import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import com.yaoji.yz.R;

/**
 * @Description: 启动闪屏广告页
 * @Author: zhjian
 * @date 2019/6/26
 */
public class SplashActivity extends AppCompatActivity {

    private static final int times = 1000;
    private Handler handler = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);
        handler = new Handler();
    }

    @Override
    protected void onStart() {
        super.onStart();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                MainActivity.startActivity(SplashActivity.this);
                finish();
            }
        }, times);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
    }
}
