package com.example.thin.base.http.callback;

import android.util.Log;

import com.example.thin.BuildConfig;
import com.example.thin.MyApp;
import com.example.thin.base.bean.ResultBean;
import com.example.thin.base.util.ToastUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/************************************************************
 *  @author     : zhouwenhao@yingu.com Hale
 *  @date       : 2018/10/25
 *  description :
 ************************************************************/
public abstract class BaseGsonCallback<T> implements Callback<ResultBean<T>> {

    @Override
    public void onResponse(Call<ResultBean<T>> call, Response<ResultBean<T>> response) {
        if (response.isSuccessful()) {
            dealResponseSuccess(response.body());
        } else {
            dealResponseFailed(response);
        }
    }

    @Override
    public void onFailure(Call<ResultBean<T>> call, Throwable t) {
        onConnectionFailed();
        t.printStackTrace();
        Log.e("gson,接口调用失败:", t.getMessage());
    }

    private void dealResponseSuccess(ResultBean<T> model) {
        int state = model.getCode();
        switch (state) {
            case ResultBean.STATE_SUCCESS:
                T data = model.getData();
                onSuccess(data);
                break;
            case ResultBean.STATE_FAILURE:
//                ResultBean.ErrorObject error = model.getErrorObj();
//                if (error != null) {
//                    int errorCode = error.getCode();
//                    String errorMsg = error.getMsg();
//                    if (errorCode == ErrorCode.STOP_TAKING_CODE) {
////                        EventBus.getDefault().post(new StopTakingMsgData(errorMsg));
//                    } else if (errorCode == ErrorCode.DEVICE_LOGIN_LIMIT) {
////                        EventBus.getDefault().post(new DeviceLoginLimitExpiredData(errorMsg));
//                    } else {
//                        onBizFailed(errorCode, errorMsg);
//                    }
//                } else {
//                    onBizFailed(-10, "服务器返回错误");
//                }
                onBizFailed(state, model.getMessage());
                break;
            case ResultBean.REGISTER_FAILURE://注册用户已存在
                onBizFailed(state, model.getMessage());
                break;
            default:
                onBizFailed(-10, "网络请求失败");
        }

    }

    private void dealResponseFailed(Response<ResultBean<T>> response) {
        Log.i("LOG_HTTP", "[BaseGsonCallback] 接口返回错误 code=" + response.code());
        switch (response.code()) {
            case 401:  //Cookie过期
                onCookieExpired();
                break;
            case 403://停服通知
                onStopService("");
                break;
            case 543:
//                EventBus.getDefault().post(new DeviceLoginLimitExpiredData(""));
                break;
            default: //网络连接异常
                onConnectionFailed();
                break;
        }
    }

    public abstract void onSuccess(T data);


    public abstract void onBizFailed(int code, String errorMsg);

    public abstract void onCookieExpired();

    public abstract void onStopService(String msg);

    public abstract void onConnectionFailed();

}
