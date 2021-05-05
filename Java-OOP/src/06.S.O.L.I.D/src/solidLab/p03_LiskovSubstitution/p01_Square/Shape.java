package solidLab.p03_LiskovSubstitution.p01_Square;

public abstract class Shape {
    private double width;
    private double height;

    protected Shape(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return this.width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public abstract double getArea();
}
