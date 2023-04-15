package Linked_链表.删除链表的倒数第N个结点;

import Linked_链表.ListNode;
import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 炸薯条
 * Date: 2023/4/15
 * Time: 20:13
 * Description: No Description
 */
public class main {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fastNode = dummy;
        ListNode slowNode = dummy;

        for (int i = 0; i < n; i++) {
            fastNode = fastNode.next;
        }

        while (fastNode.next != null) {
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }

        slowNode.next = slowNode.next.next;

        return dummy.next;
    }

}
