package com.yaoji.yz.mvp.cashiertab.ui.fragment;

import com.yaoji.yz.R;
import com.yaoji.yz.base.BaseFragment;

/**
 * @Description: 取单
 * @Author: zhjian
 * @date 2019/7/3
 */
public class CancelOrderFragment extends BaseFragment {

    public static CancelOrderFragment newInstance(){
        CancelOrderFragment fragment = new CancelOrderFragment();
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_cancel_order;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected boolean isRegisterEventBus() {
        return false;
    }
}
