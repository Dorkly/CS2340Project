package project.waterSystem.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import project.waterSystem.R;
import project.waterSystem.RegistrationScreen;

/**
 * Welcome screen that allows user to login or register.
 */
public class WelcomeScreen extends AppCompatActivity {

    //public LinearLayout AppScreen;
    //public LinearLayout LoginScreen;
    public Button loginButton;
    public Button regButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                loginClicked(v);
                //setContentView(R.layout.activity_login);
            }
        });

        regButton = (Button) findViewById(R.id.registrationButton);
        regButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                registrationClicked(v);
                //setContentView(R.layout.activity_login);
            }
        });

    }

    public void loginClicked(View v) {
        Intent intent = new Intent(WelcomeScreen.this, LoginActivity.class);
        startActivity(intent);
        //finish();
    }

    public void registrationClicked(View v) {
        Intent intent2 = new Intent(WelcomeScreen.this, RegistrationScreen.class);
        startActivity(intent2);
        //finish();

    }
}