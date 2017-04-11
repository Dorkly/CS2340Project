package project.waterSystem.Controller;

import android.content.ComponentName;
import android.support.test.espresso.intent.rule.IntentsTestRule;

import org.junit.Rule;
import org.junit.Test;

import project.waterSystem.R;
import project.waterSystem.RegistrationScreen;

import static android.support.test.InstrumentationRegistry.getTargetContext;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;

/**
 * Created by AustinJ on 4/5/17.
 */

public class isPasswordValidTest {

    @Rule
    public IntentsTestRule<RegistrationScreen> mActivityRule = new IntentsTestRule<>(RegistrationScreen.class);

    @Test
    public void isPasswordValidTest1() {
        onView(withId(R.id.nameInput)).perform(typeText("123456"), closeSoftKeyboard());
        onView(withId(R.id.editText2)).perform(typeText("123456"), closeSoftKeyboard());
        onView(withId(R.id.emailInput)).perform(typeText("1234567"), closeSoftKeyboard());
        onView(withId(R.id.passwordInput)).perform(typeText(""), closeSoftKeyboard());

        //ViewInteraction loginButton2 = onView(withId(R.id.loginButton));
        onView(withId(R.id.save)).perform(click());
        onView(withText("Password should more than 4 character"))
                .inRoot(withDecorView(
                        not(is(mActivityRule.getActivity().
                                getWindow().getDecorView())))).
                check(matches(isDisplayed()));
    }

    @Test
    public void isPasswordValidTest2() {
        onView(withId(R.id.nameInput)).perform(typeText("123456"), closeSoftKeyboard());
        onView(withId(R.id.editText2)).perform(typeText("123456"), closeSoftKeyboard());
        onView(withId(R.id.emailInput)).perform(typeText("1234567"), closeSoftKeyboard());
        onView(withId(R.id.passwordInput)).perform(typeText("123"), closeSoftKeyboard());

        //ViewInteraction loginButton2 = onView(withId(R.id.loginButton));
        onView(withId(R.id.save)).perform(click());
        onView(withText("Password should more than 4 character"))
                .inRoot(withDecorView(
                        not(is(mActivityRule.getActivity().
                                getWindow().getDecorView())))).
                check(matches(isDisplayed()));
    }

    @Test
    public void isPasswordValidTest3() {
        onView(withId(R.id.nameInput)).perform(typeText("1234567"), closeSoftKeyboard());
        onView(withId(R.id.editText2)).perform(typeText("1234567"), closeSoftKeyboard());
        onView(withId(R.id.emailInput)).perform(typeText("1234567"), closeSoftKeyboard());
        onView(withId(R.id.passwordInput)).perform(typeText("1234"), closeSoftKeyboard());

        //ViewInteraction loginButton2 = onView(withId(R.id.loginButton));
        onView(withId(R.id.save)).perform(click());
        intended(hasComponent(new ComponentName(getTargetContext(), LoginActivity.class)));
    }

}
