package unknow;

public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }

        int count = 0;
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = node;

        while (fast != null) {
            if (count < n) {
                fast = fast.next;
                count++;
            } else {
                prev = slow;
                fast = fast.next;
                slow = slow.next;
            }
        }
        prev.next = slow.next;
        return node.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        RemoveNthFromEnd removeNthFromEnd =
                new RemoveNthFromEnd();

        ListNode head = removeNthFromEnd
                .removeNthFromEnd(n1,2);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    static class ListNode{
        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
