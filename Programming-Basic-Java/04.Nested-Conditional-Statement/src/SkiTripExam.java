import java.util.Scanner;

public class SkiTripExam {
    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);
        //input
                int days = Integer.parseInt(scanner.nextLine());
                String rooms = scanner.nextLine();
                String grade = scanner.nextLine();
                double price = 0;
                double nights = days - 1;

                switch (rooms) {
                    case "room for one person":
                        price = nights * 18.00;
                        break;
                    case "apartment":
                        price = nights * 25.00;
                        if (days < 10) {
                            price *= 0.7;
                        } else if (days <= 15) {
                            price *= 0.65;
                        } else if (days > 15) {
                            price *= 0.50;
                        }
                        break;
                    case "president apartment":
                        price = nights * 35.00;
                        if (days < 10) {
                            price *= 0.9;
                        } else if (days <= 15) {
                            price *= 0.85;
                        } else if (days > 15) {
                            price *= 0.8;
                        }
                        break;
                }

                if ("positive".equals(grade)) {
                    price = price + (price * 0.25);

                } else {
                    price = price - (price * 0.1);
                }
                System.out.println(String.format("%.2f", price));
            }
        }
