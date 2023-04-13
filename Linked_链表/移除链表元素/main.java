package Linked_链表.移除链表元素;

import Linked_链表.ListNode;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 炸薯条
 * Date: 2023/4/13
 * Time: 8:41
 * Description: No Description
 */

public class main {

    /**
     * 添加虚节点方式
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public ListNode removeElements1(ListNode head, int val) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        ListNode cur = head;

        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }

        return dummy.next;
    }

    /**
     * 不添加虚节点方式
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public ListNode removeElements2(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }

        if (head == null) {
            return head;
        }

        // 这个head不会是val
        ListNode pre = head;
        ListNode cur = head.next;

        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }

        return head;
    }

    /**
     * 不添加虚拟节点and pre Node方式
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public ListNode removeElements3(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }

        if (head == null) {
            return head;
        }

        ListNode cur = head;

        while (cur != null) {
            while (cur.next != null && cur.next.val == val) {
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }

        return head;
    }

}
