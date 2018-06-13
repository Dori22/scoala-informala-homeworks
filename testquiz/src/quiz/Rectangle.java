package quiz;

public class Rectangle {

    private double lenght;
    private double width;
    private double surface;
    private double perimeter;

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

    public void calcSurfaceRectangle() {
        this.surface = surface;
         surface = lenght * width;

        System.out.println("Area of Rectangle is:" + surface);

    }

    public void calcPerimeterRectangle() {
       this.perimeter=perimeter;
        perimeter = lenght * 2 + width * 2;
        System.out.println(("The perimeter of the rectangle is "+perimeter));

    }

}
