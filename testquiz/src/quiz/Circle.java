package quiz;

public class Circle {

    private double radius;
    private double area;


    public Circle(double radius, double area) {
        this.radius = radius;
        this.area = area;
    }

    public double getRadius() {
        return radius;
    }

    public double getArea() {
        return area;
    }

    public void calcAreaCircle() {
        double area = Math.PI * (radius * radius);

        System.out.println("The area of circle is: " + area);

    }
        public void calcCircumferenceCircle(){

            double circumference= Math.PI * 2*radius;

            System.out.println( "The circumference of the circle is:"+circumference);
        }


    }

