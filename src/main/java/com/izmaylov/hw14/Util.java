package com.izmaylov.hw14;

import java.math.BigDecimal;
import java.util.List;

class Util<E> implements Multiplier<Number>{
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
                array[i] = sum(array[i],array[i]);
        }
        return array;
    }


   public Number sum(Number one, Number two) {// should work only with numbers
       return new BigDecimal(one.toString()).multiply(new BigDecimal(two.toString()));
    }



    /*public <N> double sumOfArray(List<N> list) {
        Number temp;
        double s = 0.0;
        for (N n : list) {
            if(n instanceof Number) {
                temp = (Number) n;
                s += temp.doubleValue();
            }
        }
        return s;
    }*/

    public double sumOfArray(List<? extends Number> list) {
        double s = 0.0;
        for (Number n : list) {
                s += n.doubleValue();
        }
        return s;
    }

    public void addNumbers(List<? super Integer> list) {
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
    }


}
