import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WriteToFile {

    public static void main(String[] args) throws FileNotFoundException {

        String path = "C:\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outputFile = "C:\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\02.WriteToFileOutput.txt";

        List<Character> symbols = new ArrayList<>();
        Collections.addAll(symbols, '.', ',', '!', '?');

        try (FileInputStream in = new FileInputStream(path);
             FileOutputStream out = new FileOutputStream(outputFile)) {

            int oneByte = 0;
            while ((oneByte = in.read()) >= 0) {
                if (!symbols.contains((char) oneByte)) {
                    out.write(oneByte);
                }
            }

                } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
