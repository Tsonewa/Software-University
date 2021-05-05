package CounterStriker.models.field;

import CounterStriker.models.players.CounterTerrorist;
import CounterStriker.models.players.Player;
import CounterStriker.models.players.PlayerImpl;
import CounterStriker.models.players.Terrorist;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static CounterStriker.common.OutputMessages.COUNTER_TERRORIST_WINS;
import static CounterStriker.common.OutputMessages.TERRORIST_WINS;

public class FieldImpl implements Field {
    private Collection<Terrorist> terrorists;
    private Collection<CounterTerrorist> counterTerrorists;

    public FieldImpl() {
        this.terrorists = new ArrayList<>();
        this.counterTerrorists = new ArrayList<>();
    }

    @Override
    public String start(Collection<Player> players) {

        for (Player player : players) {
            if (player instanceof Terrorist) {
                terrorists.add((Terrorist) player);
            } else if (player instanceof CounterTerrorist) {
                counterTerrorists.add((CounterTerrorist) player);
            }
        }

        while (terrorists.stream().anyMatch(Player::isAlive) &&
                counterTerrorists.stream().anyMatch(Player::isAlive)) {

            for (Terrorist terrorist : terrorists) {
                for (CounterTerrorist counterTerrorist : counterTerrorists) {
                    counterTerrorist.takeDamage(terrorist.getGun().fire());
                }
            }
            counterTerrorists = counterTerrorists.stream().filter(PlayerImpl::isAlive).collect(Collectors.toList());

            for (CounterTerrorist counterTerrorist : counterTerrorists) {
                for (Terrorist terrorist : terrorists) {
                    terrorist.takeDamage(counterTerrorist.getGun().fire());
                }
            }
            terrorists = terrorists.stream().filter(PlayerImpl::isAlive).collect(Collectors.toList());
        }
        return terrorists.stream().anyMatch(Player::isAlive) ? TERRORIST_WINS : COUNTER_TERRORIST_WINS;
    }
}

