package project.waterSystem;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * Created by hmgut_000 on 4/4/2017.
 */

public class TestProfileActivity {
    /**
     * The test fixture
     */
    private ProfileActivity profileActivity;
    /**
     * This method is run before each test
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
       profileActivity = new ProfileActivity();
    }

    @Test
    public void testFindPosition() {

        Assert.assertEquals("Reg. User", 0, profileActivity.findPosition("Regular User"));
        Assert.assertEquals("Worker", 1, profileActivity.findPosition("Worker"));
        Assert.assertEquals("Manage", 2, profileActivity.findPosition("Manager"));
        Assert.assertEquals("Admin", 3, profileActivity.findPosition("Admin"));
        Assert.assertEquals("Should be Regular User", 0, profileActivity.findPosition("User"));
//        Assert.assertEquals("Should be user not admin", 0, profileActivity.findPosition("Admin"));
//        Assert.assertEquals("Should be worker nut user", 1, profileActivity.findPosition("Regular User"));
//        Assert.assertEquals("Should be manager not worker", 2, profileActivity.findPosition("Worker"));
//        Assert.assertEquals("Should be admin not manager", 3, profileActivity.findPosition("Manager"));

    }
}
