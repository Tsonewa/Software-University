package GenericArrayCreator;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayCreator {


    @SuppressWarnings("unchecked")
public static <T>T[] create(int lenght, T elements){
   T[] arr = (T[]) Array.newInstance(elements.getClass(), lenght);
        Arrays.fill(arr, elements);
    return arr;
}
@SuppressWarnings("unchecked")
public static <T> T[] create (Class<T> tClass, int lenght, T item){

    T[] array = (T[]) Array.newInstance(tClass, lenght);
    Arrays.fill(array, item);
    return array;
}
}
