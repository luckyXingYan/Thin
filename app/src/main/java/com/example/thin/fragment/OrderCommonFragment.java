package com.example.thin.fragment;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.thin.R;
import com.example.thin.adapter.OrderAdapter;
import com.example.thin.base.adapter.BaseRecyclerAdapter;
import com.example.thin.base.mvp.BaseFragment;
import com.example.thin.base.mvp.BasePresenter;
import com.example.thin.base.mvp.IBaseView;
import com.example.thin.bean.CartGoodsBean;
import com.example.thin.bean.CartListBean;
import com.example.thin.bean.FootBean;
import com.example.thin.bean.OrderDataHelper;
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

    }

    @Override
    protected void initData() {
        List<CartListBean> data = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            CartListBean bean = new CartListBean();
            bean.title = "店铺" + i;

            CartGoodsBean info = new CartGoodsBean();
            info.title = "https://img.52z.com/upload/news/image/20180621/20180621055734_59936.jpg";
            info.id = "1";
            bean.goods.add(info);

            CartGoodsBean info2 = new CartGoodsBean();
            info.title = "https://img.pc841.com/2018/0922/20180922111049508.jpg";
            info.id = "2";
            bean.goods.add(info2);

            FootBean footBean = new FootBean();
            footBean.title = "物流";

            bean.footBean = footBean;

            data.add(bean);
        }
        adapter.setData(OrderDataHelper.getDataAfterHandle2(data));

        refreshLayout.finishRefresh();
        refreshLayout.finishLoadMore();
    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }
}
