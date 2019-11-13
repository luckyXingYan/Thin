package com.example.thin.presenter;

import android.content.Context;
import android.os.Message;

import com.example.thin.activity.CreateAddressActivity;
import com.example.thin.activity.ShopCartActivity;
import com.example.thin.base.http.callback.HttpGsonCallback;
import com.example.thin.base.mvp.BasePresenter;
import com.example.thin.bean.GoodBean;
import com.example.thin.bean.ShopCartBean;
import com.example.thin.bean.UpdateAddressBean;
import com.example.thin.iview.IUpdateAddressView;
import com.example.thin.model.MinePageModel;
import com.example.thin.util.Constants;
import com.example.thin.widget.addresspicker.bean.AreaProvince;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xingyan
 * @Date: 2019/11/12
 * @Desc:
 */
public class UpdateAddressPresenter extends BasePresenter<IUpdateAddressView> {
    private MinePageModel model;
    private Thread thread;
    private List<AreaProvince> area;
    private CreateAddressActivity.MyHandler myHandler;

    public void getArea(final Context context) {
        myHandler = new CreateAddressActivity.MyHandler((CreateAddressActivity) context);
        if (thread == null) {//如果已创建就不再重新创建子线程了
            thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    // 写子线程中的操作,解析省市区数据
                    try {
                        String json = toStringTemp(context.getAssets().open("city.json"));
                        area = new Gson().fromJson(json, new TypeToken<ArrayList<AreaProvince>>() {
                        }.getType());
                        Message message = Message.obtain();
                        message.what = Constants.GET_AREA;
                        message.obj = area;
                        myHandler.sendMessage(message);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
        }
    }


    public void addAddress(Context context, String deliveryName, String deliveryTelephone, String provinceId, String cityId, String countyId, String detailedAddress) {
        model.addAddress(deliveryName, deliveryTelephone, provinceId, cityId, countyId, detailedAddress, new HttpGsonCallback<UpdateAddressBean>(context) {
            @Override
            public void onSuccess(UpdateAddressBean data) {
                if (isViewAttached()) {
                    getView().updateData();
                }
            }
        });
    }

    public void updateAddress(Context context, String id, String deliveryName, String deliveryTelephone, String provinceId, String cityId, String countyId, String detailedAddress) {
        model.updateAddress(id, deliveryName, deliveryTelephone, provinceId, cityId, countyId, detailedAddress, new HttpGsonCallback<UpdateAddressBean>(context) {
            @Override
            public void onSuccess(UpdateAddressBean data) {
                if (isViewAttached()) {
                    getView().updateData();
                }
            }
        });
    }

    public String toStringTemp(InputStream is) {
        return toStringOk(is, "utf-8");
    }

    public static String toStringOk(InputStream is, String charset) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, charset));
            while (true) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                } else {
                    sb.append(line).append("\n");
                }
            }
            reader.close();
            is.close();
        } catch (IOException e) {
        }
        return sb.toString();
    }

    @Override
    public void createModel() {
        model = new MinePageModel();
    }

    @Override
    public void cancelNetWork() {
        model.cancel();
    }
}
