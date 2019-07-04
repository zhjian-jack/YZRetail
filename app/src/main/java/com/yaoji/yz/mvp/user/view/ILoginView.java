package com.yaoji.yz.mvp.user.view;

import com.yaoji.yz.base.BaseView;

/**
 * @Description: 登陆View
 * @Author: zhjian
 * @date 2019/6/26
 */
public interface ILoginView extends BaseView {
    /**
     * 当数据请求成功后，调用此接口显示数据
     * @param data 数据源
     */
    void showData(String data);

}
