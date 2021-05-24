package com.calpis.interview.algorithm;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author Calpis
 * @Description
 * @Date 2021/3/27 12:42
 */
public class Test2 {

    public static void main(String[] args) throws InterruptedException {
        // 奇数 5 8
        int[] arr = {4, 5, 5, 5, 4, 7, 6, 8, 6, 7, 7, 7};
//        int eor = 0;
//        for (int i = 0; i < arr.length; i++) {
//            eor ^= arr[i];
//        }
//        int eor1 = 0;
//        int rightOne = eor & (~eor + 1);
//        for (int i = 0; i < arr.length; i++) {
//            if ((arr[i] & rightOne) != 0) {
//                eor1 ^= arr[i];
//            }
//        }
//        int eor2 = eor ^ eor1;
//        System.out.println(eor1);
//        System.out.println(eor2);
//        System.out.println(Arrays.toString(singleNumber(arr)));
//        System.out.println(fizzBuzz(1));
        System.out.println(numRabbits(new int[]{10, 10, 10}));
    }

    public static int numRabbits(int[] answers) {
        int len = answers.length;
        if (len == 0) {
            return 0;
        }
        int res = 0, cur, count;
        Arrays.sort(answers);
        for (int i = 0; i < len; i++) {
            res += answers[i] + 1;
            cur = answers[i];
            count = answers[i];
            while (i < len - 1 && cur == answers[i + 1] && count > 0) {
                i++;
                count--;
            }
        }
        return res;
    }

    private static boolean[] visited;
    private static List<String> res;
    private static String s;

    public static String[] permutation(String s) {
        visited = new boolean[s.length()];
        res = new ArrayList<>();
        Test2.s = s;
        dfs(new StringBuilder());
        return res.toArray(new String[0]);
    }

    private static void dfs(StringBuilder path) {
        if (path.length() == s.length()) {
            res.add(path.toString());
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                path.append(s.charAt(i));
                dfs(path);
                path.deleteCharAt(path.length() - 1);
                visited[i] = false;
            }
        }
    }

    public int cuttingRope(int n) {
        BigInteger[] dp = new BigInteger[n + 1];
        // 1 * 1 = 1
        Arrays.fill(dp, BigInteger.valueOf(1));
        for (int i = 3; i <= n; i++) {
            // 从1开始
            for (int j = 1; j < i; j++) {
                // 剪或者不剪
                dp[i] = dp[i].max(
                        BigInteger.valueOf(j * (i - j))).max(
                        dp[i - j].multiply(BigInteger.valueOf(j)));
            }
        }
        return dp[n].mod(BigInteger.valueOf(1000000007)).intValue();
    }

    public String minNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int num : nums) {
            list.add(String.valueOf(num));
        }
        list.sort((o1, o2) -> (o1 + o2).compareTo((o2 + o1)));
        return String.join("", list);
    }

    public static List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                res.add("FizzBuzz");
            } else if (i % 3 == 0) {
                res.add("Fizz");
            } else if (i % 5 == 0) {
                res.add("Buzz");
            } else {
                res.add(i + "");
            }
        }
        return res;
    }

    public static int[] singleNumber(int[] nums) {
        /**
         有两个数只出现了一次记为 num1、num2 初始化为 0, 其余的数出现了两次,
         我们可以对所有的数进行一次异或操作, 易知这个结果就等于 num1 和 num2
         的异或结果(相同的数异或结果都为 0, 0和任意数异或结果都为那个数).

         那么我可以考虑异或结果的某个非 0 位如最后一个非 0 位, 因为我们知道只
         有当 num1、num2 在该位不一样的时候才会出现异或结果为 1. 所以我们以该
         位是否为 1 对数组进行划分, 只要该位为 1 就和 num1 异或, 只要该位为 0
         就和 num2 异或, 这样最终得到就是只出现过一次的两个数(其他在该位为 1 或
         0 的数必然出现 0/2 次对异或结果无影响)
         **/
        int num1 = 0, num2 = 0;
        int xor = 0;
        for(int num : nums)
            xor ^= num;

        int bit_1 = 1;
        while((xor & 1) == 0) {
            xor >>= 1;
            bit_1 <<= 1;
        }

        for(int num : nums) {
            if((num & bit_1) == 0)
                num1 ^= num;
            else
                num2 ^= num;
        }

        return new int[]{num1, num2};
    }
}
