package com.yaoji.yz.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import org.greenrobot.eventbus.EventBus;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @Description: 描述内容
 * @Author: zhjian
 * @date 2019/6/26
 */
public abstract class BaseFragment extends Fragment {
    protected View rotView = null;
    private   Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rotView = LayoutInflater.from(getActivity()).inflate(getLayoutId(),container,false);
        initButterKnife(rotView);
        return rotView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        initData();
        initRegister();
    }

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

    /**
     * 注解
     */
    private void initButterKnife(View view){
        unbinder = ButterKnife.bind(this,view);
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
     * 是否注册事件
     * @return
     */
    protected abstract boolean isRegisterEventBus();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder != null) {
            unbinder.unbind();
        }
        unregister();
    }
}
