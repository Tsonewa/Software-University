package FootbollTeamGenerator;

import java.util.ArrayList;
import java.util.List;

public class Team {
private String name;
private List<Player> players;

public Team(String name){
    this.setName(name);
    this.players = new ArrayList<>();
}

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void addPlayer(Player player){
    if (getName() == null){
        throw new IllegalArgumentException("Team" + name +  "does not exist.");
    }
    this.players.add(player);
    }

    public void removePlayer(String name){
    boolean flag = true;
        if (!this.players.removeIf(e -> e.getName().equals(name))) {
            flag = false;
        } else {
            throw new IllegalArgumentException("Player " + name + " is not in " + getName() +  " team.");
        }
    }
    public double getRating(String name){
        if (!getName().equals(name)){
            throw new IllegalArgumentException("Team " + name + " does not exist.");
        }
        return Player.overallSkillLevel();
    }
}
