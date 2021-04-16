package SpeedRacing;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, Car> cars = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] carInfo = scanner.nextLine().split("\\s+");
            String carModel = carInfo[0];
            double capacity = Double.parseDouble(carInfo[1]);
            double fuelPerKm = Double.parseDouble(carInfo[2]);
            Car car = new Car(carModel, capacity, fuelPerKm);
            cars.putIfAbsent(carModel, car);
        }
        String command = scanner.nextLine();
        while (!command.equals("End")){
            String[] tokans = command.split("\\s+");
            //Drive BMW-M2 56
            String model = tokans[1];
            int distanceToDrive = Integer.parseInt(tokans[2]);
            Car drivenCar = cars.get(model);
            if (!drivenCar.drive(distanceToDrive)){
                System.out.println("Insufficient fuel for the drive");
            }
            command = scanner.nextLine();
        }
        for (Car car: cars.values()) {
        System.out.println(car.toString());
    }
    }
}
