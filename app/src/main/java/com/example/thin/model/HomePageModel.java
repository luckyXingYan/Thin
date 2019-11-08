package com.example.thin.model;

import com.example.thin.base.http.callback.HttpGsonCallback;
import com.example.thin.base.model.BaseModel;
import com.example.thin.bean.DetailDataBean;
import com.example.thin.bean.HotBean;

import java.util.List;

/**
 * @Author: Mr.Z
 * @Date: 2018/9/20
 * @Desc:
 */
public class HomePageModel extends BaseModel {

    //http://172.24.132.216:8093/thinbar-octopus/shop/query?keyWord=测试&isHot=1&pageNo=1&pageSize=10&groupId=1
    public void getHot(String keyWord, String isHot, String groupId, String pageNo, String pageSize, HttpGsonCallback<List<HotBean>> callback) {
//        callback.onStart(false);//可以参数形式传进来，是否显示加载框，默认false
        invoke(apiService.getHot(keyWord, isHot, groupId, pageNo, pageSize), callback);
    }

//    public void getDetailData(String start, String count, HttpGsonCallback<List<DetailDataBean>> callback) {
//        invoke(apiService.getDetailData(start, count), callback);
//    }
//
//    public void getInfoData(String start, String count, HttpGsonCallback<List<DetailDataBean>> callback) {
//        invoke(apiService.getInfoData(start, count), callback);
//    }

}
