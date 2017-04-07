package project.waterSystem;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import project.waterSystem.Controller.LoginActivity;
import project.waterSystem.Model.Users;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;



/**
 * Created by Bree~ on 4/4/2017.
 */
public class AndroidJUnitTest {

    private static final int TIMEOUT = 10000;
    private Users user1;
    private Users user2;
    private Users user3;
    private String success;
    private String type;

    @Before
    public void setUp() {
        user1 = new Users("Test", "happy", "Yaay", "what@thewhat.com",
                "Worker");
        user2 = new Users("Test", "happy", "Yaay", "what@thewhat.com",
                "Manager");
        user3 = new Users("Test", "happy", "Yaay", "what@thewhat.com",
                "User");
        success = user1.toString();

    }

    @Test(timeout = TIMEOUT)
    public void SuccessWorker(){
        Assert.assertEquals("Hello Employee , let's get to work!",user1.toString());
    }
    @Test(timeout = TIMEOUT)
    public void SuccessManager(){
        Assert.assertEquals("Hello All Powerful Ruler , let's create!",user2.toString());
    }
    @Test(timeout = TIMEOUT)
    public void SuccessUser(){
        Assert.assertEquals("Hello User, let's explore!",user3.toString());
    }

}


