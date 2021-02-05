package ueb11;

import java.util.Locale;

/**
 * created by EESSAMMB on 01.02.2021
 */
public class Circle extends Figure{
    private double diameter;

    public Circle(Color color, double diameter) {
        super(color);
        this.diameter = diameter;
    }

    @Override
    public double getArea() {
        return (Math.PI * diameter * diameter) / 4;
    }

    @Override
    public double getPerimeter() {
        return (Math.PI*2*diameter)/2;
    }

    @Override
    public String getDescription() {
        return String.format(Locale.GERMAN, "Kreis    mit Durchmesser  (%6.2f)", diameter);
    }
}
