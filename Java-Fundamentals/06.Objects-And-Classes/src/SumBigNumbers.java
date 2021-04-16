import java.math.BigInteger;
import java.util.Scanner;

public class SumBigNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigInteger firstLine = new BigInteger(scanner.nextLine());
        BigInteger secondLine =new BigInteger(scanner.nextLine());

        BigInteger sum = new BigInteger(String.valueOf(firstLine.add(secondLine)));

        System.out.println(sum);

    }
}