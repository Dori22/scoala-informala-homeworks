package quiz;

public class Main {

    public static void main(String[] args) {


        Rectangle rectangle=new Rectangle(10,15);
        Square square=new Square(15);
        Circle circle=new Circle(15.2,14.5);
        Triangle triangle=new Triangle(12.5,14.5,19.2);

        rectangle.calcPerimeterRectangle();
        rectangle.calcSurfaceRectangle();
        square.calcPerimeterSquare();
        square.calcSurfaceSquare();
        circle.calcAreaCircle();
        circle.calcCircumferenceCircle();



      
    }
}
