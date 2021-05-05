import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersOfWagon = Arrays.stream(scanner.nextLine(). split(" ")).
                map(Integer::parseInt).collect(Collectors.toList());
        int maxCapacity = Integer.parseInt(scanner.nextLine());
        String line = scanner.nextLine();
        while (!line.equals("end")){
            String[] operation = line.split(" ");
            String passengers = operation[0];

            if (passengers.equals("Add")){
                int addWagon = Integer.parseInt(operation[1]);// add
                numbersOfWagon.add(addWagon);
            }else {
                int addpassenger = Integer.parseInt(operation[0]); // 30
                for (int i = 0; i < numbersOfWagon.size() ; i++) {
                    if ((numbersOfWagon.get(i) + addpassenger) <= maxCapacity ){
                        numbersOfWagon.set(i, (numbersOfWagon.get(i) + addpassenger));
                        break;
                    }
                }
            }
            line = scanner.nextLine();
        }
        for (int wagoon: numbersOfWagon) {
            System.out.print(wagoon + " ");
        }
    }
}
