package com.example.thin.base.mvp;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.example.thin.R;
import com.example.thin.base.util.AppManager;
import com.example.thin.base.util.ToastUtil;
/**
 * 作者： 钟雄辉
 * 时间： 2018/6/27
 * 描述： 放置公共业务的Activity
 **/
public abstract class BaseActivity<P extends BasePresenter> extends MvpBaseActivity<P> implements IBaseView {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppManager.getAppManager().addActivity(this);
        setContentView(layoutId());
        setStatusBarLightMode(this, R.color.white);
        initView(savedInstanceState);
        initData();
    }

    public static void setStatusBarLightMode(Activity activity, int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                //如果是6.0以上将状态栏文字改为黑色，并设置状态栏颜色
                activity.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                activity.getWindow().setStatusBarColor(color);

                //fitsSystemWindow 为 false, 不预留系统栏位置.
                ViewGroup mContentView = activity.getWindow().findViewById(Window.ID_ANDROID_CONTENT);
                View mChildView = mContentView.getChildAt(0);
                if (mChildView != null) {
                    mChildView.setFitsSystemWindows(true);
                    ViewCompat.requestApplyInsets(mChildView);
                }
            } else {
                //4.4以上6.0以下的其他系统，暂时没有修改状态栏的文字图标颜色的方法，有可以加上
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppManager.getAppManager().removeActivity(this);
        if (presenter != null) {
            presenter.cancelNetWork();
        }
    }

    @Override
    public void showToastMsg(String msg) {
        ToastUtil.showToastShort(this, msg);
    }

    protected abstract int layoutId();

    protected abstract void initView(Bundle savedInstanceState);

    protected abstract void initData();
}
