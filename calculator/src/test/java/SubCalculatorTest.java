import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;

public class SubCalculatorTest extends BaseTest{

    @Test(dataProvider = "valuesForSubTest")
    public void subOfTwoNumbers(long a, long b, long expectedValues) {
        long result = calculator.sub(a, b);
        Assert.assertEquals(result, expectedValues);
    }

    @DataProvider(name = "valuesForSubTest")
    public Object[][] valuesForSum() {
            return new Object[][]{
                    {10, 23, -13},
                    {10, -1, 11},
                    {0, 0, 0},
                    {-1, 10, -11}
            };

    }
}
