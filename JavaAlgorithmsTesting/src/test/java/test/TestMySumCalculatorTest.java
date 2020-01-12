package test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestMySumCalculatorTest {

    TestMySumCalculator calculator = new TestMySumCalculator();

    @Test
    public void testSum() {
        int calculation = calculator.sum(7, 5);
        Assert.assertEquals(calculation, 12);
    }

    @Test
    public void testMultiply() {
        int calculation = calculator.multiply(7, 5);
        Assert.assertEquals(calculation, 35);
    }
}