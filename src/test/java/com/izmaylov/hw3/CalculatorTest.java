package com.izmaylov.hw3;


import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    private final Calculator calculator = new Calculator();


    @Test
    public void shouldReturnCorrectSumOfGivenDigits() {
        int given = 12;
        int expected = 3;

        int actual = calculator.sumOfDigits(given);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnSameDigitWhatWasGivenBecauseThisDigitLowerThanTen() {
        int given = 9;
        int expected = 9;

        int actual = calculator.sumOfDigits(given);

        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnSameDigitWhatWasGivenBecauseThisDigitLowerThanZero() {
        int given = -5;

        calculator.sumOfDigits(given);
    }

    @Test
    public void shouldReturnCorrectNumberAfterFoldingOfGivenNumbers() {
        String givenOperation = "+";
        int givenFirstNumber = 6;
        int givenSecondNumber = 4;
        String str = givenOperation + "\r\n" + givenFirstNumber + "\r\n" + givenSecondNumber + "\r\n" + ".";
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        calculator.calc(new Scanner(new ByteArrayInputStream(str.getBytes())));

        assertEquals("Choose operation (*,/,+,-).Choose '.' for the end of program" + System.lineSeparator() +
                "Enter first number: " + System.lineSeparator() +
                "Enter second number: " + System.lineSeparator() +
                "10" + System.lineSeparator() +
                "Choose operation (*,/,+,-).Choose '.' for the end of program" + System.lineSeparator(), bos.toString());
    }

    @Test
    public void shouldReturnCorrectNumberAfterMultiplicationOfGivenNumbers() {
        String givenOperation = "*";
        int givenFirstNumber = 6;
        int givenSecondNumber = 4;
        String str = givenOperation + "\r\n" + givenFirstNumber + "\r\n" + givenSecondNumber + "\r\n" + ".";
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        calculator.calc(new Scanner(new ByteArrayInputStream(str.getBytes())));

        assertEquals("Choose operation (*,/,+,-).Choose '.' for the end of program" + System.lineSeparator() +
                "Enter first number: " + System.lineSeparator() +
                "Enter second number: " + System.lineSeparator() +
                "24" + System.lineSeparator() +
                "Choose operation (*,/,+,-).Choose '.' for the end of program" + System.lineSeparator(), bos.toString());
    }

    @Test
    public void shouldReturnCorrectNumberAfterDivisionOfGivenNumbers() {
        String givenOperation = "/";
        int givenFirstNumber = 6;
        int givenSecondNumber = 4;
        String str = givenOperation + "\r\n" + givenFirstNumber + "\r\n" + givenSecondNumber + "\r\n" + ".";
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        calculator.calc(new Scanner(new ByteArrayInputStream(str.getBytes())));

        assertEquals("Choose operation (*,/,+,-).Choose '.' for the end of program" + System.lineSeparator() +
                "Enter first number: " + System.lineSeparator() +
                "Enter second number: " + System.lineSeparator() +
                "1" + System.lineSeparator() +
                "Choose operation (*,/,+,-).Choose '.' for the end of program" + System.lineSeparator(), bos.toString());
    }

    @Test
    public void shouldReturnCorrectNumberAfterSubtractionOfGivenNumbers() {
        String givenOperation = "-";
        int givenFirstNumber = 6;
        int givenSecondNumber = 4;
        String str = givenOperation + "\r\n" + givenFirstNumber + "\r\n" + givenSecondNumber + "\r\n" + ".";
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        calculator.calc(new Scanner(new ByteArrayInputStream(str.getBytes())));

        assertEquals("Choose operation (*,/,+,-).Choose '.' for the end of program" + System.lineSeparator() +
                "Enter first number: " + System.lineSeparator() +
                "Enter second number: " + System.lineSeparator() +
                "2" + System.lineSeparator() +
                "Choose operation (*,/,+,-).Choose '.' for the end of program" + System.lineSeparator(), bos.toString());
    }

    @Test
    public void shouldPrintInConsoleInvalidSecondNumber() {
        String givenOperation = "/";
        int givenFirstNumber = 6;
        int givenSecondNumber = 0;
        String str = givenOperation + "\r\n" + givenFirstNumber + "\r\n" + givenSecondNumber + "\r\n" + ".";
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        calculator.calc(new Scanner(new ByteArrayInputStream(str.getBytes())));

        assertEquals("Choose operation (*,/,+,-).Choose '.' for the end of program" + System.lineSeparator() +
                "Enter first number: " + System.lineSeparator() +
                "Enter second number: " + System.lineSeparator() +
                "Invalid second number." + System.lineSeparator() +
                "Choose operation (*,/,+,-).Choose '.' for the end of program" + System.lineSeparator(), bos.toString());
    }

    @Test
    public void shouldPrintInConsoleInvalidOperation() {
        String givenOperation = "ё";
        int givenFirstNumber = 6;
        int givenSecondNumber = 4;
        String str = givenOperation + "\r\n" + givenFirstNumber + "\r\n" + givenSecondNumber + "\r\n" + ".";
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        calculator.calc(new Scanner(new ByteArrayInputStream(str.getBytes())));

        assertEquals("Choose operation (*,/,+,-).Choose '.' for the end of program" + System.lineSeparator() +
                "Enter first number: " + System.lineSeparator() +
                "Enter second number: " + System.lineSeparator() +
                "Invalid operation" + System.lineSeparator() +
                "Choose operation (*,/,+,-).Choose '.' for the end of program" + System.lineSeparator(), bos.toString());
    }
}