package junittests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TgTest extends BaseTest{

    @ParameterizedTest
    @CsvSource({"0, 0", "90, 1"})
    public void subDoubleTest(double a,  double expectedResult) {
        double actualResult = calculator.tg(a);
        assertEquals(expectedResult, actualResult);
    }
}
