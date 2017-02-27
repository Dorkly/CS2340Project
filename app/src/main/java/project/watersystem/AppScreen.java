package project.watersystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

/**
 * Main application screen after login.
 */
public class AppScreen extends AppCompatActivity {

    public Button logoutButton;
    public Button createProfileButton;
    public Button editProfileButton;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_screen);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        logoutButton = (Button) findViewById(R.id.Logout);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(AppScreen.this, WelcomeScreen.class);
                startActivity(intent);
                finish();

                //setContentView(R.layout.activity_welcome_screen);
            }
        });

        createProfileButton = (Button) findViewById(R.id.createProfile);
        createProfileButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click

                Intent intent = new Intent(AppScreen.this, ProfileActivity.class);
                //intent.putExtra("AddNew", "new");
                startActivity(intent);
                finish();
                //setContentView(R.layout.activity_login);
            }
        });

        editProfileButton = (Button) findViewById(R.id.editprofile);
        editProfileButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click

                Intent intent = new Intent(AppScreen.this, ProfileActivity.class);
                //intent.putExtra("AddNew", "edit");
                startActivity(intent);
                finish();
                //setContentView(R.layout.activity_login);
            }
        });
    }
    public void report(){
        Intent intent = new Intent(AppScreen.this, Splash.class);
        startActivity(intent);
        finish();
    }
    public void profile(){
        Intent intent = new Intent(AppScreen.this, ProfileActivity.class);
        intent.putExtra("AddNew", "edit");
        startActivity(intent);
        finish();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.miCompose:
                report();
                return true;
            case R.id.miProfile:
                profile();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
