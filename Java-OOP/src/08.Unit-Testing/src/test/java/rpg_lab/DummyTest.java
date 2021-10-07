package rpg_lab;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DummyTest {

    private static final int AXE_ATTACK = 10;
    private  static final int AXE_DURABILITY = 10;
    private static final int DUMMY_HEALTH = 1000;
    private static final int DUMMY_EXPERIENCE = 10;
    private static final int DUMMY_ATTACK_POINTS = 5;
    private static final int EXPECTED_DURABILITY = DUMMY_HEALTH - DUMMY_ATTACK_POINTS;

    private Axe axe;
    private Dummy dummy;

    @Before
    public void setUp() {
        this.axe = new Axe(AXE_ATTACK,AXE_DURABILITY);
        this.dummy = new Dummy(DUMMY_HEALTH, DUMMY_EXPERIENCE);
    }


    //Dummy loses health if attacked
    @Test
    public void testDummyLosesHealthIfAttacked(){

        dummy.takeAttack(DUMMY_ATTACK_POINTS);

        assertEquals(EXPECTED_DURABILITY, dummy.getHealth());
    }

    //Dead Dummy throws exception if attacked
    @Test(expected = IllegalStateException.class)
    public void testDummyThrowsExceptionIfAttackedAndItIsDead(){
Dummy dummy = new Dummy(-10, DUMMY_EXPERIENCE);

dummy.takeAttack(AXE_ATTACK);
    }


    //Dead Dummy can give XP
    @Test(expected = IllegalStateException.class)
    public void testDummyCanNotGiveXPWhenIsDead(){

        Dummy dummy = new Dummy(0, DUMMY_EXPERIENCE);

        dummy.takeAttack(AXE_ATTACK);
    }

    //Alive Dummy can't give XP
    @Test(expected = IllegalStateException.class)
    public void testDummyCanGiveXPWhenIsAlive(){

        dummy.takeAttack(AXE_ATTACK);
        assertEquals(1000, dummy.giveExperience());
    }
}