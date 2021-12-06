package com.izmaylov.hw14;

import java.util.List;

class Util<E> implements Multiplier{
    E value;

    public void printHashCode(E e) {
        System.out.println("HashCode: " + e.hashCode());
    }

    public void save(E value) {
        this.value = value;
    }

    public E get() {
        return value;
    }

    @Override
    public Number[] doubleValueIn(Number[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i].intValue() * array[i].intValue();
        }
        return array;
    }


   public<E extends Number> void sum(E one, E two) { // should work only with numbers
        System.out.println(one.doubleValue() + two.doubleValue());
    }



    public <E extends Number> double sumOfArray(List<E> list) {
        double s = 0.0;
        for (E n : list) {
            s +=  n.doubleValue();
        }
        return s;
    }

    public void addNumbers(List<? super Integer> list) {
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
    }



}
