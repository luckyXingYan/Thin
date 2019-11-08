package com.example.thin.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import com.example.thin.R;
import com.example.thin.base.BaseScrollTitleBarActivity;
import com.example.thin.base.mvp.BasePresenter;
import com.example.thin.base.mvp.IBaseView;
import com.example.thin.util.LocalUser;

/**
 * @Author: xingyan
 * @Date: 2019/10/22
 * @Desc:
 */
public class SexSettingActivity extends BaseScrollTitleBarActivity<BasePresenter> implements IBaseView, View.OnClickListener {
    private Button next;
    private RadioButton rbMen;
    private RadioButton rbWomen;


    public static void open(Context context) {
        context.startActivity(new Intent(context, SexSettingActivity.class));
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_sex_setting;
    }

    @Override
    protected void initContentView() {
        mTitleBar.setTitle("性别");
        next = getView(R.id.btn_sex_next);
        rbMen = getView(R.id.rb_men);
        rbWomen = getView(R.id.rb_women);
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
            case R.id.btn_sex_next://下一步  （ 0：女 1：男）
                if (rbMen.isChecked()) {
                    LocalUser.getInstance().setUserSex("1");
                } else if (rbWomen.isChecked()) {
                    LocalUser.getInstance().setUserSex("0");
                }
                NickNameActivity.open(this);
                finish();
                break;
            default:
                break;
        }
    }
}
