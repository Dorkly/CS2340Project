package project.watersystem;

/**
 * Created by jimhelm on 2/28/17.
 */

public class WaterPurity {

    private String _workerName;
    private String _latitude;
    private String _longitude;
    private String _condition;
    private String _virus;
    private String _contaminant;


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
    public WaterPurity(String _workerName, String _latitude, String _longitude, String _condition, String _virus, String _contaminant){
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
    public String getLatitude(){
        return this._latitude;
    }

    /**
     * Get longitude
     * @return String
     */
    public String getLongitude(){
        return this._longitude;
    }

    /**
     * Get user password
     * @return String
     */
    public String getVirusPPM(){
        return this._virus;
    }

    /**
     * Get user password
     * @return String
     */
    public String getContaminantPPM(){
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


}
