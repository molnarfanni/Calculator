package resources;

import org.junit.Test;
import model.Calculator;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    public void add() {
        assertEquals(3, Calculator.add(1, 2));
        assertEquals(10, Calculator.add(5, 5));
        assertEquals(50, Calculator.add(35, 15));
        assertEquals(249, Calculator.add(170, 79));
        assertEquals(1234, Calculator.add(1200, 34));
    }

    @Test
    public void subtract() {
        assertEquals(2, Calculator.subtract(5, 3));
        assertEquals(10, Calculator.subtract(20, 10));
        assertEquals(45, Calculator.subtract(75, 30));
        assertEquals(154, Calculator.subtract(232, 78));
        assertEquals(1234, Calculator.subtract(2452, 1218));
    }

    @Test
    public void multiply() {
        assertEquals(8, Calculator.multiply(2, 4));
        assertEquals(25, Calculator.multiply(5, 5));
        assertEquals(110, Calculator.multiply(10, 11));
        assertEquals(910, Calculator.multiply(35, 26));
        assertEquals(5400, Calculator.multiply(120, 45));
    }

    @Test
    public void divide() {
        assertEquals(5, Calculator.divide(15, 3));
        assertEquals(2, Calculator.divide(10, 5));
        assertEquals(10, Calculator.divide(50, 5));
        assertEquals(15, Calculator.divide(45, 3));
        assertEquals(100, Calculator.divide(1200, 12));
    }

    @Test
    public void square() {
        assertEquals(16, Calculator.square(4));
        assertEquals(100, Calculator.square(10));
        assertEquals(81, Calculator.square(9));
        assertEquals(144, Calculator.square(12));
        assertEquals(400, Calculator.square(20));
    }

    @Test
    public void squareRoot() {
        assertEquals(6, Calculator.squareRoot(36));
        assertEquals(10, Calculator.squareRoot(100));
        assertEquals(7, Calculator.squareRoot(49));
        assertEquals(12, Calculator.squareRoot(144));
        assertEquals(100, Calculator.squareRoot(10000));
    }

}
