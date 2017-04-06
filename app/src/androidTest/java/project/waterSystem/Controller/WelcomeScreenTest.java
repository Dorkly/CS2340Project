package project.waterSystem.Controller;

import android.content.ComponentName;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import project.waterSystem.R;
import project.waterSystem.RegistrationScreen;

import static android.support.test.InstrumentationRegistry.getTargetContext;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.intent.matcher.IntentMatchers.toPackage;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by jimhelm on 4/5/17.
 */
public class WelcomeScreenTest {

    @Rule
    public IntentsTestRule<WelcomeScreen> mActivityRule = new IntentsTestRule<>(WelcomeScreen.class);

    @Test
    public void loginButtonTest() {

        //ViewInteraction loginButton2 = onView(withId(R.id.loginButton));
        onView(withId(R.id.loginButton)).perform(click());
        intended(hasComponent(new ComponentName(getTargetContext(), LoginActivity.class)));

    }

    @Test
    public void registrationButtonTest() {

        //ViewInteraction loginButton2 = onView(withId(R.id.loginButton));
        onView(withId(R.id.registrationButton)).perform(click());
        intended(hasComponent(new ComponentName(getTargetContext(), RegistrationScreen.class)));

    }

}
