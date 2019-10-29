package com.example.thin.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.example.thin.R;
import com.example.thin.base.BaseScrollTitleBarActivity;
import com.example.thin.base.mvp.BasePresenter;
import com.example.thin.base.mvp.IBaseView;

/**
 * @Author: xingyan
 * @Date: 2019/10/29
 * @Desc:
 */
public class ForgetPwdActivity extends BaseScrollTitleBarActivity<BasePresenter> implements IBaseView, View.OnClickListener {
    private Button btnForgetPwdNext;

    public static void open(Context context) {
        context.startActivity(new Intent(context, ForgetPwdActivity.class));
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_forget_pwd;
    }

    @Override
    protected void initContentView() {
        mTitleBar.setTitle("忘记密码");

        btnForgetPwdNext = getView(R.id.btn_forget_pwd_next);
        btnForgetPwdNext.setOnClickListener(this);
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
            case R.id.btn_forget_pwd_next://下一步
                finish();
                break;
            default:
                break;
        }
    }
}
