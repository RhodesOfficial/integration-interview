package com.calpis.interview.kafka;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author Calpis
 * @Description
 * @Date 2021/2/16 0:01
 */
public class Test {

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1, 1, 1, 2, 3, 4, 5);
        List<Integer> collect = integerList.stream().distinct().collect(Collectors.toList());
        System.out.println(collect);
    }
}
