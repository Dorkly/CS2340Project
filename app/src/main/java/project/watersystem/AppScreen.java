package project.watersystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
    public Button reportButton;
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.miCompose:
                Intent intent = new Intent(this, MainReportScreen.class);
                this.startActivity(intent);
                return true;
            case R.id.miProfile:
                Intent intent2 = new Intent(this,ProfileActivity.class);
                this.startActivity(intent2);
                return true;
            case R.id.Logout:
                Intent intent3 = new Intent(this,WelcomeScreen.class);
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
}
