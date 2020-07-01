package simple;

import java.util.List;
import java.util.Objects;

/**
 * 83. 删除排序链表中的重复元素
 */
public class DeleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        if (Objects.isNull(head) || Objects.isNull(head.next)) {
            return head;
        }

        ListNode currentNode = head;
        while (Objects.nonNull(currentNode.next)) {
            if (currentNode.next.val == currentNode.val) {
                currentNode.next = currentNode.next.next;
            } else {
                currentNode = currentNode.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        DeleteDuplicates duplicates = new DeleteDuplicates();
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(1);
        ListNode third = new ListNode(2);
        ListNode fourth = new ListNode(3);
        ListNode five = new ListNode(3);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = five;

        ListNode result = duplicates.deleteDuplicates(head);
        while (Objects.nonNull(result)) {
            System.out.print(result.val + (Objects.isNull(result.next) ? "" : "->"));
            result = result.next;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
