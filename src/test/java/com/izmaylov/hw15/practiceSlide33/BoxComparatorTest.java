package com.izmaylov.hw15.practiceSlide33;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class BoxComparatorTest {

    @Test
    void methodCompareShouldRetunrZeroBecauseVolumeEquals() {
        Box givenBoxOne = Mockito.mock(Box.class);
        Box givenBoxTwo = Mockito.mock(Box.class);
        BoxComparator boxComparator = new BoxComparator();

        Mockito.when(givenBoxOne.getVolume()).thenReturn(5);
        Mockito.when(givenBoxTwo.getVolume()).thenReturn(5);

        assertEquals(boxComparator.compare(givenBoxTwo,givenBoxOne),0);

    }

    @Test
    void methodCompareShouldReturnOneBecauseVolumeOfFirstBoxIsBigger(){

        Box givenBoxOne = Mockito.mock(Box.class);
        Box givenBoxTwo = Mockito.mock(Box.class);
        BoxComparator boxComparator = new BoxComparator();

        Mockito.when(givenBoxOne.getVolume()).thenReturn(5);
        Mockito.when(givenBoxTwo.getVolume()).thenReturn(4);

        assertEquals(boxComparator.compare(givenBoxTwo,givenBoxOne),1);
    }

    @Test
    void methodCompareShouldReturnMinusOneBecauseVolumeOfFirstBoxIsBigger(){

        Box givenBoxOne = Mockito.mock(Box.class);
        Box givenBoxTwo = Mockito.mock(Box.class);
        BoxComparator boxComparator = new BoxComparator();

        Mockito.when(givenBoxOne.getVolume()).thenReturn(3);
        Mockito.when(givenBoxTwo.getVolume()).thenReturn(4);

        assertEquals(boxComparator.compare(givenBoxTwo,givenBoxOne),-1);
    }

    @Test
    void methodCompareShoulrdReturnMinusOneBecauseVolumeOfFirstBoxIsZero(){

        Box givenBoxOne = Mockito.mock(Box.class);
        Box givenBoxTwo = Mockito.mock(Box.class);
        BoxComparator boxComparator = new BoxComparator();

        Mockito.when(givenBoxOne.getVolume()).thenReturn(0);
        Mockito.when(givenBoxTwo.getVolume()).thenReturn(4);

        assertEquals(boxComparator.compare(givenBoxTwo,givenBoxOne),-1);
    }
}