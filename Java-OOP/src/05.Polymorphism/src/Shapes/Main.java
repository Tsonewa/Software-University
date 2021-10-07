package Shapes;

public class Main {
    public static void main(String[] args) {

        Shape circle = new Circle(2D);
        Shape rectangular = new Rectangular(2D, 2D);

        System.out.println(circle.calculateArea());
        System.out.println(circle.calculatePerimeter());
        System.out.println(rectangular.calculatePerimeter());
        System.out.println(rectangular.calculateArea());
    }
}
