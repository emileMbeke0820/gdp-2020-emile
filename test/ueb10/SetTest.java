package ueb10;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 * Tests für die Mengenoperationen
 *
 * @author rhahn
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SetTest {

    /**
     * Erzeugt eine Menge mit den übergebenen Werten.
     * Erfordert ein funktionierendes addElement.
     * @param value Werte, die in die Liste eingefügt werden sollen.
     * @return Liste mit den Werten.
     */
    private Set createSet(int... value) {
        Set set = new Set();
        for (int i : value) {
            set.addElement(i);
        }
        return set;
    }

    /**
     * Add muss funktionieren.
     */
    @Test
    public void testAddElement() {
        Set set = new Set();
        set.addElement(5);
        set.addElement(2);
        set.addElement(4);
        assertArrayEquals(new int[]{2, 4, 5}, set.getValues());
    }   
    
    /**
     * Gleiche Werte dürfen nicht mehrfach zugefügt werden.
     */
    @Test
    public void testAddElement_SameValues() {
        Set set = new Set();
        set.addElement(5);
        set.addElement(2);
        set.addElement(2);
        set.addElement(4);
        set.addElement(4);
        assertArrayEquals(new int[]{2, 4, 5}, set.getValues());
    }
    
    /**
     * WerteArray muss sortiert erstellt werden.
     */
    @Test
    public void testGetValues() {
        Set set = createSet(1, 2, 3);
        assertArrayEquals(new int[]{1, 2, 3}, set.getValues());
        
        set = createSet(3, 1, 2);
        assertArrayEquals("values have to be sorted", new int[]{1, 2, 3}, set.getValues());
        
        set = new Set();
        assertArrayEquals("empty array", new int[]{}, set.getValues());
    }   
    
    //--- isSame() -------------------------------------------------------------
    
    @Test
    public void testIsSame() {
        Set set1 = createSet(1, 2, 3);
        Set set2 = createSet(1, 2, 3);
        assertTrue(set1.isSame(set2));
    }
    
    @Test
    public void testIsSame_DifferentSizes() {
        assertFalse("same size", createSet(1).isSame(createSet(2)));
        
        assertFalse("fst smaller", createSet(1).isSame(createSet(1, 2)));
        assertFalse("fst smaller", createSet(1, 2).isSame(createSet(1, 2, 3)));
        assertFalse("fst smaller", createSet(1, 2, 3).isSame(createSet(1, 2, 3, 4)));
        
        assertFalse("snd smaller", createSet(1, 2).isSame(createSet(1)));
        assertFalse("snd smaller", createSet(1, 2, 3).isSame(createSet(1, 2)));
        assertFalse("snd smaller", createSet(1, 2, 3, 4).isSame(createSet(1, 2, 3)));
    }    
    
    @Test
    public void testIsSame_DifferenceAtOneElement() {
        assertFalse("differs at last element", createSet(1, 2, 3).isSame(createSet(1, 2, 4)));
        assertFalse("differs at mid  element", createSet(1, 2, 4).isSame(createSet(1, 3, 4)));
        assertFalse("differs at first element", createSet(1, 2, 3).isSame(createSet(0, 2, 3)));
    }

    //--- diff() -------------------------------------------------------------
    @Test
    public void testDiff_emptySet(){
        Set set1 = createSet(1, 2, 3);
        Set set2 = new Set();
        assertArrayEquals(new int[]{1, 2, 3},set1.diff(set2).getValues());
    }
    @Test
    public void testDiff_disjunkt(){
        Set set1 = createSet(1, 2, 3);
        Set set2 = createSet(4, 5, 6);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, set1.diff(set2).getValues());
    }

    @Test
    public void testDiff_ueberschneidung() {
        Set set1 = createSet(1, 2, 3);
        Set set2 = createSet(2, 3, 4);
        assertArrayEquals(new int[]{1, 4}, set1.diff(set2).getValues());
    }
    @Test
    public void testDiff_echteTeilmenge() {
        Set set1 = createSet(1, 2, 3);
        Set set2 = createSet(1, 2, 3);
        assertArrayEquals(new int[]{}, set1.diff(set2).getValues());
        Set set3 = createSet(1, 2, 3, 4);
        assertArrayEquals(new int[]{4}, set1.diff(set3).getValues());
    }

    //--- intersection() -------------------------------------------------------------

    @Test
    public void testIntersection_ueberschneidung() {
        Set set1 = createSet(1, 2, 3);
        Set set2 = createSet(2, 3, 4);
        assertArrayEquals(new int[]{2, 3}, set1.intersection(set2).getValues());
    }
    @Test
    public void testIntersection_emptyList(){
        Set set1 = createSet(1, 2, 3);
        Set set2 = new Set();
        assertArrayEquals(new int[]{},set1.intersection(set2).getValues());
    }
    @Test
    public void testIntersection_disjunkt(){
        Set set1 = createSet(1, 2, 3);
        Set set2 = createSet(4, 5, 6);
        assertArrayEquals(new int[]{}, set1.intersection(set2).getValues());
    }
    @Test
    public void testIntersection_echteTeilmenge() {
        Set set1 = createSet(1, 2, 3);
        Set set2 = createSet(1, 2, 3);
        assertArrayEquals(new int[]{1, 2, 3}, set1.intersection(set2).getValues());
        Set set3 = createSet(1, 2, 3, 4);
        assertArrayEquals(new int[]{1, 2, 3}, set1.intersection(set3).getValues());
    }

    @Test
    public void testIsProperSubSet_emptySet(){
        Set set1 = createSet(1, 2, 3);
        Set set2 = new Set();
        //assertFalse("differs at last element", set1.isProperSubSet(set2));
    }
    @Test
    public void testIsProperSubSet_disjunkt(){
        Set set1 = createSet(1, 2, 3);
        Set set2 = createSet(4, 5, 6);
        //assertFalse(set1.isProperSubSet(set2));
    }

    @Test
    public void testIsProperSubSet_ueberschneidung() {
        Set set1 = createSet(1, 2, 3);
        Set set2 = createSet(2, 3, 4);
        //assertFalse(set1.isProperSubSet(set2));
    }

    @Test
    public void testIsProperSubSet_echteTeilmenge() {   //Kann nur Parameter Teilmenge sein oder auch aufrufendes Objekt?
        Set set1 = createSet(1, 2, 3);
        Set set2 = createSet(1, 2, 3);
       // assertTrue("echte Teilmenge", set1.isProperSubSet(set2));
        Set set3 = createSet(1, 2, 3, 4);
      //  assertTrue("set1 ist echte Teilmenge von set3", set1.isProperSubSet(set3));
    }
}
