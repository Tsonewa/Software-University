package ListyIterator;

import java.util.List;

public class ListyIterator {
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
    @Override
    public String toString(){
        return String.format("%s", this.data.get(this.index));
    }
}
