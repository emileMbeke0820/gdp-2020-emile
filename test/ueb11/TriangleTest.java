package ueb11;

import org.junit.Test;
import static org.junit.Assert.*;


public class TriangleTest {
    @Test
    public void getArea() {
        Triangle triangle = new Triangle(new Color(Color.ColorNames.GREEN), 16, 18, 8);
        assertEquals(63.99218702310463, triangle.getArea(), Double.MIN_VALUE);
    }

    @Test
    public void getPerimeter() {
        Triangle triangle = new Triangle(new Color(Color.ColorNames.GREEN), 1, 5, 3);
        assertEquals(9.0, triangle.getPerimeter(), Double.MIN_VALUE);
    }

    @Test
    public void getDescription() {
        Triangle triangle = new Triangle(new Color(Color.ColorNames.GREEN), 1, 5, 3);
        assertEquals("Dreieck  mit Kantenlängen (  1,00,   5,00,   3,00)", triangle.getDescription());
    }
}