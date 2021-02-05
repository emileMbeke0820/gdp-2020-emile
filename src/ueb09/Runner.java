package ueb09;

/**
 * created by EESSAMMB on 21.01.2021
 */
public class Runner {

    public static void main(String[] args) {
        Element node = new Element();

        node.insertElement(87);
        node.insertElement(17);
        node.insertElement(12);
        node.insertElement(91);
        node.insertElement(1);
        System.out.println("Size: " + node.size());
        System.out.println("Sum: " + node.sum());
        System.out.print(node.showValues() + " ");

    }
}
