package com.cloud;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WeightTest {

    @Test
    public void test() {
        List<Integer> list = Arrays.asList(1,2,3,4);
        List<Integer> newList = new ArrayList<>();
        int total = 10;
        int weightSoFar = 0;
        for (Integer a : list) {
            int weight = total - a;
            weightSoFar += weight;
            newList.add(weightSoFar);
        }
        System.out.println(newList);
    }
}
