package com.yaoji.yz.mvp.cashiertab.ui.fragment;

import android.view.View;

import com.yaoji.yz.R;
import com.yaoji.yz.base.BaseFragment;
import com.yaoji.yz.evebus.MessageEvent;

import org.greenrobot.eventbus.EventBus;

import butterknife.OnClick;

/**
 * @Description: 整单优惠
 * @Author: zhjian
 * @date 2019/7/3
 */
public class SingleDiscountFragment extends BaseFragment {

    @OnClick(R.id.img_right_close)
    public void onCloseFragment(View view){
        switch (view.getId()){
            case R.id.img_right_close:
                EventBus.getDefault().post(new MessageEvent());
                getChildFragmentManager().popBackStack();
                break;
        }
    }

    public static SingleDiscountFragment newInstance(){
        SingleDiscountFragment fragment = new SingleDiscountFragment();
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_single_discount;
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
