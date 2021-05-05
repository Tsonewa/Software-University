package Shapes;

public class Circle extends Shape{
    private Double radius;

    public Circle(Double radius) {
        this.radius = radius;
    }

    public Double getRadius() {
        return this.radius;
    }

    @Override
    public Double calculatePerimeter() {
        return (2 * Math.PI) * this.radius;
    }

    @Override
    public Double calculateArea() {
        return Math.PI * Math.pow(2, this.radius);
    }
}
