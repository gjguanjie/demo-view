package com.cloud;

import com.cloud.event.DataObserver;
import com.cloud.event.EventCenter;
import com.google.common.eventbus.EventBus;
import org.junit.jupiter.api.Test;

public class EventTest {

    @Test
    public void testEvent() {
        EventBus center = EventCenter.getInstance();
        DataObserver observer = new DataObserver();
        center.register(observer);
        center.post("event");
    }
}
