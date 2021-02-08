package com.calpis.interview.algorithm.leetcode;

/**
 * LC1206 设计跳表
 *
 * https://pic.leetcode-cn.com/1612247342-QjALhY-skiplist_insertions.png
 */
public class Skiplist {

    /**
     * 参考Redis的SkipList实现
     */
    private static final double P = 0.25d;
    private static final int MAX_LEVEL = 32;

    /**
     * 头结点
     */
    private final Node head;

    /**
     * 当前层数,从1开始计算
     */
    private int currentLevel = 1;

    public Skiplist() {
        head = new Node(-1, MAX_LEVEL);
    }

    public boolean search(int target) {
        Node searchNode = head;
        for (int i = currentLevel - 1; i >= 0; i--) {
            searchNode = findClosest(searchNode, i, target);
            if (searchNode.next[i] != null && searchNode.next[i].value == target) {
                return true;
            }
        }
        return false;
    }

    public void add(int num) {
        int level = randomLevel();
        Node updateNode = this.head;
        Node newNode = new Node(num, level);
        for (int i = currentLevel - 1; i >= 0; i--) {
            updateNode = findClosest(updateNode, i, num);
            if (i < level) {
                if (updateNode.next[i] == null) {
                    updateNode.next[i] = newNode;
                } else {
                    Node temp = updateNode.next[i];
                    updateNode.next[i] = newNode;
                    newNode.next[i] = temp;
                }
            }
        }
        // 如果随机出来的层数比当前的层数还大，那么超过currentLevel的head 直接指向newNode
        if (level > currentLevel) {
            for (int i = currentLevel; i < level; i++) {
                head.next[i] = newNode;
            }
            currentLevel = level;
        }
    }

    public boolean erase(int num) {
        boolean flag = false;
        Node searchNode = this.head;
        for (int i = currentLevel - 1; i >= 0; i--) {
            searchNode = findClosest(searchNode, i, num);
            if (searchNode.next[i] != null && searchNode.next[i].value == num) {
                searchNode.next[i] = searchNode.next[i].next[i];
                flag = true;
            }
        }
        return flag;
    }

    /**
     * 计算随机层数
     *
     * @return
     */
    private int randomLevel() {
        int level = 1;
        while (Math.random() < P && level < MAX_LEVEL) {
            level++;
        }
        return level;
    }

    /*
     * 1.随机一个层数,new要插入的节点为newNode
     * 2.找到节点在该层的位置,因为是链表所以需要一个节点node,满足newNode的值刚好不大于node的下一个节点值
     */

    /**
     * 找到level层value刚好不小于node的节点
     *
     * @param node
     * @param levelIndex
     * @param value
     * @return
     */
    private Node findClosest(Node node, int levelIndex, int value) {
        while ((node.next[levelIndex]) != null && value > node.next[levelIndex].value) {
            node = node.next[levelIndex];
        }
        return node;
    }

    class Node {
        int value; // 节点值
        Node[] next; // 节点在不同层的下一个节点

        /**
         * construct
         *
         * @param value
         * @param size 当前节点在跳表中索引底基层
         */
        public Node(int value, int size) {
            this.value = value;
            this.next = new Node[size];
        }
    }

    public static void main(String[] args) {
        Skiplist skiplist = new Skiplist();
        skiplist.add(1);
        skiplist.add(2);
        skiplist.add(3);
        System.out.println(skiplist.search(0)); // 返回 false
        skiplist.add(4);
        System.out.println(skiplist.search(1));   // 返回 true
        System.out.println(skiplist.erase(0));    // 返回 false，0 不在跳表中
        System.out.println(skiplist.erase(1));    // 返回 true
        System.out.println(skiplist.search(1));   // 返回 false，1 已被擦除
    }
}
