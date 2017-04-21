package project.waterSystem.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import project.waterSystem.R;
import project.waterSystem.RegistrationScreen;

/**
 * WelcomeScreen class used to allow user to login or register.
 */
@SuppressWarnings("ALL")
public class WelcomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        // Configure Login Button
        Button loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                loginClicked();
            }
        });

        // Configure Registration Button
        Button regButton = (Button) findViewById(R.id.registrationButton);
        regButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                registrationClicked();
            }
        });

    }

    private void loginClicked() {
        Intent intent = new Intent(WelcomeScreen.this, LoginActivity.class);
        startActivity(intent);
    }

    private void registrationClicked() {
        Intent intent2 = new Intent(WelcomeScreen.this, RegistrationScreen.class);
        startActivity(intent2);
    }
}