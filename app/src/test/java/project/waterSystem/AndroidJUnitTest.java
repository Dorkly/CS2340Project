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
    private Users users;
    private String success;
    private String type;
    @Before
    public void setUp() {
        users = new Users();
        type = users.getType();
        success = users.toString();

    }


    @Test(timeout = TIMEOUT)
    public void SuccessWorker(){
        type = "Worker";
        Assert.assertEquals("Hello Employee , let's get to work!",success);
    }
    @Test(timeout = TIMEOUT)
    public void SuccessFalse(){

    }

}


