package com.example.thin.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.thin.R;
import com.example.thin.base.BaseScrollTitleBarActivity;
import com.example.thin.base.mvp.BasePresenter;
import com.example.thin.base.mvp.IBaseView;
import com.example.thin.util.Constants;
import com.example.thin.util.InputVerifyUtil;
import com.example.thin.util.LocalUser;

/**
 * @Author: xingyan
 * @Date: 2019/10/29
 * @Desc:
 */
public class ForgetPwdActivity extends BaseScrollTitleBarActivity<BasePresenter> implements IBaseView, View.OnClickListener {
    private Button btnForgetPwdNext;
    private EditText etPhone;
    private String phone;

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
        etPhone = getView(R.id.et_phone);
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
                phone = etPhone.getText().toString().trim();
                String hintMsg = InputVerifyUtil.checkMobile(phone);
                if (Constants.INPUT_OK.equals(hintMsg)) {
                    finish();
                } else {
                    showToastMsg(hintMsg);
                }
                break;
            default:
                break;
        }
    }
}
