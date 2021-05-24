package com.calpis.interview.algorithm.tencent;

/*
小 Q 在进行射击气球的游戏，如果小 Q 在连续 T 枪中打爆了所有颜色的气球，将得到一只 QQ 公仔作为奖励。（每种颜色的球至少被打爆一只）。

这个游戏中有 m 种不同颜色的气球，编号 1 到 m。

小 Q 一共有 n 发子弹，然后连续开了 n 枪。

小 Q 想知道在这 n 枪中，打爆所有颜色的气球最少用了连续几枪？

输入格式
第一行包含两个整数 n 和 m。

第二行包含 n 个整数，分别表示每一枪打中的气球的颜色，0 表示没打中任何颜色的气球。

输出格式
一个整数表示小 Q 打爆所有颜色气球用的最少枪数。

如果小 Q 无法在这 n 枪打爆所有颜色的气球，则输出 −1。

输入样例：
12  5
2 5 3 1 3 2 4 1 0 5 4 3
输出样例：
6
样例解释
有五种颜色的气球，编号 1 到 5。

游客从第二枪开始直到第七枪，这连续六枪打爆了 5 3 1 3 2 4 这几种颜色的气球，包含了从 1 到 5 的所有颜色，所以最少枪数为 6。
 */
public class BalloonGame {

    public static void main(String[] args) {
        String[] args1 = args[0].split(" {2}");
        String[] args2 = args[1].split(" ");
        // n发子弹
        int n = Integer.parseInt(args1[0]);
        // m种气球
        int m = Integer.parseInt(args1[1]);
        // 气球序列
        int[] arr = new int[args2.length];
        for (int i = 0; i < args2.length; i++) {
            arr[i] = Integer.parseInt(args2[i]);
        }
        // 已戳破的颜色
        int colors = 0;
        // 戳破气球的计数表
        int[] count = new int[n];
        // 右指针
        int j = 0;
        // 维护最小值
        int min = Integer.MAX_VALUE;
        // 是否全部戳破
        boolean flag = false;
        // 左指针
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0 && count[arr[i]] == 0) {
                colors++;
            }
            count[arr[i]]++;
            if (colors == m) {
                flag = true;
                while (arr[j] == 0 || count[arr[j]] > 1) {
                    j++;
                    count[arr[j]]--;
                }
                min = Math.min(min, i - j + 1);
            }
        }
        System.out.println(flag ? min : -1);
    }




    /*
    // 开n枪
        int n = Integer.parseInt(split[0]);
        // 共m种气球
        int m = Integer.parseInt(split[1]);
        // 气球序列
        int[] arr = new int[sr.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(sr[i]);
        }
        // 是否能拿到公仔
        boolean flag = false;
        // 点亮的颜色
        int colors = 0;
        // j-右指针
        int j = 0;
        int res = Integer.MAX_VALUE;
        // 记录戳破了几次
        int[] count = new int[n];
        // i-左指针
        for (int i = 0; i < n; i++) {
            // 戳了非0的气球，而且是第一次戳破
            if (arr[i] > 0 && count[arr[i]] == 0) {
                colors++;
            }
            count[arr[i]]++;
            if (colors == m) {
                // 凑齐了
                flag = true;
                // 开始收缩窗口
                // 戳了个寂寞的可以收缩
                // 戳破次数大于1的可以收缩
                while (arr[j] == 0 || count[arr[j]] > 1) {
                    count[arr[j]]--;
                    j++;
                }
                res = Math.min(i - j + 1, res);
            }
        }
        System.out.println(flag ? res : -1);
     */
}
