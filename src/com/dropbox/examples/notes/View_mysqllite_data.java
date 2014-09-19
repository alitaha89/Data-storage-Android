
package com.dropbox.examples.notes;



import java.util.List;

import com.dropbox.examples.notes.R;
 

import android.app.Activity;


import android.os.Bundle;

import android.util.Log;
import android.widget.EditText;




 
public class View_mysqllite_data extends Activity {
 

  private EditText texttoview;


  @Override
  public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.view_mysqllite_data);
	
	texttoview = (EditText) findViewById(R.id.texttoview);
	
	// Reading all contacts
   Log.d("Reading: ", "Reading all contacts.."); 
    DatabaseHandler db = new DatabaseHandler(this);
    List<Texttosavesqllite> texts = db.getAllTexts();       
    String log="";
    for (Texttosavesqllite cn : texts) {
    	log += "Id: "+cn.getID()+" ,text: " + cn.getText()+"; ";
            // Writing Contacts to log
    Log.d("Name: ", log);
    }
	
	texttoview.setText(log);
  } 

 

  
  
  
  

  
  
  



	


 
}