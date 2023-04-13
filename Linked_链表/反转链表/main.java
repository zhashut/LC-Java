package Linked_链表.反转链表;

import Linked_链表.ListNode;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 炸薯条
 * Date: 2023/4/14
 * Time: 6:46
 * Description: No Description
 */
public class main {
    public ListNode reverseList1(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode tmp;

        while (cur != null) {
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }

        return pre;
    }

    public ListNode reverseList2(ListNode head) {
        ListNode ans = null;

        for (ListNode x = head; x != null; x = x.next) {
            ans = new ListNode(
                    x.val,
                    ans
            );
        }

        return ans;
    }

    // 递归
    public ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList3(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }
}
