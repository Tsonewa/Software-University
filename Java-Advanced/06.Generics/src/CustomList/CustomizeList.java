package CustomList;

import java.util.*;

public class CustomizeList<T extends Comparable<T>>  {
    private List<T> elements;

    public CustomizeList(){
        this.elements = new ArrayList<>();
    }
    public void add (T element){
        this.elements.add(element);
    }
    public T remove (int index){
        validIndex(index);
        return this.elements.remove(index);
    }
    public boolean contains (T element){
        return this.elements.contains(element);
    }
    public void swap (int firstIndex, int secondIndex){
        validIndex(firstIndex);
        validIndex(secondIndex);
        T firstElement = this.elements.get(firstIndex);
        T secondElement = this.elements.get(secondIndex);
        this.elements.set(firstIndex, secondElement);
        this.elements.set(secondIndex, firstElement);
    }
    public int countGreaterElement(T element){
        return (int) this.elements.stream().filter(e -> e.compareTo(element) > 0).count();
    }
public int size (){
        return this.elements.size();
}

    public T get (int index){
        validIndex(index);
        return this.elements.get(index);
    }
public T getMax (){
        return this.elements.stream().max(Comparable::compareTo).get();
}
public T getMin (){
        return this.elements.stream().min(Comparable::compareTo).get();
    }

    private boolean validIndex(int index) {
        if (index < 0 || index >= this.elements.size()){
            throw new IndexOutOfBoundsException("Index out of bounds!");
        }
        return true;
    }
    @Override
    public String toString (){
     StringBuilder sb = new StringBuilder();
        for (T e: this.elements) {
            sb.append(e);
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

}
