package project.waterSystem.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.Date;
import java.util.List;

import project.waterSystem.DatabaseHandler;
import project.waterSystem.Model.Location;
import project.waterSystem.Model.LoggingNavigation;
import project.waterSystem.R;

@SuppressWarnings("ALL")
public class HistoricalReportActivity extends AppCompatActivity {

    private DatabaseHandler db;
    private Spinner yrSpinner, locSpinner, graphSpinner;
    private ArrayAdapter locAdapter;
    private final String screen = "Historical Report Screen";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historical_report);
        db = new DatabaseHandler(this);

        List<Integer> yearsList = db.waterPurityReportYears();

        yrSpinner = (Spinner) findViewById(R.id.yearSpinner);

        graphSpinner = (Spinner) findViewById(R.id.graphSpinner);
        ArrayAdapter graphAdapter = ArrayAdapter.createFromResource(this, R.array.graph_array, android.R.layout.simple_spinner_dropdown_item);
        graphSpinner.setAdapter(graphAdapter);

        locSpinner = (Spinner) findViewById(R.id.locationSpinner);
        ArrayAdapter yrAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, yearsList);

        yrSpinner.setAdapter(yrAdapter);

        locSpinner.setAdapter(locAdapter);

        yrSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                int selectYear = (int) yrSpinner.getSelectedItem();
                List<Location> locationsList = db.waterPurityReportLocations(selectYear);
                locAdapter = new ArrayAdapter<>(HistoricalReportActivity.this, android.R.layout.simple_spinner_item, locationsList);
                locSpinner.setAdapter(locAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

            }

        });

        Button histReportButton = (Button) findViewById(R.id.viewGraphButton);
        histReportButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                int selectYear = (int) yrSpinner.getSelectedItem();
                Location loc = (Location) locSpinner.getSelectedItem();
                String gType = (String) graphSpinner.getSelectedItem();
                Double lat = loc.getLatitude();
                Double log = loc.getLongitude();

                Intent intent = new Intent(HistoricalReportActivity.this, GraphActivity.class);
                db.actionLogging(new LoggingNavigation(db.getCurrentUser(), new Date(), screen , "View Graph Button",
                        "View graph " + gType + " for " + selectYear + " at lat/long " + lat + "/"+ log));
                intent.putExtra("year", selectYear);
                intent.putExtra("latitude", lat);
                intent.putExtra("longitude", log);
                intent.putExtra("graphType", gType);
                startActivity(intent);
                finish();
                //setContentView(R.layout.activity_login);
            }
        });
        Button cancelButton = (Button) findViewById(R.id.cancelButton);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click

                Intent intent = new Intent(HistoricalReportActivity.this, MainReportScreen.class);
                db.actionLogging(new LoggingNavigation(db.getCurrentUser(), new Date(), screen , "Cancel Button", "Navigate to Main Report Screen"));
                //intent.putExtra("AddNew", "new");
                startActivity(intent);
                finish();
                //setContentView(R.layout.activity_login);
            }
        });
    }
}
