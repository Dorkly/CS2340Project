package project.waterSystem.Controller;

import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import project.waterSystem.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.toPackage;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by jimhelm on 4/5/17.
 */
public class WelcomeScreenTest {

    @Rule
    public WelcomeScreenTestRule<WelcomeScreen> mainActivityActivityTestRule = new WelcomeScreenTestRule<WelcomeScreen>(WelcomeScreen.class);

    @Rule
    public IntentsTestRule<WelcomeScreen> mActivityRule = new IntentsTestRule<>(WelcomeScreen.class);
    @Rule
    public ActivityTestRule<WelcomeScreen> activityTestRule = new ActivityTestRule<WelcomeScreen>(WelcomeScreen.class);


    @Test
    public void triggerIntentTest() {

        //ViewInteraction loginButton2 = onView(withId(R.id.loginButton));
        onView(withId(R.id.loginButton)).perform(click());
        intended(toPackage("project.waterSystem.Controller.LoginActivity"));

    }



}
