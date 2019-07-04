package com.yaoji.yz.mvp.user.ui.activity;

import com.yaoji.yz.R;
import com.yaoji.yz.base.BaseActivity;
import com.yaoji.yz.ui.activity.MainActivity;

import butterknife.OnClick;

/**
 * @Description: 用户登陆
 * @Author: zhjian
 * @date 2019/6/26
 */
public class LoginActivity extends BaseActivity {

    @OnClick()
    public void onLogin(){
        MainActivity.startActivity(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
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
