import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SumCalculatorTest extends BaseTest {

    @Test(dataProvider = "valuesForSumTestDouble", groups = "failed")
    public void sumOfNumbers(double firstNumber, double secondNumber, double expectedValue) {
        double result = calculator.sum(firstNumber, secondNumber);
        Assert.assertEquals(result, expectedValue);
    }
    @Test(dataProvider = "valuesForSumIntTest", groups = "passed")
    public void sumOfNumbersForIntegers(long firstNumber, long secondNumber, long expectedValue) {
        double result = calculator.sum(firstNumber, secondNumber);
        Assert.assertEquals(result, expectedValue);
    }


    @DataProvider(name = "valuesForSumTestDouble")
    public Object[][] valuesForSumDouble() {
        return new Object[][]{
                {10.9, 0.3, 11.2},
                {-10.5, -1, 11.5},
                {-12.9, 10.3, -2.6}
        };

    }

    @DataProvider(name = "valuesForSumIntTest")
    public Object[][] valuesForSumInt() {
        return new Object[][]{
                {10, 3, 13},
                {-10, -1, -11},
                {0, 0, 0},
                {-12, 10, -2}
        };
    }
}
