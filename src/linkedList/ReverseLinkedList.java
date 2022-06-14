package linkedList;

public class ReverseLinkedList {
    /*------------------------------------------递归法--------------------------------------------------*/
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode node = reverseList(head.next);
        // 这一步当时想半天没想出来能这么写。
        head.next.next = head;
        head.next = null;
        return node;
    }
    /*------------------------------------------三指针--------------------------------------------------*/
    private ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            // 第三个指针的赋值写在while循环的第一行是关键
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
