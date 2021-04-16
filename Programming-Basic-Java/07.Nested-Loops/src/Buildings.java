import java.util.Scanner;

public class Buildings {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        int floors = Integer.parseInt(scanner.nextLine());
        int rooms = Integer.parseInt(scanner.nextLine());
        //floors
        for (int i = floors; i > 0 ; i--) {
            //rooms
            for (int j = 0; j < rooms ; j++) {
                if (i == floors){
                    System.out.printf("L%d%d ",i,j);
                }else{
                    if (i % 2 == 0){
                        System.out.printf("O%d%d ", i,j);
                    }else{
                        System.out.printf("A%d%d ", i,j);
                    }

                }

            } System.out.println();

        }
    }
}
