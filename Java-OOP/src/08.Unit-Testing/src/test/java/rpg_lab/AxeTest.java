package rpg_lab;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AxeTest {

    private static final int AXE_ATTACK = 10;
    private  static final int AXE_DURABILITY = 10;
    private static final int DUMMY_HEALTH = 1000;
    private static final int DUMMY_EXPERIENCE = 10;

    private Axe axe;
    private Dummy dummy;

    @Before
    public void setUp() {
        this.axe = new Axe(AXE_ATTACK,AXE_DURABILITY);
        this.dummy = new Dummy(DUMMY_HEALTH, DUMMY_EXPERIENCE);
    }

    //Test if weapon loses durability after each attack
    @Test
    public void testAxeLosesDurabilityAfterEachAttack(){

        axe.attack(dummy);

        assertEquals(9, axe.getDurabilityPoints());
    }
    //Test attacking with a broken weapon
    @Test(expected = IllegalStateException.class)
    public void testAttackDummyWIthBrackenWeapon(){
        Axe axe = new Axe(AXE_ATTACK, 0);

        axe.attack(dummy);
    }
}