package StrategyPattern;

import java.util.Comparator;

public class PersonNameComperator implements Comparator<Person> {

    @Override
    public int compare(Person o, Person o2) {
        int result = Integer.compare(o.getName().length(), o2.getName().length());
        if (result == 0){
            result = Integer.compare(o.getName().toLowerCase().charAt(0), o2.getName().toLowerCase().charAt(0));
        }
        return result;
    }
}
