package com.example.thin.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import com.example.thin.R;
import com.example.thin.base.BaseScrollTitleBarActivity;
import com.example.thin.base.mvp.BasePresenter;
import com.example.thin.base.mvp.IBaseView;
import com.example.thin.util.Constants;

/**
 * @Author: xingyan
 * @Date: 2019/10/22
 * @Desc:
 */
public class CashierActivity extends BaseScrollTitleBarActivity<BasePresenter> implements IBaseView, View.OnClickListener {
    private RadioButton rbWeiXin;
    private RadioButton rbAliPay;
    private Button btnPay;
    private String totalPriceOfShops;

    public static void open(Context context, String totalPriceOfShops) {
        Intent intent = new Intent(context, CashierActivity.class);
        intent.putExtra(Constants.TOTAL_PRICE_OF_SHOPS, totalPriceOfShops);
        context.startActivity(intent);
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_cashier;
    }

    @Override
    protected void initContentView() {
        totalPriceOfShops = getIntent().getStringExtra(Constants.TOTAL_PRICE_OF_SHOPS);
        mTitleBar.setTitle("收银台");

        rbWeiXin = getView(R.id.rb_wei_xin);
        rbAliPay = getView(R.id.rb_ali_pay);
        btnPay = getView(R.id.btn_pay);

        btnPay.setOnClickListener(this);

        btnPay.setText("支付   " + totalPriceOfShops);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_pay://支付
                if (rbWeiXin.isChecked()) {//微信支付
                } else if (rbAliPay.isChecked()) {//支付宝
                }
                break;
            default:
                break;
        }
    }
}
