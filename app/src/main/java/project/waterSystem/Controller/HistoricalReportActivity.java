package project.waterSystem.Controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import project.waterSystem.PurityReport;
import project.waterSystem.R;

public class HistoricalReportActivity extends AppCompatActivity {

    private Button histReportButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historical_report);


    histReportButton = (Button) findViewById(R.id.viewGraphButton);
    histReportButton.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            // Perform action on click
            Intent intent = new Intent(HistoricalReportActivity.this, MainReportScreen.class);
            startActivity(intent);
            finish();
            //setContentView(R.layout.activity_login);
        }
    });
}
}
