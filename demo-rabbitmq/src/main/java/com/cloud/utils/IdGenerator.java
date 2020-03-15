package com.cloud.utils;

import java.util.UUID;

public class IdGenerator {

    public static String getNextId() {
        return UUID.randomUUID().toString().replace("-","");
    }
}
