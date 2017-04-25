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
import project.waterSystem.Model.LoggingNavigation;
import project.waterSystem.Model.LoggingSignin;
import project.waterSystem.R;

@SuppressWarnings("ALL")
public class LoggingActionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logging_action_list);

        DatabaseHandler db = new DatabaseHandler(this);
        ArrayList<LoggingNavigation> reportsList = db.actionLoggingList();
        ArrayAdapter<LoggingNavigation> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, reportsList);
        ListView reportsListView = (ListView) findViewById(R.id.ReportsListView);
        reportsListView.setAdapter(adapter);

        Button returnButton = (Button) findViewById(R.id.returnButton);
        returnButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click

                Intent intent = new Intent(LoggingActionActivity.this, LoggingReportsScreen.class);
                startActivity(intent);
                finish();
                //setContentView(R.layout.activity_login);
            }
        });

    }
}
