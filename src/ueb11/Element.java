package ueb11;

public class Element {
    private Figure figure;
    private Element next;

    public Element(Figure figure) {
        this.figure = figure;
    }

    public Element() {
    }

    //Methoden der Klasse
    public Figure getFigure() {
        return figure;
    }

    public Element getNext() {
        return next;
    }

    public void setNext(Element next) {
        this.next = next;
    }

    // erstellt ein element mit dem value direkt nach dem ersten element, das gleich groß oder größer ist.
    // vzw. immer vor den ersten, der kleiner ist
    public Element addElementInOrder(Figure newFigure) {
        if (this.figure == null) {
            return new Element(newFigure);
        }
        if (this.figure.compare(newFigure) == -1) {
            Element newElement = new Element(newFigure);
            newElement.setNext(this);
            return newElement;
        } else if (this.next == null) {
            this.next = new Element(newFigure);
            return this;
        } else {
            this.next = this.next.addElementInOrder(newFigure);
            return this;
        }
    }

    public int size() {
        return this.next == null ? 1 : 1 + this.next.size();
    }

    public boolean existsElement(Figure figure) {
        if (this.getFigure() == figure) {
            return true;
        } else if (this.next != null && this.next.getFigure().compare(figure) <= 0) {
            return this.next.existsElement(figure);
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        int counter = 0;
        return toStringHelper(counter);
    }

    private String toStringHelper(int counter) {
        String string = String.format("%2d. %s", ++counter, this.figure.toString());
        if (this.next == null) {
            return string;
        }
        return string + "\n" + this.next.toStringHelper(counter);
    }

}