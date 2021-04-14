package RawData;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Car> fragile = new ArrayList<>();
        List<Car> flamable = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] carInfo = scanner.nextLine().split("\\s+");
            String model = carInfo[0];
            int engineSpeed = Integer.parseInt(carInfo[1]);
            int enginePower = Integer.parseInt(carInfo[2]);
            int cargoWeight = Integer.parseInt(carInfo[3]);
            String cargoType = carInfo[4];
            double[] tires = new double[4];{
                tires[0] = Double.parseDouble(carInfo[5]);
               tires[1] = Double.parseDouble(carInfo[7]);
                       tires[2] = Double.parseDouble(carInfo[9]);
                               tires[3] = Double.parseDouble(carInfo[11]);}
                Engine engine = new Engine(engineSpeed, enginePower);
                Cargo cargo = new Cargo(cargoWeight, cargoType);
                Tires tires1 = new Tires(tires);
                Car car = new Car(model, engine, cargo, tires1);
                if (cargoType.equals("flamable")){
                    flamable.add(car);
                }else if (cargoType.equals("fragile")){
                    fragile.add(car);
                }
            }
        String command = scanner.nextLine();
        if (command.equals("fragile")){
//print all cars whose Cargo Type is "fragile" with a tire whose pressure is  < 1,
            for (int i = 0; i < fragile.size(); i++) {
                Car currentCar = fragile.get(i);
                if (currentCar.getTires().checkTirePressure(currentCar.getTires())){
                    System.out.println(currentCar.getModel());
                }
            }
        }else if (command.equals("flamable")){
           // print all cars whose Cargo Type is "flamable" and have Engine Power > 250.
            for (int i = 0; i < flamable.size(); i++) {
                Car currentCar = flamable.get(i);
                if (currentCar.getEngine().checkEnginePower(currentCar.getEngine().getEnginePower())){
                    System.out.println(currentCar.getModel());
                }
            }
        }
    }
}
