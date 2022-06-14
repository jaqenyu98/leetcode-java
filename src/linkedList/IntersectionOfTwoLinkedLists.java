package linkedList;

public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        ListNode lA = headA;
        ListNode lB = headB;
        // 如果不相交，最后lA=lB=null也会出循环！
        while (lA != lB) {
            // 这个写法有点东西。
            lA = lA == null ? headB : lA.next;
            lB = lB == null ? headA : lB.next;
        }
        return lA;
    }
}
