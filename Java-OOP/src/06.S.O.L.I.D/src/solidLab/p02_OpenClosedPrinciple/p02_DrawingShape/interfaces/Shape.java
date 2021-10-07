package solidLab.p02_OpenClosedPrinciple.p02_DrawingShape.interfaces;

public class Shape implements DrawingManager{

    @Override
    public void draw(Shape shape) {
        System.out.println(shape.getClass().getSimpleName());
    }
}
