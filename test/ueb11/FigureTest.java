package ueb11;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FigureTest {

    @Test
    public void testGetArea() {
        Figure figure = new Figure() {};
        assertEquals(0, figure.getArea(), 0.01);
    }

    @Test
    public void testGetPerimeter() {
        Figure figure = new Figure() {};
        assertEquals(0, figure.getPerimeter(), 0.01);
    }

    @Test
    public void testGetDescription() {
        Figure figure = new Figure() {};
        assertEquals("", figure.getDescription());
    }

    @Test
    public void testCompare() {
        Figure figure1 = new Figure() {};
        Figure figure2 = new Figure() {};
        assertEquals(0, figure1.compare(figure2));
    }

    @Test
    public void testToString() {
        Figure figure = new Figure() {};
        assertEquals("unknown    ,                                                   Umfang:   0,00, Fläche:   0,00", figure.toString()); //stuff in the middle comes from getDescription later
    }
}