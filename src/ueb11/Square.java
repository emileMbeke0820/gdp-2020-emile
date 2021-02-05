package ueb11;

/**
 * created by EESSAMMB on 01.02.2021
 */
public class Square extends Figure{

    double sides;

    public Square(Color color, double sides) {
        super(color);
        this.sides = sides;
    }

    @Override
    public double getArea() {
        return sides*sides;
    }

    @Override
    public double getPerimeter() {
        return 4*sides;
    }

    public String getDescription() {
        return String.format("Quadrat  mit Kantenlänge  (  %6.2f)", sides);
    }
}
