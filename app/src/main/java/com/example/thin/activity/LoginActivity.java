package com.example.thin.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.thin.R;
import com.example.thin.base.BaseScrollTitleBarActivity;
import com.example.thin.base.mvp.BasePresenter;
import com.example.thin.base.mvp.IBaseView;
import com.example.thin.bean.UserInfo;
import com.example.thin.util.Constants;
import com.example.thin.util.LocalUser;
import com.example.thin.util.PreferenceUtil;

/**
 * @Author: xingyan
 * @Date: 2019/10/22
 * @Desc:
 */
public class LoginActivity extends BaseScrollTitleBarActivity<BasePresenter> implements IBaseView, View.OnClickListener {

    private Button login;
    private TextView forgetPwd;

    public static void open(Context context) {
        context.startActivity(new Intent(context, LoginActivity.class));
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initContentView() {
        mTitleBar.setTitle("登录");
        login = getView(R.id.btn_login);
        forgetPwd = getView(R.id.tv_forget_pwd);
        login.setOnClickListener(this);
        forgetPwd.setOnClickListener(this);
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
            case R.id.btn_login://立即登录
                LocalUser.getInstance().setUserId("111");
                LocalUser.getInstance().setUserName("周**");
                SexSettingActivity.open(this);
                finish();
                break;
            case R.id.tv_forget_pwd://忘记密码
                ForgetPwdActivity.open(this);
                break;
            default:
                break;
        }
    }
}
