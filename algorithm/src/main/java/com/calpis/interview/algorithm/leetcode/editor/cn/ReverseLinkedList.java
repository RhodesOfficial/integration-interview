//反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表 
// 👍 1511 👎 0


package com.calpis.interview.algorithm.leetcode.editor.cn;

import com.calpis.interview.algorithm.common.ListNode;

public class ReverseLinkedList {
      public static void main(String[] args) {
           Solution solution = new ReverseLinkedList().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    // null 1 -> 2 -> 3 -> 4 -> 5
    public ListNode reverseList(ListNode head) {
//        ListNode pre = null;
//        ListNode cur = head;
//        while (cur != null) {
//            ListNode temp = cur.next;
//            cur.next = pre;
//            pre = cur;
//            cur = temp;
//        }
//        return pre;
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}