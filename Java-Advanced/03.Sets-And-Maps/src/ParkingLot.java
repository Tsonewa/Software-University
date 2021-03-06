import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input =scanner.nextLine();
        Set<String> cars = new LinkedHashSet<>();

        while(!input.equals("END")){
            String[] tokens = input.split(", ");

                switch (tokens[0]){
                    case "IN":
                        cars.add(tokens[1]);
                        break;
                    case "OUT":
                        cars.remove(tokens[1]);
                        break;
                }
            input = scanner.nextLine();
        }
        if (cars.isEmpty()){
            System.out.println("Parking Lot is Empty");
        }else {
            cars.forEach(System.out::println);
            }
        }
    }
