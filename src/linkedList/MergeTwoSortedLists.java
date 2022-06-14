package linkedList;

public class MergeTwoSortedLists {
    /*------------------------------------------递归法--------------------------------------------------*/
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // list1空了，处理完了，返回剩下的list2
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val > list2.val) {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        } else {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }
    }
    /*------------------------------------------迭代法--------------------------------------------------*/
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode node = dummy;
        while (l1 != null || l2 !=null) {
            if (l1 == null) {
                node.next = l2;
                l2 = l2.next;
            } else if (l2 == null) {
                node.next = l1;
                l1 = l1.next;
            } else if (l1.val > l2.val) {
                node.next = l2;
                l2 = l2.next;
            } else {
                node.next = l1;
                l1 = l1.next;
            }
            node = node.next;
        }
        return dummy.next;
    }
}
