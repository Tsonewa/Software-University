import java.util.Scanner;

public class AreaOfFigures {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        String f = scanner.nextLine();
        //figure type
        switch (f) {
            case "square":
                double side = Double.parseDouble(scanner.nextLine());
                double area = side * side;
                System.out.printf("%.3f", area);
                break;
            case "rectangle":
                double a = Double.parseDouble(scanner.nextLine());
                double b = Double.parseDouble(scanner.nextLine());
                area = a * b;
                System.out.printf("%.3f", area);
                break;
                case "circle":
                    double r = Double.parseDouble(scanner.nextLine());
                    double radius = Math.PI * r * r;
                    System.out.printf("%.3f", radius);
                    break;
                case "triangle" :
                    double w = Double.parseDouble(scanner.nextLine());
                    double h = Double.parseDouble(scanner.nextLine());
                    double result = w * h / 2;
                    System.out.printf("%.3f",result);
                    break;
            }
        }
    }

