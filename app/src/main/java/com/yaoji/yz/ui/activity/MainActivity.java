package com.yaoji.yz.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import com.yaoji.yz.R;
import com.yaoji.yz.base.BaseActivity;
import com.yaoji.yz.evebus.MessageEvent;
import com.yaoji.yz.mvp.cashiertab.ui.fragment.AddMoneyFragment;
import com.yaoji.yz.mvp.cashiertab.ui.fragment.CancelOrderFragment;
import com.yaoji.yz.mvp.cashiertab.ui.fragment.SingleDiscountFragment;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import java.util.ArrayList;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * @Description: 主界面
 * @Author: zhjian
 * @date 2019/6/26
 */
public class MainActivity extends BaseActivity {

    @BindView(R.id.lay_right_bottom)
    LinearLayout mLinearLayout;
    @BindView(R.id.rl_continer)
    RelativeLayout mRelativeLayout;
    private ArrayList<Fragment> fragments = new ArrayList<>();

    @OnClick({R.id.tv_add_money,R.id.tv_single_discount})
    public void tabContiner(View view){
        setTabShow(false);
        switch (view.getId()){
            case R.id.tv_cancel_order:      //取单
                //onTabChanged(0);
                break;
            case R.id.tv_add_money:         //加金额
                onTabChanged(1);
                break;
            case R.id.tv_single_discount:  //整单优惠
                onTabChanged(2);
                break;
        }
    }

    public static void startActivity(Context context){
        context.startActivity(new Intent(context,MainActivity.class));
    }

    private void setTabShow(boolean isShow){
        mLinearLayout.setVisibility(isShow ? View.VISIBLE:View.GONE);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        fragments.add(CancelOrderFragment.newInstance());
        fragments.add(AddMoneyFragment.newInstance());
        fragments.add(SingleDiscountFragment.newInstance());
    }

    @Override
    protected void initData() {
        defaultFragment();
    }

    @Override
    protected boolean isRegisterEventBus() {
        return true;
    }

    @Subscribe(threadMode = ThreadMode.POSTING,sticky = true)
    public void onMoonStickyEvent(MessageEvent messageEvent){
        setTabShow(true);
        replaceFragment();
    }

    /**
     * 功能
     * @param checkedId
     */
    private void onTabChanged(int checkedId){
        //具体的fragment切换逻辑可以根据应用调整，例如使用show()/hide()
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_container,fragments.get(checkedId)).commit();
    }

    /**
     * 默认显示
     */
    private void defaultFragment(){
        getSupportFragmentManager().beginTransaction().add(R.id.fl_container,MainFragment.newInstance()).commit();
    }

    /**
     * 替换Fragment
     */
    private void replaceFragment(){
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_container,MainFragment.newInstance()).commit();
    }
}
