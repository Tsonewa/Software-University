import java.io.PrintStream;
import java.util.Scanner;

public class Pokemon {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int pokemonPowerN = Integer.parseInt(sc.nextLine());
        int distanceM = Integer.parseInt(sc.nextLine());
        int exhaustionFactorY = Integer.parseInt(sc.nextLine());
        int count = 0;
        double sum = pokemonPowerN;

        while (distanceM <= pokemonPowerN) {

            pokemonPowerN = pokemonPowerN - distanceM;
            count++;

            if (pokemonPowerN == (sum * 0.50)) {
                if (exhaustionFactorY > 0) {
                    pokemonPowerN = pokemonPowerN / exhaustionFactorY;
                }
            }
        }

        System.out.println(pokemonPowerN);
        System.out.println(count);
    }
}