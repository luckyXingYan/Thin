package com.example.thin.view;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import com.example.thin.R;
import com.example.thin.bean.CartGoodsBean;

/**
 * @Author: xingyan
 * @Date: 2019/10/23
 * @Desc:
 */
public class CartGoodsView extends BaseHomeLayout<CartGoodsBean> implements View.OnClickListener {
    private LinearLayout item;
    private CartGoodsBean data;
    private CheckBox checkBox;

    public CartGoodsView(Context context) {
        super(context);
        data = new CartGoodsBean();
    }

    @Override
    protected void init() {
        inflate(getContext(), R.layout.layout_cart_goods, this);
        item = findViewById(R.id.ll_item_shop_cart_goods);
        checkBox = findViewById(R.id.cb_cart_shop);
        item.setOnClickListener(this);
        item.setOnLongClickListener(new OnLongClickListener() {//长按删除
            @Override
            public boolean onLongClick(View v) {
                new AlertDialog.Builder(getContext()).setTitle("确认删除吗？")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(final DialogInterface dialog, int which) {
                                dialog.dismiss();
                                if (deletePosDataListener != null) {
                                    deletePosDataListener.setOnDeletePosData(data);
                                }
                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).show();
                return true;
            }
        });
    }

    @Override
    public void setData(CartGoodsBean data) {
        this.data = data;
        checkBox.setChecked(data.isSelect);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_item_shop_cart_goods://购物车物品
                if (!data.isSelect) {
                    data.isSelect = true;
                } else {
                    data.isSelect = false;
                }
                setData(data);
                break;
            default:
                break;
        }
    }

    private DeletePosDataListener deletePosDataListener;

    public interface DeletePosDataListener {
        void setOnDeletePosData(CartGoodsBean bean);
    }

    public void setOnDeletePosDataLinstener(DeletePosDataListener deletePosDataListener) {
        this.deletePosDataListener = deletePosDataListener;
    }
}

