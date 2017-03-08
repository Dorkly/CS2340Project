package project.waterSystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import project.waterSystem.Controller.MainReportScreen;

public class SourceReportsListActivity extends AppCompatActivity {
    private Button returnButton;
    private ListView reportsListView;
    private DatabaseHandler db;
    private ArrayList<String> reportsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_source_reports_list);

        db = new DatabaseHandler(this);
        reportsList = db.listAllSourceReports();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, reportsList);
        reportsListView = (ListView) findViewById(R.id.ReportsListView);
        reportsListView.setAdapter(adapter);

        returnButton = (Button) findViewById(R.id.returnButton);
        returnButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click

                Intent intent = new Intent(SourceReportsListActivity.this, MainReportScreen.class);
                startActivity(intent);
                finish();
                //setContentView(R.layout.activity_login);
            }
        });

    }
}
