package com.example.datastorageandroid;

 

import java.util.List;
 
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
 
public class Save_data_into_mysqllite_database extends Activity {
	private EditText texttosave;
	  private Button button;
	  private Button buttonview;
	  private Button buttonempty;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.save_data_into_mysqllite_database);
         
        texttosave = (EditText) findViewById(R.id.texttosave);
    	button = (Button) findViewById(R.id.button);
    	buttonview = (Button) findViewById(R.id.buttonview);
    	buttonempty = (Button) findViewById(R.id.buttonempty);
        
        addListenerOnButton();
        
        
         
        // Reading all contacts
        Log.d("Reading: ", "Reading all contacts.."); 
        /*List<Contact> contacts = db.getAllContacts();       
         
        for (Contact cn : contacts) {
            String log = "Id: "+cn.getID()+" ,Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNumber();
                // Writing Contacts to log
        Log.d("Name: ", log);
    }*/
    }
    
    public void addListenerOnButton()  {

    	
    	button.setOnClickListener(new OnClickListener() {
     
    	  @Override
    	  public void onClick(View v) {
    		
    		  button.setEnabled(false);
    		  
    		  try{
    				if(texttosave.getText().toString() != null && !texttosave.getText().toString() .equals("")){
    					
    					
    					
    					
    					
    					
    					DatabaseHandler db = new DatabaseHandler(Save_data_into_mysqllite_database.this);
    			         
    			        
    			        Log.d("Insert: ", "Inserting .."); 
    			        db.addText(new Texttosavesqllite(texttosave.getText().toString()));        
    			        texttosave.setText("");
    					 
    					 Toast.makeText(Save_data_into_mysqllite_database.this, "saved localy into mysqllite database",Toast.LENGTH_LONG).show();
    					 
    				     
    				
    				}else{
    					Toast.makeText(Save_data_into_mysqllite_database.this, "text is required",Toast.LENGTH_LONG).show();
    					
    				}
    			} catch (Exception  e) {
    		        // TODO Auto-generated catch block
    		        e.printStackTrace();
    		    }
    		  
    		  
    		  button.setEnabled(true);
    		 
    	  }
     
    	});
      }
    
    
}