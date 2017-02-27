package project.watersystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by AustinJ on 2/19/17.
 */

public class RegistrationScreen extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    private Button cancelRegButton;
    private Button saveRegButton;
    Spinner spinner;// Create an ArrayAdapter using the string array and a default spinner layout
    ArrayAdapter<CharSequence> adapter;// Specify the layout to use when the list of choices appears
    //private String _acct ="NA";

    private EditText mPasswordView;
    private EditText mUserIdView;
    private EditText mNameView;
    private EditText mEmailView;
    private Spinner typeSpinner;

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

                DatabaseHandler db = new DatabaseHandler(v.getContext());
                Intent toMain = new Intent(RegistrationScreen.this, LoginActivity.class);

                mUserIdView = (EditText) findViewById(R.id.editText2);
                mPasswordView = (EditText) findViewById(R.id.passwordInput);
                mNameView = (EditText) findViewById(R.id.nameInput);
                mEmailView = (EditText) findViewById(R.id.emailInput);
                typeSpinner = (Spinner) findViewById(R.id.classificationSpinner);


                String userValue = mUserIdView.getText().toString();
                String passValue = mPasswordView.getText().toString();
                String nameValue = mNameView.getText().toString();
                String emailValue = mEmailView.getText().toString();
                String typeValue = (String) typeSpinner.getSelectedItem();

                int charUserLength = userValue.length();
                int charPassLength = passValue.length();
                boolean userMatch = db.sameUser(userValue);

                if (userMatch) { //Checks to see if the UserName already exists
                    Toast.makeText(RegistrationScreen.this, "UserName Already Taken", Toast.LENGTH_LONG).show();
                }
                else if (userValue.equals("") && passValue.equals("")) {
                    Toast.makeText(RegistrationScreen.this, "Fields Empty", Toast.LENGTH_SHORT).show();
                }
                else if (charUserLength <= 2 && charPassLength <= 2) {
                    Toast.makeText(RegistrationScreen.this, "Characters too short", Toast.LENGTH_SHORT).show();
                }
                else {
                    db.addUsers(new Users(userValue, passValue, nameValue, emailValue, typeValue));
                    startActivity(toMain);
                }
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
