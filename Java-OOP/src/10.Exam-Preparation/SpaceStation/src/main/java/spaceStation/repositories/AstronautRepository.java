package spaceStation.repositories;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.astronauts.BaseAstronaut;

import java.util.*;
import java.util.stream.Collectors;

import static spaceStation.common.ExceptionMessages.ASTRONAUT_DOES_NOT_EXIST;

public class AstronautRepository implements Repository<Astronaut>{

    private Set<Astronaut> astronauts;

    public AstronautRepository() {
        this.astronauts = new LinkedHashSet<>();
    }

    @Override
    public Set<Astronaut> getModels() {

        return Collections.unmodifiableSet(this.astronauts);
    }

    @Override
    public void add(Astronaut astronaut) {

        this.astronauts.add(astronaut);

    }

    @Override
    public boolean remove(Astronaut astronaut) {

        return this.astronauts.remove(astronaut);
    }

    @Override
    public Astronaut findByName(String name) {
        List<Astronaut> collect = this.astronauts.stream().filter(a -> a.getName().equals(name)).collect(Collectors.toList());

        if (collect.isEmpty()){
           throw new IllegalArgumentException(ASTRONAUT_DOES_NOT_EXIST);
        }

        return collect.get(0);
    }
}
