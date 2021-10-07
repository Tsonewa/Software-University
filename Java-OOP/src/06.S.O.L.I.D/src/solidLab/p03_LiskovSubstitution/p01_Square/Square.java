package solidLab.p03_LiskovSubstitution.p01_Square;

public class Square extends Shape {

    public Square(double width, double height) {
        super(width, height);
    }

    @Override
    public double getArea() {
        return super.getWidth() * 2;
    }
}
