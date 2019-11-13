package com.example.thin.base.http.netcore.api;

import com.example.thin.base.bean.ResultBean;
import com.example.thin.bean.CartBean;
import com.example.thin.bean.CommonBean;
import com.example.thin.bean.GoodsBean;
import com.example.thin.bean.ShopBean;
import com.example.thin.bean.RegisterLoginBean;
import com.example.thin.bean.TypeBean;
import com.example.thin.bean.UpdateAddressBean;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * <br>包名：com.netcore
 * <br>项目名称：JR
 * <br>描述：服务器api
 * <br>创建人：BaoZhi
 * <br>创建时间：2016/8/16 0016 16:10
 */
public interface ApiService {

    //http://172.24.132.216:8093/thinbar-octopus/shop/query?keyWord=测试&isHot=1&pageNo=1&pageSize=10&groupId=1
    @GET(ApiRoute.INDEX.HOME_HOT)
    Call<ResultBean<List<ShopBean>>> getHot(@Query(ApiKeys.KEY_WORD) String keyWord, @Query(ApiKeys.IS_HOT) String isHot, @Query(ApiKeys.GROUP_ID) String groupId, @Query(ApiKeys.PAGENUM) String pageNo, @Query(ApiKeys.PAGESIZE) String pageSize);

    @POST(ApiRoute.PRODUCT.TYPE_LIST)
    Call<ResultBean<List<TypeBean>>> getTypeList();

    @FormUrlEncoded
    @POST(ApiRoute.USER.REGISTER)
    Call<ResultBean<RegisterLoginBean>> register(@Field(ApiKeys.MOBILE) String mobile, @Field(ApiKeys.PASSWORD) String password);

    @FormUrlEncoded
    @POST(ApiRoute.USER.LOGIN)
    Call<ResultBean<RegisterLoginBean>> login(@Field(ApiKeys.MOBILE) String mobile, @Field(ApiKeys.PASSWORD) String password);

    @FormUrlEncoded
    @POST(ApiRoute.USER.EVALUATE)
    Call<ResultBean<RegisterLoginBean>> evaluate(@Field(ApiKeys.NICK_NAME) String nickname, @Field(ApiKeys.SEX) String sex,
                                                 @Field(ApiKeys.HEIGHT) String height, @Field(ApiKeys.TARGET_WEIGHT) String targetWeight,
                                                 @Field(ApiKeys.CONCERN_POSITION) String concernPosition);

    @GET(ApiRoute.INDEX.SHOP_DETAIL)
    Call<ResultBean<ShopBean>> shopDetail(@Query(ApiKeys.ID) String id);

    @GET(ApiRoute.PRODUCT.PRO_DETAIL)
    Call<ResultBean<GoodsBean>> goodsDetail(@Query(ApiKeys.ID) String id);

    @FormUrlEncoded
    @POST(ApiRoute.ADDRESS.ADD_ADDRESS)
    Call<ResultBean<UpdateAddressBean>> addAddress(@Field(ApiKeys.DELIVERY_NAME) String deliveryName, @Field(ApiKeys.DELIVERY_TELEPHONE) String deliveryTelephone,
                                                   @Field(ApiKeys.PROVINCE_ID) String provinceId,
                                                   @Field(ApiKeys.CITY_ID) String cityId, @Field(ApiKeys.COUNTY_ID) String countyId,
                                                   @Field(ApiKeys.DETAILED_ADDRESS) String detailedAddress);

    @FormUrlEncoded
    @POST(ApiRoute.ADDRESS.UPDATE_ADDRESS)
    Call<ResultBean<UpdateAddressBean>> updateAddress(@Field(ApiKeys.ID) String id, @Field(ApiKeys.DELIVERY_NAME) String deliveryName, @Field(ApiKeys.DELIVERY_TELEPHONE) String deliveryTelephone,
                                                      @Field(ApiKeys.PROVINCE_ID) String provinceId,
                                                      @Field(ApiKeys.CITY_ID) String cityId, @Field(ApiKeys.COUNTY_ID) String countyId,
                                                      @Field(ApiKeys.DETAILED_ADDRESS) String detailedAddress);

    @FormUrlEncoded
    @POST(ApiRoute.USER.ADD_CART)
    Call<ResultBean<CommonBean>> addCart(@Field(ApiKeys.PRODUCT_ID) String productId, @Field(ApiKeys.COUNT) String count);

    @POST(ApiRoute.USER.CART_LIST)
    Call<ResultBean<CartBean>> cartList();

}