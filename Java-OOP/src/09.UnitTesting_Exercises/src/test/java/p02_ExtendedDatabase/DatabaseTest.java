package p02_ExtendedDatabase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {

    public static final Person[] PEOPLE = {new Person(2, "Pesho"),  new Person(3, "Mike"),new Person(4, "Harvey") };
    private Database database;

@Before
public void createDatabase() throws OperationNotSupportedException {
    this.database = new Database(PEOPLE);
}

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorLengthCanNotBeMoreThanSixteen() throws OperationNotSupportedException {
        Person[] array = new Person[17];
        new Database(array);
    }

    @Test
    public void testIsConstructorInstancedCorrectly() throws OperationNotSupportedException {
        Person[] checkArray = database.getElements();

        Assert.assertEquals(3, database.getElements().length);
        for (int i = 0; i < database.getElements().length; i++) {
            Assert.assertEquals(database.getElements()[i], checkArray[i]);
        }}

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorLengthCanNotBeLessThanOne() throws OperationNotSupportedException {
        Person[] array = new Person[0];
        new Database(array);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddMethodCanNotReceiveNullElement() throws OperationNotSupportedException {

        database.add(null);
    }

    @Test
    public void testSuccessfullyAddElementToDatabase() throws OperationNotSupportedException {
        Person p = new Person(5, "Fifth");
        database.add(p);
        Person[] secondArray = database.getElements();

        Assert.assertEquals(4, database.getElements().length);
        for (int i = 0; i < database.getElements().length; i++) {
            Assert.assertEquals(database.getElements()[i], secondArray[i]);
        }
    }
    @Test
    public void testRemoveLastElement() throws OperationNotSupportedException {

        database.remove();
        Person[] elementsInDatabase = database.getElements();
        Assert.assertEquals(database.getElements().length, elementsInDatabase.length);

    }
    @Test(expected = OperationNotSupportedException.class)
    public void testValidateArrayForRemoveMethod() throws OperationNotSupportedException {
       Database database = new Database();
        database.remove();
    }

    @Test
    public void testSuccessfullyRemoveElementFromDatabase() throws OperationNotSupportedException {
        Database database = new Database(PEOPLE);
        database.remove();

        Assert.assertEquals(2, database.getElements().length);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddNoneExistingPerson() throws OperationNotSupportedException {

       Database database = new Database();
        database.add(null);
   }

   @Test
    public void testFindByUsernameReturnTheCorrectPerson() throws OperationNotSupportedException {
    Person returnedPerson = database.findByUsername("Mike");

    Assert.assertEquals("Mike", returnedPerson.getUsername());
    Assert.assertEquals(3, returnedPerson.getId());
   }

   @Test(expected = OperationNotSupportedException.class)
   public void testFindByUsernameThrowExForNullUsername() throws OperationNotSupportedException {
    database.findByUsername(null);
   }

   @Test(expected = OperationNotSupportedException.class)
   public void testFindByUsernameForEmptyDatabase() throws OperationNotSupportedException {
    Database database = new Database();
    database.findByUsername("First");
   }

   @Test(expected = OperationNotSupportedException.class)
   public void testFindByUsernameWithEqualUsernames() throws OperationNotSupportedException {
    Database database = new Database(null, null);
    database.findByUsername("First");
   }

   @Test
    public void testFindByIdReturnTheCorrectPerson() throws OperationNotSupportedException {
    Person returnedPerson = database.findById(4);

    Assert.assertEquals(4, returnedPerson.getId());
    Assert.assertEquals("Harvey", returnedPerson.getUsername());
   }

   @Test(expected = OperationNotSupportedException.class)
    public void testFindByIdForUnExistingIndex() throws OperationNotSupportedException {

    database.findById(5);
   }

   @Test(expected = OperationNotSupportedException.class)
    public void testFindByIdForEmptyDatabase() throws OperationNotSupportedException {
    Database database = new Database();

    database.findById(2);
   }
}