import org.junit.Before;
import org.junit.Test;

import project.waterSystem.Controller.LoginActivity;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;



/**
 * Created by Bree~ on 4/4/2017.
 */
public class AndroidJUnitTest {

    private static final int TIMEOUT = 10000;
    private LoginActivity login;
    private boolean success;

    @Before
    public void setUp() {
        login = new LoginActivity();
        success = true;
    }


    @Test(timeout = TIMEOUT)
    public void SuccessTrue(){

    }
    @Test(timeout = TIMEOUT)
    public void SuccessFalse(){

    }

}


