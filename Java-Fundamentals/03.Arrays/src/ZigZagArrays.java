import java.util.Scanner;

public class ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        int input = Integer.parseInt(scanner.nextLine());
        String[] firstColon = new String[input];
        String[] secondColon = new String[input];

        for (int i = 0; i < input; i++) {
            String[] firstLine = scanner.nextLine().split(" ");
            for (int j = 0; j < firstLine.length ; j++) {
                if (i % 2 != 0){
                    firstColon[i] = firstLine[0];
                    secondColon[i] = firstLine[1];
                }else {
                    secondColon[i] = firstLine[0];
                    firstColon[i] = firstLine[1];
                } } }
        for (String secondOut: secondColon
        ) {
            System.out.print(secondOut + " "); }
        System.out.println();
        for (String firstOutput: firstColon) {
            System.out.print(firstOutput + " ");
        } }}