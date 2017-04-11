package project.waterSystem;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import project.waterSystem.Model.Users;

public class AndroidJUnitTest {

    private static final int TIMEOUT = 10000;
    private Users user1;
    private Users user2;
    private Users user3;
    private Users user4;

    @Before
    public void setUp() {
        user1 = new Users("Test", "happy", "Yay", "what@thewhat.com",
                "Worker");
        user2 = new Users("Test", "happy", "Yay", "what@thewhat.com",
                "Manager");
        user3 = new Users("Test", "happy", "Yay", "what@thewhat.com",
                "User");
        user4 = new Users("Test", "happy", "Yay", "what@thewhat.com",
                "Tester");
        String success = user1.toString();

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
    @Test(timeout = TIMEOUT)
    public void SuccessDefault(){
        Assert.assertEquals("Hi",user4.toString());
    }

}


