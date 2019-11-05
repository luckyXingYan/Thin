package com.example.thin.iview;

import com.example.thin.base.mvp.IBaseView;
import com.example.thin.bean.RegisterLoginBean;

/**
 * @Author: xingyan
 * @Date: 2019/11/5
 * @Desc:
 */
public interface IRegisterView extends IBaseView {
    void registerSuccess(RegisterLoginBean data);
}
