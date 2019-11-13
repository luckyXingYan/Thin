package com.example.thin.activity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.thin.R;
import com.example.thin.base.BaseScrollTitleBarActivity;
import com.example.thin.base.mvp.BasePresenter;
import com.example.thin.base.mvp.IBaseView;
import com.example.thin.bean.ShopCartBean;
import com.example.thin.bean.TotalPriceNumBean;
import com.example.thin.bean.UpdateAddressBean;
import com.example.thin.iview.IUpdateAddressView;
import com.example.thin.presenter.UpdateAddressPresenter;
import com.example.thin.util.Constants;
import com.example.thin.util.InputVerifyUtil;
import com.example.thin.util.LocalUser;
import com.example.thin.widget.addresspicker.AddressPicker;
import com.example.thin.widget.addresspicker.OnLinkageListener;
import com.example.thin.widget.addresspicker.bean.AreaCity;
import com.example.thin.widget.addresspicker.bean.AreaCounty;
import com.example.thin.widget.addresspicker.bean.AreaProvince;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * @Author: xingyan
 * @Date: 2019/10/22
 * @Desc:
 */
public class CreateAddressActivity extends BaseScrollTitleBarActivity<UpdateAddressPresenter> implements IUpdateAddressView, View.OnClickListener {
    private Button save;
    private EditText detail, consignee, phone;
    private TextView area;
    private String deliveryName, deliveryTelephone, provinceId, cityId, countyId, detailedAddress, areaStr;
    private List<AreaProvince> areaList;
    private String provinceName = "";//省名字
    private String cityName = "";//城市名字
    private String countyName = "";//县名字
    private String addressTempStr;
    private UpdateAddressBean addressBean;

    public static void open(Context context, UpdateAddressBean addressBean) {
        Intent intent = new Intent(context, CreateAddressActivity.class);
        intent.putExtra(Constants.ADDRESS_ID, addressBean);
        context.startActivity(intent);
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_create_address;
    }

    @Override
    protected void initContentView() {
        addressBean = (UpdateAddressBean) getIntent().getSerializableExtra(Constants.ADDRESS_ID);
        mTitleBar.setTitle("新建收货地址");
        save = getView(R.id.btn_save_address);
        consignee = getView(R.id.et_consignee);
        phone = getView(R.id.et_phone);
        area = getView(R.id.tv_area);
        detail = getView(R.id.et_detail);
        save.setOnClickListener(this);
        area.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        presenter.getArea(this);
        if (addressBean != null) {
        }

    }

    @Override
    protected UpdateAddressPresenter createPresenter() {
        return new UpdateAddressPresenter();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_area://所在地区
                if (hasPermission(Manifest.permission.READ_EXTERNAL_STORAGE)) {
                    doSDCardPermission();
                } else {
                    requestPermission(Constants.READ_EXTERNAL_STORAGE_CODE, Manifest.permission.READ_EXTERNAL_STORAGE);
                }
                break;
            case R.id.btn_save_address://保存
                deliveryName = consignee.getText().toString().trim();
                deliveryTelephone = phone.getText().toString().trim();
                areaStr = area.getText().toString().trim();
                detailedAddress = detail.getText().toString().trim();

                String hintMsg = InputVerifyUtil.checkUpdateAddress(deliveryName, deliveryTelephone, areaStr, detailedAddress);
                if (Constants.INPUT_OK.equals(hintMsg)) {
                    if (addressBean != null) {
                        presenter.updateAddress(this, addressBean.id, deliveryName, deliveryTelephone, provinceId, cityId, countyId, detailedAddress);
                    } else {
                        presenter.addAddress(this, deliveryName, deliveryTelephone, provinceId, cityId, countyId, detailedAddress);
                    }
                } else {
                    showToastMsg(hintMsg);
                }
                break;
            default:
                break;
        }
    }

    @Override
    protected void doSDCardPermission() {
        if (areaList != null && areaList.size() > 0) {
            //设置所属区域
            setAreaAddress();
        } else {
            showToastMsg("区域数据解析失败");
        }
    }

    private void setAreaAddress() {
        AddressPicker picker = new AddressPicker(this, areaList);
        picker.setHideProvince(false);
        picker.setHideCounty(false);
        picker.setCanLoop(false);
        picker.setWheelModeEnable(true);
        picker.setColumnWeight(2 / 8.0f, 3 / 8.0f, 3 / 8.0f);//省级、地级和县级的比例为2:3:3
        picker.setSelectedItem(provinceName, cityName, countyName);
        picker.setOnLinkageListener(new OnLinkageListener() {
            @Override
            public void onAddressPicked(AreaProvince province, AreaCity city, AreaCounty county) {
                area.setText(province.getAreaName() + city.getAreaName() + county.getAreaName());
                addressTempStr = province.getAreaName() + "," + city.getAreaName() + "," + county.getAreaName();

                provinceName = province.getAreaName();
                cityName = city.getAreaName();
                countyName = county.getAreaName();
            }
        });
        picker.show();
    }

    @Override
    public void updateData() {
        finish();
    }

    public static class MyHandler extends Handler {
        WeakReference<CreateAddressActivity> mWeakReference;

        public MyHandler(CreateAddressActivity activity) {
            mWeakReference = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            CreateAddressActivity activity = mWeakReference.get();
            if (activity == null) {
                return;
            }
            switch (msg.what) {
                case Constants.GET_AREA:
                    List<AreaProvince> area = (List<AreaProvince>) msg.obj;
                    activity.areaList = area;
                    break;
                default:
                    break;
            }
        }
    }
}
