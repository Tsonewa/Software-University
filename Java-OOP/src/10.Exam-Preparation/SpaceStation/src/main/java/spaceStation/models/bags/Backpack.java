package spaceStation.models.bags;

import java.util.Collection;

public class Backpack implements Bag {

    private Collection<String> items;

    public Backpack() {
    }

    public void setItems(Collection<String> items) {
        this.items = items;
    }

    @Override
    public Collection<String> getItems() {
        return this.items;
    }


}
