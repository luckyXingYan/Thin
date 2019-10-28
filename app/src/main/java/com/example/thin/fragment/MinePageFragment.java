package com.example.thin.fragment;

import android.view.View;
import android.widget.TextView;

import com.example.thin.R;
import com.example.thin.activity.CashierActivity;
import com.example.thin.activity.CreateAddressActivity;
import com.example.thin.activity.FollowPositionActivity;
import com.example.thin.activity.LoginActivity;
import com.example.thin.activity.MyOrderActivity;
import com.example.thin.activity.RegisterActivity;
import com.example.thin.activity.SexSettingActivity;
import com.example.thin.activity.TargetWeightActivity;
import com.example.thin.activity.WelcomeJoinActivity;
import com.example.thin.base.mvp.BaseFragment;
import com.example.thin.base.mvp.BasePresenter;
import com.example.thin.base.mvp.IBaseView;
import com.example.thin.presenter.MinePagePresenter;

/**
 * @Author: xingyan
 * @Date: 2019/8/2
 * @Desc:
 */
public class MinePageFragment extends BaseFragment<BasePresenter> implements IBaseView, View.OnClickListener {

    private TextView myOrder, addressManager;
    private TextView tvWaitPay;
    private TextView tvUnuse;
    private TextView tvWaitSend;
    private TextView tvWaitGet;
    private TextView tvFinish;


    public static MinePageFragment newInstance() {
        return new MinePageFragment();
    }

    @Override
    public int layoutId() {
        return R.layout.fragment_mine_page;
    }

    @Override
    protected void initView(View view) {
        myOrder = getView(view, R.id.tv_my_order);
        addressManager = getView(view, R.id.tv_my_address);
        tvWaitPay = getView(view, R.id.tv_wait_pay);
        tvUnuse = getView(view, R.id.tv_unuse);
        tvWaitSend = getView(view, R.id.tv_wait_send);
        tvWaitGet = getView(view, R.id.tv_wait_get);
        tvFinish = getView(view, R.id.tv_finish);
        myOrder.setOnClickListener(this);
        addressManager.setOnClickListener(this);
        tvWaitPay.setOnClickListener(this);
        tvUnuse.setOnClickListener(this);
        tvWaitSend.setOnClickListener(this);
        tvWaitGet.setOnClickListener(this);
        tvFinish.setOnClickListener(this);

        getView(view, R.id.tv00).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegisterActivity.open(getActivity());
            }
        });
        getView(view, R.id.tv01).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginActivity.open(getActivity());
            }
        });
        getView(view, R.id.tv02).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WelcomeJoinActivity.open(getActivity());
            }
        });
        getView(view, R.id.tv03).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SexSettingActivity.open(getActivity());
            }
        });
        getView(view, R.id.tv04).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TargetWeightActivity.open(getActivity());
            }
        });

    }

    @Override
    protected void initData() {

    }

    @Override
    public MinePagePresenter createPresenter() {
        return null;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.tv_wait_pay://待付款
                MyOrderActivity.open(getActivity(), 1);
                break;
            case R.id.tv_unuse://未使用
                MyOrderActivity.open(getActivity(), 2);
                break;
            case R.id.tv_wait_send://待发货
                MyOrderActivity.open(getActivity(), 3);
                break;
            case R.id.tv_wait_get://待收货
                MyOrderActivity.open(getActivity(), 4);
                break;
            case R.id.tv_finish://已完成
                MyOrderActivity.open(getActivity(), 5);
                break;
            case R.id.tv_my_order://我的订单
                MyOrderActivity.open(getActivity(), 0);
                break;
            case R.id.tv_my_address://地址管理
                CreateAddressActivity.open(getActivity());
                break;
            default:
                break;
        }

    }
}
