package project.watersystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProfileActivity extends AppCompatActivity {
    public Button cancelProfileButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        cancelProfileButton = (Button) findViewById(R.id.cancelProfile);
        cancelProfileButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click

                Intent intent = new Intent(ProfileActivity.this, AppScreen.class);
                startActivity(intent);
                finish();
                //setContentView(R.layout.activity_login);
            }
        });
    }
}
