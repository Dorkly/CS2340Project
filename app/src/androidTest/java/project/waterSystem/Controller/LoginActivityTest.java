package project.waterSystem.Controller;

import android.content.ComponentName;
import android.support.test.espresso.intent.rule.IntentsTestRule;

import org.junit.Rule;
import org.junit.Test;

import project.waterSystem.R;

import static android.support.test.InstrumentationRegistry.getTargetContext;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by Young on 2017-04-04.
 *
 * LoginActivityTest class used to test Login Activity
 */
public class LoginActivityTest {

    @Rule
    public IntentsTestRule<LoginActivity> mActivityRule = new IntentsTestRule<>(LoginActivity.class);

    @Test
    public void EmailSignInCancelButtonTest() {
        onView(withId(R.id.email_sign_in_cancel_button)).perform(click());
        intended(hasComponent(new ComponentName(getTargetContext(), WelcomeScreen.class)));
    }

}