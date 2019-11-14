package com.example.thin.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.thin.R;
import com.example.thin.adapter.CartAdapter;
import com.example.thin.base.BaseScrollTitleBarActivity;
import com.example.thin.bean.CartBean;
import com.example.thin.bean.ShopBean;
import com.example.thin.bean.TotalPriceNumBean;
import com.example.thin.eventbus.TotalPriceEvent;
import com.example.thin.iview.IShopCartView;
import com.example.thin.presenter.ShopCartPresenter;
import com.example.thin.util.Constants;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * @Author: xingyan
 * @Date: 2019/10/23
 * @Desc:
 */
public class ShopCartActivity extends BaseScrollTitleBarActivity<ShopCartPresenter> implements IShopCartView, View.OnClickListener {

    private RecyclerView recyclerView;
    private CartAdapter adapter;
    private Button settlement;
    private CheckBox cbAllSelect;
    private TextView tvTotal;
    private String totalNumOfShops = "0", totalPriceOfShops = "0.0";
    private List<ShopBean> listCart;

    public static void open(Context context) {
        context.startActivity(new Intent(context, ShopCartActivity.class));
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_shop_cart;
    }

    @Override
    protected int bottomLayoutId() {
        return R.layout.layout_settlement;
    }

    @Override
    protected void initContentView() {
        mTitleBar.setTitle("购物车");
        EventBus.getDefault().register(this);

        recyclerView = getView(R.id.rv_shop_cart);
        settlement = getView(R.id.btn_settlement);
        cbAllSelect = getView(R.id.cb_all_select);
        tvTotal = getView(R.id.tv_total);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CartAdapter(this);
        recyclerView.setAdapter(adapter);

        settlement.setOnClickListener(this);
        cbAllSelect.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        presenter.getCartList(this);
    }

    /**
     * EventBus 通知更新总价  点击每个商品时回调  更新选中商品总价
     *
     * @param event
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onNotifyEvent(TotalPriceEvent event) {
        adapter.isAllSelect();
        adapter.getTotalPriceAndNum();
    }

    @Override
    protected ShopCartPresenter createPresenter() {
        return new ShopCartPresenter();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cb_all_select://全选/反选
                if (cbAllSelect.isChecked()) {
                    adapter.setAllSelectData();
                } else {
                    adapter.setNoSelectData();
                }
                adapter.getTotalPriceAndNum();//点击全选、反选 更新选中商品总价
                break;
            case R.id.btn_settlement://结算  订单信息
                adapter.getSelectBean();
                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        adapter.removeCallbacks();
    }

    @Override
    public void updateCartList(CartBean data) {
        listCart = data.cartShopVos;
        adapter.setData(data.cartShopVos);

    }

    public static class MyHandler extends Handler {
        WeakReference<ShopCartActivity> mWeakReference;

        public MyHandler(ShopCartActivity activity) {
            mWeakReference = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            ShopCartActivity activity = mWeakReference.get();
            if (activity == null) {
                return;
            }
            switch (msg.what) {
                case Constants.IS_ALL_SELECT:
                    activity.adapter.notifyShopItemRangeChanged();
                    break;
                case Constants.TOTAL_PRICE_NUM:
                    TotalPriceNumBean totalPriceNumBean = (TotalPriceNumBean) msg.obj;
                    activity.totalPriceOfShops = totalPriceNumBean.totalPriceOfShops;
                    activity.tvTotal.setText(activity.totalPriceOfShops);
                    activity.totalNumOfShops = totalPriceNumBean.totalNumOfShops;
                    break;
                case Constants.GOODS_ALL_SELECT:
                    boolean isAllSelect = (boolean) msg.obj;
                    activity.cbAllSelect.setChecked(isAllSelect);
                    break;
                case Constants.GET_SELECT:
                    activity.listCart = (List<ShopBean>) msg.obj;
                    SubmitOrderActivity.open(activity, activity.listCart, activity.totalNumOfShops, activity.totalPriceOfShops);
                    break;
                default:
                    break;
            }
        }
    }
}
