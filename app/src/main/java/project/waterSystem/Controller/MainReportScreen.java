package project.waterSystem.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import project.waterSystem.DatabaseHandler;
import project.waterSystem.PurityReport;
import project.waterSystem.PurityReportsListActivity;
import project.waterSystem.R;
import project.waterSystem.SourceReport;
import project.waterSystem.SourceReportsListActivity;

/**
 * Created by AustinJ on 2/25/17.
 */

public class MainReportScreen extends AppCompatActivity {
    private Button cancelRepButton;
    private Button waterAvaButton;
    private Button waterPurButton;
    private Button waterSouButton;
    private Button listPurButton;
    private Button listSouButton;
    private DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_report);

        db = new DatabaseHandler(this);
        String userType = db.getUserType();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        listPurButton = (Button) findViewById(R.id.listPurityReports);
        listSouButton = (Button) findViewById(R.id.listSourceReports);
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

        // Water Availability
        waterAvaButton = (Button) findViewById(R.id.waterAvailability);
        waterAvaButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click

                Intent intent = new Intent(MainReportScreen.this, MapsActivity.class);
                startActivity(intent);
                finish();
                //setContentView(R.layout.activity_login);
            }
        });

        if ((userType.toLowerCase().equals("regular user")) ) {
            waterPurButton.setVisibility(View.INVISIBLE);
            listPurButton.setVisibility(View.INVISIBLE);
        } else {
            waterPurButton.setVisibility(View.VISIBLE);
            listPurButton.setVisibility(View.VISIBLE);
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


        listPurButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click

                Intent intent = new Intent(MainReportScreen.this, PurityReportsListActivity.class);
                startActivity(intent);
                finish();
                //setContentView(R.layout.activity_login);
            }
        });

        listSouButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click

                Intent intent = new Intent(MainReportScreen.this, SourceReportsListActivity.class);
                startActivity(intent);
                finish();
                //setContentView(R.layout.activity_login);
            }
        });
    }
}
