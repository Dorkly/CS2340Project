package project.watersystem;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Button;
import android.view.View;
import android.content.Intent;

public class SourceReport extends AppCompatActivity {
    public Button reportSourceButton;
    public Button cancelSourceButton;

    // Create an ArrayAdapter using the string array and a default spinner layout
    ArrayAdapter waterTypeAdapter, waterConditionAdapter;
    public Spinner waterTypeSpinner, waterConditionSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_source_report);

        //configure spinner
        waterTypeSpinner = (Spinner) findViewById(R.id.waterTypeSourceReportSpinner);
        waterTypeAdapter = ArrayAdapter.createFromResource(this, R.array.water_type_source_report, android.R.layout.simple_spinner_dropdown_item);
        waterTypeSpinner.setAdapter(waterTypeAdapter);

        //configure spinner
        waterConditionSpinner = (Spinner) findViewById(R.id.waterConditionSourceReportSpinner);
        waterConditionAdapter = ArrayAdapter.createFromResource(this, R.array.water_condition_source_report, android.R.layout.simple_spinner_dropdown_item);
        waterConditionSpinner.setAdapter(waterConditionAdapter);

        //report button
        reportSourceButton = (Button) findViewById(R.id.reportSourceReport);
        reportSourceButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Intent intent = new Intent(SourceReport.this, AppScreen.class);
                startActivity(intent);
                finish();

            }
        });

        //cancel button
        cancelSourceButton = (Button) findViewById(R.id.cancelSourceReport);
        cancelSourceButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Intent intent = new Intent(SourceReport.this, MainReportScreen.class);
                startActivity(intent);
                finish();
                //setContentView(R.layout.activity_login);
            }
        });
    }
}
