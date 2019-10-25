package com.example.thin.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import com.example.thin.R;
import com.example.thin.activity.CashierActivity;
import com.example.thin.activity.CreateAddressActivity;
import com.example.thin.activity.PublishActivity;

/**
 * @Author: xingyan
 * @Date: 2019/8/2
 * @Desc:
 */
public class MainBottomTabView extends RelativeLayout implements View.OnClickListener {

    private RadioGroup mTabRadioGroup;
    private int index;
    private ImageView publish;

    public MainBottomTabView(Context context) {
        this(context, null);
    }

    public MainBottomTabView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.widget_main_bottom_tabview, this);
        mTabRadioGroup = findViewById(R.id.tabs_rg);
        publish = findViewById(R.id.sign_iv);
        publish.setOnClickListener(this);

        mTabRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedIdsign_iv) {

            }
        });

        mTabRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // 具体的fragment切换逻辑可以根据应用调整，例如使用show()/hide()
                if (selectFragmentLinstener != null) {
                    if (checkedId == R.id.home_tab) {
                        index = 0;
                    } else if (checkedId == R.id.mall_tab) {
                        index = 1;
                    } else if (checkedId == R.id.product_tab) {
                        index = 2;
                    } else if (checkedId == R.id.mine_tab) {
                        index = 3;
                    }
                    selectFragmentLinstener.selectFragment(index);
                }
            }
        });
    }

    //定义接口名字
    private SelectFragmentLinstener selectFragmentLinstener;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sign_iv://发布
                PublishActivity.open(getContext());
                break;
            default:
                break;
        }
    }

    //回调接口
    public interface SelectFragmentLinstener {
        void selectFragment(int checkedId);
    }

    //定义回调方法
    public void setSelectFragmentInterface(SelectFragmentLinstener selectFragmentLinstener) {
        this.selectFragmentLinstener = selectFragmentLinstener;
    }
}
