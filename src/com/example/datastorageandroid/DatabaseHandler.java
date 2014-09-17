package com.example.datastorageandroid;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHandler extends SQLiteOpenHelper {
	 
    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;
 
    // Database Name
    private static final String DATABASE_NAME = "textsManager";
 
    // Contacts table name
    private static final String TABLE_TEXTS = "texts";
 
    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_TEXT = "text";

 
    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
 
    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_TEXTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_TEXT + " TEXT)";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }
 
    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TEXTS);
 
        // Create tables again
        onCreate(db);
    }
    public void addContact(Texttosavesqllite contact) {
        SQLiteDatabase db = this.getWritableDatabase();
     
        ContentValues values = new ContentValues();
        values.put(KEY_TEXT, contact.getText()); // Contact Name

     
        // Inserting Row
        db.insert(TABLE_TEXTS, null, values);
        db.close(); // Closing database connection
        
        
        
    }
    
    public Texttosavesqllite getText(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
     
        Cursor cursor = db.query(TABLE_TEXTS, new String[] { KEY_ID,
                KEY_TEXT }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
     
        Texttosavesqllite text = new Texttosavesqllite(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1));
        // return contact
        return text;
    }
    
    public int updateContact(Texttosavesqllite contact) {
        SQLiteDatabase db = this.getWritableDatabase();
     
        ContentValues values = new ContentValues();
        values.put(KEY_TEXT, contact.getText());

     
        // updating row
        return db.update(TABLE_TEXTS, values, KEY_ID + " = ?",
                new String[] { String.valueOf(contact.getID()) });
    }
    public void deleteText(Texttosavesqllite contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_TEXTS, KEY_ID + " = ?",
                new String[] { String.valueOf(contact.getID()) });
        db.close();
    }
    
    
}