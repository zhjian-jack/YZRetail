package com.yaoji.yz.mvp.cashiertab.ui.fragment;

import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import com.yaoji.yz.R;
import com.yaoji.yz.base.BaseFragment;
import com.yaoji.yz.evebus.MessageEvent;
import org.greenrobot.eventbus.EventBus;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * @Description: 添加金额
 * @Author: zhjian
 * @date 2019/7/3
 */
public class AddMoneyFragment extends BaseFragment {

    public static AddMoneyFragment newInstance(){
        AddMoneyFragment fragment = new AddMoneyFragment();
        return fragment;
    }

    @BindView(R.id.ll_eng_key)
    LinearLayout mLayEngKey;
    @BindView(R.id.ll_number_key)
    LinearLayout mLayNumberKey;

    @OnClick({R.id.tv_eng_key,R.id.tv_number_key,R.id.img_right_close})
    public void onCloseFragment(View view){
        switch (view.getId()){
            case R.id.tv_eng_key:
                setEngShow(false);
                break;
            case R.id.tv_number_key:
                setEngShow(true);
                break;
            case R.id.img_right_close:
                EventBus.getDefault().post(new MessageEvent());
                break;
        }
    }

    private void setEngShow(boolean isShow){
        mLayEngKey.setVisibility(isShow ? View.GONE:View.VISIBLE);
        mLayNumberKey.setVisibility(isShow ? View.VISIBLE:View.GONE);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_add_money;
    }

    @Override
    protected void initView() {
        Log.i("log","initView==========================================================>");
    }

    @Override
    protected void initData() {

    }

    @Override
    protected boolean isRegisterEventBus() {
        return false;
    }
}
