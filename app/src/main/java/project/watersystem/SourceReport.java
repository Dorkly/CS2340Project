package project.watersystem;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.widget.Toast;

public class SourceReport extends AppCompatActivity {
    public Button reportSourceButton;
    public Button cancelSourceButton;

    private EditText waterSourceLatitudeText;
    private EditText waterSourceLongitudeText;
    private Spinner waterTypeSpinner, waterConditionSpinner;
    ArrayAdapter waterTypeAdapter, waterConditionAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_source_report);

        //configure spinner
        waterTypeSpinner = (Spinner) findViewById(R.id.waterTypeSourceReportSpinner);
        waterTypeAdapter = ArrayAdapter.createFromResource(this, R.array.water_type_source_report, android.R.layout.simple_spinner_dropdown_item);
        waterTypeSpinner.setAdapter(waterTypeAdapter);

        waterConditionSpinner = (Spinner) findViewById(R.id.waterConditionSourceReportSpinner);
        waterConditionAdapter = ArrayAdapter.createFromResource(this, R.array.water_type_source_report, android.R.layout.simple_spinner_dropdown_item);
        waterConditionSpinner.setAdapter(waterConditionAdapter);

        reportSourceButton = (Button) findViewById(R.id.reportSourceReport); // report water source button
        reportSourceButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Intent intent = new Intent(SourceReport.this, AppScreen.class);

                try {
                    waterSourceLatitudeText = (EditText) findViewById(R.id.latitudeLocationSourceReportInput);
                    waterSourceLongitudeText = (EditText) findViewById(R.id.longitudeLocationSourceReportInput);
                    waterTypeSpinner = (Spinner) findViewById(R.id.waterTypeSourceReportSpinner);
                    waterConditionSpinner = (Spinner) findViewById(R.id.waterConditionSourceReportSpinner);

                    String waterSourceLatitude = waterSourceLatitudeText.getText().toString();
                    String waterSourceLongitude = waterSourceLongitudeText.getText().toString();
                    String waterSourceType = (String) waterTypeSpinner.getSelectedItem();
                    String waterSourceCondition = (String) waterConditionSpinner.getSelectedItem();
                    double dWaterSourceLatitude = Double.parseDouble(waterSourceLatitudeText.getText().toString());
                    double dWaterSourceLongitude = Double.parseDouble(waterSourceLongitudeText.getText().toString());

                    if (waterSourceLatitude.equals("") || waterSourceLongitude.equals("") || waterSourceType.equals("") || waterSourceCondition.equals("")) {
                        Toast.makeText(SourceReport.this, "Please fill out empty field(s).", Toast.LENGTH_SHORT).show();
                    } else if ((dWaterSourceLatitude < -90 && dWaterSourceLatitude > 90) || (dWaterSourceLongitude < -180 && dWaterSourceLongitude > 180)) {
                        Toast.makeText(SourceReport.this, "Location is out of range.", Toast.LENGTH_SHORT).show();
                    } else {
                        startActivity(intent);
                        finish();
                        //setContentView(R.layout.activity_login);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        cancelSourceButton = (Button) findViewById(R.id.cancelSourceReport);
        cancelSourceButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Intent intent = new Intent(SourceReport.this, AppScreen.class);
                startActivity(intent);
                finish();
                //setContentView(R.layout.activity_login);
            }
        });
    }
}
