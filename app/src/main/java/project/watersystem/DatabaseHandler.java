package project.watersystem;

/**
 * Created by jimhelm on 2/21/17.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * SQLite database handler
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 2;

    // Database Name
    private static final String DATABASE_NAME = "DripDrop";

    // Table Names
    private static final String TABLE_USERS = "Registerd_Accounts";
    private static final String TABLE_PROFILES = "Registerd_Profiles";
    private static final String TABLE_WATERPURITY = "Water_Purity";
    private static final String TABLE_WATERSOURCE = "Water_Source";
    private static String currentUser;

    // Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_USERS = "userID";
    private static final String KEY_PASS = "passWord";
    private static final String KEY_NAME = "userName";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_TYPE = "userType";
    private static final String KEY_HOMEADDRESS = "homeAddress";
    private static final String KEY_PHONE = "phone";
    private static final String KEY_REPORTID = "reportID";
    private static final String KEY_DATE = "reportDate";
    private static final String KEY_SUBMITBY = "reporterName";
    private static final String KEY_LATITUDE = "locLatitude";
    private static final String KEY_LONGITUDE = "locLongitude";
    private static final String KEY_WATERTYPE = "waterType";
    private static final String KEY_CONDITION = "waterCondition";
    private static final String KEY_WORKER = "workerName";
    private static final String KEY_VIRUS = "virusPPM";
    private static final String KEY_CONTAMINANT = "contaminantPPM";

    /**
     * DatabaseHandler constructor
     * @param context
     */
    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_ACCOUNT_TABLE = "CREATE TABLE " + TABLE_USERS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_USERS + " TEXT,"
                + KEY_PASS + " TEXT," + KEY_NAME + " TEXT,"
                + KEY_EMAIL + " TEXT," + KEY_TYPE + " TEXT,"
                + KEY_HOMEADDRESS + " TEXT," + KEY_PHONE + " TEXT" + ")";
        db.execSQL(CREATE_ACCOUNT_TABLE);

        CREATE_ACCOUNT_TABLE = "CREATE TABLE " + TABLE_PROFILES + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_USERS + " TEXT,"
                + KEY_HOMEADDRESS + " TEXT," + KEY_PHONE + " TEXT" + ")";
        db.execSQL(CREATE_ACCOUNT_TABLE);

        CREATE_ACCOUNT_TABLE = "CREATE TABLE " + TABLE_WATERSOURCE + "("
                + KEY_REPORTID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_USERS + " TEXT,"
                + KEY_DATE + " TEXT," + KEY_SUBMITBY + " TEXT," + KEY_LATITUDE + " DOUBLE,"
                + KEY_LONGITUDE + " DOUBLE," + KEY_WATERTYPE + " TEXT,"
                + KEY_CONDITION + " TEXT" + ")";
        db.execSQL(CREATE_ACCOUNT_TABLE);

        CREATE_ACCOUNT_TABLE = "CREATE TABLE " + TABLE_WATERPURITY + "("
                + KEY_REPORTID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_USERS + " TEXT,"
                + KEY_DATE + " TEXT," + KEY_WORKER + " TEXT," + KEY_LATITUDE + " DOUBLE,"
                + KEY_LONGITUDE + " DOUBLE," + KEY_CONDITION + " TEXT,"
                + KEY_VIRUS + " DOUBLE," + KEY_CONTAMINANT + " DOUBLE" + ")";
        db.execSQL(CREATE_ACCOUNT_TABLE);

    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(db);// Create tables again
    }

    /**
     * addUsers method adds users to the Registerd_Accounts table
     * @param users
     */
    void addUsers(Users users) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_USERS, users.getUser()); // User Name
        values.put(KEY_PASS, users.getPassword()); // Password
        values.put(KEY_NAME, users.getName()); // User Name
        values.put(KEY_EMAIL, users.getEmail()); // Password
        values.put(KEY_TYPE, users.getType()); // Password

        // Inserting Row
        db.insert(TABLE_USERS, null, values);
        db.close(); // Closing database connection
    }

    /**
     * addProfiles method adds user profiles to the Registerd_Profiles table
     * @param profile
     */
   void addProfiles(Profiles profile) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_USERS, profile.getUser()); // User Name
        values.put(KEY_HOMEADDRESS, profile.getHomeAddress()); // Password
        values.put(KEY_PHONE, profile.getPhone()); // User Name

        // Inserting Row
        db.insert(TABLE_PROFILES, null, values);
        db.close(); // Closing database connection
    }

    /**
     * addUsers method adds users to the Registerd_Accounts table
     * @param ws
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    void addSourceReport(WaterSource ws) {
        SQLiteDatabase db = this.getWritableDatabase();
        Date dateobj = Calendar.getInstance().getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");

        ContentValues values = new ContentValues();
        values.put(KEY_USERS, currentUser); // User Name
        values.put(KEY_DATE, sdf.format(dateobj)); // User Name
        values.put(KEY_SUBMITBY, ws.getName()); // User Name
        values.put(KEY_LATITUDE, ws.getLatitude()); // Password
        values.put(KEY_LONGITUDE, ws.getLongitude()); // Password
        values.put(KEY_WATERTYPE, ws.getWaterType()); // Password
        values.put(KEY_CONDITION, ws.getCondition()); // Password

        // Inserting Row
        db.insert(TABLE_WATERSOURCE, null, values);
        db.close(); // Closing database connection
    }

    /**
     * addUsers method adds users to the Registerd_Accounts table
     * @param wp
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    void addPurityReport(WaterPurity wp) {
        SQLiteDatabase db = this.getWritableDatabase();
        Date dateobj = Calendar.getInstance().getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");

        ContentValues values = new ContentValues();
        values.put(KEY_USERS, currentUser); // User ID
        values.put(KEY_DATE, sdf.format(dateobj)); // Date
        values.put(KEY_WORKER, wp.getName()); // Worker Name
        values.put(KEY_LATITUDE, wp.getLatitude()); // Latitude
        values.put(KEY_LONGITUDE, wp.getLongitude()); // Longitude
        values.put(KEY_CONDITION, wp.getCondition()); // Water Condition
        values.put(KEY_VIRUS, wp.getVirusPPM()); // Virus PPM
        values.put(KEY_CONTAMINANT, wp.getContaminantPPM()); // Contaminant PPM

        // Inserting Row
        db.insert(TABLE_WATERPURITY, null, values);
        db.close(); // Closing database connection
    }

    /**
     * deleteAllAccounts method delets all users to the Registerd_Accounts table
     */
    public void deleteAllAccounts() //Deletes all data in the database
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_USERS,null,null);
    }

    /**
     * validateUser checks if the userid and password are in the table and match
     * @param username
     * @param password
     * @return boolean
     */
    public boolean validateUser(String username, String password){
        Cursor c = getReadableDatabase().rawQuery(
                "SELECT * FROM " + TABLE_USERS + " WHERE "
                        + KEY_USERS + "='" + username +"'AND "+KEY_PASS+"='"+password+"'" ,  null);
        if (c.getCount() > 0) {
            currentUser = username;
            return true;
        }
        else{return false;}

    }

    /**
     * sameUser checks if the userid is already in the table
     * @param username
     * @return boolean
     */
    public boolean sameUser(String username){
        Cursor c = getReadableDatabase().rawQuery(
                "SELECT * FROM " + TABLE_USERS + " WHERE "
                        + KEY_USERS + "='" + username  + "'" ,  null);
        if (c.getCount() > 0) {
            return true;
        }
        else{return false;}
    }

    /**
     * getCurrentUser returns the current logged in user ID
     * @return String
     */
    public String getCurrentUser() {
        return currentUser;
    }

    /**
     * getUserName returns the user name from the Registerd_Accounts table
     * @return String
     */
    public String getUserName() {
        String userName = "";
        Cursor c = getReadableDatabase().rawQuery(
                "SELECT userName FROM " + TABLE_USERS + " WHERE "
                        + KEY_USERS + "='" + currentUser  + "'" ,  null);
        c.moveToFirst();
        userName = c.getString(0);
        return userName;
    }

    /**
     * getEmail returns the email address from the Registerd_Accounts table
     * @return String
     */
    public String getEmail() {
        String email = "";
        Cursor c = getReadableDatabase().rawQuery(
                "SELECT email FROM " + TABLE_USERS + " WHERE "
                        + KEY_USERS + "='" + currentUser  + "'" ,  null);

        if (c != null) {
            c.moveToFirst();
            email = c.getString(0);
            return email;
        }
        return "";

    }

    /**
     * getUserTypr returns the registered Type from the Registerd_Accounts table
     * @return String
     */
    public String getUserType() {
        String userType = "";
        Cursor c = getReadableDatabase().rawQuery(
                "SELECT userType FROM " + TABLE_USERS + " WHERE "
                        + KEY_USERS + "='" + currentUser  + "'" ,  null);
        if (c != null) {
            c.moveToFirst();
            userType = c.getString(0);
            return userType;
        }
        return "";
    }

    /**
     * getHomeAddress returns the home address from the Registerd_Profiles table
     * @return String
     */
    public String getHomeAddress() {
        String homeAddress = "";
        Cursor c = getReadableDatabase().rawQuery(
                "SELECT homeAddress FROM " + TABLE_PROFILES + " WHERE "
                        + KEY_USERS + "='" + currentUser  + "'" ,  null);
        if (c != null) {
            c.moveToFirst();
            homeAddress = c.getString(0);
            return homeAddress;
        }
        return "";
    }

    /**
     * getPhone returns the phone number from the Registerd_Profiles table
     * @return String
     */
    public String getPhone() {
        String phone = "";
        Cursor c = getReadableDatabase().rawQuery(
                "SELECT phone FROM " + TABLE_PROFILES + " WHERE "
                        + KEY_USERS + "='" + currentUser  + "'" ,  null);
        if (c != null) {
            c.moveToFirst();
            phone = c.getString(0);
            return phone;
        }
        return "";
    }

    /**
     * updateProfile updates the user profile data in the Registered_Profile table
     * @param profile
     */
    public void updateProfile(Profiles profile) {
        getReadableDatabase().execSQL("UPDATE " + TABLE_PROFILES + " SET "
            + KEY_HOMEADDRESS + "='" + profile.getHomeAddress() + "',"
            + KEY_PHONE + "='" + profile.getPhone() + "'"
            + " WHERE " + KEY_USERS + "='" + profile.getUser() + "'");
    }

    /**
     * updateUsers updates the user account data in the Registered_Account table
     * @param userId userid to update
     * @param name new user name
     * @param email new email address
     * @param type new registered type
     */
    public void updateUsers(String userId, String name, String email, String type) {
        getReadableDatabase().execSQL("UPDATE " + TABLE_USERS + " SET "
                + KEY_NAME + "='" + name + "', "
                + KEY_EMAIL + "='" + email + "', "
                + KEY_TYPE + "='" + type + "'"
                + " WHERE " + KEY_USERS + "='" + userId + "'");
    }

    /**
     * profileExists checks if the profile for the current user is in the Registered_Profile table
     * @return boolean
     */
    public boolean profileExists() {
        Cursor c = getReadableDatabase().rawQuery(
                "SELECT * FROM " + TABLE_PROFILES + " WHERE "
                        + KEY_USERS + "='" + currentUser  + "'" ,  null);
        return c.getCount() > 0;
    }

    /**
     * listAllPurityReports returns the list of reports from the Water_Purity table
     * @return reportsList
     */
    public ArrayList<String> listAllPurityReports() {
        ArrayList<String> reportsList = new ArrayList<>();
        String report = "";
        Cursor c = getReadableDatabase().rawQuery(
                "SELECT "+ KEY_REPORTID + ", " + KEY_WORKER + ", " + KEY_LATITUDE
                        + ", " + KEY_LONGITUDE + " FROM " + TABLE_WATERPURITY,  null);

        if (c != null ) {
            if  (c.moveToFirst()) {
                do {
                    report += "ReportID: " + c.getString(0);
                    report += "  Worker:" + c.getString(1);
                    report += "  Latitude:" + c.getString(2);
                    report += "  Longitude:" + c.getString(3);
                    reportsList.add(report);
                }while (c.moveToNext());
            }
        }

        return reportsList;
    }


}