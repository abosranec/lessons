package ru.lessons.lesson;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {
    @Test
    public void add() throws Exception {
        Calculator calc = new Calculator();
        calc.add(1, 1.05);
        Assert.assertEquals(2, calc.getResult(), 0.1);
    }

    @Test
    public void div() throws Exception {
        Calculator calc = new Calculator();
        calc.div(5, 2);
        Assert.assertEquals(2.5, calc.getResult(), 0.1);
    }
    @Test(expected = IllegalArgumentException.class)
    public void divException() throws Exception {
        Calculator calc = new Calculator();
        calc.div(1);
        calc.div(5, 0);
    }

    @Test
    public void sub() throws Exception {
        Calculator calc = new Calculator();
        calc.sub(4, 2);
        Assert.assertEquals(2, calc.getResult(), 0.1);
    }

    @Test
    public void mul() throws Exception {
        Calculator calc = new Calculator();
        calc.mul(3, 6);
        Assert.assertEquals(18, calc.getResult(), 0.1);
    }
}