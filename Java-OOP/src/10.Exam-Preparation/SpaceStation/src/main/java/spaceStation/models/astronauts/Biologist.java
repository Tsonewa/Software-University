package spaceStation.models.astronauts;

public class Biologist extends BaseAstronaut{


    public Biologist(String name) {
        super(name, 70.0);
    }

    @Override
    public void breath() {

        if (super.getOxygen() >= 5){
            super.setOxygen(super.getOxygen() - 5);
        }
    }
}
