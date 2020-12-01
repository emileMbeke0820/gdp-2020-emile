package ueb09;

public class MyList {
    private Element elements; // Einstieg in Listenstruktur, Zugriff auf Listenelemente

    public boolean isEmpty() {
        return elements == null;
    }

    public void appendElement(int value) {
        if (this.isEmpty()) {
            elements = new Element();
            elements.setValue(value);
        } else {
            elements = elements.appendElement(value);
        }
    }

    public void insertElement(int value) {
        if (this.isEmpty()) {
            elements = new Element();
            elements.setValue(value);
        }
        else
            elements = elements.insertElement(value);
    }

    public void deleteElement(int value) {
        if (! isEmpty())
            elements = elements.deleteElement(value);
    }

    public void printList() {
        if (!isEmpty())
            elements.printList();
    }

    /**
     * @return die Anzahl der Listenelemente
     * @todo implementieren
     */
    int size() {
        return 0;
    }

    /**
     * @return die Summe aller in der Liste enthaltenen Werte
     * @todo implementieren
     */
    int sum() {
        return 0;
    }

    /**
     * @return true, wenn die Liste aufsteigend sortiert ist
     * @todo implementieren
     */
    boolean isSorted() {
        return false;
    }

    /**
     * @param value der zu suchende Wert
     * @return true, wenn bereits ein Element mit diesem Wert in der Liste enthalten ist
     * @todo implementieren
     */
    boolean existsElement(int value) {
        return false;
    }

    /**
     * Liefert einen String, der umschlossen von geschweiften Klammern die in der Liste enthaltenen Werte (jeweils durch ein Leerzeichen getrennt) darstellt.
     *
     * @return String, der umschlossen von geschweiften Klammern die in der Liste enthaltenen Werte (jeweils durch ein Leerzeichen getrennt) darstellt
     * @todo implementieren
     */
    String showValues() {
        return "";
    }

    /**
     * @return ein Array mit den enthaltenen Werten
     * @todo implementieren
     */
    int[] getValues() {
        return null;
    }

    /**
     *
     * @param index
     * @return der Wert an der Stelle index. Ist der Index ungültig, so wird Integer.MAX_VALUE zurückgegeben
     * @todo implementieren
     */
    int getValueAt(int index) {
        return 0;
    }

    /**
     * Fügt ein Element mit dem Wert value an der Stelle index ein. Ist der Index ungültig, bleibt die Liste unverändert.
     * @param value neuer Wert
     * @param index Index zum Einfügen des neuen Werts
     * @todo implementieren
     */
    void insertElementAt(int value, int index) {

    }

    /**
     * Fügt ein Element mit dem Wert value an den Anfang der Liste
     * @param value neuer Wert
     * @todo implementieren
     */
    void insertElementAtFront(int value) {

    }

    /**
     * Fügt ein Element mit dem Wert value vor dem ersten Element mit einem größeren Wert ein, wenn noch kein Element
     * mit diesem Wert vorhanden ist. Sonst bleibt die Liste unverändert.
     *
     * @param value neuer Wert
     * @todo implementieren
     */
    void insertSortedIfUnique(int value) {

    }
}