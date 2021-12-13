package com.izmaylov.hw15.practiceSlide20;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

class MyListTest {

    @Test
    void shouldThrowExceptionWhenTryingToAddNullValue(){
        MyList myList = new MyList();
        String temp = null;

        Assertions.assertThrows(NullPointerException.class, () -> myList.add(temp));
    }

    @Test
    void shouldIncreaseSizeByOneWhenTryingToAddValue(){
        MyList myList = new MyList();
        String temp = "1";
        int expected = 1;
        myList.add(temp);


        Assertions.assertEquals(expected, myList.getSize());

    }

    @Test
    void shouldThrowExceptionBecauseLastValueIsNull(){
        MyList myList = new MyList();

        Assertions.assertThrows(NoSuchElementException.class,() -> myList.getFromLast(3));
    }

    @Test
    void shouldReturnLastValueBecauseItIsEqualToGivenValue(){
        MyList myList = new MyList();
        String temp = "1";

        myList.add(temp);


        Assertions.assertEquals("1",myList.getFromLast("1"));
    }

    @Test
    void shouldReturnNotLastAddedValue(){
        MyList myList = new MyList();

        myList.add("temp1");
        myList.add("temp2");
        myList.add("temp3");
        myList.add("temp4");


        Assertions.assertEquals("temp3",myList.getFromLast("temp3"));
    }

}