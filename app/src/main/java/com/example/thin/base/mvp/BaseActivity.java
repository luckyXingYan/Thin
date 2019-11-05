package com.example.thin.base.mvp;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

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

    /**
     * 实现功能：点击EditText，软键盘出现并且不会隐藏，点击或者触摸EditText以外的其他任何区域，软键盘被隐藏；
     * <p>
     * 1、重写dispatchTouchEvent()方法，获取当前触摸事件为DOWN的时候隐藏软键盘
     *
     * @param ev
     * @return
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        //Finger touch screen event
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            // get current focus,Generally it is EditText
            View view = getCurrentFocus();
            if (isShouldHideSoftKeyBoard(view, ev)) {
                hideSoftKeyBoard(view.getWindowToken());
            }
        }
        return super.dispatchTouchEvent(ev);
    }

    /**
     * Judge what situation hide the soft keyboard,click EditText view should show soft keyboard
     *
     * @param event
     * @return
     */
    private boolean isShouldHideSoftKeyBoard(View view, MotionEvent event) {
        if (view != null && (view instanceof EditText)) {
            int[] l = {0, 0};
            view.getLocationInWindow(l);
            int left = l[0], top = l[1], bottom = top + view.getHeight(), right = left
                    + view.getWidth();
            if (event.getX() > left && event.getX() < right
                    && event.getY() > top && event.getY() < bottom) {
                // If click the EditText event ,ignore it
                return false;
            } else {
                return true;
            }
        }
        // if the focus is EditText,ignore it;
        return false;
    }

    /**
     * hide soft keyboard
     *
     * @param token
     */
    private void hideSoftKeyBoard(IBinder token) {
        if (token != null) {
            InputMethodManager im = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            im.hideSoftInputFromWindow(token,
                    InputMethodManager.HIDE_NOT_ALWAYS);
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
