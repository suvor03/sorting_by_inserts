package ru.vsu.cs.suvorov_d_a;

public class LinkedList<T> {

    public static class LinkedListException extends Exception {
        public LinkedListException(String message) {
            super(message);
        }
    }

    public Node head;

    public LinkedList() {
        head = new Node();
    }


    private class LinkedListNode {
        public T value;
        public LinkedListNode next;

        public LinkedListNode(T value, LinkedListNode next) {
            this.value = value;
            this.next = next;
        }

        public LinkedListNode(T value) {
            this(value, null);
        }
    }

    private LinkedListNode first = null;
    private LinkedListNode last = null;
    private int size = 0;

    public void addFirst(T value) {
        first = new LinkedListNode(value, last);
        if (size == 0) {
            last = first;
        }
        size++;
    }

    public void addLast(T value) {
        if (size == 0) {
            first = last = new LinkedListNode(value);
        } else {
            last.next = new LinkedListNode(value);
            last = last.next;
        }
        size++;
    }

    private void checkEmptyError() throws LinkedListException {
        if (size == 0) {
            throw new LinkedListException("Empty list");
        }
    }

    private LinkedListNode getNode(int index) {
        LinkedListNode curr = first;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr;
    }

    public void removeFirst() throws LinkedListException {
        checkEmptyError();
        first = first.next;
        if (size == 1) {
            last = null;
        }
        size--;
    }

    public void removeLast() throws LinkedListException {
        checkEmptyError();
        if (size == 1) {
            first = last = null;
        } else {
            last = getNode(size - 2);
            last.next = null;
        }
        size--;
    }

    public void remove(int index) throws LinkedListException {
        checkEmptyError();
        if (index < 0 || index >= size) {
            throw new LinkedListException("Incorrect index");
        }
        if (index == 0) {
            removeFirst();
        } else {
            LinkedListNode prev = getNode(index - 1);
            prev.next = prev.next.next;
            if (prev.next == null) {
                last = prev;
            }
            size--;
        }
    }

    public int size() {
        return size;
    }

    public T get(int index) throws LinkedListException {
        checkEmptyError();
        return getNode(index).value;
    }

    public T getFirst() throws LinkedListException {
        checkEmptyError();
        return first.value;
    }

    public T getLast() throws LinkedListException {
        checkEmptyError();
        return last.value;
    }

    public void insert(int i, Object x) throws LinkedListException {
        Node p = head;
        int j = -1;

        while (p != null && j < i - 1) {
            p = p.next;
            ++j;
        }
        if (j > i - 1 || p == null)
            throw new LinkedListException("Incorrect insertion position!");
        Node s = new Node(x);
        s.next = p.next;
        p.next = s;
    }

    public void display()
    {
        Node node = head.next;
        while(node != null)
        {
            System.out.print(node.data + "  ");
            node = node.next;
        }
        System.out.println();
    }
}