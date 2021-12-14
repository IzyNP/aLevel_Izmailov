package com.izmaylov.hw15.practiceSlide44;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.*;

class UtilTest {

    @Test
    void shouldThrowExceptionBecauseGivenParamIsNull() {
        List list = Mockito.mock(List.class);
        Mockito.when(list.isEmpty()).thenReturn(true);
        Assert.assertThrows(NoSuchElementException.class, () -> Util.stringIntegerMap(list));
    }

    @Test
    void shouldReturnMapWithSomeValue() {
        List<String> list = new ArrayList<>();
        list.add("Nikita");

        Map<String,Integer> expected = new HashMap<>();
        expected.put("Nikita",6);
        Map<String,Integer> actual = Util.stringIntegerMap(list);

        Assert.assertEquals(expected,actual);
    }

}

