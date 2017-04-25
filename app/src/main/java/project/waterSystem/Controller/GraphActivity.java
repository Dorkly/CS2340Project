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
import java.util.Date;

import project.waterSystem.DatabaseHandler;
import project.waterSystem.Model.GraphValues;
import project.waterSystem.Model.LoggingNavigation;
import project.waterSystem.R;



@SuppressWarnings("ALL")
public class GraphActivity extends AppCompatActivity {
    private DatabaseHandler db;
    private final String screen = "Purity Graphs Screen";
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph_screen);
        Intent intent = getIntent();

        int selYear = intent.getIntExtra("year",0);
        Double lat = intent.getDoubleExtra("latitude",0);
        Double log = intent.getDoubleExtra("longitude",0);
        String gType = intent.getStringExtra("graphType");
        db = new DatabaseHandler(this);

        TextView graphTitle = (TextView) findViewById(R.id.graph);
        String newTitle = "" + selYear + " " + graphTitle.getText() + " for " + gType;
        String gTitle = "Latitude/Longitude: " + lat + " / " + log;
        graphTitle.setText(newTitle);
        ArrayList<GraphValues> graphValues;
        if(gType.equals("Contaminant PPM")) {
            graphValues = db.waterPurityContaminantGraph(selYear,lat, log);
        } else {
            graphValues = db.waterPurityVirusGraph(selYear,lat, log);

        }

        DataPoint[] dataPoints = new DataPoint[graphValues.size()];
        int i = 0;
        for(GraphValues g: graphValues) {
            dataPoints[i++] = new DataPoint(g.getMonth(), g.getPpm());
        }

        GraphView graph = (GraphView) findViewById(R.id.graphView);
        graph.setTitle(gTitle);
        graph.removeAllSeries();
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(dataPoints);
        graph.addSeries(series);
        graph.getGridLabelRenderer().setVerticalAxisTitle(gType);
        graph.getGridLabelRenderer().setHorizontalAxisTitle("Month");
        graph.getViewport().setMinX(1);
        graph.getViewport().setMaxX(12);

        graph.getViewport().setXAxisBoundsManual(true);

        Button selectionsButton = (Button) findViewById(R.id.selectionsFButton);
        selectionsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click

                Intent intent = new Intent(GraphActivity.this, HistoricalReportActivity.class);
                db.actionLogging(new LoggingNavigation(db.getCurrentUser(), new Date(), screen , "Selection Button", "Navigate to Historical Report screen"));
                //intent.putExtra("AddNew", "new");
                startActivity(intent);
                finish();
                //setContentView(R.layout.activity_login);
            }
        });

        Button exitButton = (Button) findViewById(R.id.exitFButton);
        exitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click

                Intent intent = new Intent(GraphActivity.this, MainReportScreen.class);
                db.actionLogging(new LoggingNavigation(db.getCurrentUser(), new Date(), screen , "Exit Button", "Navigate to Main Reports Screen"));
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
