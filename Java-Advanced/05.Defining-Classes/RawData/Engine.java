package RawData;

public class Engine {
private int engineSpeed;
private int enginePower;

public Engine(int engineSpeed, int enginePower){
    this.engineSpeed = engineSpeed;
    this.enginePower = enginePower;
}

    public int getEnginePower() {
        return enginePower;
    }

    public boolean checkEnginePower (int enginePower){
    if (enginePower > 250){
        return true;
    }
    return false;
}
}

