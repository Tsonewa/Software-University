package rpg_lab;

public class Axe implements Weapon {
    private int attackPoints;
    private int durabilityPoints;

    public Axe(int attackPoints, int durabilityPoints) {
        this.attackPoints = attackPoints;
        this.durabilityPoints = durabilityPoints;
    }

    @Override
    public int getAttackPoints() {
        return this.attackPoints;
    }

    @Override
    public int getDurabilityPoints() {
        return this.durabilityPoints;
    }

    @Override
    public void attack(Target target) {
        if (this.durabilityPoints <= 0) {
            throw new IllegalStateException("Axe is broken.");
        }

        target.takeAttack(this.attackPoints);
        this.durabilityPoints -= 1;
    }
}
