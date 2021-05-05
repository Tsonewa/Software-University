import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {

        String path = "C:\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String output = "C:\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\05.WriteEveryThirdLineOutput.txt";

        BufferedReader reader = new BufferedReader(new FileReader(path));
        BufferedWriter writer = new BufferedWriter(new FileWriter(output));
        Stream<String> lines = reader.lines();
        List<String> stringLines = lines.collect(Collectors.toList());

        for (int i = 0; i < stringLines.size() ; i++) {
            if ((i + 1) % 3 == 0){
                writer.write(stringLines.get(i));
            writer.newLine();
        }
        }
        writer.close();
    }
}
