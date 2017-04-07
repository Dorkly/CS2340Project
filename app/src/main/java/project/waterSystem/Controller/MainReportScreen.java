package project.waterSystem.Controller;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
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
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            createTestReports();
        }
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

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(MainReportScreen.this, AppScreen.class);
        startActivity(intent);
        finish();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void createTestReports(){
        if (!db.sameUser("worker")) {
            db.testAddUser("worker","Worker","pass","worker@dripdrop.com","Worker");
            db.addTestPurityReport("worker","2016-01-01 08:00:00","Worker",-122.25,34.04,"Treatable",3.01,10.50);
            db.addTestPurityReport("worker","2016-02-01 08:00:00","Worker",-122.25,34.04,"Treatable",2.91,10.00);
            db.addTestPurityReport("worker","2016-03-01 08:00:00","Worker",-122.25,34.04,"Treatable",2.81,9.50);
            db.addTestPurityReport("worker","2016-04-01 08:00:00","Worker",-122.25,34.04,"Treatable",2.51,9.00);
            db.addTestPurityReport("worker","2016-05-01 08:00:00","Worker",-122.25,34.04,"Treatable",2.21,8.50);
            db.addTestPurityReport("worker","2016-06-01 08:00:00","Worker",-122.25,34.04,"Treatable",1.91,7.00);
            db.addTestPurityReport("worker","2016-07-01 08:00:00","Worker",-122.25,34.04,"Treatable",1.71,6.50);
            db.addTestPurityReport("worker","2016-08-01 08:00:00","Worker",-122.25,34.04,"Treatable",1.41,5.00);
            db.addTestPurityReport("worker","2016-09-01 08:00:00","Worker",-122.25,34.04,"Treatable",1.21,4.50);
            db.addTestPurityReport("worker","2016-10-01 08:00:00","Worker",-122.25,34.04,"Treatable",0.91,3.00);
            db.addTestPurityReport("worker","2016-11-01 08:00:00","Worker",-122.25,34.04,"Treatable",0.41,1.50);
            db.addTestPurityReport("worker","2016-12-01 08:00:00","Worker",-122.25,34.04,"Safe",0.01,00.00);
            db.testAddUser("worker","Worker","pass","worker@dripdrop.com","Worker");
            db.addTestPurityReport("worker","2017-01-01 08:00:00","Worker",-112.25,24.04,"Treatable",3.01,10.50);
            db.addTestPurityReport("worker","2017-02-01 08:00:00","Worker",-112.25,24.04,"Treatable",2.91,10.00);
            db.addTestPurityReport("worker","2017-03-01 08:00:00","Worker",-112.25,24.04,"Treatable",2.51,9.00);
            db.addTestPurityReport("worker","2017-05-01 08:00:00","Worker",-112.25,24.04,"Treatable",2.21,8.50);
            db.addTestPurityReport("worker","2017-06-01 08:00:00","Worker",-112.25,24.04,"Treatable",1.91,7.00);
            db.addTestPurityReport("worker","2017-07-01 08:00:00","Worker",-112.25,24.04,"Treatable",1.71,6.50);
            db.addTestPurityReport("worker","2017-08-01 08:00:00","Worker",-112.25,24.04,"Treatable",1.41,5.00);
            db.addTestPurityReport("worker","2017-09-01 08:00:00","Worker",-112.25,24.04,"Treatable",1.21,4.50);
            db.addTestPurityReport("worker","2017-10-01 08:00:00","Worker",-112.25,24.04,"Treatable",0.91,3.00);
            db.addTestPurityReport("worker","2017-11-01 08:00:00","Worker",-112.25,24.04,"Treatable",0.41,1.50);
            db.addTestPurityReport("worker","2017-12-01 08:00:00","Worker",-112.25,24.04,"Safe",0.01,00.00);
        }
    }
}
