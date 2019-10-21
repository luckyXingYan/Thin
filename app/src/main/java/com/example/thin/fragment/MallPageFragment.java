package com.example.thin.fragment;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.thin.R;
import com.example.thin.adapter.HotAdapter;
import com.example.thin.adapter.MallAdapter;
import com.example.thin.base.mvp.BaseFragment;
import com.example.thin.bean.ProductDataBean;
import com.example.thin.iview.IProductPageView;
import com.example.thin.presenter.ProductPagePresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xingyan
 * @Date: 2019/8/2
 * @Desc:
 */
public class MallPageFragment extends BaseFragment<ProductPagePresenter> implements IProductPageView {
    private static final String TAG = "MallPageFragment";
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<Fragment> fragments = new ArrayList<>();

    public static MallPageFragment newInstance() {
        return new MallPageFragment();
    }

    @Override
    public int layoutId() {
        return R.layout.fragment_mall_page;
    }

    @Override
    protected void initView(View view) {
        tabLayout = getView(view, R.id.tb_mall);
        viewPager = getView(view, R.id.vp_mall);


        final List<String> titles = new ArrayList<>();
        titles.add("标题1");
        titles.add("标题2");
        titles.add("标题3");
        titles.add("标题4");
        titles.add("标题5");
        titles.add("标题6");
        titles.add("标题7");
        titles.add("标题8");

        for (int i = 0; i < titles.size(); i++) {
            fragments.add(MallCommonFragment.newInstance());
            TabLayout.Tab tab = tabLayout.newTab();
            tab.setTag(i);
            tab.setText(titles.get(i));
            tabLayout.addTab(tab);
        }

        tabLayout.setupWithViewPager(viewPager);
        viewPager.setAdapter(new FragmentStatePagerAdapter(getActivity().getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return titles.get(position);
            }
        });
    }

    @Override
    protected void initData() {
//        if (presenter != null) {
//            presenter.getProductPageData("0", "1", getActivity());
//        }
    }

    @Override
    public void updateProductData(List<ProductDataBean> data) {
        Log.e(TAG, "updateProductData：" + data.toString());
    }

    @Override
    public ProductPagePresenter createPresenter() {
        return new ProductPagePresenter();
    }
}
