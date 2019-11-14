package com.example.thin.adapter;

import android.content.Context;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.thin.R;
import com.example.thin.activity.ShopCartActivity;
import com.example.thin.activity.ShopDetailOrderActivity;
import com.example.thin.base.adapter.BaseRecyclerAdapter;
import com.example.thin.base.adapter.BaseViewHolder;
import com.example.thin.bean.GoodsBean;
import com.example.thin.bean.ShopBean;
import com.example.thin.bean.TotalPriceNumBean;
import com.example.thin.util.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xingyan
 * @Date: 2019/10/23
 * @Desc:
 */
public class CartAdapter extends BaseRecyclerAdapter<ShopBean, CartAdapter.MyViewHolder> {
    private Context context;
    private CartGoodsAdapter adapter;
    private ShopCartActivity.MyHandler myHandler;

    public CartAdapter(Context context) {
        super(context);
        this.context = context;
        myHandler = new ShopCartActivity.MyHandler(((ShopCartActivity) context));
    }

    @Override
    public int getItemLayout(int viewType) {
        return R.layout.item_shop_cart;
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
        adapter = new CartGoodsAdapter(context);
        myViewHolder.rvGoodsCart.setAdapter(adapter);

        final ShopBean data = getItemData(i);
        if (data == null) return;

        myViewHolder.shopName.setText(data.shopName);
        adapter.setData(data.cartProductVos);

        adapter.setDeleteShopItemListener(new CartGoodsAdapter.DeleteShopItemListener() {
            @Override
            public void deleteShopItem() {
                if (data.cartProductVos.size() == 0) {
                    getData().remove(data);
                    notifyDataSetChanged();
                }
            }
        });

        ////店铺详情
        myViewHolder.rlShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //需要再写一个标准模式的 activity 因为从商品详情页进去得店铺详情是singleTask模式
                ShopDetailOrderActivity.open(context);
            }
        });
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

    public void setAllSelectData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                //子线程耗时循环店铺
                for (final ShopBean bean : getData()) {
                    adapter.setAllSelectData(bean.cartProductVos);
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
                for (final ShopBean bean : getData()) {
                    adapter.setNoSelectData(bean.cartProductVos);
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
                for (ShopBean bean : getData()) {
                    for (GoodsBean goodsBean : bean.cartProductVos) {
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
                List<ShopBean> shopBeans = new ArrayList<>();
                for (ShopBean listBean : getData()) {
                    ShopBean cartListBean = new ShopBean();
                    for (GoodsBean goodBean : listBean.cartProductVos) {
                        if (goodBean.isSelect) {
                            if (cartListBean.shopId != listBean.shopId) {
                                cartListBean.shopName = listBean.shopName;
                                cartListBean.shopId = listBean.shopId;
                            }
                            cartListBean.cartProductVos.add(goodBean);
                        }
                    }
                    if (cartListBean.cartProductVos != null && cartListBean.cartProductVos.size() > 0) {
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
                for (ShopBean bean : getData()) {
                    totalPriceOfPerShop = 0;
                    for (int i = 0; i < bean.cartProductVos.size(); i++) {
                        if (bean.cartProductVos.get(i).isSelect) {
                            String num = bean.cartProductVos.get(i).count;
                            numOfPerShop = Integer.valueOf(num);
                            totalNumOfShops += numOfPerShop;
                            String priceOfGood = bean.cartProductVos.get(i).unitPrice;//选中的每个商品的价格
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

    protected class MyViewHolder extends BaseViewHolder {

        private RecyclerView rvGoodsCart;
        private RelativeLayout rlShop;
        private TextView shopName;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            rvGoodsCart = itemView.findViewById(R.id.rv_goods_cart);
            rlShop = itemView.findViewById(R.id.rl_shop);
            shopName = itemView.findViewById(R.id.tv_shop_name);
        }
    }
}
