package project.waterSystem.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import project.waterSystem.R;

/**
 * Created by AustinJ on 3/27/17.
 */

public class GraphActivity extends AppCompatActivity {

    public Button cancelButton;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph_screen);


        cancelButton = (Button) findViewById(R.id.createProfile);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click

                Intent intent = new Intent(GraphActivity.this, MainReportScreen.class);
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
