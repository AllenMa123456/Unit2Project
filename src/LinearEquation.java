public class LinearEquation {

    private int x1;
    private int x2;
    private int y1;
    private int y2;

    public LinearEquation(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
    public double roundedToHundredth(double toRound) {
        return Math.round(toRound * 100) / 100.0;
    }

    public double distance() {
        double dx = x2 - x1;
        double dy = y2 - y1;
        return Math.round(Math.sqrt(dx * dx + dy * dy) * 100.0) / 100.0;
    }

    public double yIntercept() {
        double yChange = y2 - y1;
        double xChange = x2 - x1;
        double change = (yChange / xChange);
        double c = y2 - (change * x2);
        return roundedToHundredth(c);
    }

    public double slope() {
        double yChange = y2 - y1;
        double xChange = x2 - x1;
        return roundedToHundredth((yChange/xChange));
    }

    public String equation() {
        if (slope() == 1) {
            if (yIntercept() < 0) {
                return "y = x + " + yIntercept();
            }
            if (yIntercept() == 0) {
                return "y = x";
            }
            return "y = x + " + yIntercept();
        } else if ( slope() == -1) {
            if (yIntercept() < 0) {
                return "y = x + " + yIntercept();
            }
            if (yIntercept() == 0) {
                return "y = x";
            }
            return "y = -x + " + (yIntercept());
        } else {
            if (y2 == y1) {

                return "y = " + yIntercept();
            }
            if ((int) slope() == slope()) {
                if (yIntercept() < 0) {
                    return "y = " + slope() + "x - " + Math.abs(((yIntercept())));
                }
                if (yIntercept() == 0) {
                    return "y = " + slope() + "x";
                }
                if (yIntercept() > 0) {
                    return "y = " + slope() + "x" + " + " + yIntercept();
                } else {
                    return "y = " + slope() + "x" + " - " + Math.abs(yIntercept());
                }

            } else {
                if (y2 - y1 < 0 && x2 - x1 < 0) {
                    if (yIntercept() < 0) {
                        return "y = " + Math.abs((y2 - y1)) + "/" + Math.abs((x2 - x1)) + "x - " + Math.abs(yIntercept());
                    }
                    if (yIntercept() == 0) {
                        return "y = " + Math.abs((y2 - y1)) + "/" + Math.abs((x2 - x1)) + "x" ;
                    }
                    return "y = " + Math.abs((y2 - y1)) + "/" + Math.abs((x2 - x1)) + "x " + yIntercept();
                } else if (slope() < 0) {
                    if (yIntercept() == 0) {
                        return "y = " + (y2 - y1) + "/" + (x2 - x1) + "x";
                    }
                    if (yIntercept() < 0) {
                        return "y = " + (y2 - y1) + "/" + (x2 - x1) + "x - " + Math.abs((yIntercept()));
                    }
                    return "y = " + (y2 - y1) + "/" + (x2 - x1) + "x" + " + " + (yIntercept());
                } else {
                    if (yIntercept() < 0) {
                        return "y = " + (y2 - y1) + "/" + (x2 - x1) + "x - " + Math.abs((yIntercept()));
                    }
                    if (yIntercept() == 0) {
                        return "y = " + (y2 - y1) + "/" + (x2 - x1) + "x";
                    }
                    return "y = " + (y2 - y1) + "/" + Math.abs((x2 - x1)) + "x" + " + " + (yIntercept());
                }
            }
        }
    }

    public String coordinateForX(double x) {
        double y = slope() * x + yIntercept();
        return "(" + String.format("%.2f", x) + ", " + String.format("%.2f", y) + ")";
    }

    public String lineInfo() {
        return "The two points are: (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ")\n" +
                "The equation of the line between these points is: " + equation() + "\n" +
                "The slope of this line is: " + slope() + "\n" +
                "The y-intercept of this line is: " + yIntercept() + "\n" +
                "The distance between these points is " + distance();
    }
}