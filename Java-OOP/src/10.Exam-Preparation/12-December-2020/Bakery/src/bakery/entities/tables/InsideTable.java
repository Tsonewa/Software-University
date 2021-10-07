package bakery.entities.tables;

public class InsideTable extends BaseTable {

    public static final double PRICE_PER_PERSON = 2.5;

    public InsideTable(int tableNumber, int capacity) {
        super(tableNumber, capacity, PRICE_PER_PERSON);
    }
}
