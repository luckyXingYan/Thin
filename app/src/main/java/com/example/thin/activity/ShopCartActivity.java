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
import com.example.thin.adapter.ShopCartAdapter;
import com.example.thin.base.BaseScrollTitleBarActivity;
import com.example.thin.base.mvp.BasePresenter;
import com.example.thin.base.mvp.IBaseView;
import com.example.thin.bean.CartGoodsBean;
import com.example.thin.bean.CartListBean;
import com.example.thin.bean.TotalPriceNumBean;
import com.example.thin.eventbus.TotalPriceEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xingyan
 * @Date: 2019/10/23
 * @Desc:
 */
public class ShopCartActivity extends BaseScrollTitleBarActivity<BasePresenter> implements IBaseView, View.OnClickListener {

    private RecyclerView recyclerView;
    private ShopCartAdapter adapter;
    private Button settlement;
    private CheckBox cbAllSelect;
    private TextView tvTotal;
    private String totalNumOfShops, totalPriceOfShops;
    private List<CartListBean> listCart;

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
        adapter = new ShopCartAdapter(this);
        recyclerView.setAdapter(adapter);

        settlement.setOnClickListener(this);
        cbAllSelect.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        listCart = new ArrayList<>();
        List<CartListBean> data = new ArrayList<>();

        CartListBean bean1 = new CartListBean();
        bean1.id = "11";
        bean1.title = "店铺1";


        CartGoodsBean info1 = new CartGoodsBean();
        info1.title = "https://img.52z.com/upload/news/image/20180621/20180621055734_59936.jpg";
        info1.id = "1";
        info1.shopId = "11";
        info1.price = "1";
        info1.num = "1";
        bean1.goods.add(info1);


        CartGoodsBean info2 = new CartGoodsBean();
        info2.title = "https://img.52z.com/upload/news/image/20180621/20180621055734_59936.jpg";
        info2.id = "2";
        info2.shopId = "11";
        info2.price = "2";
        info2.num = "2";
        bean1.goods.add(info2);

        data.add(bean1);


        CartListBean bean2 = new CartListBean();
        bean2.id = "22";
        bean2.title = "店铺2";


        CartGoodsBean info3 = new CartGoodsBean();
        info3.title = "https://img.pc841.com/2018/0922/20180922111049508.jpg";
        info3.id = "3";
        info3.shopId = "22";
        info3.price = "3";
        info3.num = "3";
        bean2.goods.add(info3);

        CartGoodsBean info4 = new CartGoodsBean();
        info4.title = "https://img.pc841.com/2018/0922/20180922111049508.jpg";
        info4.id = "4";
        info4.shopId = "22";
        info4.price = "4";
        info4.num = "4";
        bean2.goods.add(info4);

        data.add(bean2);

        adapter.setData(data);
    }

    /**
     * EventBus 通知更新总价  点击每个商品时回调  更新选中商品总价
     *
     * @param event
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onNotifyEvent(TotalPriceEvent event) {
        adapter.isAllSelect();
        adapter.getTotalPrice();
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
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
                adapter.getTotalPrice();//点击全选、反选 更新选中商品总价
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
                case 101:
                    activity.adapter.notifyShopItemRangeChanged();
                    break;
                case 102:
                    TotalPriceNumBean totalPriceNumBean = (TotalPriceNumBean) msg.obj;
                    activity.totalPriceOfShops = totalPriceNumBean.totalPriceOfShops;
                    activity.tvTotal.setText(activity.totalPriceOfShops);
                    activity.totalNumOfShops = totalPriceNumBean.totalNumOfShops;
                    break;
                case 103:
                    boolean isAllSelect = (boolean) msg.obj;
                    activity.cbAllSelect.setChecked(isAllSelect);
                    break;
                case 104:
                    activity.listCart = (List<CartListBean>) msg.obj;
                    TakeOrderActivity.open(activity, activity.listCart, activity.totalNumOfShops, activity.totalPriceOfShops);
                    break;
                default:
                    break;
            }
        }
    }
}
