package ueb10;

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

        Element node = this.next;
        if(node == null){
            return 0;
        }
        else{
            return 1 + node.size();
        }
    }

    /**
     * @return die Summe der Werte dieses und aller folgenden Elemente
     * @todo implementieren
     */
    public int sum() {
        Element node = this.next;
     if (node == null){
         return value;
     }
     else{
         return value + node.sum();
     }

    }

    /**
     * @return true, wenn kein Element folgt oder die folgenden Elemente jeweils keinen kleineren Wert enthalten als ihr Vorgänger
     */
    public boolean isSorted() {
        if(next == null)
            return true;
        return value <= next.value && this.next.isSorted();
    }

    /**
     * @param value der zu suchende Wert
     * @return true, wenn dieses oder eines der folgenden Elemente den übergebenen Wert enthält.
     * @todo implementieren
     */
    boolean existsElement(int value) {
        if(this.value == value)
            return true;
        if(next != null)
            return next.existsElement(value);
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
        if(next != null) {
            return value + " " + next.showValues();
        }
        else{
            return "" + value;
        }

    }

    /**
     * Liefert den Wert des Elements an der Stelle x (Zählung beginnt bei 0). Wurde ein falscher Index angegeben, wird
     * Integer.MAX_VALUE zurückgegeben.
     *
     * @param index Index des Wertes
     * @return der Wert an der Stelle index
     * @todo implementieren
     */
   public  int getValueAt(int index) {

        if(index < this.size() && index >= 0)
        {
            if(index == 0)
            {
                return value;
            }
            else
            {
                return next.getValueAt(index - 1) ;
            }

        }
        return Integer.MAX_VALUE;
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

        if (index == 0){
            return insertElementAtFront(value);
        }
        else if (index == 1 && next == null){
            Element node = new Element();
            node.setValue(value);
            this.next = node;
        }
        else if (next != null){
            this.next = insertElementAt(value, index-1);
        }

        return this;
    }

    /**
     * Fügt ein neues Element mit dem übergebenen Wert vor das aktuelle Element ein.
     *
     * @param value neuer Wert
     * @return der Rest der Liste
     * @todo implementieren
     */
    Element insertElementAtFront(int value) {
        Element node = new Element();
        node.setValue(value);
        node.setNext(this);

        return node;

    }
    public boolean isSame(Element elements) {
        if (this.next == null && elements.next == null) {
            if (this.value == elements.value){
                return true;
            }
        } else if (this.next != null && elements.next != null){
            if (this.value == elements.value){
                return this.next.isSame(elements.next);
            }
        }
        return false;
    }
}