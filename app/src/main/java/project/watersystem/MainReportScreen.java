package project.watersystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by AustinJ on 2/25/17.
 */

public class MainReportScreen extends AppCompatActivity {
    private Button cancelRepButton;
    private Button waterPurButton;
    private Button waterSouButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_report);

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

                Intent intent = new Intent(MainReportScreen.this, AppScreen.class);
                startActivity(intent);
                finish();
                //setContentView(R.layout.activity_login);
            }
        });


        //cancel button
        cancelRepButton = (Button) findViewById(R.id.toolbar);
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
