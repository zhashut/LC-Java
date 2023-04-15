package Linked_链表.链表相交;

import Linked_链表.ListNode;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 炸薯条
 * Date: 2023/4/15
 * Time: 20:33
 * Description: https://leetcode.cn/problems/intersection-of-two-linked-lists-lcci/
 */
public class main {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        int lenA = 0, lenB = 0;

        // 求链表A的长度
        while (curA != null) {
            ++lenA;
            curA = curA.next;
        }

        // 求链表B的长度
        while (curB != null) {
            ++lenB;
            curB = curB.next;
        }

        curA = headA;
        curB = headB;
        // 让curA最长链表的头，lenA为其长度
        if (lenB > lenA) {
            // 1. swap(lenA, lenB)
            int tmpLen = lenA;
            lenA = lenB;
            lenB = tmpLen;
            // 2. swap(curA, curB)
            ListNode tmpNode = curA;
            curA = curB;
            curB = tmpNode;
        }
        // 求长度差
        int gap = lenA - lenB;
        while (gap-- > 0) {
            curA = curA.next;
        }

        while (curA != null) {
            if (curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }

        return null;
    }
}
