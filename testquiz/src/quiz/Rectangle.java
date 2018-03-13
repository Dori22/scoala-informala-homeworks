package quiz;

public class Rectangle {

    private double lenght;
    private double width;

    public Rectangle(int lenght, int width) {
        this.lenght = lenght;
        this.width = width;

    }

    public double getLenght() {
        return lenght;
    }

    public double getWidth() {
        return width;
    }

    public void calcSurfaceRectangle(double surface) {
        surface = lenght * width;

        System.out.println("Area of Rectangle is:" + surface);

    }

    public void calcPerimeterRectangle(double perimeter) {
        perimeter = lenght * 2 + width * 2;

    }

}
