package ueb10;

import java.util.Iterator;

public class Set {
    private Element elements;

    /**
     * Prüft, ob Elemente enthalten sind
     *
     * @return true, wenn das Set leer ist
     * @todo implementieren
     */
    public boolean isEmpty() {
        return false;
    }

    /**
     * Fügt ein neues Element mit übergebenem Wert zu, wenn der Wert noch nicht existiert. Ein Wert kann also nur ein Mal in der Menge vorkommen.
     *
     * @param value
     * @todo implementieren
     */
    public void addElement(int value) {

    }

    /**
     * Prüft, ob der Wert schon in der Elementliste existiert.
     *
     * @param value
     * @return true, wenn das Element existiert
     * @todo implementieren
     */
    public boolean existsElement(int value) {
        return false;
    }

    /**
     * Löscht ein Element diesen Wertes; falls es nicht vorhanden ist, passiert nichts.
     *
     * @param value
     * @todo implementieren
     */
    public void deleteElement(int value) {

    }

    /**
     * Liefert eine Stringdarstellung des Mengeninhalts mit umschließenden geschweiften Klammern.
     *
     * @return String-Repräsentation der Menge
     * @todo implementieren
     */
    public String showValues() {
        return "";
    }

    /**
     * Liefert ein Array mit allen enthaltenen Werten (iterative Lösung).
     *
     * @return Array mit allen Werten
     * @todo implementieren
     */
    public int[] getValues() {
        return null;
    }

    /**
     * Prüft, ob die übergebene Menge die gleichen Werte enthält wie die aktuelle.
     *
     * @param other
     * @return true, wenn die Mengen gleich sind
     * @todo implementieren
     */
    public boolean isSame(Set other) {

        return elements.isSame(other.elements);
    }

    /**
     * Liefert eine neue Menge, die die Vereinigung der aktuellen mit der übergebenen abbildet.
     *
     * @param other
     * @return die Vereinigungsmenge mit der übergebenen Menge
     * @todo implementieren
     */
    public Set union(Set other) {

        return null;
    }

    /**
     * Liefert eine neue Menge, die die Schnittmenge der aktuellen mit der übergebenen abbildet.
     *
     * @param other
     * @return die Schnittmenge mit der übergebenen Menge
     * @todo implementieren
     */
    public Set intersection(Set other) {


        return null;
    }

    /**
     * Liefert eine neue Menge, die die Differenzmenge der aktuellen mit der übergebenen abbildet.
     *
     * @param other
     * @return die Differenzmenge mit der übergebenen Menge
     * @todo implementieren
     */
    public Set diff(Set other) {
        Set output = new Set();
        if (isEmpty()) {
            return output;
        } else if (other.isEmpty()) {
            return this;
        } else {
            Element tempElement = this.elements;
            Element tempOther = other.elements;
            while (tempElement.getNext() != null) {
                if (!other.existsElement(tempElement.getValue())) {
                    output.addElement(tempElement.getValue());
                }
                tempElement = tempElement.getNext();
            }
            if (!other.existsElement(tempElement.getValue())) {
                output.addElement(tempElement.getValue());
            }
            return this;
        }
    }
}


        /**
         * Prüft, ob diese Menge eine echte Teilmenge der übergebenen ist.
         *
         * @param other
         * @return true, wenn diese Menge eine echte Teilmenge der übergebenen ist
         * @todo implementieren
         */

        /**
         * Fügt alle noch nicht enthaltenen Werte einer übergebenen Liste vom Typ Element als Elemente zu.
         *
         * @param list
         * @todo implementieren
         */
   /* private void addElementList(Element list) {
            Element newElement = new Element();
            newElement.setValue(list.getValue());
            addElementList(list.getNext());
        } else if (list.getNext() != null && !existsElement(list.getValue())) {
            addElement(list.getValue());
            addElementList(list.getNext());
        } else if (list.getNext() == null && !existsElement(list.getValue())){
            addElement(list.getValue());
        } else if (list.getNext() != null){
            addElementList(list.getNext());
        }
    }*/
