package project.watersystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class ProfileActivity extends AppCompatActivity {
    public Button cancelProfileButton;
    public Button saveProfileButton;
    private String addNew;

    public static List<String> legalTypes = Arrays.asList("Regular User", "Worker", "Manager", "Admin");
    private static int Next_Id = 0;

    Spinner spinner;// Create an ArrayAdapter using the string array and a default spinner layout
    ArrayAdapter<CharSequence> adapter;// Specify the layout to use when the list of choices appears

    public static int findPosition(String code) {
        int i = 0;
        while (i < legalTypes.size()) {
            if (code.equals(legalTypes.get(i))) return i;
            ++i;
        }
        return 0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        DatabaseHandler db = new DatabaseHandler(this);

        //configure spinner
        spinner = (Spinner) findViewById(R.id.classificationSpinner);
        adapter = ArrayAdapter.createFromResource(this, R.array.account_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        addNew = getIntent().getStringExtra("AddNew");

        TextView tvName = (TextView) findViewById(R.id.nameInput);
        tvName.setText(db.getUserName());

        TextView tvEmail = (TextView) findViewById(R.id.emailInput);
        tvEmail.setText(db.getEmail());
        //tvEmail.setText(addNew);
        if (addNew.equals("edit")) {

            Spinner typeSpinner = (Spinner) findViewById(R.id.classificationSpinner);

            typeSpinner.setSelection(findPosition(db.getUserType()));

            TextView tvAddress = (TextView) findViewById(R.id.addressInput);
            tvAddress.setText(db.getHomeAddress());
            TextView tvPhone = (TextView) findViewById(R.id.phoneInput);
            tvPhone.setText(db.getPhone());

        }



        cancelProfileButton = (Button) findViewById(R.id.cancelProfile);
        cancelProfileButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Intent toMain = new Intent(ProfileActivity.this, AppScreen.class);
                startActivity(toMain);
                finish();
                //setContentView(R.layout.activity_login);
            }
        });
        saveProfileButton = (Button) findViewById(R.id.save);
        saveProfileButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                DatabaseHandler db = new DatabaseHandler(v.getContext());
                Intent toMain = new Intent(ProfileActivity.this, AppScreen.class);

                String userValue = db.getCurrentUser();
                EditText mAddressView = (EditText) findViewById(R.id.addressInput);
                EditText mPhoneView = (EditText) findViewById(R.id.phoneInput);
                EditText mNameValue = (EditText) findViewById(R.id.nameInput);
                EditText mEmailValue = (EditText) findViewById(R.id.emailInput);
                Spinner typeSpinner = (Spinner) findViewById(R.id.classificationSpinner);
                //EditText mTypeValue = (EditText) findViewById(R.id.classification);



                String addressValue = mAddressView.getText().toString();
                String phoneValue = mPhoneView.getText().toString();
                String nameValue = mNameValue.getText().toString();
                String emailValue = mEmailValue.getText().toString();
                String typeValue = (String) typeSpinner.getSelectedItem();


                if (addNew.equals("new")) {
                    db.updateUsers(userValue, nameValue, emailValue, typeValue);
                    db.addProfiles(new Profiles(userValue, addressValue, phoneValue));
                } else {
                    db.updateUsers(userValue, nameValue, emailValue, typeValue);
                    db.updateProfile(new Profiles(userValue, addressValue, phoneValue));
                }
                startActivity(toMain);
                finish();
                //setContentView(R.layout.activity_login);
            }
        });
    }
}
