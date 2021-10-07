import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Main {

    public static class MethodsComparatorByName implements Comparator<Method> {

        @Override
        public int compare(Method o1, Method o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class<?> clazz = Class.forName("Reflection");
        System.out.println(clazz);

        Class<?> superclass = clazz.getSuperclass();
        System.out.println(superclass);

        Class<?>[] interfaces = clazz.getInterfaces();
        for (Class inter: interfaces) {
            System.out.println(inter);
        }

        Object o = clazz.getConstructor().newInstance();
        System.out.println(o);

//        Class<Reflection> reflection = Reflection.class;
//
//        Method[] methods = reflection.getDeclaredMethods();
//
//        Set<Method> setters = new TreeSet<>(new MethodsComparatorByName());
//        Set<Method> getters = new TreeSet<>(new MethodsComparatorByName());
//
//        for (Method method : methods) {
//           if(method.getName().startsWith("set")){
//                setters.add(method);
//           } else if(method.getName().startsWith("get")){
//               getters.add(method);
//           }
//        }
//        for (Method getter : getters) {
//            System.out.printf("%s will return class %s%n", getter.getName(), getter.getReturnType().getName().replace("class", ""));
//        }
//
//        for (Method setter : setters) {
//            System.out.printf("%s and will set field of class %s%n", setter.getName(), setter.getParameterTypes()[0].getName().replace("class", ""));
//        }
//

        Class<Reflection> reflection = Reflection.class;

        Set<Field> fields = new TreeSet<>(Comparator.comparing(Field::getName));
        Set<Method> setters = new TreeSet<>(new MethodsComparatorByName());
        Set<Method> getters = new TreeSet<>(new MethodsComparatorByName());

        Field[] declaredFields = reflection.getDeclaredFields();
        Method[] declaredMethods = reflection.getDeclaredMethods();

        fields.addAll
                (Arrays.stream(declaredFields)
                .filter(f -> !Modifier.isPrivate(f.getModifiers()))
                .collect(Collectors.toList())
        );

        for (Field field : fields) {
            System.out.println(field.getName() + " must be private!");
        }

        for (Method declaredMethod : declaredMethods) {
            if (declaredMethod.getName().startsWith("get")
                    && !Modifier.isPublic(declaredMethod.getModifiers())){
                getters.add(declaredMethod);
            } else  if(declaredMethod.getName().startsWith("set")
                    && !Modifier.isPrivate(declaredMethod.getModifiers())){
                setters.add(declaredMethod);
            }
        }

        for (Method getter : getters) {
            System.out.println(getter.getName() + " have to be public!");
        }

        for (Method setter : setters) {
            System.out.println(setter. getName() + " have to be private!");
        }
    }
}
