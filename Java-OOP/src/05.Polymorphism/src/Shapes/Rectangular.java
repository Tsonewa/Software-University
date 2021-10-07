package Shapes;

import javax.xml.crypto.dom.DOMCryptoContext;

public class Rectangular extends Shape {
    private Double height;
    private Double width;

    public Rectangular(Double height, Double width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public Double calculatePerimeter() {
        return 2 * (this.height + this.width);
    }

    @Override
    public Double calculateArea() {
        return this.width * this.height;
    }
}
