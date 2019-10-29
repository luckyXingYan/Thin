package com.example.thin.activity;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.thin.R;
import com.example.thin.base.BaseScrollTitleBarActivity;
import com.example.thin.base.mvp.BasePresenter;
import com.example.thin.base.mvp.IBaseView;
import com.example.thin.util.LocalUser;
import com.example.thin.view.RulerView;

/**
 * @Author: xingyan
 * @Date: 2019/10/29
 * @Desc:
 */
public class BodyHeightActivity extends BaseScrollTitleBarActivity<BasePresenter> implements IBaseView, View.OnClickListener, RulerView.OnValueChangeListener {
    private Button btnBodyHeightNext;
    private RulerView simpleRuler;
    private TextView tvBodyHeight;


    public static void open(Context context) {
        context.startActivity(new Intent(context, BodyHeightActivity.class));
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_body_height;
    }

    @Override
    protected void initContentView() {
        mTitleBar.setTitle("身高");
        btnBodyHeightNext = getView(R.id.btn_body_height_next);
        simpleRuler = getView(R.id.simple_ruler);
        tvBodyHeight = getView(R.id.tv_body_height);

        btnBodyHeightNext.setOnClickListener(this);
        simpleRuler.setOnValueChangeListener(this);
    }

    @Override
    protected void initData() {

    }

    //TargetWeightActivity.open(this);
    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_body_height_next://下一步
                LocalUser.getInstance().setUserBodyHeight("175");
                TargetWeightActivity.open(this);
                finish();
                break;
            default:
                break;
        }
    }

    @Override
    public void onChange(RulerView view, float value) {
        switch (view.getId()) {
            case R.id.simple_ruler:
                Log.e("-----simple_ruler", "you have " + value + " dollars");
                tvBodyHeight.setText(((int) value) + "cm");
                break;
            default:
                break;
        }
    }
}
