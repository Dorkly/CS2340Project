package project.waterSystem.Controller;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import java.util.Date;

import project.waterSystem.DatabaseHandler;
import project.waterSystem.Model.LoggingNavigation;
import project.waterSystem.PurityReport;
import project.waterSystem.R;
import project.waterSystem.SourceReport;


@SuppressWarnings("ALL")
public class LoggingReportsScreen extends AppCompatActivity {
    private DatabaseHandler db;
    private final String screen = "Logging Reports Screen";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logging_reports);

        db = new DatabaseHandler(this);

        Button signinLoggingButton = (Button) findViewById(R.id.SignInLoggingButton);
        Button navigationLoggingButton = (Button) findViewById(R.id.NavagationLoggingButton);
        Button returnButton = (Button) findViewById(R.id.returnButton);
        signinLoggingButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click

                Intent intent = new Intent(LoggingReportsScreen.this, LoggingSigninActivity.class);
                db.actionLogging(new LoggingNavigation(db.getCurrentUser(), new Date(), screen , "Sign in Logging Button", "View user Login logging"));
                startActivity(intent);
                finish();
                //setContentView(R.layout.activity_login);
            }
        });

        // Water Source

        navigationLoggingButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click

                Intent intent = new Intent(LoggingReportsScreen.this, LoggingActionActivity.class);
                db.actionLogging(new LoggingNavigation(db.getCurrentUser(), new Date(), screen , "Action Logging Button", "View user Actions logging"));
                startActivity(intent);
                finish();
                //setContentView(R.layout.activity_login);
            }
        });

        returnButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click

                Intent intent = new Intent(LoggingReportsScreen.this, AppScreen.class);
                db.actionLogging(new LoggingNavigation(db.getCurrentUser(), new Date(), screen , "Return Button", "Navigate to Main App Screen"));
                startActivity(intent);
                finish();
                //setContentView(R.layout.activity_login);
            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(LoggingReportsScreen.this, AppScreen.class);
        db.actionLogging(new LoggingNavigation(db.getCurrentUser(), new Date(), screen , "Back Button", "Phone Back Button Pressed - Go to Application Screen"));
        startActivity(intent);
        finish();
    }

}
