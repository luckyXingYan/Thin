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
public class RegisterActivity extends BaseScrollTitleBarActivity<BasePresenter> implements IBaseView, View.OnClickListener {
    private TextView tvPhone;
    private String phone, pwd, surePwd;
    private EditText etPwd;
    private EditText etSurePwd;
    private Button btnRegisterLogin;


    public static void open(Context context, String phone) {
        Intent intent = new Intent(context, RegisterActivity.class);
        intent.putExtra(Constants.PHONE, phone);
        context.startActivity(intent);
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    protected void initContentView() {
        phone = getIntent().getStringExtra(Constants.PHONE);
        mTitleBar.setTitle("注册");
        tvPhone = getView(R.id.tv_register_phone);
        etPwd = getView(R.id.et_pwd);
        etSurePwd = getView(R.id.et_sure_pwd);
        btnRegisterLogin = getView(R.id.btn_register_login);

        btnRegisterLogin.setOnClickListener(this);

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
            case R.id.btn_register_login://注册并登录
                pwd = etPwd.getText().toString().trim();
                surePwd = etSurePwd.getText().toString().trim();
                if (TextUtils.isEmpty(pwd)) {
                    showToastMsg("请输入密码");
                    return;
                }
                if (TextUtils.isEmpty(surePwd)) {
                    showToastMsg("请输入确认密码");
                    return;
                }
                if (!pwd.equals(surePwd)) {
                    showToastMsg("密码不一致");
                    return;
                }
                LocalUser.getInstance().setUserId("111");
                LocalUser.getInstance().setUserName("周**");
                SexSettingActivity.open(this);
                finish();
                break;
            default:
                break;
        }
    }
}
