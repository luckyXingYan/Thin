package com.example.thin.activity;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.thin.R;
import com.example.thin.base.BaseScrollTitleBarActivity;
import com.example.thin.base.mvp.BasePresenter;
import com.example.thin.base.mvp.IBaseView;
import com.example.thin.util.Constants;
import com.example.thin.util.LocalUser;

/**
 * @Author: xingyan
 * @Date: 2019/10/22
 * @Desc:
 */
public class LoginActivity extends BaseScrollTitleBarActivity<BasePresenter> implements IBaseView, View.OnClickListener {

    private Button login;
    private TextView forgetPwd;
    private TextView tvPhone;
    private String phone;
    private EditText etPwd;
    private String pwd;

    public static void open(Context context, String phone) {
        Intent intent = new Intent(context, LoginActivity.class);
        intent.putExtra(Constants.PHONE, phone);
        context.startActivity(intent);
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initContentView() {
        phone = getIntent().getStringExtra(Constants.PHONE);
        mTitleBar.setTitle("登录");
        login = getView(R.id.btn_login);
        forgetPwd = getView(R.id.tv_forget_pwd);
        tvPhone = getView(R.id.tv_login_phone);
        etPwd = getView(R.id.et_pwd);
        login.setOnClickListener(this);
        forgetPwd.setOnClickListener(this);

        tvPhone.setText(phone);
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
                pwd = etPwd.getText().toString().trim();
                if (TextUtils.isEmpty(pwd)) {
                    showToastMsg("请输入密码");
                    return;
                }
                LocalUser.getInstance().setUserId("111");
                LocalUser.getInstance().setUserName("周**");
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
