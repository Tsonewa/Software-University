package computers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ComputerManagerTest {

    private ComputerManager computerManager;
    private Computer computer;
    private Computer secondComputer;

    @Before
    public void setUp(){
        this.computerManager = new ComputerManager();

        computer = new Computer("HP", "Pavilion", 300.00);
        secondComputer = new Computer("Asus", "Pog", 500.00);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetComputers(){
        this.computerManager.getComputers().remove(0);
    }

    @Test
    public void testGetCount(){}


    @Test(expected = IllegalArgumentException.class)
    public void testNullAdd(){
        this.computerManager.addComputer(null);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testSecondAdd(){
        this.computerManager.addComputer(computer);
        this.computerManager.addComputer(computer);
    }

    @Test
    public void testAdd(){
        this.computerManager.addComputer(computer);
        Assert.assertEquals(1, this.computerManager.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullGet(){
        this.computerManager.getComputer("test", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullGet2(){
        this.computerManager.getComputer(null, "test");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetNonExistingParam(){
        this.computerManager.getComputer(computer.getManufacturer(), computer.getModel());
    }

    @Test
    public void testGetReturnsCorrect(){
        this.computerManager.addComputer(computer);
        this.computerManager.addComputer(secondComputer);

        Computer returned = this.computerManager.getComputer(computer.getManufacturer(), computer.getModel());
    Assert.assertNotNull(returned);
    assertEquals(computer.getManufacturer(), returned.getManufacturer());
    assertEquals(computer.getModel(), returned.getModel());
    }

    @Test
    public void testGetReturnsCorrectByMan(){
        this.computerManager.addComputer(computer);
        this.computerManager.addComputer(secondComputer);

        List<Computer> list = this.computerManager.getComputersByManufacturer(computer.getManufacturer());
        Assert.assertNotNull(list);
        assertEquals(list.get(0).getManufacturer(), computer.getManufacturer());
    }

    @Test
    public void testGetReturnsCorrectByManEmpty(){

        List<Computer> list = this.computerManager.getComputersByManufacturer(computer.getManufacturer());
        Assert.assertNotNull(list);
        assertTrue(list.isEmpty());
    }

}