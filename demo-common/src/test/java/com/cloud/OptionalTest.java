package com.cloud;

import org.junit.jupiter.api.Test;

import java.util.Optional;

public class OptionalTest {

    @Test
    public void test() {
        Optional<String> optional = Optional.of(null);
        if (optional.isPresent()) {
            System.out.println(optional.get());
        } else {
            System.out.println(optional.orElse("1111"));
        }
    }
}
