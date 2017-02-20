package project.watersystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

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

        loginButton = (Button) findViewById(R.id.button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click

                Intent intent = new Intent(WelcomeScreen.this, LoginActivity.class);
                startActivity(intent);
                finish();
                //setContentView(R.layout.activity_login);
            }
        });

        regButton = (Button) findViewById(R.id.button2);
        regButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click

                Intent intent2 = new Intent(WelcomeScreen.this, RegistrationScreen.class);
                startActivity(intent2);
                finish();

                //setContentView(R.layout.activity_login);
            }
        });
    }
}