package com.calpis.interview.algorithm.tencent;

/*
牛家村的货币是一种很神奇的连续货币。

他们货币的最大面额是n，并且一共有面额为1，面额为2.....面额为n，n种面额的货币。

牛牛每次购买商品都会带上所有面额的货币，支付时会选择给出硬币数量最小的方案。

现在告诉你牛牛将要购买的商品的价格，你能算出牛牛支付的硬币数量吗？ (假设牛牛每种面额的货币都拥有无限个。)

输入格式

共一行，包含两个整数n和m，分别表示货币的最大面额以及商品的价格。

输出格式

一个整数表示牛牛支付的硬币数量。

数据范围

1≤n≤1051≤n≤105,
1≤m≤1091≤m≤109

输入样例1：

6 7
输出样例1：

2
输入样例2：

4 10
输出样例2：

3
 */
public class Coin {

    public static void main(String[] args) {
        String[] split = args[0].split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);

        if (n >= m) {
            System.out.println(1);
        } else {
            if (m % n == 0) {
                System.out.println(m / n);
            } else {
                System.out.println(m / n + 1);
            }
        }
    }
}
