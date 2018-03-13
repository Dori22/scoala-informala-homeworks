package quiz;


public class Square {

    private double side;

    public Square(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void calcSurfaceSquare(double surface) {
        surface = side * side;

        System.out.println("Area of Square is:" + surface);

    }

    public void calcPerimeterSquare(double perimeter) {
        perimeter = side * 4;

        System.out.println("Perimeter of the  square equals:  " + perimeter);

    }

}