package ueb09;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

/**
 * Tests der Methoden, die bereits im Tutorium vorgestellt wurden.
 * @author klk
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MyListTest {

    /**
     * Erzeugt eine Liste mit den übergebenen Werten.
     * @param value Werte, die in die Liste eingefügt werden sollen.
     * @return Liste mit den Werten.
     */
    private MyList createList(int... value) {
        MyList list = new MyList();
        for (int i : value) {
            list.appendElement(i);
        }
        return list;
    }

//<editor-fold defaultstate="collapsed" desc="Methodentests für Methoden aus dem Tutorium">
    //-----------------------------------------------

    @Test
    public void testIsEmpty() {
        MyList list = new MyList();
        assertTrue(list.isEmpty());
        list = createList(1);
        assertFalse(list.isEmpty());
    }

    @Test
    public void testAppendElement() {
        MyList list = new MyList();
        assertEquals(0, list.size());
        list.appendElement(1);
        assertEquals(1, list.size());
    }

    //-----------------------------------------------

    @Test
    public void testInsertElement_InEmptyList() {
        MyList list = createList();
        list.insertElement(0);
        assertEquals(1, list.size());
    }

    @Test
    public void testInsertElement_AtFront() {
        MyList list = createList(1, 2, 3);
        list.insertElement(0);
        assertEquals(4, list.size());
        assertArrayEquals(new int[]{0, 1, 2, 3}, list.getValues());
    }

    @Test
    public void testInsertElement_InMiddle() {
        MyList list = createList(0, 2, 3);
        list.insertElement(1);
        assertEquals(4, list.size());
        assertArrayEquals(new int[]{0, 1, 2, 3}, list.getValues());
    }

    @Test
    public void testInsertElement_AtEnd() {
        MyList list = createList(0, 1, 2);
        list.insertElement(3);
        assertEquals(4, list.size());
        assertArrayEquals(new int[]{0, 1, 2, 3}, list.getValues());
    }

    //-----------------------------------------------

    @Test
    public void testDeleteElement_AtFront() {
        MyList list = createList(0, 1, 2);
        list.deleteElement(0);
        assertEquals(2, list.size());
        assertArrayEquals(new int[]{1, 2}, list.getValues());
    }

    @Test
    public void testDeleteElement_InMiddle() {
        MyList list = createList(0, 1, 2);
        list.deleteElement(1);
        assertEquals(2, list.size());
        assertArrayEquals(new int[]{0, 2}, list.getValues());
    }

    @Test
    public void testDeleteElement_AtEnd() {
        MyList list = createList(0, 1, 2);
        list.deleteElement(2);
        assertEquals(2, list.size());
        assertArrayEquals(new int[]{0, 1}, list.getValues());
    }

    @Test
    public void testDeleteElement_NotExisting() {
        MyList list = createList(0, 1, 2);
        list.deleteElement(3);
        assertEquals(3, list.size());
        assertArrayEquals(new int[]{0, 1, 2}, list.getValues());
    }

    @Test
    public void testDeleteElement_EmptyList() {
        MyList list = createList();
        list.deleteElement(3);
        assertEquals(0, list.size());
        assertArrayEquals(new int[]{}, list.getValues());
    }
