package com.izmaylov.hw15.practiceSlide20;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MyNode<E>{
    private E value;
    private MyNode<E> next;
    private MyNode<E> prev;

    public MyNode(E value) {
        this.value = value;
    }

    public MyNode(E value, MyNode<E> next, MyNode<E> prev) {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }

}
