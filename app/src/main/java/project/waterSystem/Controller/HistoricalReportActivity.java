package project.waterSystem.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

import project.waterSystem.DatabaseHandler;
import project.waterSystem.Model.Location;
import project.waterSystem.R;

public class HistoricalReportActivity extends AppCompatActivity {

    private Button histReportButton;
    private Button cancelButton;
    private DatabaseHandler db;
    private Spinner yrSpinner, locSpinner;
    private ArrayAdapter yrAdapter, locAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historical_report);
        db = new DatabaseHandler(this);

        List<Integer> yearsList = db.waterPurityReportYears();

        yrSpinner = (Spinner) findViewById(R.id.yearSpinner);


        locSpinner = (Spinner) findViewById(R.id.locationSpinner);
        yrAdapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, yearsList);

        yrSpinner.setAdapter(yrAdapter);

        List<Location> locationsList = db.waterPurityReportLocations(2017);

        locAdapter = new ArrayAdapter<Location>(HistoricalReportActivity.this, android.R.layout.simple_spinner_item, locationsList);

        locSpinner.setAdapter(locAdapter);

        yrSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                int selectYear = (int) yrSpinner.getSelectedItem();
                List<Location> locationsList = db.waterPurityReportLocations(selectYear);
                locAdapter = new ArrayAdapter<Location>(HistoricalReportActivity.this, android.R.layout.simple_spinner_item, locationsList);
                locSpinner.setAdapter(locAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

            }

        });

        histReportButton = (Button) findViewById(R.id.viewGraphButton);
        histReportButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Intent intent = new Intent(HistoricalReportActivity.this, GraphActivity.class);
                startActivity(intent);
                finish();
                //setContentView(R.layout.activity_login);
            }
        });
        cancelButton = (Button) findViewById(R.id.cancelButton);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click

                Intent intent = new Intent(HistoricalReportActivity.this, MainReportScreen.class);
                //intent.putExtra("AddNew", "new");
                startActivity(intent);
                finish();
                //setContentView(R.layout.activity_login);
            }
        });
    }
}
