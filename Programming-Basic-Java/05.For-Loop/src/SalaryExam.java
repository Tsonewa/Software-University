import java.util.Scanner;

public class SalaryExam {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        //input
            int tabs = Integer.parseInt(scanner.nextLine());
            int salary = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= tabs ; i++) {
            String name = scanner.nextLine();

            if (name.equals("Facebook")){
                salary -= 150;
            }else if (name.equals("Instagram")){
                salary -= 100;
            }else if (name.equals("Reddit")){
                salary -=  50;
            }
            if (salary <= 0){
                System.out.print("You have lost your salary.");
                break;
            }
                }
        if (salary > 0){
            System.out.println(salary);
        }

            }
        }