import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultipleCalculatorTest extends BaseTest {

    @Test(dataProvider = "valuesForMultipleOfIntegers", groups = "passed")
    public void mulOfTwoIntegers(long a, long b, long expectedValues) {
        long result = calculator.mult(a, b);
        Assert.assertEquals(result, expectedValues);
    }

    @Test(dataProvider = "valuesForMultipleOfDoubles", groups = "failed")
    public void multipleOfTwoIntegers(double a, double b, double expectedValues) {
        double result = calculator.mult(a, b);
        Assert.assertEquals(result, expectedValues);
    }

    @DataProvider(name = "valuesForMultipleOfDoubles")
    public Object[][] valuesForMultipleOfTwoDoubles() {
        return new Object[][]{
                {10.4, 0.3, 3.12},
                {10.5, -1.0, -10.5},
                {-1.1, -10.3, -11.33}
        };

    }

    @DataProvider(name = "valuesForMultipleOfIntegers")
    public Object[][] valuesForMultipleOfTwoIntegers() {
        return new Object[][]{
                {3, 4, 12},
                {10, -9, -90},
                {0, 0, 0},
                {-1, -10, 10}
        };
    }
}