//</editor-fold>


    //-----------------------------------------------

    @Test
    public void testSum_EmptyList() {
        MyList list = createList();
        assertEquals(0, list.sum());
    }

    @Test
    public void testSum_OneElement() {
        MyList list = createList(10);
        assertEquals(10, list.sum());
    }

    @Test
    public void testSum_MultipleElements() {
        MyList list = createList(1, 2, 3, 4, 5);
        assertEquals(15, list.sum());
    }

    @Test
    public void testIsSorted_EmptyList() {
        MyList list = createList();
        assertTrue(list.isSorted());
    }

    @Test
    public void testIsSorted_OneElement() {
        MyList list = createList(10);
        assertTrue(list.isSorted());
    }

    @Test
    public void testIsSorted_MultipleElements1() {
        MyList list = createList(1, 2, 3, 4, 5);
        assertTrue(list.isSorted());
    }

    @Test
    public void testIsSorted_MultipleElements2() {
        MyList list = createList(1, 1, 3, 4, 5);
        assertTrue(list.isSorted());
    }

    @Test
    public void testIsSorted_MultipleElements3() {
        MyList list = createList(5, 4, 3, 2, 1);
        assertFalse(list.isSorted());
    }

    @Test
    public void testIsSorted_MultipleElements4() {
        MyList list = createList(20, 1, 3, 4, 5);
        assertFalse(list.isSorted());
    }

    @Test
    public void testExistsElement_EmptyList() {
        MyList list = createList();
        assertFalse(list.existsElement(1));
    }

    @Test
    public void testExistsElement_ListOfOne() {
        MyList list = createList(10);
        assertTrue(list.existsElement(10));
        assertFalse(list.existsElement(20));
    }

    @Test
    public void testExistsElement_ListOfFive() {
        MyList list = createList(1, 2, 3, 4, 5);
        assertTrue(list.isSorted());
    }

    @Test
    public void testShowValues_EmptyList() {
        MyList list = createList();
        assertEquals("{}", list.showValues());
    }

    @Test
    public void testShowValues_ListOfTwo() {
        MyList list = createList(1, 2);
        assertEquals("{1 2}", list.showValues());
    }

    @Test
    public void testGetValueAt_EmptyList() {
        MyList list = createList();
        assertEquals(Integer.MAX_VALUE, list.getValueAt(0));
    }

    @Test
    public void testGetValueAt_ListOfTwo() {
        MyList list = createList(1, 2);
        assertEquals(1, list.getValueAt(0));
    }

    @Test
    public void testInsertElementAt_EmptyList() {
        MyList list = createList();
        list.insertElementAt(10, 1);
        assertEquals(0, list.size());
        assertArrayEquals(new int[]{}, list.getValues());
        list.insertElementAt(11, 0);
        assertEquals(1, list.size());
        assertArrayEquals(new int[]{11}, list.getValues());
    }

    @Test
    public void testInsertElementAt_ListOfTwo() {
        MyList list = createList(1, 2);
        list.insertElementAt(10, 3);
        assertEquals(2, list.size());
        assertArrayEquals(new int[]{1, 2}, list.getValues());
        list.insertElementAt(11, 2);
        assertEquals(3, list.size());
        assertArrayEquals(new int[]{1, 2, 11}, list.getValues());
        list.insertElementAt(12, 0);
        assertEquals(4, list.size());
        assertArrayEquals(new int[]{12, 1, 2, 11}, list.getValues());
    }

    @Test
    public void testInsertElementAtFront_EmptyList() {
        MyList list = createList();
        list.insertElementAtFront(10);
        assertEquals(1, list.size());
        assertArrayEquals(new int[]{10}, list.getValues());
    }

    @Test
    public void testInsertElementAtFront_ListOfTwo() {
        MyList list = createList(1, 2);
        list.insertElementAtFront(10);
        assertEquals(3, list.size());
        assertArrayEquals(new int[]{10, 1, 2}, list.getValues());
    }

    @Test
    public void testInsertSortedIfUnique_EmptyList() {
        MyList list = createList();
        list.insertSortedIfUnique(10);
        assertEquals(1, list.size());
        assertArrayEquals(new int[]{10}, list.getValues());
    }

    @Test
    public void testInsertSortedIfUnique_ListOfTwo() {
        MyList list = createList(1, 2, 10);
        list.insertSortedIfUnique(10);
        assertEquals(3, list.size());
        assertArrayEquals(new int[]{1, 2, 10}, list.getValues());
        list.insertSortedIfUnique(11);
        assertEquals(4, list.size());
        assertArrayEquals(new int[]{1, 2, 10, 11}, list.getValues());
    }

    /*  geforderte Situationstests */

    @Test
    public void testListOfThree() {
        MyList list = createList(1, 2, 5);
        assertFalse(list.isEmpty());
        assertTrue(list.isSorted());
        assertEquals(3, list.size());
        assertEquals(8, list.sum());
        assertTrue(list.existsElement(1));
        assertTrue(list.existsElement(2));
        assertTrue(list.existsElement(5));
        assertFalse(list.existsElement(15));
        assertEquals(1, list.getValueAt(0));
        assertEquals(2, list.getValueAt(1));
        assertEquals(5, list.getValueAt(2));
        assertEquals(Integer.MAX_VALUE, list.getValueAt(-1));
    }

    @Test
    public void testListWithDoubleValues() {
        MyList list = createList(1, 2, 2, 3);
        assertFalse(list.isEmpty());
        assertTrue(list.isSorted());
        assertEquals(4, list.size());
        assertEquals(8, list.sum());
        assertTrue(list.existsElement(1));
        assertTrue(list.existsElement(2));
        assertTrue(list.existsElement(3));
        assertFalse(list.existsElement(15));
        assertEquals(1, list.getValueAt(0));
        assertEquals(2, list.getValueAt(1));
        assertEquals(2, list.getValueAt(2));
        assertEquals(3, list.getValueAt(3));
        assertEquals(Integer.MAX_VALUE, list.getValueAt(-1));
    }

    @Test
    public void testListUnsortedAtBegin() {
        MyList list = createList(2, 1, 3);
        assertFalse(list.isEmpty());
        assertFalse(list.isSorted());
        assertEquals(3, list.size());
        assertEquals(6, list.sum());
        assertTrue(list.existsElement(2));
        assertTrue(list.existsElement(1));
        assertTrue(list.existsElement(3));
        assertFalse(list.existsElement(15));
        assertEquals(2, list.getValueAt(0));
        assertEquals(1, list.getValueAt(1));
        assertEquals(3, list.getValueAt(2));
        assertEquals(Integer.MAX_VALUE, list.getValueAt(-1));
    }

    @Test
    public void testListEmpty() {
        MyList list = createList();
        assertTrue(list.isEmpty());
        assertTrue(list.isSorted());
        assertEquals(0, list.size());
        assertEquals(0, list.sum());
        assertFalse(list.existsElement(15));
        assertEquals(Integer.MAX_VALUE, list.getValueAt(0));
    }

    /*TODO Test ListOfThree mit Liste    {1, 2, 5}    */
    /*TODO Test ListWithDoubleValues mit {1, 2, 2, 3} */
    /*TODO Test ListUnsortedAtBegin  mit {2, 1, 3}    */
    /*TODO Test ListEmpty            mit {}           */

    /*
    zu testen ist jeweils
    - ist leer
    - ist sortiert
    - Listenlänge
    - Summe
    - existiert der Wert [..] (alle vorhandenen und mindestens einen nicht vorhandenen Wert prüfen)
    - getValueAt für jeden vorhandenen Wert und für mindestens einen falschen Index

    zu verwenden sind
    - assertTrue(), assertFalse(), assertEquals() !nicht auf Referenzen
    */

}