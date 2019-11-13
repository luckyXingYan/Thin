package com.example.thin.view;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.thin.R;
import com.example.thin.activity.WelcomeThinActivity;

/**
 * “我的”页面登录弹框
 * Created by liuwei
 * on 2018/9/20.
 */
public class MineLoginLayout extends RelativeLayout {
    Context context;
    private View view;
    private TextView tv_login_btn;
    private int viewHeight;
    private int viewWidth;
    private ValueAnimator valueAnimator;
    private FocusRelativeLayout rv_bg;
    private ValueAnimator valueAnimator1;

    public MineLoginLayout(Context context) {
        this(context, null);
        this.context = context;
    }

    public MineLoginLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        this.context = context;
    }

    public MineLoginLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init();
    }

    private void init() {
        view = View.inflate(context, R.layout.dialog_login_bottom, null);
        addView(view);
        tv_login_btn = view.findViewById(R.id.tv_login_btn);
        rv_bg = view.findViewById(R.id.rv_bg);
        view.measure(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED);
        viewHeight = view.getMeasuredHeight();
        viewWidth = view.getMeasuredWidth();
        tv_login_btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                WelcomeThinActivity.open(context);
            }
        });
    }

    public void show() {
        valueAnimator = ValueAnimator.ofFloat(-1.0f, 0.0f);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                MineLoginLayout.this.setVisibility(View.VISIBLE);
                float animatedValue = (float) animation.getAnimatedValue();
                LayoutParams layoutParams = (LayoutParams) MineLoginLayout.this.getLayoutParams();
                layoutParams.setMargins(0, 0, 0, (int) (viewHeight * animatedValue));
                MineLoginLayout.this.setLayoutParams(layoutParams);
            }
        });
        valueAnimator.setDuration(600);
        valueAnimator.start();

        valueAnimator1 = ValueAnimator.ofInt(0x00000000, 0x99000000);
        valueAnimator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int valueArgb = (int) animation.getAnimatedValue();
                rv_bg.setBackgroundColor(valueArgb);
            }
        });
        valueAnimator1.setEvaluator(new ArgbEvaluator());
        valueAnimator1.setDuration(600);
        valueAnimator1.start();

    }

    public void dismiss() {
        MineLoginLayout.this.setVisibility(View.GONE);
        if (valueAnimator != null) {
            valueAnimator.cancel();
            valueAnimator = null;
        }
        if (valueAnimator1 != null) {
            valueAnimator1.cancel();
            valueAnimator1 = null;
        }
    }
}
