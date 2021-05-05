package onlineShop.models.products.computers;

import onlineShop.models.products.BaseProduct;
import onlineShop.models.products.components.Component;
import onlineShop.models.products.peripherals.Peripheral;

import java.util.ArrayList;
import java.util.List;

import static onlineShop.common.constants.ExceptionMessages.*;
import static onlineShop.common.constants.OutputMessages.*;

public abstract class BaseComputer extends BaseProduct implements Computer {
    private List<Component> components;
    private List<Peripheral> peripherals;


    protected BaseComputer(int id, String manufacturer, String model, double price, double overallPerformance) {
        super(id, manufacturer, model, price, overallPerformance);
        this.components = new ArrayList<>();
        this.peripherals = new ArrayList<>();
    }

    @Override
    public List<Component> getComponents() {
        return this.components;
    }

    @Override
    public List<Peripheral> getPeripherals() {
        return this.peripherals;
    }

    @Override
    public void addComponent(Component component) {
        if(components.stream().anyMatch(c -> c.getClass() == component.getClass())){
            throw  new IllegalArgumentException(String.format(EXISTING_COMPONENT, component.getClass().getSimpleName(), this.getClass().getSimpleName(), this.getId()));
        }

        this.components.add(component);
    }

    @Override
    public double getOverallPerformance() {

        double componentsPerformance = components.stream().mapToDouble(Component::getOverallPerformance).average().orElse(0);
        return super.getOverallPerformance() + componentsPerformance;
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public double getPrice() {

        return super.getPrice() + components.stream()
                .mapToDouble(Component::getPrice)
                .sum()
                + peripherals.stream()
                .mapToDouble(Peripheral::getPrice)
                .sum();

    }

    @Override
    public String getModel() {
        return super.getModel();
    }

    @Override
    public void addPeripheral(Peripheral peripheral) {
        if(peripherals.stream().anyMatch(c -> c.getClass() == peripheral.getClass())){
            throw  new IllegalArgumentException(String.format(EXISTING_PERIPHERAL, peripheral.getClass().getSimpleName(), this.getClass().getSimpleName(), this.getId()));
        }

        this.peripherals.add(peripheral);
    }

    @Override
    public Component removeComponent(String componentType) {

        if(components.stream().noneMatch(c -> c.getClass().getSimpleName().equals(componentType))){
            throw  new IllegalArgumentException(String.format(NOT_EXISTING_COMPONENT, componentType, this.getClass().getSimpleName(), this.getId()));

        }
        int index = 0;

        for (int i = 0; i < components.size(); i++) {
            Component component = components.get(i);
            if (component.getClass().getSimpleName().equals(componentType)){
                index = i;
                break;
            }
        }

        return components.remove(index);
    }


    @Override
    public Peripheral removePeripheral(String peripheralType) {

        if(peripherals.stream().noneMatch(p -> p.getClass().getSimpleName().equals(peripheralType))){
            throw  new IllegalArgumentException(String.format(NOT_EXISTING_PERIPHERAL, peripheralType, this.getClass().getSimpleName(), this.getId()));

        }
        int index = 0;

        for (int i = 0; i < peripherals.size(); i++) {
            Peripheral peripheral = peripherals.get(i);
            if (peripheral.getClass().getSimpleName().equals(peripheralType)){
                index = i;
                break;
            }
        }

        return peripherals.remove(index);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());

        sb.append(System.lineSeparator());

        sb.append(String.format(" " + COMPUTER_COMPONENTS_TO_STRING, getComponents().size()));
        sb.append(System.lineSeparator());

        for (Component component: components) {
            sb.append("  ").append(component.toString()).append(System.lineSeparator());
        }

        sb.append(String.format(" " + COMPUTER_PERIPHERALS_TO_STRING, getPeripherals().size(),
                peripherals.stream().mapToDouble(Peripheral::getOverallPerformance).average().orElse(0)));
        sb.append(System.lineSeparator());

        for (Peripheral peripheral: peripherals) {
            sb.append("  ").append(peripheral.toString()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
