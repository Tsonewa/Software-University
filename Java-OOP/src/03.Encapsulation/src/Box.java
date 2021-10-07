public class Box {
    // length, width and height
    private double length;
    private double width;
    private double height;
    
    public Box(double length, double width, double height){
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }
    private boolean positiveValueValidation(double val){
        return val > 0;
    }

    private void setHeight(double height) {
        if (!positiveValueValidation(height)){
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }
        this.height = height;
    }

    private void setWidth(double width) {
        if (!positiveValueValidation(width)){
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
      this.width = width;
    }

    private void setLength(double length) {
        if (!positiveValueValidation(length)){
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }
        this.length = length;
    }

public double calculateVolume(){
        return length * width * height;
}

public double calculateSurfaceArea(){
        return 2 * length * width + calculateLateralSurfaceArea();
}

    public double calculateLateralSurfaceArea() {
        return (2 * length * height) + (2 * width * height);
    }

}
