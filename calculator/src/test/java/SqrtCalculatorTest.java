import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SqrtCalculatorTest extends BaseTest{
    @Test(dataProvider = "valuesForSqrtCalculatorTest", groups = "passed")
    public void powOfTwoNumbers(double a,double expectedResult) {
        double actualResult = calculator.sqrt(a);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @DataProvider(name = "valuesForSqrtCalculatorTest")
    public Object[][] valuesForSqrt() {
        return new Object[][]{
                {1.21, 1.1},
                {156.25, 12.5},
        };
    }
}
