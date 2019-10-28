package com.example.thin.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import com.example.thin.R;
import com.example.thin.base.BaseTitleBarActivity;
import com.example.thin.base.mvp.BasePresenter;
import com.example.thin.base.mvp.IBaseView;
import com.example.thin.fragment.OrderCommonFragment;
import com.example.thin.util.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xingyan
 * @Date: 2019/10/22
 * @Desc:
 */
public class MyOrderActivity extends BaseTitleBarActivity<BasePresenter> implements IBaseView {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<Fragment> fragments = new ArrayList<>();
    private int position = 0;

    public static void open(Context context, int position) {
        Intent intent = new Intent();
        intent.setClass(context, MyOrderActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt(Constants.MY_ORDER_TAB_LAYOUT_TYPE, position);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_my_order;
    }

    @Override
    protected void initContentView() {
        titleBar.setTitle("我的订单");

        Bundle bundle = getIntent().getExtras();
        if (null == bundle) {
            this.finish();
            return;
        }
        position = getIntent().getIntExtra(Constants.MY_ORDER_TAB_LAYOUT_TYPE, 0);

        tabLayout = getView(R.id.tb_order);
        viewPager = getView(R.id.vp_order);
        final List<String> titles = new ArrayList<>();
        titles.add("全部");
        titles.add("待付款");
        titles.add("未使用");
        titles.add("待发货");
        titles.add("待收货");
        titles.add("已完成");
        for (int i = 0; i < titles.size(); i++) {
            fragments.add(OrderCommonFragment.newInstance());
            TabLayout.Tab tab = tabLayout.newTab();
            tab.setTag(i);
            tab.setText(titles.get(i));
            tabLayout.addTab(tab);
        }


        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(position).select(); //默认选中某项放在 tabLayout.setupWithViewPager 之后

        viewPager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
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
        viewPager.setCurrentItem(position);//默认选中frag放在 viewPager.setAdapter 之后
    }

    @Override
    protected void initData() {

    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }
}
