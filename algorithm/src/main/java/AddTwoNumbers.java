import java.util.Stack;

public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        int sum = 0;
        ListNode listNode = new ListNode(0);
        while (!s1.isEmpty() || !s2.isEmpty()) {
            if (!s1.isEmpty()) {
                sum += s1.pop();
            }

            if (!s2.isEmpty()) {
                sum += s2.pop();
            }

            listNode.val = sum % 10;
            ListNode head = new ListNode(sum / 10);
            head.next = listNode;
            listNode = head;
            sum /= 10;
        }

        listNode = listNode.val == 0 ? listNode.next : listNode;
        return revert(listNode);
    }

    public static ListNode revert(ListNode head) {
        if (head == null || head.next==null) {
            return head;
        }

        ListNode prev = null;
        ListNode next;
        while(head.next!=null){
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        head.next = prev;
        return head;
    }

    public static void main(String[] args) {
       ListNode node1 = new ListNode(2);
       ListNode node2 = new ListNode(4);
       node1.next = node2;
       ListNode node3 = new ListNode(3);
       node2.next = node3;

       ListNode node4 = new ListNode(5);
       ListNode node5 = new ListNode(6);
       node4.next = node5;
       ListNode node6 = new ListNode(4);
       node5.next = node6;

       addTwoNumbers(node1, node4);
    }

}

class ListNode{
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
