package project.waterSystem.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;

import project.waterSystem.DatabaseHandler;
import project.waterSystem.Model.GraphValues;
import project.waterSystem.R;

/**
 * Created by AustinJ on 3/27/17.
 */

public class GraphActivity extends AppCompatActivity {

    public Button cancelButton;
    private ArrayList<GraphValues> graphValues;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph_screen);
        Intent intent = getIntent();

        int selYear = intent.getIntExtra("year",0);
        Double lat = intent.getDoubleExtra("latitude",0);
        Double log = intent.getDoubleExtra("longitude",0);
        String gType = intent.getStringExtra("graphType");
        DatabaseHandler db = new DatabaseHandler(this);

        TextView graphTitle = (TextView) findViewById(R.id.graph);
        String newTitle = graphTitle.getText() + " - " + gType;
        graphTitle.setText(newTitle);
        if(gType.equals("Contaminant PPM")) {
            graphValues = db.waterPurityContaminantGraph(selYear,lat, log);
        } else {
            graphValues = db.waterPurityVirusGraph(selYear,lat, log);

        }

        DataPoint[] dataPoints = new DataPoint[graphValues.size()];
        int i = 0;
        for(GraphValues g:graphValues) {
            dataPoints[i++] = new DataPoint(g.getMonth(), g.getPpm());
        }

        GraphView graph = (GraphView) findViewById(R.id.graphView);
        graph.removeAllSeries();
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(dataPoints);
        graph.addSeries(series);

        cancelButton = (Button) findViewById(R.id.button2);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click

                Intent intent = new Intent(GraphActivity.this, HistoricalReportActivity.class);
                //intent.putExtra("AddNew", "new");
                startActivity(intent);
                finish();
                //setContentView(R.layout.activity_login);
            }
        });
    }

    /*
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.miCompose:
                Intent intent = new Intent(this, MainReportScreen.class);
                this.startActivity(intent);
                return true;
            case R.id.miProfile:
                Intent intent2 = new Intent(this,ProfileActivity.class);
                this.startActivity(intent2);
                return true;
            case R.id.Logout:
                Intent intent3 = new Intent(this,WelcomeScreen.class);
                this.startActivity(intent3);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }
    */
}
