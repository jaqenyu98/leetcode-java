package linkedList;

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode smallDummy = new ListNode(-1);
        ListNode small = smallDummy;
        ListNode largeDummy = new ListNode(-1);
        ListNode large = largeDummy;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        small.next = largeDummy.next;
        large.next = null;
        return smallDummy.next;
    }
}
