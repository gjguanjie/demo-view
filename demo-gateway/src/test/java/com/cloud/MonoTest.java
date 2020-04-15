package com.cloud;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public class MonoTest {

    @Test
    public void test() throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        Mono<String> mono = Mono.fromCallable(() -> "aa");
        mono.map(aa -> {
            System.out.println(aa);
            System.out.println(Thread.currentThread().getName());
            return aa;
        });
        Thread.sleep(1000000);
    }
}
