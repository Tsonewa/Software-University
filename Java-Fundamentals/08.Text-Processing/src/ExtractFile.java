import java.util.Scanner;

public class ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] fileToken = scanner.nextLine().split("\\\\");
        String last = fileToken[fileToken.length -1];

        String[] tokens = last.split("\\.");

        String name = tokens[0];
        String extenssion = tokens[1];

        System.out.printf("File name: %s%n",name);
        System.out.printf("File extension: %s", extenssion);


    }
}
