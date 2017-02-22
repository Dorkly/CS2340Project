package project.watersystem;

/**
 * Created by jimhelm on 2/21/17.
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
    // constructor
    public Users(String userId, String _passWord, String _userName, String _userEmail,
                 String _userType){
        this._userId = userId;
        this._passWord = _passWord;
        this._userName = _userName;
        this._userEmail = _userEmail;
        this._userType = _userType;
    }
    // getting User
    public String getUser(){
        return this._userId;
    }

    // getting Password
    public String getPassword(){
        return this._passWord;
    }

    // getting User
    public String getName(){
        return this._userName;
    }

    // getting Password
    public String getEmail(){
        return this._userEmail;
    }

    // getting Password
    public String getType(){
        return this._userType;
    }

}