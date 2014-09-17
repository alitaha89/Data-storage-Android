package com.example.datastorageandroid;

 

import java.util.List;
 
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
 
public class Save_data_into_mysqllite_database extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
         
        DatabaseHandler db = new DatabaseHandler(this);
         
        /**
         * CRUD Operations
         * */
        // Inserting Contacts
        Log.d("Insert: ", "Inserting .."); 
        db.addContact(new Texttosavesqllite("Ravi"));        
        db.addContact(new Texttosavesqllite("Srinivas"));
        db.addContact(new Texttosavesqllite("Tommy"));
        db.addContact(new Texttosavesqllite("Karthik"));
         
        // Reading all contacts
        Log.d("Reading: ", "Reading all contacts.."); 
        /*List<Contact> contacts = db.getAllContacts();       
         
        for (Contact cn : contacts) {
            String log = "Id: "+cn.getID()+" ,Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNumber();
                // Writing Contacts to log
        Log.d("Name: ", log);
    }*/
    }
}