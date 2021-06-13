package junittests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CtgTest extends BaseTest{

    @ParameterizedTest
    @CsvSource({"90, 0", "45, 1"})
    public void ctgTest(double a,  double expectedResult) {
        double actualResult = calculator.ctg(a);
        assertEquals(expectedResult, actualResult);
    }
}
