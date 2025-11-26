import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class FactorialCalculatorTest {
    @Test public void testFactorial() { assertEquals(FactorialCalculator.factorial(5), 120); }
    @Test public void testZero() { assertEquals(FactorialCalculator.factorial(0), 1); }
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testNegative() { FactorialCalculator.factorial(-1); }
}
