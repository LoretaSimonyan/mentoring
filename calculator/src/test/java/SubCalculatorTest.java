import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;

public class SubCalculatorTest extends BaseTest{

    @Test(dataProvider = "valuesForSubOfIntegers", groups = "passed")
    public void subOfTwoIntegers(long a, long b, long expectedValues) {
        long result = calculator.sub(a, b);
        Assert.assertEquals(result, expectedValues);
    }

    @Test(dataProvider = "valuesForSubOfDoubles", groups = "passed")
    public void subOfTwoIntegers(double a, double b, double expectedValues) {
        double result = calculator.sub(a, b);
        Assert.assertEquals(result, expectedValues);
    }

    @DataProvider(name = "valuesForSubOfDoubles")
    public Object[][] valuesForSubOfTwoDoubles() {
        return new Object[][]{
                {10.4, 0.3, 10.1},
                {10.5, -1, 11.5},
                {0, 0, 0},
                {-1.1, 10, -11.1}
        };

    }

    @DataProvider(name = "valuesForSubOfIntegers")
    public Object[][] valuesForSubOfTwoIntegers() {
            return new Object[][]{
                    {10, 23, -13},
                    {10, -1, 11},
                    {0, 0, 0},
                    {-1, 10, -11}
            };

    }
}
