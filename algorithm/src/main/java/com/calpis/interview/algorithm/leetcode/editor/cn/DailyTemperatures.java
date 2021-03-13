//请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
// 
//
// 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2
//, 1, 1, 0, 0]。 
//
// 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。 
// Related Topics 栈 哈希表 
// 👍 676 👎 0

  
package com.calpis.interview.algorithm.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class DailyTemperatures {
      public static void main(String[] args) {
           Solution solution = new DailyTemperatures().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] dailyTemperatures(int[] T) {
        int len = T.length;
        int[] res = new int[len];
        Deque<Integer> stack = new ArrayDeque<>(len);
        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && T[i] >= T[stack.peek()]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}