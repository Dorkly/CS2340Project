package project.waterSystem.Controller;

import android.support.test.espresso.intent.rule.IntentsTestRule;

import org.junit.Rule;
import org.junit.Test;

import project.waterSystem.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;

/**
 * Created by AustinJ on 4/23/17.
 */

public class isEmailRecoveryValidTest {

    @Rule
    public final IntentsTestRule<emailRecoveryActivity> mActivityRule = new IntentsTestRule<>(emailRecoveryActivity.class);

    @Test
    public void isEmailRecoveryValidTest1() {
        onView(withId(R.id.editText2)).perform(typeText("jiang2023"), closeSoftKeyboard());
        onView(withId(R.id.emailInput)).perform(typeText("jiang2023@gmail.com"), closeSoftKeyboard());

        //ViewInteraction loginButton2 = onView(withId(R.id.loginButton));
        onView(withId(R.id.save)).perform(click());
        onView(withText("Email was sent, please check your email"))
                .inRoot(withDecorView(
                        not(is(mActivityRule.getActivity().
                                getWindow().getDecorView())))).
                check(matches(isDisplayed()));
    }
}
