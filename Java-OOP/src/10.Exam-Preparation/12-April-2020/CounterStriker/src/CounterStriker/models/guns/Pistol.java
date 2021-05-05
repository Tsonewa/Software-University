package CounterStriker.models.guns;

public class Pistol extends GunImpl {
    private static final int CONSTANT_AMOUNT_BULLETS_PER_SHOOT = 1;
    public Pistol(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    public int fire() {
        //Pistol can fire 1 bullet a time.
        if(super.getBulletsCount() < CONSTANT_AMOUNT_BULLETS_PER_SHOOT){
            return super.fire();
        }

        super.decreaseBullets(CONSTANT_AMOUNT_BULLETS_PER_SHOOT);
        return CONSTANT_AMOUNT_BULLETS_PER_SHOOT;
    }
}
