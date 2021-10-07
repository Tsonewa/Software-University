package p03_IteratorTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ListIteratorTest {

    private ListIterator listIterator;
    private static final String[] data = {"x","y","z"};
    private static final int CURRENT_INDEX = 2;

    @Before
    public void setUp() throws OperationNotSupportedException {
        this.listIterator = new ListIterator(data);
    }


@Test(expected = OperationNotSupportedException.class)
public void testInvalidConstructorParameter() throws OperationNotSupportedException {
    new ListIterator(null);
}

@Test
    public void testHasNextMethodReturnCorrectBoolean(){
    Assert.assertTrue(listIterator.hasNext());
    listIterator.move();
    Assert.assertEquals("y", listIterator.print());
}

    @Test
    public void testHasNextMethodReturnFalseIfThereIsNoNextElement(){
        Assert.assertTrue(listIterator.hasNext());
        listIterator.move();
        Assert.assertTrue(listIterator.hasNext());
        listIterator.move();

       Assert.assertFalse(listIterator.hasNext());
    }

    @Test
    public void testMethodMoveHasNextAvailableIndexToMoveTo(){
        listIterator.hasNext();

        Assert.assertTrue(listIterator.move());
    }

    @Test
    public void testMethodMoveDoestHaveNextAvailableIndexToMoveTo(){
        listIterator.hasNext();
        listIterator.move();
        listIterator.hasNext();
        listIterator.move();
        listIterator.hasNext();

        Assert.assertFalse(listIterator.move());
    }

    @Test(expected = IllegalStateException.class)
    public void testPrintMethodWithEmptyStringArray() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator();
        listIterator.print();
    }

@Test
    public void testPrintWithValidStringArray(){
        Assert.assertEquals("x", this.listIterator.print());
        this.listIterator.move();
        Assert.assertEquals("y", this.listIterator.print());
        this.listIterator.move();
        Assert.assertEquals("z", this.listIterator.print());
}
}