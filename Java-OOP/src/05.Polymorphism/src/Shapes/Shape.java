package Shapes;

public abstract class Shape {

    private Double perimeter;
    private Double area;

    public Double getArea() {
        return this.area;
    }

    public Double getPerimeter() {
        return this.perimeter;
    }

    public abstract Double calculatePerimeter();
    public abstract Double calculateArea();
}
