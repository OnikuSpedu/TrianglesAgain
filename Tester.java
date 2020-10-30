public class Tester {
    public static void main(String[] args) {
        System.out.println("Triangle setVertex test:");
        Triangle tri = new Triangle(0, 1, 2, 5, 2, 8);
        System.out.println("Triangle before:");
        System.out.println(tri);
        Point tempPoint = new Point(1, 2);
        tri.setVertex(0, tempPoint);
        System.out.println("Triangle after:");
        System.out.println(tri);

        System.out.println("distance:");
        double[][] distTest = {                                            
            {0.0, 0.0, 0.0, 0.0, 0.0}, // One Point
            {0.1, 2, 0.1, 6, 4}, //Vertical line
            {1, 2, 7, 2, 6}, //Horizontal line
            {0, 1, 2, 4, 3.605551275463989}, //Diagonal line
            {0.23,1231,22.232,4123, 2892.0836931188555}, //Floating points
            {0,4,3,0,5} //Integer Distance
                                   
        };
        for (int i = 0; i < distTest.length; i++) {
            Point a = new Point(distTest[i][0], distTest[i][1]);
            Point b = new Point(distTest[i][2], distTest[i][3]);

            System.out.println(a.distanceTo(b));
            System.out.println(a.distanceTo(b) == distTest[i][4]) ;
        };

        System.out.println("classify:");
        double[][] classifyTest = {                                            
            {0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, // One Point
            {0.0, 0.0, 0.0, 0.1, 0.0, 0.2},  // Degenerate triangle
            {0, 1, 2, 5, 2, 8},  // scalene
            {0.2356, 1.3342, 2.3454, 5.1232, 2.5347, 8.2131}, //Floating point
            {0,0,0,1,1,0.5}, // isosceles
            {4.5,5.3301,2,1,7,1} // equilateral
        };
        String[] classifyAnswers = {
            "equilateral",
            "isosceles",
            "scalene",
            "scalene",
            "isosceles",
            "equilateral"
        };

        for (int i = 0; i < classifyTest.length; i++) {
            Point a = new Point(classifyTest[i][0],classifyTest[i][1]);
            Point b = new Point(classifyTest[i][2],classifyTest[i][3]);
            Point c = new Point(classifyTest[i][4],classifyTest[i][5]);

            Triangle shape = new Triangle(a,b,c);

            System.out.println(shape);
            System.out.println(shape.classify());
            System.out.println(shape.classify() == classifyAnswers[i]);
        };

        System.out.println("perimeter:");
        double[][] perimeterPoints = {
            {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, // One Point
            {0.0, 0.0, 0.0, 0.1, 0.0, 0.2, 0.4},  // Degenerate triangle
            {0, 1, 2, 5, 2, 8, 14.752},  // scalene
            {0.2356, 1.3342, 2.3454, 5.1232, 2.5347, 8.2131, 14.685}, //Floating point
            {0,0,0,1,1,0.5, 3.236}, // isosceles
            {4.5,5.3301,2,1,7,1,15} // equilateral
        };
        for (int i = 0; i < perimeterPoints.length; i++) {
            Point a = new Point(perimeterPoints[i][0], perimeterPoints[i][1]);
            Point b = new Point(perimeterPoints[i][2], perimeterPoints[i][3]);
            Point c = new Point(perimeterPoints[i][4], perimeterPoints[i][5]);

            Triangle shape = new Triangle(a,b,c);

            System.out.println(shape);
            System.out.println(shape.getPerimeter());
            System.out.println(shape.getPerimeter() == perimeterPoints[i][6]);
        };
        System.out.println("area:");
        double[][] areaPoints = {
            {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, // One Point
            {0.0, 0.0, 0.0, 0.1, 0.0, 0.2, 0},  // Degenerate triangle
            {0, 1, 2, 5, 2, 8, 3},  // scalene - Error is due to precision. If rounded this would be correct.
            {0.2356, 1.3342, 2.3454, 5.1232, 2.5347, 8.2131, 2.901}, //Floating point - Error is due to precision. If rounded this would be correct.
            {0,0,0,1,1,0.5, 0.5}, // isosceles
            {4.5,5.3301,2,1,7,1,10.825} // equilateral //Floating point - Error is due to precision. If rounded this would be correct.
        };
        for (int i = 0; i < areaPoints.length; i++) {
            Point a = new Point(areaPoints[i][0], areaPoints[i][1]);
            Point b = new Point(areaPoints[i][2], areaPoints[i][3]);
            Point c = new Point(areaPoints[i][4], areaPoints[i][5]);

            Triangle shape = new Triangle(a,b,c);

            System.out.println(shape);
            System.out.println(shape.getArea());
            System.out.println("Area:" + (shape.getArea() == areaPoints[i][6]));

            if(shape.getArea() != areaPoints[i][6] && Math.round(shape.getArea()*1000)/(double)1000 == Math.round(areaPoints[i][6]*1000)/(double)1000) {
                System.out.println("Error is due to precision. If rounded this would be correct.");
            }
            
        };
    }
}