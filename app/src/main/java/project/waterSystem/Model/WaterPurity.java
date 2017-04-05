package project.waterSystem.Model;

/**
 * Created by Jim Helm on 2/28/17.
 * CLass to store the Water Purity objects
 */

public class WaterPurity {

    private String _workerName;
    private Double _latitude;
    private Double _longitude;
    private String _condition;
    private Double _virus;
    private Double _contaminant;


    // Empty constructor
    public WaterPurity(){

    }

    /**
     * Users constructor
     * @param _workerName user's name
     * @param _latitude the latitude of the water source being reported
     * @param _longitude the longitude of the water source being reported
     * @param _virus the virus ppm level of the water source being reported
     * @param _condition the condition of the water being reported
     * @param _contaminant the contaminant ppm of the water being reported
     */
    public WaterPurity(String _workerName, Double _latitude, Double _longitude, String _condition, Double _virus, Double _contaminant){
        this._workerName = _workerName;
        this._latitude = _latitude;
        this._longitude = _longitude;
        this._virus = _virus;
        this._condition = _condition;
        this._contaminant = _contaminant;
    }

    /**
     * Get latitude
     * @return String
     */
    public Double getLatitude(){
        return this._latitude;
    }

    /**
     * Get longitude
     * @return String
     */
    public Double getLongitude(){
        return this._longitude;
    }

    /**
     * Get user password
     * @return String
     */
    public Double getVirusPPM(){
        return this._virus;
    }

    /**
     * Get user password
     * @return String
     */
    public Double getContaminantPPM(){
        return this._contaminant;
    }


    /**
     * Get user Name
     * @return String
     */
    public String getName(){
        return this._workerName;
    }

    /**
     * Get user email address
     * @return String
     */
    public String getCondition(){
        return this._condition;
    }

    public String getSnippet() {
        return "Virus PPM: "+ _virus + ", Contaminant: " + _contaminant;
    }
}
