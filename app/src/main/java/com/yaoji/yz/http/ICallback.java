package com.yaoji.yz.http;

import com.androidnetworking.error.ANError;

/**
 * @Description: 回调结果
 * @Author: zhjian
 * @date 2019/6/28
 */
public interface ICallback<T> {
    /**
     * 数据请求成功
     * @param data 请求到的数据
     */
    void onSuccess(T data);
    /**
     *  使用网络API接口请求方式时，虽然已经请求成功但是由
     *  于{@code msg}的原因无法正常返回数据。
     */
    void onFailure(ANError msg);

}
