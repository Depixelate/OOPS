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
        if(head == null) return "[]";
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
        
        LinkedList<Integer> ints = new LinkedList<>();
        System.out.println("Current int linked list: " + ints);
        System.out.println("Adding 5..");
        ints.add(5);
        System.out.println("Adding 7..");
        ints.add(7);
        System.out.println("Adding 6..");
        ints.add(6);
        System.out.println("Current int linked list: " + ints);
        ints.add(0, 2);
        System.out.println("Adding 2..");
        System.out.println("Removing 5..");
        ints.remove(Integer.valueOf(5));
        System.out.println("Current int linked List: " + ints);
        ints.remove(1);
        System.out.println("Removing element at index 1..");
        System.out.println("Current int linked List: " + ints);
        
        LinkedList<String> strings = new LinkedList<>();
        System.out.println();
        System.out.println("Current string linked list: " + strings);
        strings.add("Hi");
        System.out.println("Adding 'Hi'..");
        strings.add("Hello");
        System.out.println("Adding 'Hello'..");
        strings.add(0, "What?");
        System.out.println("Adding 'What?'..");
        System.out.println("Current string linked list: " + strings);
        strings.add(1, "In the middle");
        System.out.println("Adding 'In the middle' at index 1..");
        System.out.println("Current string linked list: " + strings);
        strings.remove("What?");
        System.out.println("Removing 'What?'..");
        System.out.println("Current string linked list: " + strings);
    }
}