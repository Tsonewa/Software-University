import java.util.Scanner;

public class ChristmasSweets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        double priceBaklava = Double.parseDouble(scanner.nextLine());
        double priceMufin = Double.parseDouble(scanner.nextLine());
        double kilogramSholen = Double.parseDouble(scanner.nextLine());
        double kilogramSweets = Double.parseDouble(scanner.nextLine());
        int kilogramCookies = Integer.parseInt(scanner.nextLine());//
        //•	Щолен – 60% по-скъп от баклавата
        //•	Бонбони – 80% по-скъпи от мъфини
        //•	Бисквити – 7.50 лв. за килограм
        double priceShtolen = priceBaklava + (priceBaklava * 0.6);
        double sumShtolen = priceShtolen * kilogramSholen;
        double sweets = priceMufin + (priceMufin * 0.8);
        double sumSweets = sweets * kilogramSweets;
        double sumBiscuit = kilogramCookies * 7.5;
        double totalSum = sumBiscuit + sumShtolen + sumSweets;
        System.out.printf("%.2f", totalSum);
    }
}
