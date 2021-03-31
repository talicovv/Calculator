import com.version1.layout.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.fail;

public class CalculatorTest {
    @Test
    @DisplayName("Should calculate the addition")
    void shouldCalculateTheAddition () {
        //Scenario: When I have two numbers 34.32 plus 476.87
        //Given
        String d1 = "34.32";
        String d2 = "476.87";

        //When - I add this two values
        Calculator calculator = new Calculator();
        BigDecimal result = calculator.add(d1,d2);

        //Then I will get this result
        Assertions.assertEquals(new BigDecimal("511.19"),result);
    }

    @Test
    @DisplayName("Should calculate the division")
    void shouldCalculateTheDivision() {
        //Scenario: I have 32 and I have to divide by 4
        //Given
        String d1 = "32.00";
        String d2 = "4.00";

        //When
        Calculator t = new Calculator();
        BigDecimal result = t.division(d1,d2);

        //Then
        Assertions.assertEquals(new BigDecimal("8"),result);
    }

    @Test
    @DisplayName("Should fail when divide by zero")
    void shouldFailWhenDivideByZero() {
        //Scenario: I have a number divide by zero
        //Given
        String d1 = "32.00";
        String d2 = "0.00";

        //When - Divide by Zero should raise a error.
        Calculator test = new Calculator();

        //Then
        Assertions.assertThrows(ArithmeticException.class,() -> {test.division(d1,d2);});

    }
    @Test
    @DisplayName("Should calculate the multiplication")
    void shouldCalculateTheMultiplication () {
        //Given - I have to two numbers to multiplier
        String d1 = "5.1";
        String d2 = "5.5";

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
        String d1 = "734.32";
        String d2 = "476.87";

        //When - I add this two values
        Calculator calculator = new Calculator();
        BigDecimal result = calculator.subtraction(d1,d2);

        //Then I will get this result
        Assertions.assertEquals(new BigDecimal("257.45"),result);

    }
}