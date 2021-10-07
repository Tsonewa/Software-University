package RandomArrayList;

public class Main {
    public static void main(String[] args) {

        RandomArrayList<Integer> data = new RandomArrayList<Integer>();

        for (int i = 0; i < 100; i++) {
            data.add(i);
        }

        System.out.println(data.getRandomElement());
    }
}
