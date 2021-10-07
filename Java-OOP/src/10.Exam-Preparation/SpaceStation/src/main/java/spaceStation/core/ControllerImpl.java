package spaceStation.core;

import spaceStation.models.astronauts.*;
import spaceStation.models.mission.Mission;
import spaceStation.models.mission.MissionImpl;
import spaceStation.models.planets.Planet;
import spaceStation.models.planets.PlanetImpl;
import spaceStation.repositories.AstronautRepository;
import spaceStation.repositories.PlanetRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static spaceStation.common.ConstantMessages.*;
import static spaceStation.common.ExceptionMessages.ASTRONAUT_INVALID_TYPE;
import static spaceStation.common.ExceptionMessages.PLANET_ASTRONAUTS_DOES_NOT_EXISTS;

public class ControllerImpl implements Controller {

    private final AstronautRepository astronautRepository;
    private final PlanetRepository planetRepository;

    public ControllerImpl(AstronautRepository astronautRepository, PlanetRepository planetRepository) {
        this.astronautRepository = astronautRepository;
        this.planetRepository = planetRepository;
    }


    @Override
    public String addAstronaut(String type, String astronautName) {

        Astronaut astronaut;
   switch (type){
       case "Biologist":
           astronaut = new Biologist(astronautName);
           break;
       case "Geodesist":
           astronaut = new Geodesist(astronautName);
           break;
       case "Meteorologist":
           astronaut = new Meteorologist(astronautName);
           break;
       default:
           throw new IllegalArgumentException(ASTRONAUT_INVALID_TYPE);
   }

   this.astronautRepository.add(astronaut);

        return String.format(ASTRONAUT_ADDED, type, astronautName);
    }

    @Override
    public String addPlanet(String planetName, String... items) {

        PlanetImpl planet = new PlanetImpl(planetName);

        if(items != null) {
            planet.setItems(Arrays.asList(items));
        }

        planetRepository.add(planet);

        return String.format(PLANET_ADDED, planetName);
    }

    @Override
    public String retireAstronaut(String astronautName) {

        Astronaut retiredAstronaut = astronautRepository.findByName(astronautName);

        astronautRepository.remove(retiredAstronaut);

        return String.format(ASTRONAUT_RETIRED, astronautName);
    }

    @Override
    public String explorePlanet(String planetName) {

        Planet planet = planetRepository.findByName(planetName);

        List<Astronaut> astronauts = astronautRepository.getModels().stream().filter(a -> a.getOxygen() > 60).collect(Collectors.toList());

        if (astronauts.isEmpty()){
            throw new IllegalArgumentException(PLANET_ASTRONAUTS_DOES_NOT_EXISTS);
        }

        Mission mission = new MissionImpl(planet, astronauts, planetRepository);
        mission.explore(planet, astronauts);

        return String.format(PLANET_EXPLORED, planetName,  astronautRepository.getModels().size() - 1 - astronauts.size());
    }


    @Override
    public String report() {
        return planetRepository.toString() + astronautRepository.getModels().toString();
    }
}
