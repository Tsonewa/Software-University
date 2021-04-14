package CountGenerics;

import java.util.ArrayList;
import java.util.List;

public class BoxCount<T extends Comparable<T>>{
    private List<T> elements;

    public BoxCount (){
        this.elements = new ArrayList<>();
    }
    public void  add (T element){
      this.elements.add(element);
    }

    public long countGreaterString(T number) {
       return elements.stream().filter(e-> e.compareTo(number) > 0).count();
    }
}
