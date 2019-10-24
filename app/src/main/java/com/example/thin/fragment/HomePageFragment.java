package com.example.thin.fragment;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.thin.R;
import com.example.thin.activity.SearchActivity;
import com.example.thin.adapter.HomeAdapter;
import com.example.thin.base.mvp.BaseFragment;
import com.example.thin.bean.HomeDataBean;
import com.example.thin.iview.IHomePageView;
import com.example.thin.presenter.HomePagePresenter;
import com.example.thin.refresh.TwinklingRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xingyan
 * @Date: 2019/8/2
 * @Desc:
 */
public class HomePageFragment extends BaseFragment<HomePagePresenter> implements IHomePageView, View.OnClickListener {
    private static final String TAG = "HomePageFragment";
    private RecyclerView recyclerView;
    private HomeAdapter adapter;
    private TwinklingRefreshLayout refreshLayout;
    private TextView search;

    public static HomePageFragment newInstance() {
        return new HomePageFragment();
    }

    @Override
    public int layoutId() {
        return R.layout.fragment_home_page;
    }

    @Override
    protected void initView(final View view) {
        recyclerView = getView(view, R.id.rv_home);
        refreshLayout = getView(view, R.id.rl_home);
        search = getView(view, R.id.tv_input_search);
        refreshLayout.setEnableLoadMore(false);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new HomeAdapter(getActivity());
        recyclerView.setAdapter(adapter);

        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                initData();
            }
        });

        search.setOnClickListener(this);
    }

    @Override
    protected void initData() {
//        if (presenter != null) {
//            presenter.getHomePageData("0", "1", getActivity());
//            presenter.getBannerData("0", "1", getActivity());
//        }
        HomeDataBean bean = new HomeDataBean();
        bean.title = "eee";
        bean.url.add("https://img.52z.com/upload/news/image/20180621/20180621055734_59936.jpg");
        bean.url.add("https://img.pc841.com/2018/0922/20180922111049508.jpg");
        bean.url.add("https://img.52z.com/upload/news/image/20180621/20180621055734_59936.jpg");
        bean.url.add("https://img.pc841.com/2018/0922/20180922111049508.jpg");
        bean.url.add("https://img.52z.com/upload/news/image/20180621/20180621055734_59936.jpg");
        bean.url.add("https://img.pc841.com/2018/0922/20180922111049508.jpg");
        bean.url.add("https://img.52z.com/upload/news/image/20180621/20180621055734_59936.jpg");
        bean.url.add("https://img.pc841.com/2018/0922/20180922111049508.jpg");

        adapter.setData(bean);
        refreshLayout.finishRefresh();
    }

    @Override
    public void updateHomeData(List<HomeDataBean> data) {
//        Log.e(TAG, "updateHomeData：" + data.toString());
    }

    @Override
    public void updateBannerData(List<HomeDataBean> data) {
//        Log.e(TAG, "updateBannerData：" + data.toString());
    }

    @Override
    public HomePagePresenter createPresenter() {
        return new HomePagePresenter();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_input_search://搜索
                SearchActivity.open(getActivity());
                break;
            default:
                break;
        }
    }
}
