import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int digit = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> binary = new ArrayDeque<>();

        while(digit != 0){
            binary.push(digit % 2);
            digit = digit / 2;

        }
        if (binary.isEmpty()){
            System.out.println(0);
        }
        while (!binary.isEmpty()){
            System.out.print(binary.pop());
        }
    }
}
