package spaceStation.models.mission;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.planets.Planet;
import spaceStation.repositories.AstronautRepository;

import java.util.Collection;

public interface Mission {

    void explore(Planet planet, Collection<Astronaut> astronauts);
}
