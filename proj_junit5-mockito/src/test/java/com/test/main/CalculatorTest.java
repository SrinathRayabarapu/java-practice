package com.test.main;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    // test<System under Test>_<Condition or State change>_<Expected Result>
    @Test
    void testIntegerDivision_WhenFourIsDividedByTwo_ShouldReturnTwo() {
        Calculator calculator = new Calculator();
        int result = calculator.integerDivision(4, 2);

        Assertions.assertEquals(2, result, "The value didn't match!");
    }

    @Test
    void testIntegerSubtraction_WhenThreeIsSubtractedByOne_ShouldReturnTwo() {
        Calculator calculator = new Calculator();
        int result = calculator.integerSubtraction(3, 1);
        assertEquals(2, result);
    }

}