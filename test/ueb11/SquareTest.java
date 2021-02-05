package ueb11;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SquareTest {
    @Test
    public void getArea() {
        Square square = new Square(new Color(Color.ColorNames.GREEN), 1.5);
        assertEquals(2.25, square.getArea(), Double.MIN_VALUE);
    }

    @Test
    public void getPerimeter() {
        Square square = new Square(new Color(Color.ColorNames.GREEN), 1.5);
        assertEquals(6.0, square.getPerimeter(), Double.MIN_VALUE);
    }

    @Test
    public void getDescription() {
        Square square = new Square(new Color(Color.ColorNames.GREEN), 1.5);
        assertEquals("Quadrat  mit Kantenlänge  (  1,50)", square.getDescription());
    }
}