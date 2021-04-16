import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numbers = Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        String line = reader.readLine();

        while (!line.equals("end")){

            String[] input = line.split("\\s+");
            String cmd = input[0];


            if (cmd.equals("Delete")){
                int element = Integer.parseInt(input[1]);


                while (numbers.contains(element)){
                    numbers.remove(Integer.valueOf(element));
                }
            } else {
                int element = Integer.parseInt(input[1]);
                int index = Integer.parseInt(input[2]);
                if (index < numbers.size()){
                    numbers.add(index,element);
                }


            }

            line = reader.readLine();
        }

        numbers.forEach(e -> System.out.print(e + " "));
    }
}