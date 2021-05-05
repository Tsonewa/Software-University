package p06_TirePressureMonitoringSystem;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Random;

public class SensorTest {
    private static final double OFFSET = 16;
    private Random secondRandom = Mockito.mock(Random.class);
    private Random firstRandom = Mockito.mock(Random.class);
    private Sensor sensor = Mockito.mock(Sensor.class);

    @Test
    public void testPopNextPressurePsiValueCorrectValue(){
        Mockito.when(this.firstRandom.nextDouble()).thenReturn(0.5);
        Mockito.when(this.secondRandom.nextDouble()).thenReturn(1.1);

        Mockito.when(this.sensor.popNextPressurePsiValue()).thenReturn(17.6);

        Assert.assertEquals(OFFSET + this.firstRandom.nextDouble() + this.secondRandom.nextDouble(), this.sensor.popNextPressurePsiValue(), 0);
    }
}