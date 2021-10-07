package BorderControl;

public class Identified implements Identifiable {

    private String id;

    protected Identified(String id){
        this.id = id;
    }
    @Override
    public String getId() {
        return this.id;
    }
}
