package com.cloud.event;

import com.google.common.eventbus.Subscribe;

public class DataObserver {

    @Subscribe
    public void print(String msg) {
        System.out.println("pring message:" + msg);
    }
}
