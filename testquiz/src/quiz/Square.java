package quiz;


public class Square {

    private double side;
    private double surface;
    private double perimeter;

    public Square(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void calcSurfaceSquare() {
       this.surface=surface;
        surface = side * side;

        System.out.println("Area of Square is:" + surface);

    }

    public void calcPerimeterSquare() {
       this.perimeter=perimeter;
        perimeter = side * 4;

        System.out.println("Perimeter of the  square equals:  " + perimeter);

    }

}