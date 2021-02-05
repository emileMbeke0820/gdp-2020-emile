package ueb11;

import java.util.Locale;

/**
 * created by EESSAMMB on 01.02.2021
 */
public class Triangle extends Figure{

    private double side1;
    private double side2;
    private double side3;

    public Triangle(Color color, double side1, double side2, double side3) {
        super(color);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    public double getArea() { // herons formula
        double s = 0.5 * (side1 + side2 + side3);
        return Math.sqrt(s * (s- side1) * (s- side2) * (s- side3));
    }

    @Override
    public double getPerimeter() {
        return side1+side2+side3;
    }

    public String getDescription() {
        return String.format(Locale.GERMAN, "Dreieck  mit Kantenlängen (  %2.2f,   %2.2f,   %2.2f)",  side1, side2,side3);

    }
}
