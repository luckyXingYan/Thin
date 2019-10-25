package com.example.thin.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.example.thin.R;
import com.example.thin.base.BaseScrollTitleBarActivity;
import com.example.thin.base.mvp.BasePresenter;
import com.example.thin.base.mvp.IBaseView;

/**
 * @Author: xingyan
 * @Date: 2019/10/25
 * @Desc:
 */
public class PublishActivity extends BaseScrollTitleBarActivity<BasePresenter> implements IBaseView, View.OnClickListener {
    private ImageView ivFinish;


    public static void open(Context context) {
        context.startActivity(new Intent(context, PublishActivity.class));
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_publish;
    }

    @Override
    protected void initContentView() {
        mTitleBar.setTitle("发布");

        ivFinish = getView(R.id.iv_finish);
        ivFinish.setOnClickListener(this);

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
            case R.id.iv_finish://取消发布
                finish();
                break;
            default:
                break;
        }
    }
}
