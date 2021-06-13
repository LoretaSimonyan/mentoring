package junittests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CosTest extends BaseTest {

    @ParameterizedTest
    @CsvSource({"90, 0", "60, 0.5"})
    public void cosTest(double a,  double expectedResult) {
        double actualResult = calculator.cos(a);
        assertEquals(expectedResult, actualResult);
    }
}
