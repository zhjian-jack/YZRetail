package com.yaoji.yz.app;

import android.app.Application;
import com.androidnetworking.AndroidNetworking;
import com.yaoji.yz.BuildConfig;
import com.yaoji.yz.utils.LoggerUtils;

/**
 * @Description: 全局类
 * @Author: zhjian
 * @date 2019/6/25
 */
public class YZAplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init(){
        LoggerUtils.init(BuildConfig.LOG_DEBUG);               //是否开启输出日志
        AndroidNetworking.initialize(getApplicationContext()); //初始化网络
    }
}
