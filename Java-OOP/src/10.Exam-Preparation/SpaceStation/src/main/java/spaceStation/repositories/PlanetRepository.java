package spaceStation.repositories;

import spaceStation.models.planets.Planet;

import java.util.*;
import java.util.stream.Collectors;

import static spaceStation.common.ConstantMessages.REPORT_PLANET_EXPLORED;

public class PlanetRepository implements Repository<Planet> {

    private Set<Planet> planets;

    public PlanetRepository() {
        this.planets = new LinkedHashSet<>();
    }

    @Override
    public Set<Planet> getModels() {
        return Collections.unmodifiableSet(this.planets);
    }

    @Override
    public void add(Planet model) {

        this.planets.add(model);
    }

    @Override
    public boolean remove(Planet model) {
        return this.planets.remove(model);
    }

    @Override
    public Planet findByName(String name) {
        List<Planet> collect = this.planets.stream().filter(p -> p.getName().equals(name)).collect(Collectors.toList());

        return collect.get(0);
    }

    @Override
    public String toString() {
        return String.format(REPORT_PLANET_EXPLORED, this.getModels().size());
    }
}
