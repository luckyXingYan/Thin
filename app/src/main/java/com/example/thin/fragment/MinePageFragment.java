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

    private TextView myOrder;

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
        myOrder.setOnClickListener(this);

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
                FollowPositionActivity.open(getActivity());
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
            case R.id.tv_my_order://我的订单
                MyOrderActivity.open(getActivity());
                break;
            default:
                break;
        }

    }
}
