package ueb11;

import java.util.Locale;

/**
 * created by EESSAMMB on 01.02.2021
 */
public class Rectangle extends Figure{
    private double side1;
    private double side2;

    public Rectangle(Color color, double side1, double side2) {
        super(color);
        this.side1 = side1;
        this.side2 = side2;
    }

    @Override
    public double getArea() {
        return side1*side2;
    }

    @Override
    public double getPerimeter() {
        return 2*(side1 +side2);
    }

    public String getDescription() {

        return String.format(Locale.GERMAN, "Rechteck mit Kantenlängen (  %2.2f,   %2.2f)",  side1, side2);
    }
}
