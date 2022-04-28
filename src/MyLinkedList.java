class MyLinkedList {
    int size;
    ListNode head;
    ListNode tail;

    private static class ListNode {
        int val;
        ListNode prev;
        ListNode next;

        public ListNode() {
        }

        public ListNode(ListNode prev, int val, ListNode next) {
            this.prev = prev;
            this.val = val;
            this.next = next;
        }
    }

    //双向链表，可以从两边开始找，哪边快从哪边
    private ListNode getListNode(int index) {
        ListNode cur;
        if (index < (size >> 1)) {
            cur = head;
            for (int i = 0; i < index; i++)
                cur = cur.next;
        } else {
            cur = tail;
            for (int i = size - 1; i > index; i--)
                cur = cur.prev;
        }
        return cur;
    }

    public MyLinkedList() {
    }

    public int get(int index) {
        if (index < 0 || index > size - 1)
            return -1;
        return getListNode(index).val;
    }

    public void addAtHead(int val) {
        ListNode newNode = new ListNode(null, val, head);
        if (head == null)
            tail = newNode;
        else
            head.prev = newNode;
        head = newNode;
        size++;
    }

    public void addAtTail(int val) {
        ListNode newNode = new ListNode(tail, val, null);
        if (tail == null)
            head = newNode;
        else
            tail.next = newNode;
        tail = newNode;
        ++size;
    }

    public void addAtIndex(int index, int val) {
        if (index > this.size)
            return;
        if (index == this.size) {
            addAtTail(val);
            return;
        }
        ListNode cur = getListNode(index);
        ListNode newNode = new ListNode(cur.prev, val, cur);
        if (cur.prev == null)
            head = newNode;
        else
            cur.prev.next = newNode;
        cur.prev = newNode;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index > this.size - 1)
            return;
        ListNode cur = getListNode(index);
        //这两个ifelse，太帅了
        if (cur.prev == null)
            head = cur.next;
        else
            cur.prev.next = cur.next;

        if (cur.next == null)
            tail = cur.prev;
        else
            cur.next.prev = cur.prev;
        //unlink
        cur.prev = null;
        cur.next = null;
        --size;
    }

    public static void main(String[] args) {
        MyLinkedList l = new MyLinkedList();
        l.addAtHead(7);
        l.addAtTail(7);
        l.addAtHead(9);
        l.addAtTail(8);
        l.addAtHead(6);
        l.addAtHead(0);
        l.addAtHead(0);
        l.addAtTail(4);
        System.out.println(l.get(2));
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
