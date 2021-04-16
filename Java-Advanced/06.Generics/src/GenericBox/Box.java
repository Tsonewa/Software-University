package GenericBox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Box <T>{
private List<T> value;

public Box (){
    this.value = new ArrayList<>();
}

    public List<T> getValue() {
        return value;
    }
    @Override
    public String toString (){
        StringBuilder stringBuilder = new StringBuilder();
        for (T line: value) {
            stringBuilder.append(String.format("%s: %s", line.getClass().getName(), line));
            stringBuilder.append(System.lineSeparator());
        }
        return stringBuilder.toString();
}
}
