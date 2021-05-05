import java.util.Scanner;

public class EqualNumber {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        //input
        int n = Integer.parseInt(scanner.nextLine());
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int lastSum = 0;
        int diff = 0;
        for (int i=0;i<n ;i++ ) {
            int first = Integer.parseInt(scanner.nextLine());
            int second = Integer.parseInt(scanner.nextLine());
            int sum = first+second;

            if(i > 0) {
                diff = Math.abs(lastSum - sum);
            }
            lastSum = sum;
        }

        if (diff == 0){
            System.out.printf("Yes, value=%s", lastSum);
        }else{
            System.out.printf("No, maxdiff=%s", diff);
        }
    }
}
