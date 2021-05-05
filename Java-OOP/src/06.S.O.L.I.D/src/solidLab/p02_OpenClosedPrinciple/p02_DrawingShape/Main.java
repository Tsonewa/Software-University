package solidLab.p02_OpenClosedPrinciple.p02_DrawingShape;

import solidLab.p02_OpenClosedPrinciple.p02_DrawingShape.interfaces.Shape;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


       Circle c = new Circle();
       Rectangle r = new Rectangle();

       List<Shape> s = new ArrayList<>();
       s.add(new Circle());
       s.add(new Rectangle());

        for (Shape shape: s) {
            shape.draw(c);
        }
    }
}
