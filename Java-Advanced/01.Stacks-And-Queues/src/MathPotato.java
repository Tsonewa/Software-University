import java.util.ArrayDeque;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> queue = new ArrayDeque<>();
        for (String child : input
        ) {
            queue.offer(child);
        }
        int cycle = 1;
        while (queue.size() > 1) {
            for (int i = 0; i < n - 1; i++) {
                queue.offer(queue.poll());
            }
            if (!isPrime(cycle)) {
                System.out.printf("Removed %s%n", queue.poll());
            }else {
                System.out.printf("Prime %s%n", queue.peek());
            }
            cycle++;
        }
        System.out.printf("Last is %s%n", queue.peek());
    }
        private static boolean isPrime ( int cycle){
            boolean flag = true;
                // no remainder, means divides
            boolean isItPrime = true;

            if(cycle <= 1)
            {
                isItPrime = false;

                return isItPrime;
            }
            else
            {
                for (int i = 2; i <= cycle/2; i++)
                {
                    if ((cycle % i) == 0)
                    {
                        isItPrime = false;

                        break;
                    }
                }

                return isItPrime;
            }
        }

        }
