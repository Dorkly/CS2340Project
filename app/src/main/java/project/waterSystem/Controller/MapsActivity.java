package project.waterSystem.Controller;


import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

import project.waterSystem.DatabaseHandler;
import project.waterSystem.Model.WaterSource;
import project.waterSystem.R;


/**
 * Created by AustinJ on 3/5/17.
 */

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(googleServiceAvailable()) {
            setContentView(R.layout.activity_maps);
            // Obtain the SupportMapFragment and get notified when the map is ready to be used.
            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.map_fragment);
            mapFragment.getMapAsync(this);
        }else{
            // No Google Map Available
        }
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
            Toast.makeText(this,"Can't connect to play service", Toast.LENGTH_LONG);
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
                // Creating a marker
                MarkerOptions markerOptions = new MarkerOptions();

                // Setting the position for the marker
                markerOptions.position(latLng);


                // Clears the previously touched position
                mMap.clear();
                //mFacade.addReport("newly added", "Bobs Place", new Location(latLng.latitude, latLng.longitude));

                // Setting the title for the marker.
                // This will be displayed on taping the marker
                //markerOptions.title(mFacade.getLastReport().getName());
                //markerOptions.snippet(mFacade.getLastReport().getDescription());

                // Animating to the touched position
                mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));

                // Placing a marker on the touched position
                mMap.addMarker(markerOptions);
            }
        });

        DatabaseHandler db = new DatabaseHandler(this);
        List<WaterSource> reportList = db.waterAvailabilityReports();
        for (WaterSource r : reportList) {
            LatLng loc = new LatLng(r.getLatitude(), r.getLongitude());
            mMap.addMarker(new MarkerOptions().position(loc).title(r.getWaterType()).snippet(r.getCondition()));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(loc));
        }
        // mMap.setInfoWindowAdapter(new CustomInfoWindowAdapter());

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

