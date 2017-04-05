package project.waterSystem.Model;

/**
 * Created by Jim Helm on 2/28/17.
 * Class to store the water sources object
 */

public class WaterSource {
    //private variables
    private String _userName;
    private Double _latitude;
    private Double _longitude;
    private String _waterType;
    private String _condition;

    // Empty constructor
    public WaterSource(){

    }

    /**
     * Users constructor
     * @param _userName user's name
     * @param _latitude latitude of the water source being reported
     * @param _longitude longitude of the water source being reported
     * @param _waterType the type of the water being reported
     * @param _condition the condition of the water being reported
     */
    public WaterSource(String _userName, Double _latitude, Double _longitude, String _waterType, String _condition){
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
