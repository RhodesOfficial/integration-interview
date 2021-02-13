package com.calpis.interview.jdk.sw;

import com.calpis.interview.jdk.enums.DemoEnums;


/**
 * @Author Calpis
 * @Description
 * @Date 2021/2/13 16:56
 */
public class SwitchTest {

    public static void main(String[] args) {
        // 只支持<=int的数据类型
        byte b = 1;
        short sh = 1;
        char c = 1;
        int i = 1;
        long l = 1L;
        float f = 1F;
        double d = 1D;
        String st = "1";
        DemoEnums demoEnums = DemoEnums.TEST;
        switch (demoEnums) {
            case TEST:
                System.out.println("hello world");
        }
    }

}
