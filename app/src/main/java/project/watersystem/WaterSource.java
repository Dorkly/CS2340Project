package project.watersystem;

/**
 * Created by jimhelm on 2/28/17.
 */

public class WaterSource {
    //private variables
    private String _userName;
    private String _latitude;
    private String _longitude;
    private String _waterType;
    private String _condition;

    // Empty constructor
    public WaterSource(){

    }

    /**
     * Users constructor
     * @param _userName user name
     * @param _latitude
     * @param _longitude
     * @param _waterType
     * @param _condition
     */
    public WaterSource(String _userName, String _latitude, String _longitude, String _waterType, String _condition){
        this._userName = _userName;
        this._latitude = _latitude;
        this._longitude = _longitude;
        this._waterType = _waterType;
        this._condition = _condition;
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
    public String getWaterType(){
        return this._waterType;
    }

    /**
     * Get user Name
     * @return String
     */
    public String getName(){
        return this._userName;
    }

    /**
     * Get user email address
     * @return String
     */
    public String getCondition(){
        return this._condition;
    }

}
