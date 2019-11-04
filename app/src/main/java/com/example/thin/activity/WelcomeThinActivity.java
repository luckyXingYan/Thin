package com.example.thin.activity;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.thin.R;
import com.example.thin.base.BaseScrollTitleBarActivity;
import com.example.thin.base.mvp.BasePresenter;
import com.example.thin.base.mvp.IBaseView;


/**
 * @Author: xingyan
 * @Date: 2019/11/4
 * @Desc:
 */
public class WelcomeThinActivity extends BaseScrollTitleBarActivity<BasePresenter> implements IBaseView, View.OnClickListener {
    private EditText etPhone;
    private String phone;
    private Button next;

    public static void open(Context context) {
        context.startActivity(new Intent(context, WelcomeThinActivity.class));
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_welcome_thin;
    }

    @Override
    protected void initContentView() {
        mTitleBar.setTitle("欢迎来到瘦吧");
        etPhone = getView(R.id.et_phone);
        next = getView(R.id.btn_register_next);
        next.setOnClickListener(this);

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
            case R.id.btn_register_next://下一步
                phone = etPhone.getText().toString().trim();
                if (TextUtils.isEmpty(phone)) {
                    showToastMsg("请输入手机号");
                    return;
                }
                //判断是不是新用户  跳转注册或是登录
//                RegisterActivity.open(this, phone);
                LoginActivity.open(this, phone);
                finish();
                break;
            default:
                break;
        }
    }
}
