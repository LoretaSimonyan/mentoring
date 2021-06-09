import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SumCalculatorTest extends BaseTest {

    @Test(dataProvider = "valuesForSumTest")
    public void sumOfNumbers(double firstNumber, double secondNumber, double expectedValue) {
        double result = calculator.sum(firstNumber, secondNumber);
        Assert.assertEquals(result, expectedValue);
    }

    @DataProvider(name = "valuesForSumTest")
    public Object[][] valuesForSum() {
        return new Object[][]{
                {10.9, 0.3, 11.2},
                {-10.5, -1, 11.5},
                {0, 0, 0},
                {-12.9, 10.3, -2.6}
        };

    }
}
