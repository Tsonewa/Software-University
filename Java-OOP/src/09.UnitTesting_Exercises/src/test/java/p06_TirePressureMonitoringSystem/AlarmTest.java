package p06_TirePressureMonitoringSystem;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class AlarmTest {

    private static final double LOW_PRESSURE_THRESHOLD = 17;
    private static final double HIGH_PRESSURE_THRESHOLD = 21;
    Sensor sensor = Mockito.mock(Sensor.class);

    @Test
    public void testCheckMethodPressureLessThanTheAllowedAmount(){
        when(this.sensor.popNextPressurePsiValue()).thenReturn(LOW_PRESSURE_THRESHOLD + 0.5);
        Alarm alarm = new Alarm(this.sensor);
        alarm.check();

        Assert.assertFalse(alarm.getAlarmOn());
    }

    @Test
    public void testCheckMethodPressureMoreThanTheAllowedAmount(){
        when(this.sensor.popNextPressurePsiValue()).thenReturn(HIGH_PRESSURE_THRESHOLD - 0.5);
        Alarm alarm = new Alarm(this.sensor);
        alarm.check();

        Assert.assertFalse(alarm.getAlarmOn());
    }

    @Test
    public void testCheckMethodWithCorrectValuesForLowPressure(){
        when(this.sensor.popNextPressurePsiValue()).thenReturn(LOW_PRESSURE_THRESHOLD + 0.5);
        Alarm alarm = new Alarm(this.sensor);
        alarm.check();

        Assert.assertFalse(alarm.getAlarmOn());
    }

    @Test
    public void testCheckMethodWithCorrectValuesForHighPressure(){

        when(this.sensor.popNextPressurePsiValue()).thenReturn(HIGH_PRESSURE_THRESHOLD - 1.1);
        Alarm alarm = new Alarm(this.sensor);
        alarm.check();

        Assert.assertFalse(alarm.getAlarmOn());
    }

}