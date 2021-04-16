import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        int n = Integer.parseInt(scanner.nextLine());
        int[] su = new int[n];

        int sum = 0;
        for (int i = 0; i < n ; i++) {
            int people = Integer.parseInt(scanner.nextLine());
            su[i] = people;
            sum += people;
        }
        for (int person: su
        ) {
            System.out.print(person + " ");

        }
        System.out.println();
        System.out.println(sum);
    }
}