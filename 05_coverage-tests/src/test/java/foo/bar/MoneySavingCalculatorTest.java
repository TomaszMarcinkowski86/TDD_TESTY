package foo.bar;

import com.sun.org.glassfish.gmbal.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Period;

public class MoneySavingCalculatorTest {

    MoneySavingCalculator calc = new MoneySavingCalculator();


    @ParameterizedTest(name = "During period of {3} year, when saving is {2} {1}," +
            " total savings should be {0}")
    @CsvSource({
            "1000.00, ONCE_A_YEAR, 1000.00, 1",
            "3000.00, ONCE_A_YEAR, 1000.00, 3",
            "3600.00, EACH_MONTH, 100.00, 3"


    })
       void shouldReturnExpectedSaving(double expectedValue,
                                          SavingFrequency frecuency,
                                          double singleAmmount,
                                          int years) {
        Assertions.assertEquals(
                BigDecimal.valueOf(expectedValue),
                calc.calculateSavings(frecuency,
                        BigDecimal.valueOf(singleAmmount), Period.ofYears(years))
        );
    }

}
