package project.waterSystem;

import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import project.waterSystem.Controller.AppScreen;
import project.waterSystem.Controller.MainReportScreen;
import project.waterSystem.Model.WaterPurity;

public class PurityReport extends AppCompatActivity {
    public static List<String> purityTypes = Arrays.asList("safe", "Treatable", "Unsafe");
    private Button purityReportSaveButton;
    private Button purityReportCancelButton;
    private static int Next_Id = 0;
    private DatabaseHandler db;
    private String userValue;
    private String dateTimeValue;

    Spinner spinner;// Create an ArrayAdapter using the string array and a default spinner layout
    ArrayAdapter<CharSequence> adapter;// Specify the layout to use when the list of choices appears

    public static int findPosition(String code) {
        int i = 0;
        while (i < purityTypes.size()) {
            if (code.equals(purityTypes.get(i))) return i;
            ++i;
        }
        return 0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purity_report);

        db = new DatabaseHandler(this);
        userValue = db.getUserName();

        TextView mUserName = (TextView) findViewById(R.id.purityReportName);
        mUserName.setText(userValue);

        TextView mReportId = (TextView) findViewById(R.id.purityReportNumber);
        int newReportId = db.getPurityReportId();
        mReportId.setText("" + newReportId);

        Date dateObj = Calendar.getInstance().getTime();
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
            dateTimeValue = sdf.format(dateObj);
        }
        TextView mDateField = (TextView) findViewById(R.id.purityReportDate);
        mDateField.setText(dateTimeValue);


        //configure spinner
        spinner = (Spinner) findViewById(R.id.conditionSpinner);
        adapter = ArrayAdapter.createFromResource(this, R.array.water_condition_purity_report, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        purityReportSaveButton = (Button) findViewById(R.id.purityReportSave);
        purityReportSaveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click

                EditText mLatitude = (EditText) findViewById(R.id.purityReportLatitude);
                EditText mLongitude = (EditText) findViewById(R.id.purityReportLongitude);
                EditText mVirus = (EditText) findViewById(R.id.virusPPM);
                EditText mContaminant = (EditText) findViewById(R.id.contaminantPPM);
                Spinner mWaterCondition = (Spinner) findViewById(R.id.conditionSpinner);

                Double latitudeValue = Double.parseDouble(mLatitude.getText().toString());
                Double longitudeValue = Double.parseDouble(mLongitude.getText().toString());
                String virusValue = mVirus.getText().toString();
                String contaminantValue = mContaminant.getText().toString();
                String conditionValue = (String) mWaterCondition.getSelectedItem();

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    db.addPurityReport(new WaterPurity(userValue, latitudeValue, longitudeValue, conditionValue, virusValue, contaminantValue));
                }

                Intent intent = new Intent(PurityReport.this, AppScreen.class);
                startActivity(intent);
                finish();

            }
        });

        //cancel button
        purityReportCancelButton = (Button) findViewById(R.id.purityReportCancel);
        purityReportCancelButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Intent intent = new Intent(PurityReport.this, MainReportScreen.class);
                startActivity(intent);
                finish();
                //setContentView(R.layout.activity_login);
            }
        });


    }
}
