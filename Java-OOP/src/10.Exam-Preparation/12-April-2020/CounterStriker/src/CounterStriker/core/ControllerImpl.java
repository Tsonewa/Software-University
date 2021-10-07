package CounterStriker.core;

import CounterStriker.models.field.Field;
import CounterStriker.models.field.FieldImpl;
import CounterStriker.models.guns.Gun;
import CounterStriker.models.guns.Pistol;
import CounterStriker.models.guns.Rifle;
import CounterStriker.models.players.CounterTerrorist;
import CounterStriker.models.players.Player;
import CounterStriker.models.players.Terrorist;
import CounterStriker.repositories.GunRepository;
import CounterStriker.repositories.PlayerRepository;
import CounterStriker.repositories.Repository;

import java.util.*;
import java.util.stream.Collectors;

import static CounterStriker.common.ExceptionMessages.*;
import static CounterStriker.common.OutputMessages.SUCCESSFULLY_ADDED_GUN;
import static CounterStriker.common.OutputMessages.SUCCESSFULLY_ADDED_PLAYER;

public class ControllerImpl implements Controller {
    private Repository<Gun> guns;
    private Repository<Player> players;
    private Field field;

    protected ControllerImpl(){
        this.guns = new GunRepository();
        this.players = new PlayerRepository();
        this.field = new FieldImpl();
    }

    @Override
    public String addGun(String type, String name, int bulletsCount) {

        Gun gun;

        switch (type) {
            case "Pistol":
                gun = new Pistol(name, bulletsCount);
                break;
            case "Rifle":
                gun = new Rifle(name, bulletsCount);
                break;
            default:
                throw new IllegalArgumentException(INVALID_GUN_TYPE);
        }

        this.guns.add(gun);
        return String.format(SUCCESSFULLY_ADDED_GUN, name);
    }

    @Override
    public String addPlayer(String type, String username, int health, int armor, String gunName) {
        Gun gun = this.guns.findByName(gunName);

        if(gun == null){
            throw new NullPointerException(GUN_CANNOT_BE_FOUND);
        }

        Player player;

        switch (type) {
            case "Terrorist":
                player = new Terrorist(username, health, armor, gun);
                break;
            case "CounterTerrorist":
                player = new CounterTerrorist(username,health, armor, gun);
                break;
            default:
                throw new IllegalArgumentException(INVALID_PLAYER_TYPE);
        }

        this.players.add(player);
        return String.format(SUCCESSFULLY_ADDED_PLAYER, username);
    }

    @Override
    public String startGame() {
Collection<Player> players = this.players.getModels()
        .stream().
                filter(Player::isAlive).
                collect(Collectors.toList());
        return this.field.start(players);
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();

        List<Player> playerList = (List<Player>) players.getModels();

        List<Player> filteredPlayers = playerList.stream()
                .sorted(Comparator.comparing(p -> p.getClass().getSimpleName()))
                .sorted(Comparator.comparing(Player::getHealth).reversed())
                .collect(Collectors.toList());

        for (Player player : filteredPlayers) {
            sb.append(String.format("%s: %s", player.getClass().getSimpleName(), player.getUsername())).append(System.lineSeparator());
            sb.append(String.format("--Health: %s", player.getHealth())).append(System.lineSeparator());
            sb.append(String.format("--Armor: %s", player.getArmor())).append(System.lineSeparator());
            sb.append(String.format("--Gun: %s", player.getGun().getName())).append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
