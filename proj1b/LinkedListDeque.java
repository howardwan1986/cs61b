public class LinkedListDeque<T> implements Deque<T>{

    private class Node {
        private T item;
        private Node prev;
        private Node next;

        public Node(T item, Node prev, Node next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node sentinel;
    private int size;

    public LinkedListDeque() {
        this.sentinel = new Node(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void addFirst(T item) {
        Node n = new Node(item, null, null);
        n.next = sentinel.next;
        n.prev = sentinel;
        sentinel.next = n;
        sentinel.next.next.prev = sentinel.next;
        size += 1;
    }

    @Override
    public void addLast(T item) {
        Node n = new Node(item, null, null);
        n.next = sentinel;
        n.prev = sentinel.prev;
        sentinel.prev.next = n;
        sentinel.prev = n;
        size += 1;
    }

    @Override
    public void printDeque() {
        Node n = sentinel.next;
        int i = 0;
        while (i < size) {
            System.out.println(n.item + " ");
            n = n.next;
            i += 1;
        }
    }

    @Override
    public T removeFirst() {
        T t = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        if(!isEmpty()) {
            size -= 1;
        }
        return t;
    }

    @Override
    public T removeLast() {
        T t = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        if(!isEmpty()){
            size -= 1;
        }
        return t;

    }

    @Override
    public T get(int index) {

            Node n = sentinel.next;
            for (int i =0; i< index; i++){
                n = n.next;
            }
            return n.item;


    }

    private T getRecursive(int index, Node cur) {
        if(index == 0){
            return cur.item;
        }
        return getRecursive(index - 1, cur.next);
    }

    public T getRecursive(int index) {
        return getRecursive(index, sentinel.next);
    }
}
