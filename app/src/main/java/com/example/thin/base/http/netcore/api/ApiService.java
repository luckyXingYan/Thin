package com.example.thin.base.http.netcore.api;

import com.example.thin.base.bean.ResultBean;
import com.example.thin.bean.DetailDataBean;
import com.example.thin.bean.HomeDataBean;
import com.example.thin.bean.ProductDataBean;
import com.example.thin.bean.RegisterLoginBean;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * <br>包名：com.netcore
 * <br>项目名称：JR
 * <br>描述：服务器api
 * <br>创建人：BaoZhi
 * <br>创建时间：2016/8/16 0016 16:10
 */
public interface ApiService {

    // 获取首页红包状态
    //#https://douban.uieee.com/v2/movie/top250?start=0&count=10即可。
    @FormUrlEncoded
    @POST(ApiRoute.PRODUCT.GET_HOMEPAGE_REDPACKETS_STATUS)
    Call<ResultBean<List<HomeDataBean>>> getHomePageData(@Field(ApiKeys.START) String start, @Field(ApiKeys.COUNT) String count);

    @FormUrlEncoded
    @POST(ApiRoute.PRODUCT.GET_HOMEPAGE_REDPACKETS_STATUS)
    Call<ResultBean<List<DetailDataBean>>> getDetailData(@Field(ApiKeys.START) String start, @Field(ApiKeys.COUNT) String count);

    @FormUrlEncoded
    @POST(ApiRoute.PRODUCT.GET_HOMEPAGE_REDPACKETS_STATUS)
    Call<ResultBean<List<DetailDataBean>>> getInfoData(@Field(ApiKeys.START) String start, @Field(ApiKeys.COUNT) String count);

    @FormUrlEncoded
    @POST(ApiRoute.PRODUCT.GET_HOMEPAGE_REDPACKETS_STATUS)
    Call<ResultBean<List<ProductDataBean>>> getProductPageData(@Field(ApiKeys.START) String start, @Field(ApiKeys.COUNT) String count);

    @FormUrlEncoded
    @POST(ApiRoute.USER.REGISTER)
    Call<ResultBean<RegisterLoginBean>> register(@Field(ApiKeys.MOBILE) String mobile, @Field(ApiKeys.PASSWORD) String password);

    @FormUrlEncoded
    @POST(ApiRoute.USER.LOGIN)
    Call<ResultBean<RegisterLoginBean>> login(@Field(ApiKeys.MOBILE) String mobile, @Field(ApiKeys.PASSWORD) String password);

    @FormUrlEncoded
    @POST(ApiRoute.USER.EVALUATE)
    Call<ResultBean<RegisterLoginBean>> evaluate(@Field(ApiKeys.NICK_NAME) String nickName, @Field(ApiKeys.SEX) String sex,
                                                 @Field(ApiKeys.HEIGHT) String height, @Field(ApiKeys.TARGET_WEIGHT) String targetWeight,
                                                 @Field(ApiKeys.CONCERN_POSITION) String concernPosition);
}