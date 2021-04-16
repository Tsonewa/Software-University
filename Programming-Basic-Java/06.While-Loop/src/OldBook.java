import java.util.Scanner;

public class OldBook {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        //input

        String searchedBook = scanner.nextLine();
        int capacity = Integer.parseInt(scanner.nextLine());
        int outBook = 0;

        while (capacity > 0){
            String nameBook = scanner.nextLine();

            if (nameBook.equals(searchedBook)){
                System.out.printf("You checked %d books and found it.", outBook);
                break;
            }else {
                outBook++;
                capacity--;
            }
        }
        if (capacity == 0){
            System.out.println("The book you search is not here!");
            System.out.printf("You checked %d books.", outBook);
        }
            }
        }