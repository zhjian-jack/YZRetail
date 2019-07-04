package com.yaoji.yz.utils;

import androidx.annotation.Nullable;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

/**
 * @Description: 日志打印工具类：对Logger再进行一层封装
 * @Author: zhjian
 * @date 2019/6/26
 */
public class LoggerUtils {

    public static void init(final boolean debug) {
        Logger.addLogAdapter(new AndroidLogAdapter() {
            @Override
            public boolean isLoggable(int priority, @Nullable String tag) {
                return debug;
            }
        });
    }

    public static void v(String message) {
        Logger.v(message);
    }

    public static void d(String message) {
        Logger.d(message);
    }

    public static void d(String tag,String message) {
        Logger.t(tag).d(message);
    }

    public static void i(String message) {
        Logger.i(message);
    }

    public static void i(String tag,String message) {
        Logger.t(tag).i(message);
    }

    public static void e(String message) {
        Logger.e(message);
    }

    public static void json(String json) {
        Logger.json(json);
    }

    public static void xml(String json) {
        Logger.xml(json);
    }
}
