package model;

import static java.lang.StrictMath.sqrt;

public class Calculator {

    public static double add(double firstNumber, double secondNumber) {
        return firstNumber + secondNumber;
    }

    public static double subtract(double firstNumber, double secondNumber) {
        return firstNumber - secondNumber;
    }

    public static double multiply(double firstNumber, double secondNumber) {
        return firstNumber * secondNumber;
    }

    public static double divide(double firstNumber, double secondNumber) {
        if (secondNumber == 0) {
            throw new IllegalArgumentException("Az osztó nem lehet 0!");
        }
        return firstNumber / secondNumber;
    }

    public static double square(double firstNumber) {
        return firstNumber * firstNumber;
    }

    public static double squareRoot(double firstNumber) {
        return sqrt(firstNumber);
    }
}
