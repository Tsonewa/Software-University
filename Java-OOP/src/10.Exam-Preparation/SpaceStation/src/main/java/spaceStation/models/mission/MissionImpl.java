package spaceStation.models.mission;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.bags.Backpack;
import spaceStation.models.planets.Planet;
import spaceStation.repositories.PlanetRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MissionImpl implements Mission{

    private Planet planet;
    private Collection<Astronaut> astronauts;
    private final PlanetRepository planetRepository;

    public MissionImpl(Planet planet, Collection<Astronaut> astronauts, PlanetRepository planetRepository) {
        this.planet = planet;
        this.astronauts =  astronauts;
        this.planetRepository = planetRepository;
    }

    public Collection<Astronaut> getAstronauts() {
        return astronauts;
    }

    public void setAstronauts(Collection<Astronaut> astronauts) {
        this.astronauts = astronauts;
    }

    public Planet getPlanet() {
        return planet;
    }

    public void setPlanet(Planet planet) {
        this.planet = planet;
    }

    @Override
    public void explore(Planet planet, Collection<Astronaut> astronauts) {

        List<Astronaut> astronautsAlive = astronauts.stream().filter(Astronaut::canBreath).collect(Collectors.toList());

        Backpack getteredItems = new Backpack();
        List<String> item = new ArrayList<>();

        for (int i = 0; i < astronautsAlive.size(); i++) {

            Astronaut astronaut = astronautsAlive.get(i);
           while (astronaut.canBreath()){
               List<String> getteredItem = planet.getItems().stream().collect(Collectors.toList());
               if (!getteredItem.isEmpty()){
                   item.add(getteredItem.get(0));
                   getteredItem.remove(0);
                   astronaut.breath();
               }
           }

        }

        getteredItems.setItems(item);


    }
}
