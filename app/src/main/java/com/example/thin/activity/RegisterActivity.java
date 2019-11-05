package com.example.thin.activity;

import android.content.Context;
import android.content.Intent;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import com.example.thin.R;
import com.example.thin.base.BaseScrollTitleBarActivity;
import com.example.thin.bean.RegisterLoginBean;
import com.example.thin.iview.IRegisterView;
import com.example.thin.presenter.RegisterPresenter;
import com.example.thin.util.Constants;
import com.example.thin.util.InputVerifyUtil;
import com.example.thin.util.LocalUser;

/**
 * @Author: xingyan
 * @Date: 2019/10/22
 * @Desc:
 */
public class RegisterActivity extends BaseScrollTitleBarActivity<RegisterPresenter> implements IRegisterView, View.OnClickListener {
    private TextView tvPhone;
    private String phone, pwd, surePwd;
    private EditText etPwd;
    private EditText etSurePwd;
    private Button btnRegisterLogin;
    private CheckBox cbPwd, cbSurePwd;

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
        cbPwd = getView(R.id.cb_pwd);
        cbSurePwd = getView(R.id.cb_sure_pwd);
        btnRegisterLogin.setOnClickListener(this);

        cbPwd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    //如果选中，显示密码
                    etPwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    //否则隐藏密码
                    etPwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                etPwd.setSelection(etPwd.getText().toString().length());
            }
        });
        cbSurePwd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    etSurePwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    etSurePwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                etSurePwd.setSelection(etSurePwd.getText().toString().length());
            }
        });

        tvPhone.setText(phone);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected RegisterPresenter createPresenter() {
        return new RegisterPresenter();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_register_login://注册并登录
                pwd = etPwd.getText().toString().trim();
                surePwd = etSurePwd.getText().toString().trim();
                String hintMsg = InputVerifyUtil.checkRegisterPwd(pwd, surePwd);
                if (Constants.INPUT_OK.equals(hintMsg)) {
                    presenter.register(this, phone, pwd);
                } else {
                    showToastMsg(hintMsg);
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void registerSuccess(RegisterLoginBean data) {
        LocalUser.getInstance().setUserId(phone);
        LocalUser.getInstance().setToken(data.token);
        SexSettingActivity.open(this);
        finish();
    }
}
