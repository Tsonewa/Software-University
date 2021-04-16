import java.util.Scanner;

public class Grades {

    public static void printGrade(double grade){
        if (grade >= 2.00 && grade <= 2.99){
            System.out.print("Fail");
        }else if(grade >= 3.00 && grade <= 3.49){
            System.out.print("Poor");
        }else if(grade >= 3.50 && grade <= 4.49){
            System.out.print("Good");
        }else if(grade >= 4.50 && grade <= 5.49){
            System.out.print("Very good");
        }else if(grade >= 5.50 && grade <= 6.00){
            System.out.print("Excellent");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        /*
        Write a method that receives a grade between 2.00 and 6.00 and prints the corresponding grade in words:
 2.00 – 2.99 - Fail
 3.00 – 3.49 - Poor
 3.50 – 4.49 - Good
 4.50 – 5.49 - Very good
 5.50 – 6.00 - Excellent
         */
        double grade = Double.parseDouble(scanner.nextLine());
        printGrade(grade);
    }
}