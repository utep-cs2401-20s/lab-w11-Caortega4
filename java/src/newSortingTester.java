import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class newSortingTester {

    @Test
    /*Test for regular performance where the array should be Divided by the exact half only once to be sorted
    * input array = {5,4,6,2,3,1,7,8}
    * expected output array = {1,2,3,4,5,6,7,8}*/
    //Test passed
    public void newSortingTest1(){
        newSorting Test = new newSorting();
        int[] test = {5,4,6,2,3,1,7,8};
        int[] expected = {1,2,3,4,5,6,7,8};
        Test.newSorting(test, 4);
        assertArrayEquals(expected, test);

    }


    @Test
    /*Test with negative numbers to see if the method can handle them correctly
     * input array = {-5,-1,-10,5,1,2}
     * expected output array = {-10,-5,-1,1,2,5} */
    //Test passed
    public void newSortingTest2(){
        newSorting Test = new newSorting();
        int[] test = {-5,-1,-10,5,1,2};
        int[] expected = {-10,-5,-1,1,2,5};
        Test.newSorting(test,2);
        assertArrayEquals(expected, test);

    }

    @Test
    /*Test edge case where the array size is one and the method asks to divide the array in arrays of size 5
    * input array = {0}
    * expected output array = {0} */
    //Test passed
    public void newSortingTest3(){
        newSorting Test = new newSorting();
        int[] test = {0};
        int[] expected = {0};
        Test.newSorting(test,5);
        assertArrayEquals(expected, test);

    }

    @Test
    /*Test or an edge case when the array is completely empty
     * input array = {}
     * expected output array = {} */
    //Test passed
    public void newSortingTest4(){
        newSorting Test = new newSorting();
        int[] test = {};
        int[] expected = {};
        Test.newSorting(test,2);
        assertArrayEquals(expected, test);

    }

    @Test
    /*Test with repeated numbers to see if the method can handle it correctly
     * input array = {1,2,4,5,6,7,8,1,2,4,5,6,7,8,1,7}
     * expected output array = {1,1,1,2,2,4,4,5,5,6,6,7,7,7,8,8}*/
    //Test passed
    public void newSortingTest5(){
        newSorting Test = new newSorting();
        int[] test = {1,2,4,5,6,7,8,1,2,4,5,6,7,8,1,7};
        int[] expected = {1,1,1,2,2,4,4,5,5,6,6,7,7,7,8,8};
        Test.newSorting(test,2);
        assertArrayEquals(expected, test);

    }
}
