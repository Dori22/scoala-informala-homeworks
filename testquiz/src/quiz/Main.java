package quiz;

public class Main {

    public static void main(String[] args) {


        Rectangle rectangle = new Rectangle(10, 15);

        rectangle.calcSurfaceRectangle();
        rectangle.calcPerimeterRectangle();

        Square square = new Square(15);
        square.calcPerimeterSquare();
        square.calcSurfaceSquare();

        Circle circle = new Circle(15.2, 14.5);

        circle.calcAreaCircle();
      circle.calcCircumferenceCircle();

        Triangle triangle = new Triangle(12.5, 14.5, 19.2);

        triangle.calcAreaOfTriangle();
        triangle.calcPerimeterOfTriangle();


    }
}
