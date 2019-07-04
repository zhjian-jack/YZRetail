package com.yaoji.yz.utils;

import android.content.Context;
import android.util.DisplayMetrics;

/**
 * @Description: 获取设备信息
 * @Author: zhjian
 * @date 2019/6/27
 */
public class DeviceUtils {

    private static final String TAG = "YQY";

    /**
     * 获取设备的SN号
     */
    public static String getDeviceSN() {
        String sn = android.os.Build.SERIAL;
        LoggerUtils.i(TAG,"设备型号：" + sn);
        return sn;
    }

    /**
     * 获取设备的型号
     */
    public static String getDeviceName() {
        String model = android.os.Build.MODEL;
        LoggerUtils.i(TAG,"设备型号：" + model);
        return model;
    }

    /**
     * 获取设备的系统版本号
     */
    public static String getDeviceSDK() {
        String sdk = android.os.Build.VERSION.RELEASE;
        LoggerUtils.i(TAG,"设备版本：" + sdk);
        return sdk;
    }

    /**
     * 获取设备分辨率
     * @param context
     * @return
     */
    public static void getMetrics(Context context){
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        int screenWidth = dm.widthPixels;
        int screenHeight = dm.heightPixels;
        LoggerUtils.i(screenWidth+"x"+screenHeight);
    }
}
