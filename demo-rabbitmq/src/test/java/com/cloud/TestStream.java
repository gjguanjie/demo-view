package com.cloud;

import org.junit.jupiter.api.Test;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TestStream {

    @Test
    public void test() {
        List<TestVO> list = new ArrayList<>();
        TestVO vo1 = new TestVO("1","a1");
        TestVO vo2 = new TestVO("2","a2");
        list.add(vo1);
        list.add(vo2);
        List<TestVO> newLIst = CollectionUtils.isEmpty(list)? new ArrayList<>() : list.stream()
                .filter(item -> item.getId().equals("1"))
                .collect(Collectors.toList());

        System.out.println(newLIst.size());
    }
}
