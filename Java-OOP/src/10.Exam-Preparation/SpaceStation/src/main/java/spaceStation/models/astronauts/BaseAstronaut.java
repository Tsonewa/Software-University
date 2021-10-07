package spaceStation.models.astronauts;

import spaceStation.models.bags.Backpack;
import spaceStation.models.bags.Bag;
import spaceStation.repositories.PlanetRepository;

import static spaceStation.common.ConstantMessages.*;
import static spaceStation.common.ExceptionMessages.ASTRONAUT_NAME_NULL_OR_EMPTY;
import static spaceStation.common.ExceptionMessages.ASTRONAUT_OXYGEN_LESS_THAN_ZERO;

public abstract class BaseAstronaut implements Astronaut{

    private String name;
    private double oxygen;
    private Backpack bag;

//    public BaseAstronaut(String name, double oxygen, Backpack bag) {
//        this.name = name;
//        this.oxygen = oxygen;
//        this.bag = bag;
//    }

    public BaseAstronaut(String name, double oxygen) {
        setName(name);
        setOxygen(oxygen);
        this.bag = new Backpack();
    }

    public void setName(String name) {

        if(name == null || name.trim().equals("")){
            throw new NullPointerException(ASTRONAUT_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public void setOxygen(double oxygen) {

        if(oxygen < 0){
            throw new IllegalArgumentException(ASTRONAUT_OXYGEN_LESS_THAN_ZERO);
        }
        this.oxygen = oxygen;
    }

    public void setBag(Backpack bag) {
        this.bag = bag;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getOxygen() {
        return this.oxygen;
    }

    @Override
    public boolean canBreath() {

        return this.oxygen >= 10;
    }

    @Override
    public Bag getBag() {
        return this.bag;
    }

    @Override
    public void breath() {

        if(canBreath()){
            this.oxygen -= 10;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(REPORT_ASTRONAUT_INFO);

        sb
                .append(System.lineSeparator())
                .append(String.format(REPORT_ASTRONAUT_NAME, getName()))
                .append(System.lineSeparator())
                .append(String.format(REPORT_ASTRONAUT_OXYGEN, getOxygen()))
                .append(System.lineSeparator())
                .append(getBag().getItems() == null ? "Bag items: none" :
                        String.format(String.join(REPORT_ASTRONAUT_BAG_ITEMS_DELIMITER),
                                REPORT_ASTRONAUT_BAG_ITEMS, getBag().getItems().size()))
                .append(System.lineSeparator());

        return sb.toString();

    }


}
