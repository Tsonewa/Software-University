import java.util.Scanner;

public class FirstTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String activationKey =scanner.nextLine();
        String commands = scanner.nextLine();

        while (!commands.equals("Generate")){
            String[] tokans = commands.split(">>>");
            String command = tokans[0];

            switch (command) {
                case "Contains":
                    String subString = tokans[1];
                    if (activationKey.contains(subString)) {
                        System.out.printf("%s contains %s%n", activationKey, subString);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    String upLow = tokans[1];
                    int stsrtIndex = Integer.parseInt(tokans[2]);
                    int endIndex = Integer.parseInt(tokans[3]);

                    if (upLow.equals("Lower")) {
                        String first = activationKey.substring(0, stsrtIndex);
                        String second = activationKey.substring(stsrtIndex, endIndex).toLowerCase();
                        String third = activationKey.substring(endIndex, activationKey.length());
                        activationKey = first + second + third;
                        System.out.println(activationKey);

                    } else if (upLow.equals("Upper")) {
                        String firstUp = activationKey.substring(0, stsrtIndex);
                        String secondUp = activationKey.substring(stsrtIndex, endIndex).toUpperCase();
                        String thirdUp = activationKey.substring(endIndex, activationKey.length());
                        activationKey = firstUp + secondUp + thirdUp;
                        System.out.println(activationKey);
                    } else {
                        break;
                    }
                    break;
                case "Slice":
                    int startInd = Integer.parseInt(tokans[1]);
                    int endInd = Integer.parseInt(tokans[2]);
                    String replace = activationKey.substring(startInd, endInd);
                    activationKey = activationKey.replace(replace, "");
                    System.out.println(activationKey);
                    break;
                default:
                    break;
            }

            commands = scanner.nextLine();
        }
        System.out.printf("Your activation key is: %s",activationKey);
    }
}

