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
import com.example.thin.bean.BannerBean;
import com.example.thin.bean.HotBean;
import com.example.thin.iview.IHomePageView;
import com.example.thin.presenter.HomePagePresenter;
import com.example.thin.refresh.TwinklingRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

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
    private String keyWord, isHot = "1", groupId, pageNo = "1", pageSize = "10";//是否热门 1：是（非必填）

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
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new HomeAdapter(getActivity());
        recyclerView.setAdapter(adapter);

        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                if (recyclerView != null) {
                    recyclerView.scrollToPosition(0);
                }
                initData();
            }
        });

        search.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        presenter.getHot(keyWord, isHot, groupId, pageNo, pageSize, getActivity());

        BannerBean bean = new BannerBean();
        bean.title = "eee";
        bean.url.add("https://img.52z.com/upload/news/image/20180621/20180621055734_59936.jpg");
        bean.url.add("https://img.pc841.com/2018/0922/20180922111049508.jpg");
        bean.url.add("https://img.52z.com/upload/news/image/20180621/20180621055734_59936.jpg");
        bean.url.add("https://img.pc841.com/2018/0922/20180922111049508.jpg");
        bean.url.add("https://img.52z.com/upload/news/image/20180621/20180621055734_59936.jpg");
        bean.url.add("https://img.pc841.com/2018/0922/20180922111049508.jpg");
        bean.url.add("https://img.52z.com/upload/news/image/20180621/20180621055734_59936.jpg");
        bean.url.add("https://img.pc841.com/2018/0922/20180922111049508.jpg");

        adapter.setData2(bean);
        refreshLayout.finishRefresh();
    }

    @Override
    public void updateHot(List<HotBean> data) {
        adapter.setData(data);
    }

    @Override
    public void updateBannerData(List<HotBean> data) {
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

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden) {
            adapter.setBannerStopAutoPlay(false);
        } else {
            adapter.setBannerStopAutoPlay(true);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        adapter.setBannerStopAutoPlay(true);
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.setBannerStopAutoPlay(false);
    }
}
