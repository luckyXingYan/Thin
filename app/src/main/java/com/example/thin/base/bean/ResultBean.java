package com.example.thin.base.bean;

/************************************************************
 *  @author     : zhouwenhao@yingu.com Hale
 *  @date       : 2018/10/25
 *  description :   code:响应码  成功：0000  失败：3000
 ************************************************************/
public class ResultBean<T> {
    public static final int STATE_SUCCESS = 0000;
    public static final int STATE_FAILURE = 3000;
    public static final int REGISTER_FAILURE = 4017;
    private int code;//模拟成功
    private T data;
    private String message;


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ResultBean{" +
                "code=" + code +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }
}
