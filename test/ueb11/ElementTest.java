package ueb11;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ElementTest {
    Element createList(Figure[] figures) {
        Element list = null;

        for (Figure figure : figures) {
            if (list == null) {
                list = new Element(figure);
            } else {
                list = list.addElementInOrder(figure);
            }
        }

        return list;
    }

    @Test
    public void testAddElementInOrder() {
        Figure[] figures = {
                new Rectangle(new Color(0,0,0), 2, 3),
                new Circle(new Color(0xFF, 0xFF, 0xFF), 3),
                new Triangle(new Color(0xFF, 0xFF, 0xFF), 3, 3, 3),
                new Square(new Color(0xFF, 0xFF, 0xFF), 3)
        };
        Element list = createList(figures);
        assertEquals(4, list.size());
    }

    @Test
    public void testAddElementInOrderWithOrderedInput() {
        Figure[] figures = {
                new Circle(new Color(0xFF, 0xFF, 0xFF), 1),
                new Circle(new Color(0xFF, 0xFF, 0xFF), 3),
                new Circle(new Color(0xFF, 0xFF, 0xFF), 2),
                new Circle(new Color(0xFF, 0xFF, 0xFF), 5),
                new Circle(new Color(0xFF, 0xFF, 0xFF), 4),
        };
        Element list = createList(figures);
        assertEquals("" +
                        " 1. WHITE      Kreis    mit Durchmesser  (  5,00),                 Umfang:  15,71, Fläche:  19,63\n" +
                        " 2. WHITE      Kreis    mit Durchmesser  (  4,00),                 Umfang:  12,57, Fläche:  12,57\n" +
                        " 3. WHITE      Kreis    mit Durchmesser  (  3,00),                 Umfang:   9,42, Fläche:   7,07\n" +
                        " 4. WHITE      Kreis    mit Durchmesser  (  2,00),                 Umfang:   6,28, Fläche:   3,14\n" +
                        " 5. WHITE      Kreis    mit Durchmesser  (  1,00),                 Umfang:   3,14, Fläche:   0,79"
                , list.toString());
    }

    @Test
    public void testAddElementInOrderWithUnorderedInput() {
        Figure[] figures = {
                new Circle(new Color(0xFF, 0xFF, 0xFF), 4),
                new Circle(new Color(0xFF, 0xFF, 0xFF), 2),
                new Circle(new Color(0xFF, 0xFF, 0xFF), 3),
                new Circle(new Color(0xFF, 0xFF, 0xFF), 5),
                new Circle(new Color(0xFF, 0xFF, 0xFF), 1),
        };
        Element list = createList(figures);
        assertEquals("" +
                        " 1. WHITE      Kreis    mit Durchmesser  (  5,00),                 Umfang:  15,71, Fläche:  19,63\n" +
                        " 2. WHITE      Kreis    mit Durchmesser  (  4,00),                 Umfang:  12,57, Fläche:  12,57\n" +
                        " 3. WHITE      Kreis    mit Durchmesser  (  3,00),                 Umfang:   9,42, Fläche:   7,07\n" +
                        " 4. WHITE      Kreis    mit Durchmesser  (  2,00),                 Umfang:   6,28, Fläche:   3,14\n" +
                        " 5. WHITE      Kreis    mit Durchmesser  (  1,00),                 Umfang:   3,14, Fläche:   0,79"
                , list.toString());
    }

    @Test
    public void testToStringOneElement() {
        Figure[] figures = {
                new Rectangle(new Color(0,0,0), 2, 3)
        };
        Element list = createList(figures);
        assertEquals("" +
                        " 1. BLACK      Rechteck mit Kantenlängen (  2,00,   3,00),         Umfang:  10,00, Fläche:   6,00"
                , list.toString());
    }

    @Test
    public void testToStringTwoElements() {
        Figure[] figures = {
                new Rectangle(new Color(0,0,0), 2, 3),
                new Circle(new Color(0xFF, 0xFF, 0xFF), 3)
        };
        Element list = createList(figures);
        assertEquals("" +
                        " 1. WHITE      Kreis    mit Durchmesser  (  3,00),                 Umfang:   9,42, Fläche:   7,07\n" +
                        " 2. BLACK      Rechteck mit Kantenlängen (  2,00,   3,00),         Umfang:  10,00, Fläche:   6,00"
                , list.toString());
    }
}