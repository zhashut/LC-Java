package Linked_链表.两两交换链表中的节点;

import Linked_链表.ListNode;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 炸薯条
 * Date: 2023/4/14
 * Time: 7:30
 * Description: No Description
 */
public class main {
    // 迭代
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode tmp = dummy;
        ListNode node1 = null;
        ListNode node2 = null;

        while (tmp.next != null && tmp.next.next != null) {
            node1 = tmp.next;
            node2 = tmp.next.next;
            tmp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            tmp = node1;
        }

        return dummy.next;
    }

    // 递归
    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode one = head;
        ListNode two = one.next;
        ListNode three = two.next;

        two.next = one;
        one.next = swapPairs2(three);

        return two;
    }

    // 递归
    public ListNode swapPairs3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs3(newHead.next);
        newHead.next = head;

        return newHead;
    }
}
