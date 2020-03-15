package com.cloud;

import org.junit.jupiter.api.Test;

public class TestClose {


    @Test
    public void test() {
        int aa = 1;
        while (true) {
            System.out.println("111");
            if (aa ==1) {
                continue;
            }
            System.out.println("2222222");
        }
    }

}
