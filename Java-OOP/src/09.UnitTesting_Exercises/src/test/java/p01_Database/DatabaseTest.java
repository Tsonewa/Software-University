package p01_Database;

import org.junit.Assert;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {

@Test(expected = OperationNotSupportedException.class)
public void testConstructorLengthCanNotBeMoreThanSixteen() throws OperationNotSupportedException {
    Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17};
   new Database(array);
}

@Test
public void testIsConstructorInstancedCorrectly() throws OperationNotSupportedException {
    Integer[] array = {1,2,3,4};
    Database database = new Database(array);
    Integer[] checkArray = database.getElements();

    Assert.assertEquals(4, database.getElements().length);
    for (int i = 0; i < database.getElements().length; i++) {
Assert.assertEquals(database.getElements()[i], checkArray[i]);
    }}

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorLengthCanNotBeLrssThanOne() throws OperationNotSupportedException {
        Integer[] array = new Integer[0];
        new Database(array);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddMethodCanNotReceiveNullElement() throws OperationNotSupportedException {
        Integer[] array = {1,2,3,4};
        Database database = new Database(array);
        Integer element = null;

        database.add(element);
    }

    @Test
    public void testSuccessfullyAddElementToDatabase() throws OperationNotSupportedException {
    Integer[] array = {1,2,3};
    Database database = new Database(array);
    Integer digit = 4;
    database.add(digit);
    Integer[] secondArray = database.getElements();

    Assert.assertEquals(4, database.getElements().length);
        for (int i = 0; i < database.getElements().length; i++) {
            Assert.assertEquals(database.getElements()[i], secondArray[i]);
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testValidateArrayForRemoveMethod() throws OperationNotSupportedException {
        Database database = new Database();

        database.remove();
    }

    @Test
    public void testSuccessfullyRemoveElementFromDatabase() throws OperationNotSupportedException {
        Integer[] array = {1,2,3};
        Database database = new Database(array);
        database.remove();

        Assert.assertEquals(2, database.getElements().length);
            Assert.assertEquals(2, database.getElements().length);
    }

    
}