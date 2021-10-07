package PointInRectangle;

public class Rectangle {

    private Point leftBottom;
    private Point rightTop;

    public Rectangle(Point leftBottom, Point rightTop){
        this.leftBottom = leftBottom;
        this.rightTop = rightTop;
    }

    public Point getLeftBottom() {
        return leftBottom;
    }

    public Point getRightTop() {
        return rightTop;
    }

    public boolean contains(Point point){
        return getLeftBottom().getX() <= point.getX() && getLeftBottom().getY() <= point.getY()
                && getRightTop().getX() >= point.getX() && getRightTop().getY() >= point.getY();
    }

}
