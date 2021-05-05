import com.sun.source.tree.IfTree;

import java.util.Scanner;

public class Moving {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        int weightFreeSpace = Integer.parseInt(scanner.nextLine());
        int lenghtFreeSpace = Integer.parseInt(scanner.nextLine());
        int haightFreeSpace = Integer.parseInt(scanner.nextLine());
        int roomVolume = weightFreeSpace * lenghtFreeSpace * haightFreeSpace;
        int countBox = 0;
        String input = scanner.nextLine();

        while (!input.equals("Done")) {
            int boxes = Integer.parseInt(input);
            countBox += boxes;

            if (countBox > roomVolume) {
                break;
            }
            if (roomVolume <= countBox){
                System.out.printf("No more free space! You need %d Cubic meters more.", Math.abs(boxes - roomVolume));
            }else{
                System.out.printf("%d Cubic meters left.",Math.abs(roomVolume-boxes));
            }
        }
    }
}