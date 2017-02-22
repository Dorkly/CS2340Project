package project.watersystem;

/**
 * Created by jimhelm on 2/22/17.
 */

public class Profiles {

    String _userId;
    String _homeAddress;
    String _phone;

    public Profiles(String userId, String _homeAddress, String _phone) {
        this._userId = userId;
        this._homeAddress = _homeAddress;
        this._phone = _phone;

    }

    // getting User
    public String getUser(){
        return this._userId;
    }

    // getting Password
    public String getHomeAddress(){
        return this._homeAddress;
    }

    // getting User
    public String getPhone(){
        return this._phone;
    }


}
