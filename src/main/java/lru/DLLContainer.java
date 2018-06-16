package lru;

class DLL<K, V> {

    K key;
    V val;
    DLL prev;
    DLL next;

    public DLL(K key) {
        this.key = key;
    }

}

class DLLContainer<K, V> {

    DLL head;
    DLL tail;

    public void addFirst(DLL<K, V> node) {
        node.prev = null;
        node.next = null;
        if (head == null) {
            tail = node;
        } else {
            node.next = head;
            head.prev = node;
        }
        head = node;
    }

    public void remove(DLL<K, V> node) {
        DLL prev = node.prev;
        DLL next = node.next;
        if (prev != null)
            prev.next = next;
        if (next != null)
            next.prev = prev;
        if (node == head) {
            head = next;
        }
        if (node == tail) {
            tail = prev;
        }
    }

    public DLL<K, V> removeLast() {
        if (tail == null) {
            return null;
        }
        DLL res = tail;
        if (tail == head) {
            tail = null;
            head = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        return res;
    }
}
