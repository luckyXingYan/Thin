package com.example.thin.fragment;

import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.thin.R;
import com.example.thin.activity.MallDetailActivity;
import com.example.thin.adapter.MallAdapter;
import com.example.thin.adapter.OrderAdapter;
import com.example.thin.base.adapter.BaseRecyclerAdapter;
import com.example.thin.base.mvp.BaseFragment;
import com.example.thin.base.mvp.BasePresenter;
import com.example.thin.base.mvp.IBaseView;
import com.example.thin.refresh.TwinklingRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xingyan
 * @Date: 2019/10/21
 * @Desc:
 */
public class OrderCommonFragment extends BaseFragment<BasePresenter> implements IBaseView {
    private RecyclerView recyclerView;
    private OrderAdapter adapter;
    private TwinklingRefreshLayout refreshLayout;

    public static OrderCommonFragment newInstance() {
        return new OrderCommonFragment();
    }

    @Override
    public int layoutId() {
        return R.layout.fragment_order_common;
    }

    @Override
    protected void initView(View view) {
        recyclerView = getView(view, R.id.rv_order_common);
        refreshLayout = getView(view, R.id.refresh_layout);
        refreshLayout.setEnableLoadMore(true);
        recyclerView.setHasFixedSize(false);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new OrderAdapter(getActivity());
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
            }
        });

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
    public BasePresenter createPresenter() {
        return null;
    }
}
