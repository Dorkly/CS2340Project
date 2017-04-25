package project.waterSystem.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import project.waterSystem.DatabaseHandler;
import project.waterSystem.Model.LoggingSignin;
import project.waterSystem.R;

@SuppressWarnings("ALL")
public class LoggingSigninActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logging_signin_list);

        DatabaseHandler db = new DatabaseHandler(this);
        ArrayList<LoggingSignin> reportsList = db.userLoggingList();
        ArrayAdapter<LoggingSignin> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, reportsList);
        ListView reportsListView = (ListView) findViewById(R.id.ReportsListView);
        reportsListView.setAdapter(adapter);

        Button returnButton = (Button) findViewById(R.id.returnButton);
        returnButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click

                Intent intent = new Intent(LoggingSigninActivity.this, LoggingReportsScreen.class);
                startActivity(intent);
                finish();
                //setContentView(R.layout.activity_login);
            }
        });

    }
}
