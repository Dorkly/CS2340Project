package project.waterSystem.Controller;

import android.app.Activity;
import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.util.Log;


/**
 * Created by Jim Helm on 4/5/17.
 */

public class WelcomeScreenTestRule<A extends Activity> extends ActivityTestRule<A> {
    public WelcomeScreenTestRule(Class<A> activityClass) {
        super(activityClass);
    }

    @Override
    protected Intent getActivityIntent() {
        Log.e("WelcomeScreenTestRule", "Prepare the activity's intent");
        return super.getActivityIntent();
    }

    @Override
    protected void beforeActivityLaunched() {
        Log.e("WelcomeScreenTestRule", "Execute before the activity is launched");
        super.beforeActivityLaunched();
    }

    @Override
    protected void afterActivityLaunched() {
        Log.e("WelcomeScreenTestRule", "Execute after the activity has been launched");
        super.afterActivityLaunched();
    }

    @Override
    protected void afterActivityFinished() {
        Log.e("WelcomeScreenTestRule", "Cleanup after it has finished");
        super.afterActivityFinished();
    }

    @Override
    public A launchActivity(Intent startIntent) {
        Log.e("WelcomeScreenTestRule", "Launching the activity");
        return super.launchActivity(startIntent);
    }


}
