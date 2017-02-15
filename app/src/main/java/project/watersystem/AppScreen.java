package project.watersystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AppScreen extends AppCompatActivity {

    public Button logoutButton;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_screen);

        logoutButton = (Button) findViewById(R.id.Logout);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(AppScreen.this, WelcomeScreen.class);
                startActivity(intent);
                finish();

                //setContentView(R.layout.activity_welcome_screen);
            }
        });
    }

}
