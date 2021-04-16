package CarSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Engine> engines = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] engineTokens = scanner.nextLine().split("\\s+");
            String engineModel = engineTokens[0];
            int enginePower = Integer.parseInt(engineTokens[1]);
            Engine engine;
            if (engineTokens.length == 4){
                //<Model> <Power> <Displacement> <Efficiency>
                int displacement = Integer.parseInt(engineTokens[2]);
                String efficiency = engineTokens[3];
                engine = new Engine(engineModel, enginePower, displacement, efficiency);
                engines.add(engine);

            }else if (engineTokens.length == 2){
                engine = new Engine(engineModel, enginePower);
                engines.add(engine);
            } else {
                try{
                    int displacementOrEfficiency = Integer.parseInt(engineTokens[2]);
                    engine = new Engine(engineModel, enginePower, displacementOrEfficiency);
                    engines.add(engine);
                }catch (NumberFormatException e){
                    engine = new Engine(engineModel, enginePower, engineTokens[2]);
                    engines.add(engine);
                }
            }
        }
        List<Car> cars = new ArrayList<>();

        int m = Integer.parseInt(scanner.nextLine());

        for (int k = 0; k < m; k++) {
            String[] carTokens = scanner.nextLine().split("\\s+");
            String carModel = carTokens[0];
            String engineModel = carTokens[1];
            Car car;
            if (carTokens.length == 2){
               car = new Car(carModel, engineModel);
               cars.add(car);
            }else if (carTokens.length == 4){
                int weight = Integer.parseInt(carTokens[2]);
                String color = carTokens[3];
                car = new Car(carModel, engineModel, weight, color);
                cars.add(car);
            }else {
                try {
                int weightOrColor = Integer.parseInt(carTokens[2]);
                car = new Car(carModel, engineModel, weightOrColor);
                cars.add(car);
                } catch (NumberFormatException e) {
                        car = new Car(carModel, engineModel, carTokens[2]);
                        cars.add(car);
                }
            }
        }

        cars.stream().forEach(car -> {
            System.out.println(car.getCarModel() + ":");
            System.out.println(car.getEngineModel() + ":");
            engines.forEach(engine -> {
                        if (engine.getEngineModel().equals(car.getEngineModel())) {
                            System.out.println(engine.toString());
                        }
                    }
            );
            if (car.getWeight() == 0){
                System.out.println("Weight: n/a");
            }else {
                System.out.printf("Weight: %d%n", car.getWeight());
            }
            System.out.printf("Color: %s%n", car.getColor());
        });
    }
}
