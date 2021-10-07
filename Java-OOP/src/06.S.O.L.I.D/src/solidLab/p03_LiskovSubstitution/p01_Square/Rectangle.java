package solidLab.p03_LiskovSubstitution.p01_Square;

public class Rectangle extends Shape {

    public Rectangle(double width, double height) {
        super(width, height);
    }

    @Override
    public double getArea() { return super.getWidth() * super.getHeight();
    }
}
