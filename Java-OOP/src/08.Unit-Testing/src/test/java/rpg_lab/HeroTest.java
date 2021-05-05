package rpg_lab;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class HeroTest {

    private static final String HERO_NAME = "Pesho";
    private static final int TARGET_XP = 0;

    @Test
    public void testAttackGainsExperienceIfTargetIsDead(){
    Target target = Mockito.mock(Target.class);
    Weapon weapon = Mockito.mock(Weapon.class);

    Mockito.when(target.isDead()).thenReturn(true);
    Mockito.when(target.giveExperience()).thenReturn(TARGET_XP);

    Hero hero = new Hero(HERO_NAME, weapon);
    hero.attack(target);
    Assert.assertEquals(TARGET_XP, hero.getExperience());
}
}