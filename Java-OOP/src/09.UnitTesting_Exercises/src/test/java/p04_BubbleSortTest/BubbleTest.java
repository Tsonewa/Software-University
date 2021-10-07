package p04_BubbleSortTest;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BubbleTest {

    @Test
    public void testMethodSortSortedTheArrayCorrectly(){

        int[] array = {1,59,4,87,0,-2};
        Bubble.sort(array);
        int[] sortedArray = {-2,0,1,4,59,87};

        Assert.assertArrayEquals(array, sortedArray);
    }
}