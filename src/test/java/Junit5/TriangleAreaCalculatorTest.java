import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TriangleAreaCalculatorTest {
    @Test void testArea() { assertEquals(6.0, TriangleAreaCalculator.triangleArea(3, 4, 5)); }
    @Test void testInvalid() {
        assertThrows(IllegalArgumentException.class,
            () -> TriangleAreaCalculator.triangleArea(0, 4, 5));
    }
}
