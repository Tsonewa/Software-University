import java.util.Scanner;

public class PersonalTitles {
    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);
        //input
        double age = Double.parseDouble(scanner.nextLine());
        String sex = scanner.nextLine();
        //•	"Mr." - мъж (пол "m") на 16 или повече години
        //•	"Master" - момче (пол "m") под 16 години
        //•	"Ms." - жена (пол "f") на 16 или повече години
        //•	"Miss" - момиче (пол "f") под 16 години
        if (sex.equals("m") && age >= 16){
            System.out.println("Mr.");
        }else if (sex.equals("m") && age < 16){
            System.out.println("Master");
        }else if(sex.equals("f") && age >= 16){
            System.out.println("Ms.");
        }else if (sex.equals("f") && age < 16){
            System.out.println("Miss");
        }
            }
        }