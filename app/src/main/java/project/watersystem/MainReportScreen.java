package project.watersystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

/**
 * Created by AustinJ on 2/25/17.
 */

public class MainReportScreen extends AppCompatActivity {
    private Button cancelRepButton;
    private Button waterPurButton;
    private Button waterSouButton;
    private DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_report);

        db = new DatabaseHandler(this);
        String userType = db.getUserType();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Water Purity
        waterPurButton = (Button) findViewById(R.id.waterPurity);
        waterPurButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click

                Intent intent = new Intent(MainReportScreen.this, PurityReport.class);
                startActivity(intent);
                finish();
                //setContentView(R.layout.activity_login);
            }
        });

        // Water Source
        waterSouButton = (Button) findViewById(R.id.waterSource);
        waterSouButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click

                Intent intent = new Intent(MainReportScreen.this, SourceReport.class);
                startActivity(intent);
                finish();
                //setContentView(R.layout.activity_login);
            }
        });

        if (userType.toLowerCase().equals("worker")) {
            waterPurButton.setVisibility(View.VISIBLE);
        } else {
            waterPurButton.setVisibility(View.INVISIBLE);
        }

        if (userType.toLowerCase().equals("regular user")) {
            waterSouButton.setVisibility(View.VISIBLE);
        } else {
            waterSouButton.setVisibility(View.INVISIBLE);
        }
        //cancel button
        cancelRepButton = (Button) findViewById(R.id.Logout);
        cancelRepButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click

                Intent intent = new Intent(MainReportScreen.this, AppScreen.class);
                startActivity(intent);
                finish();
                //setContentView(R.layout.activity_login);
            }
        });
    }
}
