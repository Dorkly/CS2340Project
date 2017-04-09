package project.waterSystem;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import project.waterSystem.Controller.LoginActivity;
import project.waterSystem.Model.Users;

/**
 * Created by AustinJ on 4/5/17.
 */

public class MapsActivityTest {
    private LoginActivity testLoginActivity;
    private static final int TIMEOUT = 10000;
    private Users user1;
    private Users user2;
    private Users user3;

    @Before
    public void setUp() {
        testLoginActivity = new LoginActivity();
        user1 = new Users("User", "000", "Yaay", "what@gmail.com",
                "Worker");
        user2 = new Users("User", "0000", "Yaay", "what@gmail.com",
                "Worker");
        user3 = new Users("User", "00000", "Yaay", "what@gmail.com",
                "Worker");
    }

    @Test
    public void testIsPasswordValid() {
        Assert.assertEquals("000",user1.getPassword());
        Assert.assertEquals("0000",user2.getPassword());
        Assert.assertEquals("00000",user3.getPassword());
    }
}
