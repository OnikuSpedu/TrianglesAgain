public class Triangle {
    private Point v1, v2, v3;
    public Triangle(Point a, Point b, Point c) {
        this.v1 = a;
        this.v2 = b;
        this.v3 = c;
    }
    public Triangle(double x1, double y1,double x2, double y2,double x3, double y3) {
        Point a = new Point(x1, y1);
        Point b = new Point(x2, y2);
        Point c = new Point(x3, y3);

        this.v1 = a;
        this.v2 = b;
        this.v3 = c;
    }
    public double getPerimeter() {
        double a = v1.distanceTo(v2);
        double b = v1.distanceTo(v3);
        double c = v2.distanceTo(v3);

        return a + b + c;
    }
    public double getArea() {
        double a = v1.distanceTo(v2);
        double b = v1.distanceTo(v3);
        double c = v2.distanceTo(v3);

        double s = getPerimeter()/2;
        
        return Math.sqrt(s*(s-a)*(s-b)*(s-c));
    }
    public String classify() {
        double a = Math.round(v1.distanceTo(v2)*10000)/(double)10000;
        double b = Math.round(v1.distanceTo(v3)*10000)/(double)10000;
        double c = Math.round(v2.distanceTo(v3)*10000)/(double)10000;

        if (a == b && a == c && b == c) {
            return "equilateral"; 
        } else if (a == b || a == c || b == c) {
            return "isosceles";
        } else {
            return "scalene";
        }
    }
    public String toString() {
        return "v1"+v1+" "+"v2"+v2+" "+"v3"+v2;
    }
    
}