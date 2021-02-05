package ueb11;

import java.util.Locale;

public abstract class Figure {
    private final double EPSILON = Math.exp(-5.0);
    private Color colorName;

    public Figure() {
    }

    public Figure(Color color) {
        this.colorName = color;
    }

    public double getArea() {
        return 0;
    }

    public double getPerimeter() {
        return 0;
    }

    @Override
    public String toString() {
        //System.out.println("epsilon: " + EPSILON);
        String colorName;
        if (this.colorName == null) {
            colorName = "unknown";
        } else {
            colorName = this.colorName.toString();
        }
        return String.format(Locale.GERMAN, "%-10s %-51s Umfang: %6.2f, Fläche: %6.2f", colorName, getDescription() + ",", getPerimeter(), getArea());
    }

    public String getDescription() {
        return "";
    }

    public int compare(Figure other) {
        if(Math.abs(this.getArea() - other.getArea()) < EPSILON) { //Math.abs entfernt negative Vorzeichen (absoluter Wert)
            return 0;
        } else if (this.getArea() > other.getArea()) {
            return 1;
        } else {
            return -1;
        }
    }

}