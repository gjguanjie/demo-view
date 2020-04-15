package com.cloud.event;

import com.google.common.eventbus.EventBus;

public class EventCenter {

    private static EventBus eventBus = new EventBus();

    private EventCenter(){}

    public static EventBus getInstance() {
        return eventBus;
    }

    public static void register(Object obj) {
        eventBus.register(obj);
    }

    public static void unRegister(Object obj) {
        eventBus.unregister(obj);
    }

    public static void post(Object obj) {
        eventBus.post(obj);
    }
}
