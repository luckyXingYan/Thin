package com.example.thin.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.thin.R;
import com.example.thin.adapter.HomeTypeDetailAdapter;
import com.example.thin.base.adapter.BaseRecyclerAdapter;
import com.example.thin.base.mvp.BaseActivity;
import com.example.thin.base.mvp.BasePresenter;
import com.example.thin.base.mvp.IBaseView;
import com.example.thin.bean.TypeBean;
import com.example.thin.refresh.TwinklingRefreshLayout;
import com.example.thin.util.Constants;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xingyan
 * @Date: 2019/10/22
 * @Desc:
 */
public class HomeTypeDetailActivity extends BaseActivity<BasePresenter> implements IBaseView, View.OnClickListener {
    private TwinklingRefreshLayout refreshLayout;
    private RecyclerView recyclerView;
    private HomeTypeDetailAdapter adapter;
    private ImageView back;
    private TypeBean typeBean;
    private EditText etSearch;
    private TextView tvCommercialArea;
    private TextView tvType;


    public static void open(Context context, TypeBean typeBean) {
        Intent intent = new Intent(context, HomeTypeDetailActivity.class);
        intent.putExtra(Constants.HOME_TOP_TYPE_BEAN, (Serializable) typeBean);
        context.startActivity(intent);
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_home_type_detail;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        typeBean = (TypeBean) getIntent().getSerializableExtra(Constants.HOME_TOP_TYPE_BEAN);
        refreshLayout = getView(R.id.refresh_layout);
        recyclerView = getView(R.id.rv_home_type);
        etSearch = getView(R.id.et_input_search);
        back = getView(R.id.iv_back);
        tvCommercialArea = getView(R.id.tv_commercial_area);
        tvType = getView(R.id.tv_type);

        back.setOnClickListener(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        adapter = new HomeTypeDetailAdapter(this);
        recyclerView.setAdapter(adapter);
        refreshLayout.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                if (recyclerView != null) {
                    recyclerView.scrollToPosition(0);
                }
                initData();
            }

            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                initData();
            }
        });
        adapter.setOnItemClickListener(new BaseRecyclerAdapter.OnItemClickListener<String>() {
            @Override
            public void onItemClick(ViewGroup parent, View view, String s, int position) {
                ShopDetailActivity.open(HomeTypeDetailActivity.this, "");
            }
        });

        tvType.setText(typeBean.name);
//        etSearch.setText(inputStr);
//        etSearch.setSelection(inputStr.length());
    }

    @Override
    protected void initData() {
        List<String> data = new ArrayList<>();
        data.add("https://img.52z.com/upload/news/image/20180621/20180621055734_59936.jpg");
        data.add("https://img.pc841.com/2018/0922/20180922111049508.jpg");
        data.add("https://img.52z.com/upload/news/image/20180621/20180621055734_59936.jpg");
        data.add("https://img.pc841.com/2018/0922/20180922111049508.jpg");
        data.add("https://img.52z.com/upload/news/image/20180621/20180621055734_59936.jpg");

        adapter.setData(data);

        refreshLayout.finishRefresh();
        refreshLayout.finishLoadMore();
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            default:
                break;
        }
    }
}
