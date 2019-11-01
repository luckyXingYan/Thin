package com.example.thin.adapter;

import android.content.Context;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.thin.R;
import com.example.thin.activity.ShopCartActivity;
import com.example.thin.base.adapter.BaseRecyclerAdapter;
import com.example.thin.base.adapter.BaseViewHolder;
import com.example.thin.bean.GoodBean;
import com.example.thin.bean.ShopCartBean;
import com.example.thin.bean.TotalPriceNumBean;
import com.example.thin.util.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xingyan
 * @Date: 2019/10/23
 * @Desc:
 */
public class ShopCartAdapter extends BaseRecyclerAdapter<ShopCartBean, ShopCartAdapter.MyViewHolder> {
    private Context context;
    private GoodsAdapter adapter;
    private ShopCartActivity.MyHandler myHandler;

    public ShopCartAdapter(Context context) {
        super(context);
        this.context = context;
        myHandler = new ShopCartActivity.MyHandler(((ShopCartActivity) context));
    }

    @Override
    public int getItemLayout(int viewType) {
        return R.layout.item_shop_cart;
    }

    public void setAllSelectData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                //子线程耗时循环店铺
                for (final ShopCartBean bean : getData()) {
                    adapter.setAllSelectData(bean.goods);
                    //通知主线程更新商品
                    //myHandler.sendEmptyMessage(100);
                }
                //通知主线程更新店铺
                myHandler.sendEmptyMessage(Constants.IS_ALL_SELECT);
            }
        }).start();
    }

    public void setNoSelectData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (final ShopCartBean bean : getData()) {
                    adapter.setNoSelectData(bean.goods);
                }
                myHandler.sendEmptyMessage(Constants.IS_ALL_SELECT);
            }
        }).start();
    }

    /**
     * 判断二级列表是否全部选中
     *
     * @param
     * @return
     */
    public void isAllSelect() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Message message = Message.obtain();
                message.what = Constants.GOODS_ALL_SELECT;
                for (ShopCartBean bean : getData()) {
                    for (GoodBean goodsBean : bean.goods) {
                        if (!goodsBean.isSelect) {
                            message.obj = false;
                            myHandler.sendMessage(message);
                            return;
                        }
                    }
                }
                message.obj = true;
                myHandler.sendMessage(message);
                return;
            }
        }).start();
    }

    /**
     * 更新店铺选中状态
     */
    public void notifyShopItemRangeChanged() {
        notifyItemRangeChanged(0, getData().size(), Constants.CHECK_BOX_SHOP_CART);
    }

    /**
     * 防止 handler 内存泄漏
     */
    public void removeCallbacks() {
        myHandler.removeCallbacks(null);
    }

    /**
     * 获取选中的 店铺 + 商品
     */
    public void getSelectBean() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                List<ShopCartBean> shopBeans = new ArrayList<>();
                for (ShopCartBean listBean : getData()) {
                    ShopCartBean cartListBean = new ShopCartBean();
                    for (GoodBean goodBean : listBean.goods) {
                        if (goodBean.isSelect) {
                            if (cartListBean.id != listBean.id) {
                                cartListBean.title = listBean.title;
                                cartListBean.id = listBean.id;
                            }
                            cartListBean.goods.add(goodBean);
                        }
                    }
                    if (cartListBean.goods != null && cartListBean.goods.size() > 0) {
                        shopBeans.add(cartListBean);
                    }
                }

                Message message = Message.obtain();
                message.what = Constants.GET_SELECT;
                message.obj = shopBeans;
                myHandler.sendMessage(message);
                return;
            }
        }).start();
    }

    private double totalPriceOfShops;//选中的商品总价
    private double totalPriceOfPerShop;//选中的每个店铺的商品总价
    private int numOfPerShop;//选中的每个店铺的商品个数
    private int totalNumOfShops;//选中的所有的商品个数

    public void getTotalPriceAndNum() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                totalPriceOfShops = 0;
                totalNumOfShops = 0;
                for (ShopCartBean bean : getData()) {
                    totalPriceOfPerShop = 0;
                    for (int i = 0; i < bean.goods.size(); i++) {
                        if (bean.goods.get(i).isSelect) {
                            String num = bean.goods.get(i).num;
                            numOfPerShop = Integer.valueOf(num);
                            totalNumOfShops += numOfPerShop;
                            String priceOfGood = bean.goods.get(i).price;//选中的每个商品的价格
                            totalPriceOfPerShop += numOfPerShop * Double.valueOf(priceOfGood);
                        }
                    }
                    totalPriceOfShops += totalPriceOfPerShop;
                }

                Message message = Message.obtain();
                message.what = Constants.TOTAL_PRICE_NUM;
                TotalPriceNumBean totalPriceNumBean = new TotalPriceNumBean();
                totalPriceNumBean.totalPriceOfShops = (totalPriceOfShops + "").trim();
                totalPriceNumBean.totalNumOfShops = (totalNumOfShops + "").trim();
                message.obj = totalPriceNumBean;
                myHandler.sendMessage(message);
            }
        }).start();
    }

    @Override
    public int getViewType(int position) {
        return 0;
    }

    @Override
    public MyViewHolder getViewHolder(View view, int viewType) {
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position,
                                 @NonNull List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
        if (payloads.isEmpty()) {
            // payloads 为 空，说明是更新整个 ViewHolder
            onBindViewHolder(holder, position);
        } else {
            // payloads 不为空，这只更新需要更新的 View 即可。
            for (Object payload : payloads) {
                String payloadStr = ((String) payload);
                if (Constants.CHECK_BOX_SHOP_CART.equals(payloadStr)) {
                    Log.e("----onBindViewHolder", payloads + "");
                }
            }
        }
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        myViewHolder.rvGoodsCart.setLayoutManager(new LinearLayoutManager(context));
        /**
         * 当确定Item的改变不会影响RecyclerView的宽高时
         * 可以设置setHasFixedSize(true)，
         * 并通过Adapter的增删改插方法去刷新RecyclerView，
         *       === 比如更新pos位置的item：notifyItemChanged(pos);/notifyItemChanged(pos,payload);而不是通过notifyDataSetChanged()。
         *       ===notifyItemRangeChanged(pos, getData().size(), "payload");
         * （其实可以直接设置为true，当需要改变宽高的时候就用 notifyDataSetChanged() 去整体刷新一下）
         * 因为删除时改变了rv的宽高，所以不用考虑 直接 notifyDataSetChanged 更新即可
         */
        myViewHolder.rvGoodsCart.setHasFixedSize(true);
        adapter = new GoodsAdapter(context);
        myViewHolder.rvGoodsCart.setAdapter(adapter);

        adapter.setData(getItemData(i).goods);

        adapter.setDeleteShopItemListener(new GoodsAdapter.DeleteShopItemListener() {
            @Override
            public void deleteShopItem() {
                if (getItemData(i).goods.size() == 0) {
                    getData().remove(getItemData(i));
                    notifyDataSetChanged();
                }
            }
        });
    }

    protected class MyViewHolder extends BaseViewHolder {

        private RecyclerView rvGoodsCart;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            rvGoodsCart = itemView.findViewById(R.id.rv_goods_cart);
        }
    }
}
