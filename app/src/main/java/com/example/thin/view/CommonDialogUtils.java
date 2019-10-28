package com.example.thin.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.example.thin.R;

/**
 * @Author: xingyan
 * @Date: 2019/10/28
 * @Desc:
 */
public abstract class CommonDialogUtils {
    private View view;
    private Context context;
    private AlertDialog alertDialog;


    public CommonDialogUtils(Context context) {
        this.context = context;
        init();
    }

    private void init() {
        view = LayoutInflater.from(context).inflate(layoutId(), null);
        alertDialog = new AlertDialog.Builder(context, R.style.dialog)
                .setView(view)
                .create();
        initView(view);
        Window mWindow = alertDialog.getWindow();
        mWindow.setGravity(Gravity.BOTTOM);
        //添加动画
//        mWindow.setWindowAnimations(R.style.dialogAnim);
        alertDialog.show();
        //重新设置dialog的宽度  需要 放在show方法之后 才有效果
        WindowManager.LayoutParams lp = mWindow.getAttributes();
        lp.width = ViewGroup.LayoutParams.MATCH_PARENT;
        mWindow.setAttributes(lp);

    }

    public void show() {
        alertDialog.show();
    }

    public void dismiss() {
        alertDialog.dismiss();
    }

    protected abstract int layoutId();

    protected abstract void initView(View view);
}
