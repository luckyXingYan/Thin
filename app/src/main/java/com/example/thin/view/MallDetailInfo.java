package com.example.thin.view;

import android.content.Context;

import com.example.thin.R;
import com.example.thin.bean.HotBean;

/**
 * @Author: xingyan
 * @Date: 2019/10/22
 * @Desc:
 */
public class MallDetailInfo extends BaseHomeLayout<HotBean> {
    public MallDetailInfo(Context context) {
        super(context);
    }

    @Override
    protected void init() {
        inflate(getContext(), R.layout.layout_mall_detail_info, this);
    }

    @Override
    public void setData(HotBean data) {

    }
}
