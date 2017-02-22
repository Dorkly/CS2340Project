package project.watersystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

/**
 * Created by AustinJ on 2/19/17.
 */

public class RegistrationScreen extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    public Button cancelRegButton;
    public Button saveRegButton;
    Spinner spinner;// Create an ArrayAdapter using the string array and a default spinner layout
    ArrayAdapter<CharSequence> adapter;// Specify the layout to use when the list of choices appears
    //private String _acct ="NA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_screen);

        //configure spinner
        spinner = (Spinner) findViewById(R.id.classificationSpinner);
        adapter = ArrayAdapter.createFromResource(this, R.array.account_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        //cancel button
        cancelRegButton = (Button) findViewById(R.id.cancelProfile);
        cancelRegButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click

                Intent intent = new Intent(RegistrationScreen.this, WelcomeScreen.class);
                startActivity(intent);
                finish();
                //setContentView(R.layout.activity_login);
            }
        });

        // save button
        saveRegButton = (Button) findViewById(R.id.save);
        saveRegButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click

                Intent intent = new Intent(RegistrationScreen.this, AppScreen.class);
                startActivity(intent);
                finish();
                //setContentView(R.layout.activity_login);
            }
        });
    }

    // override the account type
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //_acct = parent.getItemAtPosition(position).toString();
        //Toast.makeText(getBaseContext(),parent.getItemAtPosition(position)+ "is selected",Toast.LENGTH_LONG);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
