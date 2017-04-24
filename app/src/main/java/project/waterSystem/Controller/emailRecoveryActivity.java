package project.waterSystem.Controller;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.appcompat.BuildConfig;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import javax.mail.AuthenticationFailedException;
import javax.mail.MessagingException;

import project.waterSystem.DatabaseHandler;
import project.waterSystem.R;

/**
 * Created by AustinJ on 4/22/17.
 */

public class emailRecoveryActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    //private String _acct ="NA";

    private EditText mUserIdView;
    private EditText mEmailView;
    private Spinner typeSpinner;
    private String emailValue;
    private String userValue;
    private DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emailrecovery_screen);

        //cancel button
        Button cancelRegButton = (Button) findViewById(R.id.cancelProfile);
        cancelRegButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click

                Intent intent = new Intent(emailRecoveryActivity.this, WelcomeScreen.class);
                startActivity(intent);
                finish();
                //setContentView(R.layout.activity_login);
            }
        });

        // save button
        Button saveRegButton = (Button) findViewById(R.id.save);
        saveRegButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click

                db = new DatabaseHandler(v.getContext());
                Intent toMain = new Intent(emailRecoveryActivity.this, WelcomeScreen.class);

                mUserIdView = (EditText) findViewById(R.id.editText2);
                mEmailView = (EditText) findViewById(R.id.emailInput);

                userValue = mUserIdView.getText().toString();
                emailValue = mEmailView.getText().toString();
                //String typeValue = (String) typeSpinner.getSelectedItem();

                int charUserLength = userValue.length();

                if (userValue.equals("")) {
                    Toast.makeText(emailRecoveryActivity.this, "UserID is Empty", Toast.LENGTH_SHORT).show();
                } else if (emailValue.equals("")) {
                    Toast.makeText(emailRecoveryActivity.this, "email is Empty", Toast.LENGTH_SHORT).show();
                } else if (!db.sameUser(userValue)) {
                    Toast.makeText(emailRecoveryActivity.this, "UserID doesn't Match", Toast.LENGTH_SHORT).show();
                } else if (!db.sameEmail(emailValue)) {
                    Toast.makeText(emailRecoveryActivity.this, "email doesn't Match", Toast.LENGTH_SHORT).show();
                } else {
                    //boolean userMatch = db.sameUser(userValue);
                    boolean recoveryMatch = db.validRecovery(userValue,emailValue);
                    //boolean accTypeMatch = db.sameAcc(typeValue);

                    if (!recoveryMatch) { //Checks to see if the UserName already exists
                        Toast.makeText(emailRecoveryActivity.this, "UserID/email doesn't Match", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(emailRecoveryActivity.this, "Email was sent, please check your email", Toast.LENGTH_SHORT).show();
                        sendEmail();
                        //db.addUsers(new Users(userValue, passValue, nameValue, emailValue, typeValue));
                        startActivity(toMain);
                    }
                }
            }
        });
    }

    protected void sendEmail (){

        new SendEmailAsyncTask().execute();

    }

    class SendEmailAsyncTask extends AsyncTask <Void, Void, Boolean> {
        final String username = "CS2340test01";
        final String password = "@loveCS2340";
        Mail m = new Mail(username, password);

        public SendEmailAsyncTask() {
            if (BuildConfig.DEBUG)
                Log.v(SendEmailAsyncTask.class.getName(), "SendEmailAsyncTask()");
            String[] toArr = {emailValue};
            m.setTo(toArr);
            m.setFrom(username);
            m.setSubject("Your Account Information from Android");
            //m.setBody("Your password is: " + db.getPassword(username));
            m.setBody( "Your Password is"); //?????? How to recovery the password from database
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            if (BuildConfig.DEBUG) Log.v(SendEmailAsyncTask.class.getName(), "doInBackground()");
            try {
                m.send();
                return true;
            } catch (AuthenticationFailedException e) {
                Log.e(SendEmailAsyncTask.class.getName(), "Bad account details");
                e.printStackTrace();
                return false;
            } catch (MessagingException e) {
                Log.e(SendEmailAsyncTask.class.getName(), "failed");
                e.printStackTrace();
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
