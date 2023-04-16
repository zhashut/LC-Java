package Linked_链表.环形链表II;

import Linked_链表.ListNode;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 炸薯条
 * Date: 2023/4/16
 * Time: 21:15
 * Description: https://leetcode.cn/problems/linked-list-cycle-ii/submissions/
 */
public class main {
    // 快慢指针
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null) {
            slow = slow.next;
            if (fast.next == null) {
                return null;
            }
            fast = fast.next.next;

            if (fast == slow) {
                ListNode p = head;
                while (p != slow) {
                    p = p.next;
                    slow = slow.next;
                }
                return p;
            }
        }

        return null;
    }
}
