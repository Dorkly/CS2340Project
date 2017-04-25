package project.waterSystem.Controller;


import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Date;
import java.util.List;

import project.waterSystem.DatabaseHandler;
import project.waterSystem.Model.LoggingNavigation;
import project.waterSystem.Model.WaterPurity;
import project.waterSystem.Model.WaterSource;
import project.waterSystem.R;




@SuppressWarnings("ALL")
public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Spinner waterTypeSpinner, waterConditionSpinner;
    private ArrayAdapter waterTypeAdapter, waterConditionAdapter;
    private String typeValue, conditionValue;
    private DatabaseHandler db;
    private final String screen = "Maps Screen";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map_fragment);
            mapFragment.getMapAsync(this);
//        if(googleServiceAvailable()) {
//            setContentView(R.layout.activity_maps);
//            // Obtain the SupportMapFragment and get notified when the map is ready to be used.
//            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
//                    .findFragmentById(R.id.map_fragment);
//            mapFragment.getMapAsync(this);
//        }else{
//            // No Google Map Available
//        }
    }

    private boolean googleServiceAvailable() {
        GoogleApiAvailability api = GoogleApiAvailability.getInstance();
        int isAvailable = api.isGooglePlayServicesAvailable(this);
        if(isAvailable == ConnectionResult.SUCCESS){
            return true;
        } else if(api.isUserResolvableError(isAvailable)){
            Dialog dialog = api.getErrorDialog(this,isAvailable,0);
            dialog.show();
        } else {
            Toast toast = Toast.makeText(this,"Can't connect to play service", Toast.LENGTH_LONG);
            toast.show();
        }
        return false;
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     *
     * Users constructor
     * @param googleMap Google Map
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // Setting a click event handler for the map

        // Add a marker in Sydney and move the camera
        LatLng atlanta = new LatLng(33.749, -84.388);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(atlanta));

        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {

            @Override
            public void onMapClick(LatLng latLng) {
                // custom dialog
                final LatLng nLatLng = latLng;

                final Dialog dialog = new Dialog(MapsActivity.this);
                dialog.setContentView(R.layout.custom);


                waterTypeSpinner = (Spinner) dialog.findViewById(R.id.waterTypeDialogSpinner);
                waterTypeAdapter = ArrayAdapter.createFromResource(MapsActivity.this, R.array.water_type_source_report, android.R.layout.simple_spinner_dropdown_item);
                waterTypeSpinner.setAdapter(waterTypeAdapter);

                //configure spinner
                waterConditionSpinner = (Spinner) dialog.findViewById(R.id.waterConditionDialogSpinner);
                waterConditionAdapter = ArrayAdapter.createFromResource(dialog.getContext(), R.array.water_condition_source_report, android.R.layout.simple_spinner_dropdown_item);
                waterConditionSpinner.setAdapter(waterConditionAdapter);

                // set the custom dialog components - text, image and button
                //TextView text = (TextView) dialog.findViewById(R.id.text);
                //text.setText("Android custom dialog example!");


                Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonSave);
                // if button is clicked, close the custom dialog
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Creating a marker
                        MarkerOptions markerOptions = new MarkerOptions();

                        // Setting the position for the marker
                        markerOptions.position(nLatLng);

                        Spinner mWaterType = (Spinner) dialog.findViewById(R.id.waterTypeDialogSpinner);
                        Spinner mWaterCondition = (Spinner) dialog.findViewById(R.id.waterConditionDialogSpinner);

                        typeValue = (String) mWaterType.getSelectedItem();
                        conditionValue = (String) mWaterCondition.getSelectedItem();

                        db = new DatabaseHandler(MapsActivity.this);
                        String userValue = db.getUserName();
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                            db.addSourceReport(new WaterSource(userValue, nLatLng.latitude, nLatLng.longitude, typeValue, conditionValue));
                        }

                        mMap.addMarker(new MarkerOptions().position(nLatLng).title(typeValue).snippet(conditionValue));
                        mMap.moveCamera(CameraUpdateFactory.newLatLng(nLatLng));
                        // Animating to the touched position
                        mMap.animateCamera(CameraUpdateFactory.newLatLng(nLatLng));

                        // Placing a marker on the touched position
                        mMap.addMarker(markerOptions);
                        db.actionLogging(new LoggingNavigation(db.getCurrentUser(), new Date(), screen , "Dialog Create Report", "New Water Source Report Created"));
                        dialog.cancel();
                    }
                });

                Button dialogButtonCancel = (Button) dialog.findViewById(R.id.dialogButtonCancel);
                // if button is clicked, close the custom dialog
                dialogButtonCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        db.actionLogging(new LoggingNavigation(db.getCurrentUser(), new Date(), screen , "Dialog Cancel Button", "Cancel Create Water Report"));
                        dialog.cancel();
                    }
                });


                dialog.show();
            }
        });

        db = new DatabaseHandler(this);
        List<WaterSource> reportList = db.waterAvailabilityReports();
        for (WaterSource r : reportList) {
            LatLng loc = new LatLng(r.getLatitude(), r.getLongitude());
            mMap.addMarker(new MarkerOptions().position(loc).title(r.getWaterType())
                    .snippet(r.getCondition()).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(loc));
        }

        String userType = db.getUserType();
        if ((userType.toLowerCase().equals("manager")) ) {
            // mMap.setInfoWindowAdapter(new CustomInfoWindowAdapter());
            List<WaterPurity> reportPurityList = db.waterPurityReports();
            for (WaterPurity r : reportPurityList) {
                LatLng loc = new LatLng(r.getLatitude(), r.getLongitude());
                mMap.addMarker(new MarkerOptions().position(loc).title(r.getCondition())
                        .snippet(r.getSnippet()).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(loc));
            }
        }
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(MapsActivity.this, MainReportScreen.class);
        db.actionLogging(new LoggingNavigation(db.getCurrentUser(), new Date(), screen , "Back Button", "Phone Back Button Pressed - Go to Main Reports Screen"));
        startActivity(intent);
        finish();
    }
    /*

    class CustomInfoWindowAdapter implements GoogleMap.InfoWindowAdapter {

        private final View myContentsView;

        CustomInfoWindowAdapter(){
            myContentsView = getLayoutInflater().inflate(R.layout.custom_info_contents, null);
        }


        @Override
        public View getInfoContents(Marker marker) {

            TextView tvTitle = ((TextView)myContentsView.findViewById(R.id.title));
            tvTitle.setText(marker.getTitle());
            //TextView tvSnippet = ((TextView)myContentsView.findViewById(R.id.snippet));
            //tvSnippet.setText(marker.getSnippet());

            return myContentsView;
        }

        @Override
        public View getInfoWindow(Marker marker) {
            // TODO Auto-generated method stub
            return null;
        }


    }
    */

}

