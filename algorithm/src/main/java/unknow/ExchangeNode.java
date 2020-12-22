package unknow;

public class ExchangeNode {

    public static Node swapPairs(Node head) {
        // 虚拟节点
        Node dummy = new Node(-1);

        dummy.next = head;

        Node curr = dummy;
        while(null != curr.next
                && null != curr.next.next) {
            Node first = curr.next;
            Node second = curr.next.next;

            first.next = second.next;
            second.next = first;
            curr.next = second;


            curr = curr.next.next;

        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        System.out.println(swapPairs(n1));


    }
}

class Node {
    int value;
    Node next;

    public Node(int x) {
        this.value = x;
    }
}
