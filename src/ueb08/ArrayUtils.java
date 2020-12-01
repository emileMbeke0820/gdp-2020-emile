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
        int max = 0;
        int index = 0;
        for(int i = 0; i < arr.length; i++)
        {
            if(max < arr[i])
            {
                max = arr[i];
                index = i;
            }
        }
        return index;
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
     * @param inputArr Das Array mit den zu untersuchenden Werten.
     * @return Die Indizees der aus dem gegebenen Array absteigend sortierten Werte.
     *
     * @todo implementieren
     */
    static public int[] buildOrderIndex(int[] inputArr) {
        int[] arr = new int[inputArr.length];
        int[] indizees = new int[arr.length];
        for(int i = 0; i < indizees.length; i++) {
            indizees[i] = i;
            arr[i] = inputArr[i];
        }
        //Die methode maximumIndex benutzen!
        for(int i = 0; i < arr.length; i++)
        {
            for(int k = 0; k < arr.length;k++)
            {
                if(arr[i] < arr[k] || (arr[i] == arr[k] && indizees[i] > indizees[k]))
                {
                    int temp = arr[i];
                    arr[i] = arr[k];
                    arr[k] = temp;
                    int index = indizees[i];
                    indizees[i] = indizees[k];
                    indizees[k] = index;
                }
            }
        }

        int[] reorderedArr = new int[indizees.length];
        for(int i = 0; i < reorderedArr.length; i++)
        {
            reorderedArr[i] = indizees[indizees.length - i - 1];
        }
        return reorderedArr;
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
        int temp = 0;
        for (int j : arr) {
            if (j == value) {
                temp++;
            }
        }

        int[] arr2 = new int[arr.length - temp];
        for(int i = 0, counter = 0; i< arr.length; i++)
        {
            if(arr[i] != value){
                arr2[counter] = arr[i];//arr2[counter++] besser?
                counter++;
            }
        }
        return arr2;
    }
}
