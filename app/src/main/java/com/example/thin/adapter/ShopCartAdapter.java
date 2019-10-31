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
import com.example.thin.bean.CartGoodsBean;
import com.example.thin.bean.CartListBean;
import com.example.thin.bean.CartShopBean;
import com.example.thin.bean.TotalPriceNumBean;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @Author: xingyan
 * @Date: 2019/10/23
 * @Desc:
 */
public class ShopCartAdapter extends BaseRecyclerAdapter<CartListBean, ShopCartAdapter.MyViewHolder> {
    private Context context;
    private GoodsCartAdapter adapter;
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
                for (final CartListBean bean : getData()) {
                    adapter.setAllSelectData(bean.goods);
                    //通知主线程更新商品
                    //myHandler.sendEmptyMessage(100);
                }
                //通知主线程更新店铺
                myHandler.sendEmptyMessage(101);
            }
        }).start();
    }

    public void setNoSelectData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (final CartListBean bean : getData()) {
                    adapter.setNoSelectData(bean.goods);
                }
                myHandler.sendEmptyMessage(101);
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
                message.what = 103;
                for (CartListBean bean : getData()) {
                    for (CartGoodsBean goodsBean : bean.goods) {
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
        notifyItemRangeChanged(0, getData().size(), "checkBox");
    }

    /**
     * 防止 handler 内存泄漏
     */
    public void removeCallbacks() {
        myHandler.removeCallbacks(null);
    }

    public void getSelectBean() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                List<Map<CartListBean, List<CartGoodsBean>>> shopBeans = new ArrayList<>();
                for (CartListBean bean : getData()) {
                    Map<CartListBean, List<CartGoodsBean>> map = new HashMap<>();
                    List<CartGoodsBean> goodsBeans = new ArrayList<>();
                    for (CartGoodsBean goodsBean : bean.goods) {
                        if (goodsBean.isSelect) {
                            goodsBeans.add(goodsBean);
                            map.put(bean, goodsBeans);
                            shopBeans.add(map);
                        }
                    }
                }
                Message message = Message.obtain();
                message.what = 104;

                Gson gson = new Gson();
                String jsonStr = gson.toJson(shopBeans);
                /**
                 * TypeToken<List<需要映射的Bean对象>>(){}.getType()
                 *  // 参数二：需要指定类型，类型来决定解析的集合
                 */
                List<CartListBean> list = gson.fromJson(jsonStr, new TypeToken<List<CartListBean>>() {
                }.getType());

                message.obj = list;
                myHandler.sendMessage(message);
                return;
            }
        }).start();
    }

    private double totalPriceOfShops;//选中的商品总价
    private double totalPriceOfPerShop;//选中的每个店铺的商品总价
    private int numOfPerShop;//选中的每个店铺的商品个数
    private int totalNumOfShops;//选中的所有的商品个数

    public void getTotalPrice() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                totalPriceOfShops = 0;
                totalNumOfShops = 0;
                for (CartListBean bean : getData()) {
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
                message.what = 102;
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
            Log.e("----onBindViewHolder", payloads + "");
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
        adapter = new GoodsCartAdapter(context);
        myViewHolder.rvGoodsCart.setAdapter(adapter);

        adapter.setData(getItemData(i).goods);

        adapter.setDeleteShopItemListener(new GoodsCartAdapter.DeleteShopItemListener() {
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

    /**
     * 将JSON字符串转换为集合
     *
     * @param json
     * @param clazz
     * @return
     */
    public static <T> ArrayList<T> jsonToArrayList(String json, Class<T> clazz) {
        Type type = new TypeToken<ArrayList<JsonObject>>() {
        }.getType();
        ArrayList<JsonObject> jsonObjects = new Gson().fromJson(json, type);

        ArrayList<T> arrayList = new ArrayList<>();
        for (JsonObject jsonObject : jsonObjects) {
            arrayList.add(new Gson().fromJson(jsonObject, clazz));
        }
        return arrayList;
    }
}
