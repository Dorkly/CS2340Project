package project.watersystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AppScreen extends AppCompatActivity {

    public Button logoutButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_screen);

        logoutButton = (Button) findViewById(R.id.Logout);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });
    }
}
