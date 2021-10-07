package TrafficLights;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] initialStates = scanner.nextLine().split("\\s+");

        int updatesCount = Integer.parseInt(scanner.nextLine());

        ArrayList<TrafficLight> trafficLights = new ArrayList<>();

        for (String initialState : initialStates) {
            TrafficLight trafficLight = new TrafficLight(Colors.valueOf(initialState));
            trafficLights.add(trafficLight);
        }

        for (int i = 0; i < updatesCount; i++){
            for (TrafficLight trafficLight : trafficLights) {
                trafficLight.update();
                System.out.print(trafficLight.toString() + " ");
            }
            System.out.println();
        }
    }
    }
