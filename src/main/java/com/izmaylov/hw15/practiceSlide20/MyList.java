package com.izmaylov.hw15.practiceSlide20;

import java.util.NoSuchElementException;

public class MyList<E> {
        private MyNode<E> head;
        private MyNode<E> tail;
        int size = 0;



        public void add(E value){
            MyNode<E> node = new MyNode<>(value,null, null);
            if(value == null){
                throw new NullPointerException();
            }else {
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


        public E getFromLast(E value){
            if(tail == null){
                throw new NoSuchElementException();
            }
            if(tail == head){
                return tail.getValue();
            }

            MyNode<E> last = tail.getPrev();
            if(last.getValue().equals(value)){
                return last.getValue();
            }else{
                while (last.getValue() != null){
                    if(last.getValue().equals(value)){
                        return last.getValue();
                    }
                    last = last.getPrev();
                }
            }
            return null;
        }
}
