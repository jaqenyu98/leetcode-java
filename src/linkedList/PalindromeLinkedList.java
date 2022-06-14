package linkedList;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PalindromeLinkedList {
    /*------------------------------------------递归法--------------------------------------------------*/
    ListNode temp;

    public boolean isPalindrome(ListNode head) {
        temp = head;
        return isPalindromeRecursion(head);
    }

    private boolean isPalindromeRecursion(ListNode head) {
        if (head == null)
            return true;
        // 向下递归，并记录结果
        boolean result = isPalindromeRecursion(head.next);
        // 这一轮结果 = 上一轮比较的结果 && 这一轮的比较
        result = result && (head.val == temp.val);
        // 向后移动
        temp = temp.next;
        return result;
    }

    /*------------------------------------------数组法--------------------------------------------------*/
    public boolean isPalindrome2(ListNode head) {
        List<Integer> arr = new ArrayList<Integer>();
        // 将链表的值复制到数组中
        ListNode temp = head;
        while (temp != null) {
            arr.add(temp.val);
            temp = temp.next;
        }
        // 使用双指针判断是否回文
        int front = 0;
        int back = arr.size() - 1;
        while (front < back) {
            if (!arr.get(front).equals(arr.get(back))) {
                return false;
            }
            front++;
            back--;
        }
        return true;
    }

    /*------------------------------------------栈法--------------------------------------------------*/
    public boolean isPalindrome3(ListNode head) {
        if (head == null)
            return true;
        ListNode temp = head;
        Deque<Integer> stack = new LinkedList<>();
        //链表的长度
        int len = 0;
        //把链表节点的值存放到栈中
        while (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
            len++;
        }
        //len长度除以2
        len /= 2;
        //然后再出栈
        while (len > 0) {
            if (head.val != stack.pop())
                return false;
            head = head.next;
            len--;
        }
        return true;
    }
    /*------------------------------------------快慢指针反转链表法--------------------------------------------------*/
    public boolean isPalindrome4(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = reverseLinkedList(slow);
        slow = head;
        while (fast != null) {
            if (slow.val != fast.val)
                return false;
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }
    private ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
