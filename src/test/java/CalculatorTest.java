import com.version1.layout.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;



public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    @DisplayName("Should calculate the addition")
    void shouldCalculateTheAddition () {
        //Scenario: When I have two numbers 34.32 plus 476.87
        //Given
        BigDecimal d1 = calculator.convertBigDecimal("34.32");
        BigDecimal d2 = calculator.convertBigDecimal("476.87");

        //When - I add this two values

        BigDecimal result = calculator.add(d1,d2);

        //Then I will get this result
        Assertions.assertEquals(new BigDecimal("511.19"),result);
    }

    @Test
    @DisplayName("Should calculate the division")
    void shouldCalculateTheDivision() {
        //Scenario: I have 32 and I have to divide by 4
        //Given
        BigDecimal d1 = calculator.convertBigDecimal("32.00");
        BigDecimal d2 = calculator.convertBigDecimal("4.00");

        //When
        BigDecimal result = calculator.division(d1,d2);

        //Then
        Assertions.assertEquals(new BigDecimal("8.00"),result);
    }

    @Test
    @DisplayName("Should fail when divide by zero")
    void shouldFailWhenDivideByZero() {
        //Scenario: I have a number divide by zero
        //Given
        BigDecimal d1 = calculator.convertBigDecimal("32.00");
        BigDecimal d2 = calculator.convertBigDecimal("0.00");

        //When - Divide by Zero should raise a error.

        //Then
        Assertions.assertThrows(ArithmeticException.class,() -> calculator.division(d1,d2));

    }
    @Test
    @DisplayName("Should calculate the multiplication")
    void shouldCalculateTheMultiplication () {
        //Given - I have to two numbers to multiplier
        BigDecimal d1 = calculator.convertBigDecimal("5.1");
        BigDecimal d2 = calculator.convertBigDecimal("5.5");

        //When - I multiplies this two number
        Calculator t = new Calculator();
        BigDecimal result = t.multiplication(d1,d2);

        //Then - I should get this result
        Assertions.assertEquals(new BigDecimal("28.05"),result);
    }

    @Test
    @DisplayName("Should calculate the subtraction")
    void shouldCalculateTheSubtraction() {
        //Scenario: When I have two numbers 734.32 plus 476.87
        //Given
        BigDecimal d1 = calculator.convertBigDecimal("734.32");
        BigDecimal d2 = calculator.convertBigDecimal("476.87");

        //When - I add this two values
        BigDecimal result = calculator.subtraction(d1,d2);

        //Then I will get this result
        Assertions.assertEquals(new BigDecimal("257.45"),result);

    }
}