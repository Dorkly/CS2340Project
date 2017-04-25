package project.waterSystem.Controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;

import project.waterSystem.DatabaseHandler;
import project.waterSystem.Model.LoggingNavigation;
import project.waterSystem.R;

@SuppressWarnings("ALL")
public class SourceReportsListActivity extends AppCompatActivity {
    private DatabaseHandler db;
    private final String screen = "Water Source Reports List";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_source_reports_list);

        db = new DatabaseHandler(this);
        ArrayList<String> reportsList = db.listAllSourceReports();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, reportsList);
        ListView reportsListView = (ListView) findViewById(R.id.ReportsListView);
        reportsListView.setAdapter(adapter);

        Button returnButton = (Button) findViewById(R.id.returnButton);
        returnButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click

                Intent intent = new Intent(SourceReportsListActivity.this, MainReportScreen.class);
                db.actionLogging(new LoggingNavigation(db.getCurrentUser(), new Date(), screen , "Return Button", "Navigate to Main Reports Screen"));
                startActivity(intent);
                finish();
                //setContentView(R.layout.activity_login);
            }
        });

    }
}
