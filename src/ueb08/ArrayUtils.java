package ueb08;

/**
 * Fasst diverse Methoden für Arrays zusammen. Keine dieser Methoden darf
 * ein im Parameter gegebenes Array verändern!
 */
public class ArrayUtils {
    /**
     * Liefert den Index der Zelle mit der höchsten Zahl.
     *
     * @param arr Das zu durchsuchende Array.
     * @return Der Index der Zelle mit der höchsten Zahl.
     *
     * @todo implementieren
     */
    static public int maximumIndex(int[] arr) {
        return 0;
    }
    
    /**
     * Diese Methode ist eine Variante eines "normalen" Sortieralgorithmus.
     * Anstelle die Werte in absteigender Sortierung zurückzugeben, liefert sie
     * die Indizees der korrespondierenden Werte. Die Übergabe von [4,0,3,1,2]
     * würde also zum Ergebnis [0,2,4,3,1] führen: Jeder Wert im Ergebnis 
     * bezeichnet den Index des sortierten Wertes im Ausgangsarray.
     * 
     * Der einfachste Weg, dies zu implementieren, ist eine Variation eines 
     * Selectionsort-Algorithmus: Durchsuche das Array wiederholt nach dem 
     * aktuell höchsten Wert. Nach jeder Iteration wird der Wert, der gerade
     * als höchster ermittelt wurde, mit einem äußerst kleinen Wert überschrieben,
     * so dass er in Folge nicht mehr betrachtet wird.
     *
     * @param arr Das Array mit den zu untersuchenden Werten.
     * @return Die Indizees der aus dem gegebenen Array absteigend sortierten Werte.
     *
     * @todo implementieren
     */
    static public int[] buildOrderIndex(int[] arr) {
        return null;
    }
    
    /**
     * Eliminiert alle Vorkommen eines bestimmten Wertes aus dem gegebenen Array.
     *
     * @param arr   Das zu filternde Array.
     * @param value Der auszufilternde Wert.
     * @return Ein neues Array, das alle Werte des übergebenen Arrays in 
     * gleicher Reihenfolge enthält - mit Ausnahme des gefilterten Wertes. 
     *
     * @todo implementieren
     */
    static public int[] filterValue(int[] arr, int value) {
        return null;
    }
}
