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
public class NickNameActivity extends BaseScrollTitleBarActivity<BasePresenter> implements IBaseView, View.OnClickListener {

    private Button btnNickNameNext;
    private EditText etNickName;
    private String nickName;


    public static void open(Context context) {
        context.startActivity(new Intent(context, NickNameActivity.class));
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_nick_name;
    }

    @Override
    protected void initContentView() {
        mTitleBar.setTitle("你的昵称");

        btnNickNameNext = getView(R.id.btn_nick_name_next);
        etNickName = getView(R.id.et_nick_name);

        btnNickNameNext.setOnClickListener(this);

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
            case R.id.btn_nick_name_next://下一步
                nickName = etNickName.getText().toString().trim();
                String hintMsg = InputVerifyUtil.checkNickName(nickName);
                if (Constants.INPUT_OK.equals(hintMsg)) {
                    LocalUser.getInstance().setUserNickName(nickName);
                    BodyHeightActivity.open(this);
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
