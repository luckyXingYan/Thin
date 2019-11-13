package com.example.thin.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.thin.R;
import com.example.thin.base.mvp.BaseActivity;
import com.example.thin.base.mvp.BasePresenter;
import com.example.thin.base.mvp.IBaseView;
import com.example.thin.widget.zoom.ZoomImageView;

/**
 * @Author: xingyan
 * @Date: 2019/11/1
 * @Desc:
 */
public class ZoomImgActivity extends BaseActivity<BasePresenter> implements IBaseView {
    private ZoomImageView zoomImageView;

    public static void open(Context context) {
        context.startActivity(new Intent(context, ZoomImgActivity.class));
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_zoom_img;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        zoomImageView = getView(R.id.ziv_zoom);
        zoomImageView.setOnImgClickListener(new ZoomImageView.ImgClickListener() {
            @Override
            public void onClick() {
                finish();
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }
}
