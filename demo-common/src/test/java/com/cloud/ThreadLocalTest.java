package com.cloud;

import org.junit.jupiter.api.Test;

public class ThreadLocalTest {

    @Test
    public void test() {
        ThreadLocal<String> local1 = new ThreadLocal<>();
        ThreadLocal<String> local2 = new ThreadLocal<>();
        local1.set("111");
        local2.set("222");
    }
}
