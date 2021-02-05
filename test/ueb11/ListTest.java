package ueb11;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ListTest {

    @Test
    public void testAddElementInOrder() {
        List list = new List();

        list.addElementInOrder(new Circle(new Color(0xFF, 0xFF, 0xFF), 5));
        list.addElementInOrder(new Circle(new Color(0xFF, 0xFF, 0xFF), 4));
        list.addElementInOrder(new Circle(new Color(0xFF, 0xFF, 0xFF), 2));
        list.addElementInOrder(new Circle(new Color(0xFF, 0xFF, 0xFF), 3));
        list.addElementInOrder(new Circle(new Color(0xFF, 0xFF, 0xFF), 1));

        assertEquals("" +
                        " 1. WHITE      Kreis    mit Durchmesser  (  5,00),                 Umfang:  15,71, Fläche:  19,63\n" +
                        " 2. WHITE      Kreis    mit Durchmesser  (  4,00),                 Umfang:  12,57, Fläche:  12,57\n" +
                        " 3. WHITE      Kreis    mit Durchmesser  (  3,00),                 Umfang:   9,42, Fläche:   7,07\n" +
                        " 4. WHITE      Kreis    mit Durchmesser  (  2,00),                 Umfang:   6,28, Fläche:   3,14\n" +
                        " 5. WHITE      Kreis    mit Durchmesser  (  1,00),                 Umfang:   3,14, Fläche:   0,79"
                , list.toString());
    }

    @Test
    public void testSize() {
        List list = new List();
        assertEquals(0, list.size());

        list.addElementInOrder(new Circle(new Color(0xFF, 0xFF, 0xFF), 1));
        assertEquals(1, list.size());

        list.addElementInOrder(new Circle(new Color(0xFF, 0xFF, 0xFF), 2));
        assertEquals(2, list.size());
    }

    @Test
    public void testToString() {
        List list = new List();
        assertEquals("", list.toString());

        list.addElementInOrder(new Rectangle(new Color(0,0,0), 2, 3));
        assertEquals("" +
                        " 1. BLACK      Rechteck mit Kantenlängen (  2,00,   3,00),         Umfang:  10,00, Fläche:   6,00"
                , list.toString());

        list.addElementInOrder(new Circle(new Color(0xFF, 0xFF, 0xFF), 3));
        assertEquals("" +
                        " 1. WHITE      Kreis    mit Durchmesser  (  3,00),                 Umfang:   9,42, Fläche:   7,07\n" +
                        " 2. BLACK      Rechteck mit Kantenlängen (  2,00,   3,00),         Umfang:  10,00, Fläche:   6,00"
                , list.toString());
    }
}