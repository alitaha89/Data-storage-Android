package com.dropbox.examples.notes;

import java.util.ArrayList;
import java.util.List;

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
 
    // Texts table name
    private static final String TABLE_TEXTS = "texts";
 
    // Texts Table Columns names
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
    public void addText(Texttosavesqllite text) {
        SQLiteDatabase db = this.getWritableDatabase();
     
        ContentValues values = new ContentValues();
        values.put(KEY_TEXT, text.getText()); // Text Name

     
        // Inserting Row
        db.insert(TABLE_TEXTS, null, values);
        db.close(); // Closing database connection
        
        
        
    }
    
    
    public List<Texttosavesqllite> getAllTexts() {
        List<Texttosavesqllite> texttList = new ArrayList<Texttosavesqllite>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_TEXTS;
 
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
 
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
            	Texttosavesqllite text = new Texttosavesqllite();
            	text.setID(Integer.parseInt(cursor.getString(0)));
            	text.setText(cursor.getString(1));

                // Adding text to list
            	texttList.add(text);
            } while (cursor.moveToNext());
        }
 
        // return text list
        return texttList;
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
        // return text
        return text;
    }
    
    public int updateText(Texttosavesqllite text) {
        SQLiteDatabase db = this.getWritableDatabase();
     
        ContentValues values = new ContentValues();
        values.put(KEY_TEXT, text.getText());

     
        // updating row
        return db.update(TABLE_TEXTS, values, KEY_ID + " = ?",
                new String[] { String.valueOf(text.getID()) });
    }
    public void deleteText(Texttosavesqllite text) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_TEXTS, KEY_ID + " = ?",
                new String[] { String.valueOf(text.getID()) });
        db.close();
    }
    public void deleteAllText() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_TEXTS, null,null);
        db.close();
    }
    
}