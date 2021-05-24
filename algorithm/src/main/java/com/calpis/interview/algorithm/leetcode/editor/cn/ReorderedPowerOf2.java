//给定正整数 N ，我们按任何顺序（包括原始顺序）将数字重新排序，注意其前导数字不能为零。
//
// 如果我们可以通过上述方式得到 2 的幂，返回 true；否则，返回 false。
//
//
//
//
//
//
// 示例 1：
//
// 输入：1
//输出：true
//
//
// 示例 2：
//
// 输入：10
//输出：false
//
//
// 示例 3：
//
// 输入：16
//输出：true
//
//
// 示例 4：
//
// 输入：24
//输出：false
//
//
// 示例 5：
//
// 输入：46
//输出：true
//
//
//
//
// 提示：
//
//
// 1 <= N <= 10^9
//
// Related Topics 数学
// 👍 39 👎 0


package com.calpis.interview.algorithm.leetcode.editor.cn;

import java.util.Arrays;

public class ReorderedPowerOf2 {
      public static void main(String[] args) {
           Solution solution = new ReorderedPowerOf2().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean reorderedPowerOf2(int N) {
        char[] a1 = String.valueOf(N).toCharArray();
        Arrays.sort(a1);
        String s1 = new String(a1);
        for (int i = 0; i < 31; i++) {
            char[] a2 = String.valueOf((1 << i)).toCharArray();
            Arrays.sort(a2);
            String s2 = new String(a2);
            if (s1.equals(s2)) {
                return true;
            }
        }
        return false;
    }


    }

//leetcode submit region end(Prohibit modification and deletion)

}