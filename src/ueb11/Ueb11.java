package ueb11;

public class Ueb11 {

    private static void printFigures(List list) {
        System.out.println(list.toString());
    }

    private static void addFigures(List list, Figure[] figures, boolean writeLog) {
        System.out.println("Füge folgende Figuren zu: ");

        for (int i = 0; i < figures.length; i++) {
            Figure figure = figures[i];
            if (writeLog) {
                System.out.format("%2d. %s%n", i + 1, figure.toString());
            }
            list.addElementInOrder(figure);
        }

        System.out.println("Liste neu erzeugt mit " + list.size() + " Elementen.");
    }

    public static void main(String[] args) {
        List list = new List();

        Figure[] figures = {
                new Triangle(Color.newColor("unbekannt"), 7, 8, 4),
                new Triangle(new Color(Color.ColorNames.WHITE), 3.5, 4, 2),
                new Circle(new Color(Color.ColorNames.GREEN), 3),
                new Circle(new Color(Color.ColorNames.GREEN), 1.5),
                new Rectangle(new Color(Color.ColorNames.RED), 7, 8),
                new Rectangle(new Color(Color.ColorNames.RED), 3.5, 4),
                new Square(new Color(Color.ColorNames.YELLOW), 2.5),
                new Square(new Color(0x0A, 0x80, 0xFF), 1.25),
                new Rectangle(new Color(Color.ColorNames.RED), 14, 16),
                new Circle(new Color(Color.ColorNames.GREEN), 6),
                new Square(new Color(Color.ColorNames.YELLOW), 5),
                new Triangle(Color.newColor("unbekannt"), 14, 16, 8),
                new Triangle(Color.newColor("whitE"), 15, 17, 8),
                new Triangle(Color.newColor("red"), 16, 18, 8),
                new Triangle(Color.newColor("RED"), 17, 19, 8),
                new Triangle(Color.newColor("#000000"), 18, 20, 8),
                new Triangle(Color.newColor("#ffff00"), 19, 21, 8),
                new Circle(new Color(Color.ColorNames.GREEN), 23.5),
                new Rectangle(new Color(new int[] {1, 2, 3}), 3.5, 46),
                new Rectangle(new Color(Color.ColorNames.RED), 104, 8),
                new Triangle(new Color(Color.ColorNames.BLACK), 0.1, 0.2, 0.3),
                new Circle(new Color(Color.ColorNames.AQUA), 0.4),
                new Circle(new Color(Color.ColorNames.BLUE), 0.5),
                new Rectangle(new Color(Color.ColorNames.FUCHSIA), 0.6, 0.7),
                new Rectangle(new Color(Color.ColorNames.LIME), 0.8, 0.9),
                new Square(new Color(Color.ColorNames.NAVY), 1),
                new Circle(new Color(Color.ColorNames.BLUE), 1.1),
                new Rectangle(new Color(Color.ColorNames.FUCHSIA), 1.2, 1.3),
                new Rectangle(new Color(Color.ColorNames.LIME), 1.4, 1.5),
                new Square(new Color(Color.ColorNames.NAVY), 1.6)
        };

        addFigures(list, figures, true);

        System.out.println("------------------------------");

        printFigures(list);

        System.out.print("------------------------------");
    }
}