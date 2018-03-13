package quiz;

public class Triangle {
private double height;
private double base;
private double hypotenuse;

    public Triangle(double height, double base, double hypotenuse) {
        this.height = height;
        this.base = base;
        this.hypotenuse = hypotenuse;
    }

    public double getHeight() {
        return height;
    }

    public double getBase() {
        return base;
    }

    public double getHypotenuse() {
        return hypotenuse;
    }


private  void calcHypotenuse(){
    Double hypotenuse = Math.pow(Math.pow(base, 2)
            + Math.pow(height, 2),0.5);

    private void calcPerimeter{
        Double perimeter = base + height + hypotenuse;

        System.out.println("Perimeter of triangle = "
                + perimeter);
    }
private void calcArea {

        Double areaTriangle = 0.5 * base * height;

        System.out.println("Area of triangle = "
                + areaTriangle);

    }


}




}
