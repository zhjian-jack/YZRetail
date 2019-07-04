package com.yaoji.yz.http;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.DownloadListener;
import com.androidnetworking.interfaces.DownloadProgressListener;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.yaoji.yz.http.bean.ParameterBean;

/**
 * @Description: 网络请求
 * @Author: zhjian
 * @date 2019/6/26
 */
public class NetHttp{

    /**
     * post 请求
     * @param cal
     * @param url
     * @param parameter
     * @param tag
     * @param priority
     * @param iCallback
     * @param <T>
     */
    public static <T> void post(T cal,String url,ParameterBean parameter,String tag, Priority priority,ICallback iCallback){
        AndroidNetworking.post(url)
                .addHeaders("token", "1234")
                .addBodyParameter(parameter) // posting java object
                .setTag(tag)
                .setPriority(priority)
                .build()
                .getAsObject((Class) cal, new ParsedRequestListener() {
                    @Override
                    public void onResponse(Object response) {
                        iCallback.onSuccess(response);
                    }

                    @Override
                    public void onError(ANError anError) {
                        iCallback.onFailure(anError);
                    }
                });
    }

    /**
     * get 请求
     * @param cal
     * @param url
     * @param parameter
     * @param tag
     * @param priority
     * @param iCallback
     * @param <T>
     */
    public static <T> void   get(T cal, String url, ParameterBean parameter,final String tag, Priority priority, ICallback iCallback){
        AndroidNetworking.get(url)
                .addPathParameter(parameter)
                .addHeaders("token", "1234")
                .setTag(tag)
                .setPriority(priority)
                .build()
                .getAsObject((Class) cal, new ParsedRequestListener() {
            @Override
            public void onResponse(Object response) {
                iCallback.onSuccess(response);
            }

            @Override
            public void onError(ANError anError) {
                iCallback.onSuccess(anError);
            }
        });
    }

    /**
     * 下载
     * @param url
     * @param dirPath
     * @param fileName
     * @param tag
     */
    public static void  download(String url, String dirPath, String fileName, final String tag){
        AndroidNetworking.download(url,dirPath,fileName)
                .setTag(tag)
                .setPriority(Priority.MEDIUM)
                .build()
                .setDownloadProgressListener(new DownloadProgressListener() {
                    @Override
                    public void onProgress(long bytesDownloaded, long totalBytes) {
                        // do anything with progress
                    }
                })
                .startDownload(new DownloadListener() {
                    @Override
                    public void onDownloadComplete() {
                        // do anything after completion
                    }
                    @Override
                    public void onError(ANError error) {
                        // handle error
                    }
                });
    }
}
