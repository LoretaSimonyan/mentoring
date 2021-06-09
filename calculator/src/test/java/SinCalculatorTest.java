import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SinCalculatorTest extends BaseTest{
    @Test(dataProvider = "valuesForSinCalculatorTest")
    public void subOfTwoNumbers(long a, double expectedResult) {
        double actualResult = calculator.sin(a);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @DataProvider(name = "valuesForSinCalculatorTest")
    public Object[][] valuesForSum() {
        return new Object[][]{
                {30, 0.5},
                {90, 1},
        };
    }
}
