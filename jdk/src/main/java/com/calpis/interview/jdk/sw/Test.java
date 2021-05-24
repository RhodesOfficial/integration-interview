package com.calpis.interview.jdk.sw;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author Calpis
 * @Description
 * @Date 2021/5/23 1:37
 */
public class Test {

    public static void main(String[] args) {
        /**
         * "RRU"
         * [[5, 5], [9, 4], [9, 7], [6, 4], [7, 0], [9, 5], [10, 7], [1, 1], [7, 5]]
         * 1486
         * 743
         */
        System.out.println(robot("RRU", new int[][]{{5, 5}, {9, 4}, {9, 7}, {6, 4}, {7, 0}, {9, 5}, {10, 7}, {1, 1}, {7, 5}}, 1486, 743));
    }

    public static boolean robot(String command, int[][] obstacles, int x, int y) {
        int xx = 0, yy = 0;
        // 先走一圈，记录路径
        Set<Long> set = new HashSet<>();
        set.add(0L);
        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == 'U') {
                yy++;
            } else {
                xx++;
            }
            set.add(((long) xx << 30) | yy);
        }
        // 假设我要到(2,4)这个点，路径是RUU，每次XX=1，yy=2，那么意味着至少循环Math.min(x / xx,y / yy) = 2次
        // 终点的xx，yy减去该值，结果看看在不在路径内
        int min = Math.min(x / xx, y / yy);
        if (!set.contains(((long) (x - min * xx) << 30) | (y - min * yy))) {
            return false;
        }
        // 检查障碍物
        for (int[] obstacle : obstacles) {
            int ox = obstacle[0];
            int oy = obstacle[1];
            if (ox > x || oy > y) {
                continue;
            }
            min = Math.min(ox / xx, oy / yy);
            if (set.contains(((long) (ox - min * xx) << 30) | (oy - min * yy))) {
                return false;
            }
        }
        return true;
    }

    public static boolean robot0(String command, int[][] obstacles, int x, int y) {
        //多次循环 找到模式
        //学到了新的存储坐标的方法  左坐标左移30 | 右坐标
        int xx=0,yy=0;
        Set<Long> ss=new HashSet<>();
        ss.add(((long)xx << 30) | yy);
        for(int i=0;i<command.length();i++){
            if(command.charAt(i)=='U'){
                yy++;
            }else{
                xx++;
            }
            ss.add(((long)xx << 30) | yy);
        }
        int cir=Math.min(x/xx,y/yy);
        if(ss.contains(((long)(x-cir*xx) << 30) | (y-cir*yy))==false){
            return false;
        }
        for(int[] s:obstacles){
            if(s.length!=2) continue;
            int x1=s[0];
            int y1=s[1];
            if(x1 >x || y1>y) continue;
            cir=Math.min(x1/xx,y1/yy);
            if(ss.contains(((long)(x1-cir*xx) << 30) | (y1-cir*yy))==true){
                return false;
            }
        }
        return true;
    }
}
