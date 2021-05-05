package CounterStriker.models.guns;

public class Rifle extends GunImpl {
    private static final int CONSTANT_AMOUNT_BULLETS_PER_SHOOT = 10;

    public Rifle(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    public int fire() {
        //Rifle can fire() 10 bullets at a time.
        if(this.getBulletsCount() < CONSTANT_AMOUNT_BULLETS_PER_SHOOT){
            return super.fire();
        }

        super.decreaseBullets(CONSTANT_AMOUNT_BULLETS_PER_SHOOT);
        return CONSTANT_AMOUNT_BULLETS_PER_SHOOT;
    }
}
