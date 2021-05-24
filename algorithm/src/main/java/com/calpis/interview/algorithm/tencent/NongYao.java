package com.calpis.interview.algorithm.tencent;

/*
妞妞最近迷上了王者荣耀。

小Q得到了一个奇妙的数列，这个数列有无限多项，数列中的第 i 个数字为i∗(−1)ii∗(−1)i，比如数列的前几项为-1，2，-3，4，-5…

小Q兴奋把这个数列拿去给妞妞看，并希望借此邀请妞妞吃饭。

妞妞想了想，对小Q说：“对于这个数列，我每次询问你一个区间，你在1秒内把这个区间里的数字的和告诉我，如果你答得上来我就跟你一起去吃饭。”

由于妞妞最近沉迷王者荣耀，已经很久都没理过小Q了，所以小Q不想失去这次珍贵的机会，你能帮帮他吗？

输入格式

第一行，一个整数 q，表示妞妞的询问次数。

接下来 q 行，每行两个整数 l 和 r，表示妞妞询问的区间的左端点和右端点。

输出格式

共 q 行，每行一个整数，表示妞妞询问的区间和。

数据范围

1≤q≤1051≤q≤105,
1≤l≤r≤1091≤l≤r≤109

输入样例1：

4
2 4
2 2
3 3
1 5
输出样例1：

3
2
-3
-3
输入样例2：

1
1 1000000000
输出样例2：

500000000
 */
public class NongYao {

    public static void main(String[] args) {
        int q = Integer.parseInt(args[0]);
        for (int i = 0; i < q; i++) {
            String[] arg = args[i + 1].split(" ");
            int left = Integer.parseInt(arg[0]);
            int right = Integer.parseInt(arg[1]);
            // 计算前偶数项合
            int k = (right - left + 1) / 2;
            int res = (left & 2) == 0 ? -k : k;
            // 补n
            if ((right - left + 1) % 2 == 1) {
                if ((right % 2) == 0) {
                    res += right;
                } else {
                    res -= right;
                }
            }
            System.out.println(res);
        }
    }
}
