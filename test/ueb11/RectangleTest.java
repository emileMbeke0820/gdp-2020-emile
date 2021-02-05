package ueb11;

import org.junit.Test;
import static org.junit.Assert.*;



public class RectangleTest {

    @Test
    public void getArea() {
        Rectangle rectangle = new Rectangle(new Color(Color.ColorNames.GREEN), 1, 2);
        assertEquals(2.0, rectangle.getArea(), Double.MIN_VALUE);
    }

    @Test
    public void getPerimeter() {
        Rectangle rectangle = new Rectangle(new Color(Color.ColorNames.GREEN), 1, 2);
        assertEquals(6.0, rectangle.getPerimeter(), Double.MIN_VALUE);
    }

    @Test
    public void getDescription() {
        Rectangle rectangle = new Rectangle(new Color(Color.ColorNames.GREEN), 1, 2);
        assertEquals("Rechteck mit Kantenlängen (  1,00,   2,00)", rectangle.getDescription());
    }
}