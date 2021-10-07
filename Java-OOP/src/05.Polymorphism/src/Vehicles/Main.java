package Vehicles;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

         LinkedHashMap<String, Vehicle> vehicles = new LinkedHashMap<>();
         vehicles.put("Car", createVehicle(scanner));
         vehicles.put("Truck", createVehicle(scanner));
         vehicles.put("Bus", createVehicle(scanner));

        int commandsCount = Integer.parseInt(scanner.nextLine());

        while(commandsCount-- > 0){

            String[] commands = scanner.nextLine().split("\\s+");

            switch (commands[0]){
                case "Drive":
                   if (vehicles.containsKey(commands[1])){
                       System.out.println(vehicles.get(commands[1]).driving(Double.parseDouble(commands[2])));
                   }
                   break;
                case "Refuel":
                    if (vehicles.containsKey(commands[1])){
                        vehicles.get(commands[1]).refueling(Double.parseDouble(commands[2]));
                    }
                    break;
                case "DriveEmpty":
                    System.out.println(vehicles.get(commands[1]).driving(Double.parseDouble(commands[2])));
                    break;
                default:
                    throw new IllegalStateException("Unknown switch statement " + commands[0]);
            }
        }

        for (Vehicle vehicle: vehicles.values()) {
            System.out.println(vehicle.toString());
        }
    }
 public static Vehicle createVehicle(Scanner scanner){
     String[] tokens = scanner.nextLine().split("\\s+");

     if(tokens[0].equals("Car")) {
         return new Car(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]), Integer.parseInt(tokens[3]));
     } else if(tokens[0].equals("Truck")){
         return new Truck(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]), Integer.parseInt(tokens[3]));
     } else if(tokens[0].equals("Bus")){
         return new Bus(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]), Integer.parseInt(tokens[3]));
     } else{
         throw new IllegalArgumentException("Unknown vehicle type" + tokens[0]);
     }
    }


}
