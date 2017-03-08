package project.waterSystem;

/**
 * Created by Jim Helm on 2/21/17.
 *
 * Users class used for login and registration
 */
public class Users {

    //private variables
    int _id; // Just to have it.
    String _userId;
    String _passWord;
    String _userName;
    String _userEmail;
    String _userType;
    // Empty constructor
    public Users(){

    }

    /**
     * Users constructor
     * @param userId user ID
     * @param _userName user name
     * @param _passWord user password
     * @param _userEmail user email
     * @param _userType Registered type (registered user, worker, manager, admin)
     */
    public Users(String userId, String _passWord, String _userName, String _userEmail,
                 String _userType){
        this._userId = userId;
        this._passWord = _passWord;
        this._userName = _userName;
        this._userEmail = _userEmail;
        this._userType = _userType;
    }
    /**
     * Get user id
     * @return String
     */
    public String getUser(){
        return this._userId;
    }

    /**
     * Get user password
     * @return String
     */
    public String getPassword(){
        return this._passWord;
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
    public String getEmail(){
        return this._userEmail;
    }

    /**
     * Get user Registered Type
     * @return String
     */
    public String getType(){
        return this._userType;
    }

}