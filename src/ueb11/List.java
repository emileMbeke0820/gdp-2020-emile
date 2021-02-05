package ueb11;

public class List {

    private Element elements;

    public void addElementInOrder(Figure newFigure) {
        if (elements == null) {
            elements = new Element(newFigure);
        } else {
            elements = elements.addElementInOrder(newFigure);
        }
    }

    public int size() {
        return elements == null ? 0 : elements.size();
    }

    @Override
    public String toString() {
        return elements == null ? "" : elements.toString();
    }
}