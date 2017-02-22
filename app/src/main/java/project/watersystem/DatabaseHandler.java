package project.watersystem;

/**
 * Created by jimhelm on 2/21/17.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 2;

    // Database Name
    private static final String DATABASE_NAME = "DripDrop";

    private static final String TABLE_USERS = "Registerd_Accounts";
    private static final String TABLE_PROFILES = "Registerd_Profiles";
    private static String currentUser;

    // Account Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_USERS = "userID";
    private static final String KEY_PASS = "passWord";
    private static final String KEY_NAME = "userName";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_TYPE = "userType";
    private static final String KEY_HOMEADDRESS = "homeAddress";
    private static final String KEY_PHONE = "phone";

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

    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(db);// Create tables again
    }

    // Adding new User
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

    // Adding new User
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

    public void deleteAllAccounts() //Deletes all data in the database
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_USERS,null,null);
    }

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
    public boolean sameUser(String username){
        Cursor c = getReadableDatabase().rawQuery(
                "SELECT * FROM " + TABLE_USERS + " WHERE "
                        + KEY_USERS + "='" + username  + "'" ,  null);
        if (c.getCount() > 0) {
            return true;
        }
        else{return false;}
    }

    public String getCurrentUser() {
        return currentUser;
    }

    public String getUserName() {
        String userName = "";
        Cursor c = getReadableDatabase().rawQuery(
                "SELECT userName FROM " + TABLE_USERS + " WHERE "
                        + KEY_USERS + "='" + currentUser  + "'" ,  null);
        c.moveToFirst();
        userName = c.getString(0);
        return userName;
    }

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

    public void updateProfile(Profiles profile) {
        getReadableDatabase().execSQL("UPDATE " + TABLE_PROFILES + " SET "
            + KEY_HOMEADDRESS + "='" + profile.getHomeAddress() + "',"
            + KEY_PHONE + "='" + profile.getPhone() + "'"
            + " WHERE " + KEY_USERS + "='" + profile.getUser() + "'");
    }

    public void updateUsers(String userId, String name, String email, String type) {
        getReadableDatabase().execSQL("UPDATE " + TABLE_USERS + " SET "
                + KEY_NAME + "='" + name + "', "
                + KEY_EMAIL + "='" + email + "', "
                + KEY_TYPE + "='" + type + "'"
                + " WHERE " + KEY_USERS + "='" + userId + "'");
    }

    public boolean profileExists() {
        Cursor c = getReadableDatabase().rawQuery(
                "SELECT * FROM " + TABLE_PROFILES + " WHERE "
                        + KEY_USERS + "='" + currentUser  + "'" ,  null);
        return c.getCount() > 0;
    }

}