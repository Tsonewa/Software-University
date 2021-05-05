package solidLab.p03_LiskovSubstitution.p01_Square;

import java.util.List;

public class Main {
    public static void main(String[] args) {

       List<Shape> shapeList = List.of(new Rectangle(2,4), new Square(5,7));

        for (Shape shape: shapeList) {
            System.out.println(shape.getArea());
        }
    }
}
