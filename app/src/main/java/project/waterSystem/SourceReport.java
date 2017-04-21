package project.waterSystem;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Button;
import android.view.View;
import android.content.Intent;

import project.waterSystem.Controller.AppScreen;
import project.waterSystem.Controller.MainReportScreen;
import project.waterSystem.Model.WaterSource;

@SuppressWarnings("ALL")
public class SourceReport extends AppCompatActivity {
    private DatabaseHandler db;
    private String userValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_source_report);

        db = new DatabaseHandler(this);
        userValue = db.getUserName();

        //configure spinner
        Spinner waterTypeSpinner = (Spinner) findViewById(R.id.waterTypeSourceReportSpinner);
        ArrayAdapter waterTypeAdapter = ArrayAdapter.createFromResource(this, R.array.water_type_source_report, android.R.layout.simple_spinner_dropdown_item);
        waterTypeSpinner.setAdapter(waterTypeAdapter);

        //configure spinner
        Spinner waterConditionSpinner = (Spinner) findViewById(R.id.waterConditionSourceReportSpinner);
        ArrayAdapter waterConditionAdapter = ArrayAdapter.createFromResource(this, R.array.water_condition_source_report, android.R.layout.simple_spinner_dropdown_item);
        waterConditionSpinner.setAdapter(waterConditionAdapter);

        //report button
        Button reportSourceButton = (Button) findViewById(R.id.reportSourceReport);
        reportSourceButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click

                EditText mLatitude = (EditText) findViewById(R.id.latitudeLocationSourceReportInput);
                EditText mLongitude = (EditText) findViewById(R.id.longitudeLocationSourceReportInput);
                Spinner mWaterType = (Spinner) findViewById(R.id.waterTypeSourceReportSpinner);
                Spinner mWaterCondition = (Spinner) findViewById(R.id.waterConditionSourceReportSpinner);

                Double latitudeValue = Double.parseDouble(mLatitude.getText().toString());
                Double longitudeValue = Double.parseDouble(mLongitude.getText().toString());
                String typeValue = (String) mWaterType.getSelectedItem();
                String conditionValue = (String) mWaterCondition.getSelectedItem();

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    db.addSourceReport(new WaterSource(userValue, latitudeValue, longitudeValue, typeValue, conditionValue));
                }

                Intent intent = new Intent(SourceReport.this, AppScreen.class);
                startActivity(intent);
                finish();

            }
        });

        //cancel button
        Button cancelSourceButton = (Button) findViewById(R.id.cancelSourceReport);
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
