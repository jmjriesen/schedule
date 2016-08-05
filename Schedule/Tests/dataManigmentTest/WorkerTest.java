package dataManigmentTest;

import dataManigment.Worker;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

/**
 * Created by Nicholas on 7/26/16.
 */
public class WorkerTest {

    Worker testWorker;

    @Before
    public void setup(){
        testWorker = new Worker("@","Lifeguard");
    }


    // ------------------------- Tests for Request off functionality -------------------------
    @Test
    public void requestOff_valid() {
        testWorker.requestOff(4);
        testWorker.requestOff(18);

        assertTrue(testWorker.getRequestedOff().contains(4));
        assertTrue(testWorker.getRequestedOff().contains(18));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void requestOff_negative_date(){
        testWorker.requestOff(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void requestOff_date_larger_than_31(){
        testWorker.requestOff(35);
    }

    @Test
    public void requestOff_array_valid() {
        testWorker.requestOff(new int[]{3, 8, 13, 9, 2});

        assertTrue(testWorker.getRequestedOff().contains(3));
        assertTrue(testWorker.getRequestedOff().contains(8));
        assertTrue(testWorker.getRequestedOff().contains(13));
        assertTrue(testWorker.getRequestedOff().contains(9));
        assertTrue(testWorker.getRequestedOff().contains(2));
    }

    @Test
    public void requestOff_empty() {
        assertNotNull(testWorker.getRequestedOff());
        assertTrue(testWorker.getRequestedOff().isEmpty());
    }

    @Test
    public void requestOff_request_a_day_off_already_requested_as_of(){
        testWorker.requestOff(5);
        testWorker.requestOff(5);

        assertEquals(1, testWorker.getRequestedOff().size());
    }


    // ------------------------- Tests for assigning work -------------------------
    @Test
    public void willWork_valid() {
        testWorker.willWork(5);
        testWorker.willWork(19);

        assertTrue(testWorker.getDaysWorking().contains(5));
        assertTrue(testWorker.getDaysWorking().contains(19));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void willWork_negative_date(){
        testWorker.willWork(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void willWork_date_larger_than_31(){
        testWorker.willWork(35);
    }

    @Test
    public void willWork_empty(){
        assertNotNull(testWorker.getDaysWorking());
        assertTrue(testWorker.getDaysWorking().isEmpty());
    }

    @Test
    public void willWork_assign_to_work_date_already_assigned(){
        testWorker.willWork(5);
        testWorker.willWork(5);

        assertEquals(1, testWorker.getDaysWorking().size());
    }

    // ------------------------- Tests for can work -------------------------
    @Test
    public void canWork() {
        testWorker.requestOff(new int[]{3, 8, 13, 9, 2});
        testWorker.willWork(7);
        testWorker.willWork(20);

        assertTrue(testWorker.canWork(6));
        assertTrue(testWorker.canWork(15));

        assertFalse(testWorker.canWork(3));
        assertFalse(testWorker.canWork(13));
        assertFalse(testWorker.canWork(7));
        assertFalse(testWorker.canWork(20));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void canWork_negative_date(){
        testWorker.canWork(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void canWork_date_larger_than_31(){
        testWorker.canWork(35);
    }



    // ------------------------- Tests for symbol -------------------------
    @Test
    public void symbol_valid() {
        assertEquals("@", testWorker.getSymbol());
    }

    @Test
    public void symbol_multiple_chars() {
        Worker test = new Worker("Symbol of multiple chars!!");
        assertEquals("Symbol of multiple chars!!", test.getSymbol());
    }

    @Test(expected = java.lang.Exception.class)
    public void symbol_emptyString(){
        Worker test = new Worker("");
    }

    @Test(expected = NullPointerException.class)
    public void symbol_null(){
        Worker test = new Worker(null);
    }


    @Test
    public void compareTo() {

    }

    @Test
    public void clearDaysOff() {

    }

}