package Ferrari;

public class Ferrari implements Car{
   private static final String MODEL = "Spider-488";
    private String driverName;

    public Ferrari(String driverName){
        this.driverName = driverName;
    }

    @Override
    public String brakes() {
        return "Brakes!";
    }

    @Override
    public String gas() {
        return "brum-brum-brum-brrrrr";
    }

    @Override
    public String toString() {
        return String.format("%s/%s/%s/%s", Ferrari.MODEL, brakes(), gas(), this.driverName);
    }
}
