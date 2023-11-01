import java.util.Scanner;
public class LinearEquationLogic {
    private Scanner myScanner;
    private LinearEquation linearEquation;
    public LinearEquationLogic() {
        linearEquation = null;
        myScanner = new Scanner(System.in);

    }
    public void start() {
        GetInfo();
    }
    private void GetInfo() {
        String repeat = "y";
        while (repeat.equals("y")) {
            System.out.println("Welcome to the Linear equation calculator");
            System.out.print("Enter coordinate one: ");
            String pointOne = myScanner.nextLine();
            System.out.print("Enter coordinate two: ");
            String pointTwo = myScanner.nextLine();
            int len1 = pointOne.length();
            int len2 = pointTwo.length();
            int half1 = pointOne.indexOf(",");
            int half2 = pointTwo.indexOf(",");
            String sub1 = pointOne.substring(1,half1);
            String sub2 = pointOne.substring(half1 + 2,len1 - 1);
            String sub3 = pointTwo.substring(1,half2);
            String sub4 = pointTwo.substring(half2 + 2,len2 - 1);
            int x1 = Integer.parseInt(sub1);
            int y1 = Integer.parseInt(sub2);
            int x2 = Integer.parseInt(sub3);
            int y2 = Integer.parseInt(sub4);
            if (x1 == x2) {
                System.out.println("These points are on a vertical line: x = " + x1);
            } else {
            linearEquation = new LinearEquation(x1, y1, x2, y2);
            System.out.println(linearEquation.lineInfo());
            System.out.println(" ");
                System.out.print("Enter a value for x: ");
                double newX = myScanner.nextDouble();
                myScanner.nextLine();
                System.out.println("The point on the line is " + linearEquation.coordinateForX(newX));
            }
            System.out.print("Would you like to enter another pair of coordinates? y/n: ");
            repeat = myScanner.nextLine().toLowerCase();
        }
        System.out.println("Goodbye!");
    }
}