package com.example.thin.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.thin.R;
import com.example.thin.base.mvp.BaseActivity;
import com.example.thin.base.mvp.BasePresenter;
import com.example.thin.base.mvp.IBaseView;
import com.example.thin.fragment.HomePageFragment;
import com.example.thin.fragment.ProductPageFragment;
import com.example.thin.fragment.MinePageFragment;
import com.example.thin.fragment.MallPageFragment;
import com.example.thin.view.MainBottomTabView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity<BasePresenter<IBaseView>> {

    private static final String TAG = "MainActivity";
    private List<Fragment> mFrags = new ArrayList<>();
    private MainBottomTabView mainBottomTabView;
    private Fragment currentFragment;
    private FragmentManager manager;
    private HomePageFragment homePageFragment;
    private MallPageFragment productPageFragment;
    private ProductPageFragment minePageFragment;
    private MinePageFragment minePageFragment2;


    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

        currentFragment = new Fragment();
        manager = getSupportFragmentManager();

        homePageFragment = HomePageFragment.newInstance();
        productPageFragment = MallPageFragment.newInstance();
        minePageFragment = ProductPageFragment.newInstance();
        minePageFragment2 = MinePageFragment.newInstance();

        mainBottomTabView = getView(R.id.mainBottomTabView);

        mFrags.add(homePageFragment);
        mFrags.add(productPageFragment);
        mFrags.add(minePageFragment);
        mFrags.add(minePageFragment2);

        //默认显示第一个
        showFragment(mFrags.get(0));

        mainBottomTabView.setSelectFragmentInterface(new MainBottomTabView.SelectFragmentLinstener() {
            @Override
            public void selectFragment(int index) {
                //切换tab
                showFragment(mFrags.get(index));

            }
        });
    }

    /**
     * 展示当前 Fragment  Fragment的隐藏和展示，也就是完成Fragment的切换功能
     *
     * @param fragment
     */
    private void showFragment(Fragment fragment) {
        if (currentFragment != fragment) {
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.hide(currentFragment);
            currentFragment = fragment;
            if (!fragment.isAdded()) {
                transaction.add(R.id.frameLayout, fragment).show(fragment).commit();
            } else {
                transaction.show(fragment).commit();
            }
        }
    }

    @Override
    protected void initData() {
    }


    @Override
    protected BasePresenter<IBaseView> createPresenter() {
        return null;
    }
}
