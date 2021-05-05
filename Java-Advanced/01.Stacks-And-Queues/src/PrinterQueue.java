import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String operations = scanner.nextLine();
        ArrayDeque<String> printerFileQueue = new ArrayDeque<>();

        while (!operations.equals("print")){
            if (operations.equals("cancel")){
                if (printerFileQueue.isEmpty()){
                    System.out.println("Printer is on standby");
                }else {
                    System.out.printf("Canceled %s%n", printerFileQueue.poll());
                }
            }else{
                printerFileQueue.offer(operations);
            }

            operations = scanner.nextLine();
        }
        while (!printerFileQueue.isEmpty()){
            System.out.println(printerFileQueue.poll());
        }
    }
}
