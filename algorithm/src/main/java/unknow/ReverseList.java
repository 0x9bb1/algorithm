package unknow;

public class ReverseList {

    private static Node1 reverse(Node1 curr) {
        Node1 prev = null;
        Node1 next;

        while (null != curr) {
            next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        Node1 last = new Node1(2,null);
        Node1 first = new Node1(1,last);
        System.out.println(first);

        reverse(first);
        System.out.println("----reverse----");
        System.out.println(first);
    }

}

class Node1 {
    private Integer value;

    private Node1 next;

    public Node1(Integer value, Node1 next) {
        this.value = value;
        this.next = next;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Node1 getNext() {
        return next;
    }

    public void setNext(Node1 next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "unknow.Node1{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }
}
