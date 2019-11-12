package com.example.thin.iview;

import com.example.thin.base.mvp.IBaseView;
import com.example.thin.bean.TypeBean;

import java.util.List;

/**
 * @Author: xingyan
 * @Date: 2019/11/12
 * @Desc:
 */
public interface ITypeListView extends IBaseView {
    void updateData(List<TypeBean> data);
}
