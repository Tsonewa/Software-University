package PointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] rectangularCoordinates = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();


        Rectangle rectangle = new Rectangle(new Point(rectangularCoordinates[0], rectangularCoordinates[1]),
                new Point(rectangularCoordinates[2], rectangularCoordinates[3]));

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            int first = Integer.parseInt(input[0]);
            int second = Integer.parseInt(input[1]);
            System.out.println(rectangle.contains(new Point(first, second)));
        }
    }
    }
