package com.calpis.interview.jdk;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author Calpis
 * @Description
 * @Date 2021/2/16 16:55
 */
public class distinct {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            list.add(new Random().nextInt(100));
        }

        List<Integer> copy1 = new ArrayList<>(list);
        long start = System.currentTimeMillis();
        List<Integer> res1 = copy1.stream().distinct().collect(Collectors.toList());
        System.out.println(res1.size());
        System.out.printf("stream time=%d", System.currentTimeMillis() - start);
        System.out.println();

        start = System.currentTimeMillis();
        List<Integer> copy2 = new ArrayList<>(list);
        ArrayList<Integer> res2 = new ArrayList<>(new HashSet<>(copy2));
        System.out.println(res2.size());
        System.out.printf("set time=%d", System.currentTimeMillis() - start);
        System.out.println();

        start = System.currentTimeMillis();
        List<Integer> copy3 = new ArrayList<>(list);
        Collections.sort(copy3);
        int p = 0, q = 1;
        while (q < copy3.size()) {
            if (!copy3.get(p).equals(copy3.get(q))) {
                p++;
                copy3.set(p, copy3.get(q));
            }
            q++;
        }
        List<Integer> res3 = copy3.subList(0, p + 1);
        System.out.println(res3.size());
        System.out.printf("algorithm time=%d", System.currentTimeMillis() - start);
        System.out.println();


    }
}
