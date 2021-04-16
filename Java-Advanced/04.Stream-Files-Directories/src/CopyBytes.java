import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {
    public static void main(String[] args) throws IOException {

        String path = "C:\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String output = "C:\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\03.CopyBytesOutput.txt";

        FileInputStream inputStream = new FileInputStream(path);
        FileOutputStream outputStream = new FileOutputStream(output);

        int nextByte = inputStream.read();
         while (nextByte != -1){

             if (nextByte == ' ' || nextByte == '\n'){
                 outputStream.write(nextByte);
             }else {
                 outputStream.write(String.valueOf(nextByte).getBytes());
             }
             nextByte = inputStream.read();
         }
         outputStream.close();
    }
}
