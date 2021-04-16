import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) throws FileNotFoundException {

        String path = "C:\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String output = "C:\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\04.ExtractIntegersOutput.txt";
        Scanner scanner = new Scanner(new FileInputStream(path));
        PrintWriter writer = new PrintWriter(new FileOutputStream(output));


        while (scanner.hasNext()) {
            if (scanner.hasNextInt())
                writer.println(scanner.nextInt());

                scanner.next();
            }
            writer.close();
        }
}
