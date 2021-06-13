import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DivCalculatorTest extends BaseTest{

    @Test(dataProvider = "valuesForDivOfIntegers", groups = "passed")
    public void divOfTwoIntegers(long a, long b, long expectedValues) {
        long result = calculator.div(a, b);
        Assert.assertEquals(result, expectedValues);
    }

    @Test(expectedExceptions = NumberFormatException.class, groups = "passed")
    public void  divIntegerToZero(){
         calculator.div(12,0);
    }
    @Test(expectedExceptions = NumberFormatException.class, groups = "failed")
    public void divDoubleToZero(){
        calculator.div(45.6,0.0);
    }

    @Test(dataProvider = "valuesForDivOfDoubles", groups = "passed")
    public void divOfTwoIntegers(double a, double b, double expectedValues) {
        double result = calculator.div(a, b);
        Assert.assertEquals(result, expectedValues);
    }

    @DataProvider(name = "valuesForDivOfDoubles")
    public Object[][] valuesForDivOfTwoDoubles() {
        return new Object[][]{
                {15.0, 2.0, 7.5},
                {0.0, 78.0, 0.0},
                {40.4, 4, 10.1},
                {18.2, -2.0, -9.1}
        };

    }

    @DataProvider(name = "valuesForDivOfIntegers")
    public Object[][] valuesForDivOfTwoIntegers() {
        return new Object[][]{
                {15, 3, 5},
                {0, 2, 0},
                {100, -50, -2},
                {20, -10, -2}
        };
    }
}
