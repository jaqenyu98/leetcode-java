package linkedList;

public class OddEvenLinkedList {
    /*------------------------------------------partition法--------------------------------------------------*/
    public ListNode oddEvenList(ListNode head) {
        ListNode oddDummy = new ListNode(-1);
        ListNode evenDummy = new ListNode(-1);
        ListNode odd = oddDummy;
        ListNode even = evenDummy;
        int count = 1;
        while (head != null) {
            if (count % 2 == 1) {
                odd.next = head;
                odd = odd.next;
            } else {
                even.next = head;
                even = even.next;
            }
            count++;
            head = head.next;
        }
        odd.next = evenDummy.next;
        even.next = null;
        return oddDummy.next;
    }
    /*------------------------------------------递归法--------------------------------------------------*/
    public ListNode oddEvenList2(ListNode head) {
        if (head == null)
            return null;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = head.next;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
