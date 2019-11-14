package com.example.thin.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.example.thin.R;
import com.example.thin.base.mvp.BaseActivity;
import com.example.thin.base.mvp.BasePresenter;
import com.example.thin.base.mvp.IBaseView;
import com.example.thin.util.Constants;
import com.example.thin.widget.zoom.ZoomImageView;

/**
 * @Author: xingyan
 * @Date: 2019/11/1
 * @Desc:
 */
public class ZoomImgActivity extends BaseActivity<BasePresenter> implements IBaseView {
    private ZoomImageView zoomImageView;
    private String imgUrl;

    public static void open(Context context, String imgUrl) {
        Intent intent = new Intent(context, ZoomImgActivity.class);
        intent.putExtra(Constants.IMG_URL, imgUrl);
        context.startActivity(intent);
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_zoom_img;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        imgUrl = getIntent().getStringExtra(Constants.IMG_URL);
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
        Glide.with(this).load(imgUrl).placeholder(R.drawable.shape_rectangle_2_corners_white_stroke_gray).error(R.drawable.shape_rectangle_2_corners_white_stroke_gray).into(zoomImageView);
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }
}
