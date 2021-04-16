import java.util.Scanner;

public class BeerKegs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        int n = Integer.parseInt(scanner.nextLine());
        double maxValue = 0.0;
        String modelName = "";
        //Calculate the volume using the following formula: π * r^2 * h.

        for (int i = 0; i < n ; i++) {
            String model = scanner.nextLine();
            double radius = Double.parseDouble(scanner.nextLine());
            int height = Integer.parseInt(scanner.nextLine());
            double volume = Math.PI * radius * radius * height;

            if (volume > maxValue){
                maxValue = volume;
                modelName = model;
            }
        }
        System.out.println(modelName);
    }
}
