package CounterStriker.models.players;

import CounterStriker.models.guns.Gun;

import static CounterStriker.common.ExceptionMessages.*;

public abstract class PlayerImpl implements Player {
    private String username;
    private int health;
    private  int armor;
    private boolean isAlive;
    private Gun gun;

    protected PlayerImpl(String username, int health, int armor,  Gun gun) {
        this.setUsername(username);
        this.setHealth(health);
        this.setArmor(armor);
        this.isAlive = isAlive();
        this.setGun(gun);
    }

    public void setUsername(String username) {
        if(username == null || username.trim().isEmpty()){
            throw new NullPointerException(INVALID_PLAYER_NAME);
        }
        this.username = username;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setHealth(int health) {

        if(health < 0){
            throw new IllegalArgumentException(INVALID_PLAYER_HEALTH);
        }

        this.health = health;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    public void setArmor(int armor) {

        if(armor < 0){
            throw new IllegalArgumentException(INVALID_PLAYER_ARMOR);
        }

        this.armor = armor;
    }

    @Override
    public int getArmor() {
        return this.armor;
    }

    public void setGun(Gun gun) {

        if(gun == null){
            throw new NullPointerException(INVALID_GUN);
        }

        this.gun = gun;
    }

    @Override
    public boolean isAlive() {
        return this.health > 0;
    }

    @Override
    public Gun getGun() {
        return this.gun;
    }

    @Override
    public void takeDamage(int points) {

       int directDamage = points > this.getArmor() ? points - this.getArmor() : 0;
       this.setArmor(Math.max(this.getArmor() - points, 0));
       this.setHealth(Math.max(this.getHealth() - directDamage, 0));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%s: %s", this.getClass().getSimpleName(), getUsername())).append(System.lineSeparator());
        sb.append(String.format("--Health: %s", getHealth())).append(System.lineSeparator());
        sb.append(String.format("--Armor: %s", getArmor())).append(System.lineSeparator());
        sb.append(String.format("--Gun: %s", this.getGun().getName())).append(System.lineSeparator());

        return sb.toString().trim();
    }
}
