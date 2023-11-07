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
}

class Main {
    
    public static void main(String[] args) {
        LinkedList<?> s;

    }
}