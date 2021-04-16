import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstPlayerCards = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> secondPlayerCards = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        while (firstPlayerCards.size() > 0 && secondPlayerCards.size() > 0){

            int firstPlayerCard = firstPlayerCards.get(0);
            int secondPlayerCard = secondPlayerCards.get(0);

            if (firstPlayerCard > secondPlayerCard){
                firstPlayerCards.add(firstPlayerCard);
                firstPlayerCards.add(secondPlayerCard);
                firstPlayerCards.remove(0);
                secondPlayerCards.remove(0);
            }else if (firstPlayerCard == secondPlayerCard){
                firstPlayerCards.remove(0);
                secondPlayerCards.remove(0);
            }else {
                secondPlayerCards.add(secondPlayerCard);
                secondPlayerCards.add(firstPlayerCard);
                secondPlayerCards.remove(0);
                firstPlayerCards.remove(0);
            }
        }
        //Player {one/two} wins! Sum: {sum}
        if (firstPlayerCards.size() > 0){
            int sum = 0;
            for (int i = 0; i < firstPlayerCards.size() ; i++) {
                sum += firstPlayerCards.get(i);
            }
            System.out.printf("First player wins! Sum: %d", sum);
        }else {
            int sumSecond = 0;
            for (int j = 0; j < secondPlayerCards.size() ; j++) {
                sumSecond += secondPlayerCards.get(j);
            }
            System.out.printf("Second player wins! Sum: %d", sumSecond);
        }
    }
}