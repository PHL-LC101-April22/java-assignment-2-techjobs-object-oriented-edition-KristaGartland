package org.launchcode.techjobs.oo.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {


    @Test
    public void testSettingJobId() {
      Job testJob1 = new Job();
      Job testJob2 = new Job();

        assertNotEquals(testJob1, testJob2);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job theTester = new Job("Product tester", new Employer("ACME"),new Location("Desert"),new PositionType("Quality control"),new CoreCompetency("Persistence"));
        assertTrue(theTester.getEmployer() != null);
        assertEquals(theTester.getEmployer().getValue(), "ACME" );
        assertTrue(theTester.getName() != null);
        assertEquals(theTester.getName(), "Product tester");
        assertTrue(theTester.getLocation() != null);
        assertEquals(theTester.getLocation().getValue(), "Desert");
        assertTrue(theTester.getPositionType() != null);
        assertEquals(theTester.getPositionType().getValue(), "Quality control");
        assertTrue(theTester.getCoreCompetency() != null);
        assertEquals(theTester.getCoreCompetency().getValue(), "Persistence");
    }

    @Test
    public void testJobsForEquality() {
        Job Bob = new Job("Bob", new Employer("Bob"),new Location("Bob"),new PositionType("Bob"),new CoreCompetency("Bob"));
        Job bob = new Job("Bob", new Employer("Bob"),new Location("Bob"),new PositionType("Bob"),new CoreCompetency("Bob"));

        assertFalse(Bob.equals(bob));

    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job Bob = new Job("Bob", new Employer("Bob"),new Location("Bob"),new PositionType("Bob"),new CoreCompetency("Bob"));
        assertEquals(Bob.toString().charAt(0), '\n');
        assertEquals(Bob.toString().charAt(Bob.toString().length() - 1), '\n');

    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job Bob = new Job("Bob", new Employer("Bob"),new Location("Bob"),new PositionType("Bob"),new CoreCompetency("Bob"));
        assertTrue(Bob.toString().contains("Bob"));
        assertEquals(Bob.toString(), Bob.toString());

    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job Bob = new Job("Bob",new Employer(""), new Location(""), new PositionType("Bob"), new CoreCompetency(""));
        assertTrue(Bob.toString().contains("Data not available"));
        assertEquals(Bob.toString(), Bob.toString());
    }
}
