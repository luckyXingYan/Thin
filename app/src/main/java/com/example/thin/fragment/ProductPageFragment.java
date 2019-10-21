package com.example.thin.fragment;

import android.view.View;

import com.example.thin.R;
import com.example.thin.base.mvp.BaseFragment;
import com.example.thin.base.mvp.BasePresenter;
import com.example.thin.base.mvp.IBaseView;
import com.example.thin.presenter.MinePagePresenter;

/**
 * @Author: xingyan
 * @Date: 2019/8/2
 * @Desc:
 */
public class ProductPageFragment extends BaseFragment<BasePresenter> implements IBaseView {

    public static ProductPageFragment newInstance() {
        return new ProductPageFragment();
    }

    @Override
    public int layoutId() {
        return R.layout.fragment_product_page;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void initData() {

    }

    @Override
    public MinePagePresenter createPresenter() {
        return null;
    }
}
