package linkedlist.flattenlist;

/**
 * @author Alexey Merezhin
 */
public class Node<T> {
    T value;
    Node next;
    Node child;

    public Node(T value) {
        this.value = value;
    }

    Node<T> flatten() {
        Node<T> last = null;
        Node node = this;
        while (node != null) {
            Node topNext = node.next;
            if (node.child != null) {
                Node<T> next = node.next;
                node.next = node.child;
                last = node.child.flatten();
                last.next = next;
                node.child = null;
            } else {
                last = node;
            }
            node = topNext;
        }
        return last;
    }

    public static void main(String[] args) {
        Node<String> root = new Node<>("1");
        root.next = new Node<>("2");
        root.next.child = new Node<>("3");
        root.next.child.next = new Node<>("6");
        root.next.child.next.child = new Node<>("7");
        root.next.child.child = new Node<>("4");
        root.next.child.child.next = new Node<>("5");
        root.next.next = new Node<>("8");

        root.printout("");
        root.flatten();
        System.out.println();
        root.printout("");
    }

    private void printout(String prefix) {
        System.out.println(prefix + value.toString());
        if (child != null) child.printout(prefix + "  ");
        if (next != null) next.printout(prefix);
    }


}
