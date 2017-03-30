package project.waterSystem.Model;

/**
 * Created by Jim Helm on 3/29/17.
 */

public class Location {

    private Double _latitude;
    private Double _longitude;

    public Location(Double latitude, Double longitude) {
        _latitude = latitude;
        _longitude = longitude;
    }

    public Double getLatitude(){return _latitude;}

    public Double getLongitude(){return _longitude;}

    public String toString(){
        return "latitude: " + _latitude + " longitude: " + _longitude;
    }
}
