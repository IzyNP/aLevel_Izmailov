package com.izmaylov.hw15.practiceSlide20;

public class MyList<E> {
    private MyNode<E> head;
    private MyNode<E> tail;
    private int size = 0;

    public int getSize() {
        return size;
    }

    public void add(E value) {
        if (value == null) {
            throw new NullPointerException();
        } else {
            MyNode<E> node = new MyNode<>(value);
            if (head == null) {
                head = node;
            } else {
                MyNode<E> next = head.getNext();
                if (next == null) {
                    head.setNext(node);
                    node.setPrev(head);
                } else {
                    while (next.getNext() != null) {
                        next = next.getNext();
                    }
                    next.setNext(node);
                    node.setPrev(next);
                }
            }
            tail = node;
            size++;
        }
    }


    public E getFromLast(E value) {
        if (tail == null) {
            return null;
        }
        if (tail == head) {
            return tail.getValue();
        }

        MyNode<E> last = tail;
        if (last.getValue().equals(value)) {
            return last.getValue();
        } else {
            if (last.getValue() == null) {
                return null;
            } else {
                while (last.getValue() != null && head.getValue() != null) {
                    if (last.getValue().equals(value)) {
                        return last.getValue();
                    }
                    last = last.getPrev();
                }

            }
        }
        return null;
    }
}
