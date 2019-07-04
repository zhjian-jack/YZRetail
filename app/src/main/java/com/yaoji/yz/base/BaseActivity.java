package com.yaoji.yz.base;

import android.os.Bundle;
import android.view.KeyEvent;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.yaoji.yz.utils.ActivityUtil;
import org.greenrobot.eventbus.EventBus;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @Description: 基础类
 * @Author: zhjian
 * @date 2019/6/26
 */
public  abstract class BaseActivity extends AppCompatActivity {

    private Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initButterKnife();
        initView();
        initData();
        initRegister();
        // 添加到Activity工具类
        ActivityUtil.getInstance().addActivity(this);
    }

    /**
     * 设置布局
     */
    protected abstract int getLayoutId();

    /**
     * 初始化控件
     */
    protected abstract void initView();

    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * 注解
     */
    protected void initButterKnife(){
        unbinder = ButterKnife.bind(this);
    }

    /**
     * 是否注册事件
     * @return
     */
    protected abstract boolean isRegisterEventBus();

    /**
     * 注册
     */
    protected void initRegister(){
        if(isRegisterEventBus()){
            EventBus.getDefault().register(this);
        }
    }

    /**
     * 注销
     */
    protected void unregister(){
        if(isRegisterEventBus()){
            EventBus.getDefault().unregister(this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityUtil.getInstance().removeActivity(this);
        if (unbinder != null){
            unbinder.unbind();
        }
        unregister();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // 点击手机上的返回键，返回上一层
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            // 移除Activity
            ActivityUtil.getInstance().removeActivity(this);
            this.finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}
