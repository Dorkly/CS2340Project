package project.watersystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.Arrays;
import java.util.List;

public class PurityReport extends AppCompatActivity {
    public static List<String> purityTypes = Arrays.asList("safe", "Treatable", "Unsafe");
    private static int Next_Id = 0;
    private DatabaseHandler db;
    private String userValue;

    Spinner spinner;// Create an ArrayAdapter using the string array and a default spinner layout
    ArrayAdapter<CharSequence> adapter;// Specify the layout to use when the list of choices appears

    public static int findPosition(String code) {
        int i = 0;
        while (i < purityTypes.size()) {
            if (code.equals(purityTypes.get(i))) return i;
            ++i;
        }
        return 0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purity_report);

        db = new DatabaseHandler(this);
        userValue = db.getUserName();

        //configure spinner
        spinner = (Spinner) findViewById(R.id.conditionSpinner);
        adapter = ArrayAdapter.createFromResource(this, R.array.water_condition_purity_report, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

    }
}
