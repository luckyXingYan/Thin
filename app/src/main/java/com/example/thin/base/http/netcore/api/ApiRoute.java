package com.example.thin.base.http.netcore.api;

/**
 * <br>包名：com.netcore.api
 * <br>项目名称：NetCore
 * <br>描述：服务器api访问路径定义
 * <br>创建人：BaoZhi
 * <br>创建时间：2016/8/19 0019 11:25
 */
public class ApiRoute {

    //http://172.24.132.216:8093/thinbar-octopus/api/user/register/userRegister
    //http://172.24.132.216:8093/thinbar-octopus/shop/query?keyWord=测试&isHot=1&pageNo=1&pageSize=10&groupId=1

    // // http://172.24.132.216:8093/thinbar-octopus/api/product/productClassIfyQuery

    private static final String COMMON_ROOT = "/thinbar-octopus";

    public final class INDEX {
        private static final String ROOT = COMMON_ROOT + "/shop";

        public static final String HOME_HOT = ROOT + "/query";
        public static final String SHOP_DETAIL = ROOT + "/detail";
    }

    public final class USER {
        private static final String ROOT = COMMON_ROOT + "/api/user";

        public static final String REGISTER = ROOT + "/register/userRegister";
        public static final String LOGIN = ROOT + "/login/userLogin";
        public static final String EVALUATE = ROOT + "/evaluating/userEvaluating";
    }

    public final class PRODUCT {
        private static final String ROOT = COMMON_ROOT + "/product";

        public static final String TYPE_LIST = ROOT + "/api/productClassIfyQuery";
        public static final String PRO_DETAIL = ROOT + "/detail";
    }

    public final class ADDRESS {
        private static final String ROOT = COMMON_ROOT + "/api/address";

        public static final String ADD_ADDRESS = ROOT + "/addressList";
        public static final String UPDATE_ADDRESS = ROOT + "/updateAddress";
    }

}