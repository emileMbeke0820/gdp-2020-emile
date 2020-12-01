package ueb09;

public class Element {
    private int value;
    private Element next;

    //Methoden der Klasse
    public int getValue() {
        return value;
    }

    public void setValue (int value) {
        this.value = value;
    }

    public Element getNext() {
        return next;
    }

    public void setNext(Element next) {
        this.next = next;
    }

    public Element appendElement(int value) {
        if (this.next == null) {
            Element newElement = new Element();
            newElement.setValue(value);
            this.next = newElement;
        }
        else
            this.next = this.next.appendElement(value);
        return this;
    }

    public Element insertElement(int value) {
        if (this.value >= value) {
            Element newElement = new Element();
            newElement.setValue(value);
            newElement.setNext(this);
            return newElement;
        } else if (this.next == null) {
            Element newElement = new Element();
            newElement.setValue(value);
            this.next = newElement;
            return this;
        } else {
            this.next = this.next.insertElement(value);
            return this;
        }
    }

    public Element deleteElement(int value) {
        if (this.value == value) {
            return this.next;
        }
        else {
            if (this.next != null)
                this.next = this.next.deleteElement(value);
            return this;
        }
    }

    public void printList() {
        System.out.println (value);
        if (this.next != null)
            this.next.printList();
    }

    /**
     * @return die Anzahl der Elemente
     * @todo implementieren
     */
    public int size() {
        return 0;
    }

    /**
     * @return die Summe der Werte dieses und aller folgenden Elemente
     * @todo implementieren
     */
    public int sum() {
        return 0;
    }

    /**
     * @return true, wenn kein Element folgt oder die folgenden Elemente jeweils keinen kleineren Wert enthalten als ihr Vorgänger
     */
    public boolean isSorted() {
        return false;
    }

    /**
     * @param value der zu suchende Wert
     * @return true, wenn dieses oder eines der folgenden Elemente den übergebenen Wert enthält.
     * @todo implementieren
     */
    boolean existsElement(int value) {
        return false;
    }

    /**
     * Liefert einen String mit diesem Wert und jeweils durch ein Leerzeichen getrennt alle folgenden Werte. Um einen
     * Integer-Wert in einen String zu wandeln, kann man String.valueOf(value) benutzen, oder die implizite Wandlung mit
     * "" + value verwenden.
     *
     * @return String mit diesem Wert und jeweils durch ein Leerzeichen getrennt alle folgenden Werte
     * @todo implementieren
     */
    String showValues() {
        return "";
    }

    /**
     * Liefert den Wert des Elements an der Stelle x (Zählung beginnt bei 0). Wurde ein falscher Index angegeben, wird
     * Integer.MAX_VALUE zurückgegeben.
     *
     * @param index Index des Wertes
     * @return der Wert an der Stelle index
     * @todo implementieren
     */
    int getValueAt(int index) {
        return 0;
    }

    /**
     * Fügt ein neues Element mit dem übergebenen Wert an der Stelle index ein. Wird als Index die Arraylänge übergeben,
     * so wird das neue Element angehängt. Wurde ein falscher Index übergeben, so wird das Element und die folgenden
     * unverändert zurückgegeben.
     *
     * @param value neuer Wert
     * @param index Index zum Einfügen des neuen Werts
     * @return der Rest der Liste
     * @todo implementieren
     */
    Element insertElementAt(int value, int index) {
        return null;
    }

    /**
     * Fügt ein neues Element mit dem übergebenen Wert vor das aktuelle Element ein.
     *
     * @param value neuer Wert
     * @return der Rest der Liste
     * @todo implementieren
     */
    Element insertElementAtFront(int value) {
        return null;
    }
}