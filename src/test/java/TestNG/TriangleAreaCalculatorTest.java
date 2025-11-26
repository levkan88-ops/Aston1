import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class TriangleAreaCalculatorTest {
    @Test public void testArea() { assertEquals(TriangleAreaCalculator.triangleArea(3, 4, 5), 6.0); }
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testInvalid() { TriangleAreaCalculator.triangleArea(0, 4, 5); }
}
