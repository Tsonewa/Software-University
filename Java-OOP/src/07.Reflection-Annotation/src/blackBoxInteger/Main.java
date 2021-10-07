package blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Scanner scanner = new Scanner(System.in);

        Class<BlackBoxInt> clazz = BlackBoxInt.class;

        Constructor<BlackBoxInt> ctr = clazz.getDeclaredConstructor(int.class);

        ctr.setAccessible(true);
        BlackBoxInt blackBoxInt = ctr.newInstance(0);

        String input = scanner.nextLine();

        while (!input.equals("END")){
            String[] tokens = input.split("_");
            String methodName = tokens[0];
            int param = Integer.parseInt(tokens[1]);

            Method method = clazz.getDeclaredMethod(methodName, int.class);
            method.setAccessible(true);
            method.invoke(blackBoxInt, param);

            Field field = clazz.getDeclaredField("innerValue");

            field.setAccessible(true);
            System.out.println(field.get(blackBoxInt));

            input = scanner.nextLine();
        }
    }
}
