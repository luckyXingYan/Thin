package com.example.thin.eventbus;

/**
 * @Author: xingyan
 * @Date: 2019/10/31
 * @Desc: 通知更新 并且传递 string 数据标识
 */
public class MessageEvent {
    public final String message;

    public static MessageEvent getInstance(String message) {
        return new MessageEvent(message);
    }

    private MessageEvent(String message) {
        this.message = message;
    }
}
