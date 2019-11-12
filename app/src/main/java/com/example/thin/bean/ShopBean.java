package com.example.thin.bean;

import com.example.thin.base.bean.BaseBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xingyan
 * @Date: 2019/7/31
 * @Desc:
 */
public class ShopBean extends BaseBean implements Serializable {
    /**
     * id : 1
     * shopName : 瘦身
     * telephone : 1
     * averageConsumption : 1.0
     * shopLogo : http://yingufile-private.oss-cn-beijing.aliyuncs.com/thinbar/png/20191105/e8eb86f123732daab2d6ab4041306a54
     * shopStatus : 1
     */

    public String id;
    public String shopName;
    public String telephone;
    public String averageConsumption;
    public String shopLogo;
    public String shopStatus;
    public String address;
    public List<GoodsBean> list = new ArrayList<>();
}
