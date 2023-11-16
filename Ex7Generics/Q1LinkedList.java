package Ex7Generics;

class Node<T> {
    T elem;
    Node<T> next;
    public Node(T elem, Node<T> next) {
        this.elem = elem;
        this.next = next;
    }
}

class LinkedList<T>{
    private Node<T> head;
    public LinkedList() {
        head = null;
    }
    public void add(T elem) {
        if(head == null) {
            head = new Node<>(elem, null);
            return;
        }
        var last = head;
        while(last.next != null) last = last.next;
        last.next = new Node<>(elem, null);
    }

    public void add(int index, T elem) {
        var cur = head;
        for(int i = 0; i < index; i++, cur=cur.next);
        var newNode = new Node<T>(elem, cur.next);
        cur.next = newNode;
    }

    public T remove(int index) {
        if(index == 0) {
            T prev = head.elem;
            head = head.next;
            return prev;
        } 
        var cur = head;
        for(int i = 0; i < index-1; i++) cur = cur.next;
        var delNode = cur.next;
        cur.next = delNode.next;
        return delNode.elem;
    }

    public T remove(T elem) {
        if(head.elem.equals(elem)) {
            T prev = head.elem;
            head = head.next;
            return prev;
        }
        var cur = head;
        while(!cur.next.elem.equals(elem)) cur = cur.next;
        var delNode = cur.next;
        cur.next = delNode.next;
        return delNode.elem;
    }

    public T get(int index) {
        var cur = head;
        for(int i = 0; i < index; i++) cur = cur.next;
        return cur.elem;
    }

    public String toString() {
        String ret = head.elem.toString();
        Node<T> cur = head.next;
        while(cur != null) {
            ret += String.format("->%s", cur.elem);
            cur = cur.next;
        }
        return ret;
    }
}

class Main {
    
    public static void main(String[] args) {
        LinkedList<String> strings = new LinkedList<>();
        LinkedList<Integer> ints = new LinkedList<>();
        ints.add(5);
        ints.add(7);
        System.out.println(ints);
        strings.add("Hi");
        strings.add("Hello");
        strings.add(0, "What?");
        System.out.println(strings);
        ints.add(0, 2);
        ints.remove(Integer.valueOf(5));
        System.out.println(ints);
        strings.add(1, "In the middle");
        strings.remove("What?");
        System.out.println(strings);
    }
}