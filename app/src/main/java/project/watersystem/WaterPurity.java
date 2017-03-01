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
     * @param _workerName user name
     * @param _latitude
     * @param _longitude
     * @param _virus
     * @param _condition
     * @param _contaminant
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
