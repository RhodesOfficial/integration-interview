package com.calpis.interview.jdk.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Calpis
 * @Description
 * @Date 2021/2/11 15:12
 */
public class HashMapTest {

    public static void main(String[] args) {
        Map<Object, Object> map = new HashMap<>();
        map.put(new A(), new Object());
        map.put(new A(), new Object());
        map.put(new A(), new Object());
        map.put(new A(), new Object());
        map.put(new A(), new Object());
        map.put(new A(), new Object());
        map.put(new A(), new Object());
        map.put(new A(), new Object());
//        map.put(new A(), new Object());
        System.out.println(map.size());
    }

    static class A {
        @Override
        public int hashCode() {
            return 39;
        }
    }

}
