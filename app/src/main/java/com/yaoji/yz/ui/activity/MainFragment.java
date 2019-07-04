package com.yaoji.yz.ui.activity;

import com.yaoji.yz.R;
import com.yaoji.yz.base.BaseFragment;

public class MainFragment extends BaseFragment {

   public static  MainFragment newInstance(){
        MainFragment fragment = new MainFragment();
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main;
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
