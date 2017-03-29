package project.waterSystem.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import project.waterSystem.DatabaseHandler;
import project.waterSystem.PurityReport;
import project.waterSystem.R;
import project.waterSystem.SourceReport;

/**
 * Created by AustinJ on 2/25/17.
 */

public class MainReportScreen extends AppCompatActivity {
    private Button cancelRepButton;
    private Button waterAvaButton;
    private Button histReportButton;
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
        waterPurButton = (Button) findViewById(R.id.waterPurity);
        waterSouButton = (Button) findViewById(R.id.waterSource);
        waterAvaButton = (Button) findViewById(R.id.waterAvailability);
        listPurButton = (Button) findViewById(R.id.listPurityReports);
        listSouButton = (Button) findViewById(R.id.listSourceReports);
        histReportButton = (Button) findViewById(R.id.histReport);
        cancelRepButton = (Button) findViewById(R.id.Logout);

        // Water Purity
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

        waterAvaButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click

                Intent intent = new Intent(MainReportScreen.this, MapsActivity.class);
                startActivity(intent);
                finish();
                //setContentView(R.layout.activity_login);
            }
        });

        histReportButton.setVisibility(View.INVISIBLE);
        listPurButton.setVisibility(View.INVISIBLE);
        waterPurButton.setVisibility(View.INVISIBLE);
        if ((userType.toLowerCase().equals("manager")) ) {
            waterPurButton.setVisibility(View.VISIBLE);
            listPurButton.setVisibility(View.VISIBLE);
            histReportButton.setVisibility(View.VISIBLE);
        } else if ((userType.toLowerCase().equals("worker")) ) {
            waterPurButton.setVisibility(View.VISIBLE);
        }

        //cancel button

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


        histReportButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Intent intent = new Intent(MainReportScreen.this, HistoricalReportActivity.class);
                startActivity(intent);
                finish();
                //setContentView(R.layout.activity_login);
            }
        });
    }
}
