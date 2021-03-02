//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。 
//
// 
// push(x) —— 将元素 x 推入栈中。 
// pop() —— 删除栈顶的元素。 
// top() —— 获取栈顶元素。 
// getMin() —— 检索栈中的最小元素。 
// 
//
// 
//
// 示例: 
//
// 输入：
//["MinStackInner","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//输出：
//[null,null,null,null,-3,null,0,-2]
//
//解释：
//MinStackInner minStack = new MinStackInner();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
// 
//
// 
//
// 提示： 
//
// 
// pop、top 和 getMin 操作总是在 非空栈 上调用。 
// 
// Related Topics 栈 设计 
// 👍 820 👎 0


package com.calpis.interview.algorithm.leetcode.editor.cn;

import java.util.ArrayDeque;

public class MinStack {
      public static void main(String[] args) {

      }
      //leetcode submit region begin(Prohibit modification and deletion)
    // 重名 commit时需要去掉0
class MinStack0 {

     private ArrayDeque<Integer> mainStack;
     private ArrayDeque<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack0() {
        mainStack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }
    
    public void push(int x) {
        if (minStack.isEmpty() || minStack.peek() >= x) {
            minStack.push(x);
        }
        mainStack.push(x);
    }
    
    public void pop() {
        Integer pop = mainStack.pop();
        if (pop.equals(minStack.peek())) {
            minStack.pop();
        }
    }
    
    public int top() {
        return mainStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStackInner object will be instantiated and called as such:
 * MinStackInner obj = new MinStackInner();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)

}