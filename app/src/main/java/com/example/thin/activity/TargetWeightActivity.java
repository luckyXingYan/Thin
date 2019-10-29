package com.example.thin.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.example.thin.R;
import com.example.thin.base.BaseScrollTitleBarActivity;
import com.example.thin.base.mvp.BasePresenter;
import com.example.thin.base.mvp.IBaseView;
import com.example.thin.bean.UserInfo;
import com.example.thin.util.LocalUser;

/**
 * @Author: xingyan
 * @Date: 2019/10/22
 * @Desc:
 */
public class TargetWeightActivity extends BaseScrollTitleBarActivity<BasePresenter> implements IBaseView, View.OnClickListener {
    private Button btnWeightNext;


    public static void open(Context context) {
        context.startActivity(new Intent(context, TargetWeightActivity.class));
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_target_weight;
    }

    @Override
    protected void initContentView() {
        mTitleBar.setTitle("你的目标体重");

        btnWeightNext = getView(R.id.btn_weight_next);
        btnWeightNext.setOnClickListener(this);

    }

    @Override
    protected void initData() {

    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_weight_next://下一步
                LocalUser.getInstance().setUserTargetWeight("50");
                WelcomeJoinActivity.open(this);
                finish();
                break;
            default:
                break;
        }
    }
}
