//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。 
//
// 进阶： 
//
// 
// 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
//
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 5 * 104] 内 
// -105 <= Node.val <= 105 
// 
// Related Topics 排序 链表 
// 👍 1020 👎 0


package com.calpis.interview.algorithm.leetcode.editor.cn;

import com.calpis.interview.algorithm.common.ListNode;

public class SortList {
      public static void main(String[] args) {
           Solution solution = new SortList().new Solution();
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
// todo
class Solution {
    public ListNode sortList(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode p = head;
        int len = 0;
        while (p != null) {
            p = p.next;
            len++;
        }
        // 4->3->1->7->8->9->2->11->5->6
        for (int i = 1; i < len; i *= 2) {
            // cur = 4->3->1->7->8->9->2->11->5->6
            ListNode cur = dummyHead.next;
            // tail = @->4->3->1->7->8->9->2->11->5->6
            ListNode tail = dummyHead;
            while (cur != null) {
                // t1 left = 4->3->1->7->8->9->2->11->5->6

                // t2 left = 1->7->8->9->2->11->5->6
                ListNode left = cur;
                // t1 left  = 4
                // t1 right = 3->1->7->8->9->2->11->5->6

                // t2 left  = 1
                // t2 right = 7->8->9->2->11->5->6
                ListNode right = cut(left, i);
                // t1 cur = 1->7->8->9->2->11->5->6
                // t1 right = 3

                // t2 cur = 8->9->2->11->5->6
                // t2 right = 7
                cur = cut(right, i);
                // t1 tail = @->3->4

                // t2 tail = @-3->4->3->7
                tail.next = merge(left, right);
                // t1 tail = 4

                // t2 tail = 7
                while (tail.next != null) {
                    tail = tail.next;
                }
            }
        }
        return dummyHead.next;
    }

    /**
     * 将链表head切掉前n个节点，并返回后半部分的链表头
     * @param head
     * @param n
     * @return
     */
    private ListNode cut(ListNode head, int n) {
        ListNode p = head;
        // head = p = 3 -> 4 -> 5 -> 6 -> 7
        // n = 3
        while (--n > 0 && p != null) {
            p = p.next;
        }
        // p = 5 -> 6 -> 7
        if (p == null) {
            return null;
        }
        // next = 6 -> 7
        ListNode next = p.next;
        // head = 3 -> 4 -> 5
        p.next = null;
        return next;
    }

    /**
     * 两路归并
     * @param l1
     * @param l2
     * @return
     */
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                p = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                p = l2;
                l2 = l2.next;
            }
        }
        p.next = l1 == null ? l2 : l1;
        return dummyHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}