package com.example.thin.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.thin.R;
import com.example.thin.base.mvp.BaseActivity;
import com.example.thin.base.mvp.BasePresenter;
import com.example.thin.base.mvp.IBaseView;
import com.example.thin.iview.IEvaluateView;
import com.example.thin.presenter.EvaluatePresenter;
import com.example.thin.util.Constants;
import com.example.thin.util.LocalUser;

/**
 * @Author: xingyan
 * @Date: 2019/10/28
 * @Desc:
 */
public class WelcomeJoinActivity extends BaseActivity<EvaluatePresenter> implements IEvaluateView, View.OnClickListener {
    private Button btnEvaluating;

    public static void open(Context context) {
        Intent intent = new Intent(context, WelcomeJoinActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_welcome_join;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        btnEvaluating = getView(R.id.btn_start_evaluating);
        btnEvaluating.setOnClickListener(this);

    }

    @Override
    protected void initData() {

    }

    @Override
    protected EvaluatePresenter createPresenter() {
        return new EvaluatePresenter();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_start_evaluating://开始评测
                presenter.evaluate(this, LocalUser.getInstance().getUserNickName(),
                        LocalUser.getInstance().getUserSex(), LocalUser.getInstance().getUserBodyHeight(),
                        LocalUser.getInstance().getUserTargetWeight(), LocalUser.getInstance().getFollowPosition());
                break;
        }
    }

    @Override
    public void onEvaluateSuccess() {
        finish();
    }
}
