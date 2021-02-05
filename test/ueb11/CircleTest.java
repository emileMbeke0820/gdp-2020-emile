package ueb11;

import org.junit.Test;
import static org.junit.Assert.*;

public class CircleTest {
    @Test
    public void getArea() {
        Circle circle = new Circle(new Color(Color.ColorNames.GREEN), 1.5);
        assertEquals(1.7671458676442586, circle.getArea(), Double.MIN_VALUE);
    }

    @Test
    public void getPerimeter() {
        Circle circle = new Circle(new Color(Color.ColorNames.GREEN), 1.5);
        assertEquals(4.71238898038469, circle.getPerimeter(), Double.MIN_VALUE);
    }

    @Test
    public void getDescription() {
        Circle circle = new Circle(new Color(Color.ColorNames.GREEN), 1.5);
        assertEquals("Kreis    mit Durchmesser  (  1,50)", circle.getDescription());
    }
}