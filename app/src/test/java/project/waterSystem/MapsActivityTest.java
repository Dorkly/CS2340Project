package project.waterSystem;

import org.junit.Before;
import org.junit.Test;

import project.waterSystem.Controller.LoginActivity;

/**
 * Created by AustinJ on 4/5/17.
 */

public class MapsActivityTest {
    private LoginActivity testLoginActivity;

    @Before
    public void setUp() {
        testLoginActivity = new LoginActivity();
    }

    @Test
    public void testAdd() {
        //assertEquals("Simple Add result incorrect",56, testLoginActivity.execute(16, 40, "+"));
    }

    @Test
    public void testAttemptLogin() {
        /*
        Database db = mock(Database.class);
        when(db.getStudentIDFor("Bob")).thenReturn("XY32F14");
        when(db.getStudentNameFor(1234)).thenReturn("Bob Waters");

        assertEquals("XY32F14", db.getStudentIDFor("Bob"));
        assertNull(db.getStudentIDFor("Sally"));

        assertEquals("Bob Waters", db.getStudentNameFor(1234));
        assertNull(db.getStudentNameFor(5463));
        */
    }



}
