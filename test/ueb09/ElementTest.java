package ueb09;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

/**
 * Tests der Methoden aus der Klasse ueb09.Element.
 * @author klk
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ElementTest {

    /**
     * Erzeugt ein ueb09.Element mit übergebenem Wert, bei mehreren Werten werden
     * weitere Elemente angehängt.
     * @param value Wert(e) des Elements/der Elemente
     * @return ueb09.Element mit Wert, bei mehreren Werten mehrere aneinandergehängte
     *         Elemente
     */
    private Element createElements(int... value){
        if (value.length == 0) {
            return null;
        }
        // ein ueb09.Element anlegen
        Element el = new Element();
        el.setValue(value[0]);
        Element firstEl = el; //erstes ueb09.Element merken

        // weitere Elemente anlegen
        for (int i = 1; i < value.length; i++) {
            el.setNext(new Element()) ;
            el = el.getNext();
            el.setValue(value[i]);
        }
        return firstEl;
    }

    //-----------------------------------------------

    @Test
    public void testAppendElement_ToOneElement() {
        Element el = new Element();
        el.setValue(0);
        Element result = el.appendElement(1);
        assertEquals(0, result.getValue());
        assertEquals(1, result.getNext().getValue());
        assertNull(result.getNext().getNext());
    }

    @Test
    public void testAppendElement_Twice() {
        Element el = new Element();
        el.setValue(0);
        Element result = el.appendElement(1).appendElement(2);
        assertEquals(0, result.getValue());
        assertEquals(1, result.getNext().getValue());
        assertEquals(2, result.getNext().getNext().getValue());
        assertNull(result.getNext().getNext().getNext());
    }

    //-----------------------------------------------

    @Test
    public void testInsertElement_AtFront() {
        Element el = createElements(1, 3);
        Element result = el.insertElement(0);
        assertEquals(0, result.getValue());
        assertEquals(1, result.getNext().getValue());
        assertEquals(3, result.getNext().getNext().getValue());
        assertNull(result.getNext().getNext().getNext());
    }

    @Test
    public void testInsertElement_InMiddle() {
        Element el = createElements(1, 3);
        Element result = el.insertElement(2);
        assertEquals(1, result.getValue());
        assertEquals(2, result.getNext().getValue());
        assertEquals(3, result.getNext().getNext().getValue());
        assertNull(result.getNext().getNext().getNext());
    }

    @Test
    public void testInsertElement_AtEnd() {
        Element el = createElements(1, 3);
        Element result = el.insertElement(4);
        assertEquals(1, result.getValue());
        assertEquals(3, result.getNext().getValue());
        assertEquals(4, result.getNext().getNext().getValue());
        assertNull(result.getNext().getNext().getNext());
    }

    //-----------------------------------------------

    @Test
    public void testDeleteElement_AtFront() {
        Element el = createElements(0, 1, 2);
        Element result = el.deleteElement(0);
        assertEquals(1, result.getValue());
        assertEquals(2, result.getNext().getValue());
        assertNull(result.getNext().getNext());
    }

    @Test
    public void testDeleteElement_InMiddle() {
        Element el = createElements(0, 1, 2);
        Element result = el.deleteElement(1);
        assertEquals(0, result.getValue());
        assertEquals(2, result.getNext().getValue());
        assertNull(result.getNext().getNext());
    }

    @Test
    public void testDeleteElement_AtEnd() {
        Element el = createElements(0, 1, 2);
        Element result = el.deleteElement(2);
        assertEquals(0, result.getValue());
        assertEquals(1, result.getNext().getValue());
        assertNull(result.getNext().getNext());
    }

    @Test
    public void testDeleteElement_NotExisting() {
        Element el = createElements(0, 1, 2);
        Element result = el.deleteElement(3);
        assertEquals(0, result.getValue());
        assertEquals(1, result.getNext().getValue());
        assertEquals(2, result.getNext().getNext().getValue());
        assertNull(result.getNext().getNext().getNext());
    }

    //-----------------------------------------------

    @Test
    public void testSize() {
        Element el = createElements(0);
        assertEquals(1, el.size());

        el = createElements(0, 1, 2);
        assertEquals(3, el.size());
    }

    //-----------------------------------------------

    @Test
    public void testSum() {
        Element el = createElements(1, 2, 3);
        assertEquals(6, el.sum());
    }

    //-----------------------------------------------

    @Test
    public void testExistsElement_First() {
        Element el = createElements(1, 2, 4);
        assertTrue(el.existsElement(1));
    }

    @Test
    public void testExistsElement_Middle() {
        Element el = createElements(1, 2, 4);
        assertTrue(el.existsElement(2));
    }

    @Test
    public void testExistsElement_Last() {
        Element el = createElements(1, 2, 4);
        assertTrue(el.existsElement(4));
    }

    @Test
    public void testExistsElement_NotExisting() {
        Element el = createElements(1, 2, 4);
        assertFalse(el.existsElement(0));
        assertFalse(el.existsElement(3));
        assertFalse(el.existsElement(5));
    }

    //-----------------------------------------------

    @Test
    public void testIsSorted_Gapless() {
        Element el = createElements(1, 2, 3);
        assertTrue(el.isSorted());
    }

    @Test
    public void testIsSorted_WithGaps() {
        Element el = createElements(0, 2, 4);
        assertTrue(el.isSorted());
    }

    @Test
    public void testIsSorted_DoubleValues() {
        Element el = createElements(1, 1, 4);
        assertTrue(el.isSorted());
        el = createElements(1, 4, 4);
        assertTrue(el.isSorted());
        el = createElements(1, 2, 2, 4, 4);
        assertTrue(el.isSorted());
    }

    @Test
    public void testIsSorted_NotSorted() {
        Element el = createElements(0, 1, 3, 2);
        assertFalse(el.isSorted());
        el = createElements(0, 2, 1, 3);
        assertFalse(el.isSorted());
        el = createElements(1, 2, 0, 3);
        assertFalse(el.isSorted());
    }

    //-----------------------------------------------

    @Test
    public void testShowValues() {
        Element el = createElements(0, 1, 2);
        assertEquals("0 1 2", el.showValues());

        el = createElements(1);
        assertEquals("1", el.showValues());
    }

    //-----------------------------------------------

    @Test
    public void testGetValueAt() {
        Element el = createElements(11, 22, 33);
        assertEquals(11, el.getValueAt(0));
        assertEquals(22, el.getValueAt(1));
        assertEquals(33, el.getValueAt(2));
    }

    @Test
    public void testGetValueAt_InvalidArgument() {
        Element el = createElements(11, 22, 33);
        assertEquals(Integer.MAX_VALUE, el.getValueAt(-1));
        assertEquals(Integer.MAX_VALUE, el.getValueAt(3));
    }

    //-----------------------------------------------

    @Test
    public void testInsertElementAt_Front() {
        Element el = createElements(0, 1, 2);
        Element result = el.insertElementAt(11, 0);
        assertEquals(11, result.getValue());
        assertEquals(0, result.getNext().getValue());
    }

    @Test
    public void testInsertElementAt_Middle() {
        Element el = createElements(0, 1, 2);
        Element result = el.insertElementAt(11, 1);
        assertEquals(0, result.getValue());
        assertEquals(11, result.getNext().getValue());
    }

    @Test
    public void testInsertElementAt_End() {
        Element el = createElements(0, 1);
        Element result = el.insertElementAt(11, 2);
        assertEquals(0, result.getValue());
        assertEquals(1, result.getNext().getValue());
        assertEquals(11, result.getNext().getNext().getValue());
        assertNull(result.getNext().getNext().getNext());
    }

    @Test
    public void testInsertElementAt_InvalidIndex() {
        Element el = createElements(1, 2);
        Element result = el.insertElementAt(11, -1);
        assertEquals(2, result.size());
        assertEquals(1, result.getValue());
        assertEquals(2, result.getNext().getValue());
        assertNull(result.getNext().getNext());

        el = createElements(1, 2);
        result = el.insertElementAt(11, 3);
        assertEquals(2, result.size());
        assertEquals(1, result.getValue());
        assertEquals(2, result.getNext().getValue());
        assertNull(result.getNext().getNext());
    }

    //-----------------------------------------------

    @Test
    public void testInsertElementAtFront() {
        Element el = createElements(0, 1);
        Element result = el.insertElementAtFront(11);
        assertEquals(11, result.getValue());
        assertEquals(0, result.getNext().getValue());
        assertEquals(1, result.getNext().getNext().getValue());
        assertNull(result.getNext().getNext().getNext());
    }

}