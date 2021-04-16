package ListyIterator;

import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable<String>{
    private List<String> data;
    private int index;

    public ListyIterator (List<String> data){
        this.data = data;
        if (this.data.size() != 0){
            this.index = 0;
        }else {
            index = -1;
        }
    }
    public List<String> getData() {
        return data;
    }
    public boolean Move (){
       if (this.index >= this.data.size() - 1){
           return false;
       }
       this.index++;
       return true;
    }
    public boolean HasNext(){
        return this.index < this.data.size() - 1;
    }

    public String print(){
        if (this.index != -1){
            return this.data.get(this.index);
        }
        return "Invalid Operation!";
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return this.index <= data.size() - 1;
            }
            @Override
            public String next() {
                return data.get(this.index++);
            }
        };
    }
}
