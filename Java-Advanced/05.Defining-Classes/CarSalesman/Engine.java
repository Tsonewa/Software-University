package CarSalesman;

public class Engine {
    //model, power, displacement and efficiency.
    private String engineModel;
    private int enginePower;
    private int displacementKm;
    private String efficiency;

    public String getEngineModel() {
        return engineModel;
    }

    public Engine(String engineModel, int enginePower) {
        this.engineModel = engineModel;
        this.enginePower = enginePower;
        this.efficiency = "n/a";
    }

    public Engine(String engineModel, int enginePower, int displacementKm) {
        this(engineModel, enginePower);
        this.displacementKm = displacementKm;
        this.efficiency = "n/a";
    }

    public Engine(String engineModel, int enginePower, String efficiency) {
        this(engineModel, enginePower);
        this.efficiency = efficiency;
    }

    public Engine(String engineModel, int enginePower, int displacementKm, String efficiency) {
        this.engineModel = engineModel;
        this.enginePower = enginePower;
        this.displacementKm = displacementKm;
        this.efficiency = efficiency;
    }
    @Override
    public String toString (){

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Power: " + this.enginePower + "\n");
        if(this.displacementKm == 0) {
            stringBuilder.append("Displacement: n/a" + "\n");
        } else {
            stringBuilder.append("Displacement: " + this.displacementKm + "\n");
        }
        stringBuilder.append("Efficiency: " + this.efficiency);
        return stringBuilder.toString();
    }
}
