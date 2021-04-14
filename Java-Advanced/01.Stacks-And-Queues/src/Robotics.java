import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Robotics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] robotsList = scanner.nextLine().split(";");
        LinkedHashMap<String, Integer> robots = new LinkedHashMap<>();
        for (int i = 0; i < robotsList.length; i++) {
            String[] robot = robotsList[i].split("-");
            String robotName = robot[0];
            int setTimeforWork = Integer.parseInt(robot[1]);
            robots.put(robotName, setTimeforWork);
        }
        String[] inputTime = scanner.nextLine().split(":");
        int hours = Integer.parseInt(inputTime[0]);
        int minutes = Integer.parseInt(inputTime[1]);
        int seconds = Integer.parseInt(inputTime[2]);
        long timeInSeconds = hours * 3600 + minutes * 60 + seconds;

        String product = scanner.nextLine();
        ArrayDeque<String> products = new ArrayDeque<>();
        int[] workingTime = new int[robots.size()];

        while (!product.equals("End")) {
            products.offer(product);
            product = scanner.nextLine();
        }
        while (!products.isEmpty()) {
            String currentProduct = products.poll();

            timeInSeconds++;
            boolean isAssigned = false;

            for (int robot = 0; robot < workingTime.length; robot++) {
                if (workingTime[robot] > 0) {
                    --workingTime[robot];
                }
            }
            for (int i = 0; i < workingTime.length; i++) {
                if (workingTime[i] == 0) {

                    int count = 0;
                    for (Map.Entry<String, Integer> robot : robots.entrySet()) {
                        if (count == i) {
                            workingTime[i] = robot.getValue();

                            long takenHour = timeInSeconds / 3600 % 24;
                            long takenMinute = timeInSeconds % 3600 / 60;
                            long takenSeconds = timeInSeconds % 60;
                            System.out.printf("%s - %s [%02d:%02d:%02d]%n", robot.getKey(), currentProduct, takenHour, takenMinute, takenSeconds);
                            isAssigned = true;
                            break;
                        }
                        count++;
                    }
                    break;
                }
            }
            if (!isAssigned) {
                products.offer(currentProduct);
            }
        }
    }
}