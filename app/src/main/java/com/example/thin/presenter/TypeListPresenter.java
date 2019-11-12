package com.example.thin.presenter;

import com.example.thin.base.mvp.BasePresenter;
import com.example.thin.iview.ITypeListView;
import com.example.thin.model.HomePageModel;

/**
 * @Author: xingyan
 * @Date: 2019/11/12
 * @Desc:
 */
public class TypeListPresenter extends BasePresenter<ITypeListView> {
    private HomePageModel model;

//    public void getTypeList(Context context) {
//
//        model.getTypeList(new HttpGsonCallback<List<TypeBean>>(context) {
//            @Override
//            public void onSuccess(List<TypeBean> data) {
//                if (isViewAttached()) {
//                    getView().updateData();
//                }
//            }
//        });
//
//    }

    @Override
    public void createModel() {

        model = new HomePageModel();

    }

    @Override
    public void cancelNetWork() {
        model.cancel();
    }
}
