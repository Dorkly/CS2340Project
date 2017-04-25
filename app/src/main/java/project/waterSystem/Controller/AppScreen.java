package project.waterSystem.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.Date;

import project.waterSystem.DatabaseHandler;
import project.waterSystem.Model.LoggingNavigation;
import project.waterSystem.ProfileActivity;
import project.waterSystem.R;


/**
 * Main application screen after login.
 */
@SuppressWarnings("ALL")
public class AppScreen extends AppCompatActivity {
    private DatabaseHandler db;
    private final String screen = "Main App Screen";
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_screen);

        db = new DatabaseHandler(this);
        String userType = db.getUserType();

        Button logoutButton = (Button) findViewById(R.id.returnButton);
        Button createProfileButton = (Button) findViewById(R.id.createProfile);
        Button reportButton = (Button) findViewById(R.id.reportsButton);
        Button settingsButton = (Button) findViewById(R.id.settingsButton);

        settingsButton.setVisibility(View.INVISIBLE);

        if ((userType.toLowerCase().equals("admin")) ) {
            settingsButton.setVisibility(View.VISIBLE);
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        logoutButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(AppScreen.this, WelcomeScreen.class);
                db.actionLogging(new LoggingNavigation(db.getCurrentUser(), new Date(), screen , "Logout Button", "Logout of Drip-Drop Application"));
                startActivity(intent);
                finish();

                //setContentView(R.layout.activity_welcome_screen);
            }
        });


        createProfileButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click

                Intent intent = new Intent(AppScreen.this, ProfileActivity.class);
                //intent.putExtra("AddNew", "new");
                db.actionLogging(new LoggingNavigation(db.getCurrentUser(), new Date(), screen , "Profile Button", "Create/Change Profile"));
                startActivity(intent);
                finish();
                //setContentView(R.layout.activity_login);
            }
        });


        reportButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click

                Intent intent = new Intent(AppScreen.this, MainReportScreen.class);
                db.actionLogging(new LoggingNavigation(db.getCurrentUser(), new Date(), screen , "Reports Button", "Navigate to Main Reports Screen"));
                startActivity(intent);
                finish();
                //setContentView(R.layout.activity_login);
            }
        });
        settingsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click

                Intent intent = new Intent(AppScreen.this, LoggingReportsScreen.class);
                db.actionLogging(new LoggingNavigation(db.getCurrentUser(), new Date(), screen , "Admin Button", "Navigate to Admin Reports"));
                startActivity(intent);
                finish();
                //setContentView(R.layout.activity_login);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.miCompose:
                Intent intent = new Intent(this, MainReportScreen.class);
                db.actionLogging(new LoggingNavigation(db.getCurrentUser(), new Date(), screen , "Reports Menu Item", "Navigate to Main Reports Screen"));
                this.startActivity(intent);
                return true;
            case R.id.miProfile:
                Intent intent2 = new Intent(this,ProfileActivity.class);
                db.actionLogging(new LoggingNavigation(db.getCurrentUser(), new Date(), screen , "Profile Menu Item", "Create/Change Profile"));
                this.startActivity(intent2);
                return true;
            case R.id.returnButton:
                Intent intent3 = new Intent(this,WelcomeScreen.class);
                db.actionLogging(new LoggingNavigation(db.getCurrentUser(), new Date(), screen , "Logout Menu Item", "Logout of Drip-Drop Application"));
                this.startActivity(intent3);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(AppScreen.this, WelcomeScreen.class);
        db.actionLogging(new LoggingNavigation(db.getCurrentUser(), new Date(), screen , "Back Button", "Phone Back Button Pressed - Go to Welcome Screen"));
        startActivity(intent);
        finish();
    }
}