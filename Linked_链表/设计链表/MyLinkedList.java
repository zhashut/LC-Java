package Linked_链表.设计链表;

import Linked_链表.ListNode;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 炸薯条
 * Date: 2023/4/13
 * Time: 9:24
 * Description: No Description
 */
public class MyLinkedList {

    ListNode head;
    int size;

    public MyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.val;
    }

    public void addAtHead(int val) {
        ListNode newListNode = new ListNode(val);
        newListNode.next = head;
        head = newListNode;
        size++;
    }

    public void addAtTail(int val) {
        ListNode newListNode = new ListNode(val);
        if (head == null) {
            head = newListNode;
        } else {
            ListNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newListNode;
        }
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }
        if (index == 0) {
            addAtHead(val);
        } else if (index == size) {
            addAtTail(val);
        } else {
            ListNode current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            ListNode newListNode = new ListNode(val);
            newListNode.next = current.next;
            current.next = newListNode;
            size++;
        }
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        if (index == 0) {
            head = head.next;
        } else {
            ListNode current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
    }

}
