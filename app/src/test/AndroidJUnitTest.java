import org.junit.Test;
import java.util.regex.Pattern;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;



/**
 * Created by Bree~ on 4/4/2017.
 */
public class AndroidJUnitTest {
    private static final int TIMEOUT = Integer.MAX_VALUE;

    LoginActivity login = new LoginActivity;
    @Test(timeout = TIMEOUT)
    public void menuItemTest(){
        Assert.assertTrue(true,)
    }
    @Test
    public void emailValidator_CorrectEmailSimple_ReturnsTrue() {
        assertThat(EmailValidator.isValidEmail("name@email.com"), is(true));
    }
}


