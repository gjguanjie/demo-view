package com.cloud;

import org.junit.jupiter.api.Test;

public class WhileTest {

    @Test
    public void test() {

        int aa = 5;
        while(true) {
            try {
                if (aa == 1) {
                    return;
                }
                System.out.println(aa);
                aa = aa -1;
            } catch (RuntimeException ex) {
                if (aa == 0) {
                    throw new RuntimeException("特意抛异常");
                }
            }
        }
    }

}
