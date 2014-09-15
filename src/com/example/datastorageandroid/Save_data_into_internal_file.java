package com.example.datastorageandroid;

 

import com.example.datastorageandroid.ClassFile;
 

import android.app.Activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;


 
public class Save_data_into_internal_file extends Activity {
 

  private EditText texttosave;
  private Button button;
  

  @Override
  public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.save_data_into_internal_file);
	
	texttosave = (EditText) findViewById(R.id.texttosave);
	button = (Button) findViewById(R.id.button);
	
	addListenerOnButton();
  } 

 



  public void addListenerOnButton()  {
 

	
	
	
	
	button.setOnClickListener(new OnClickListener() {
 
	  @Override
	  public void onClick(View v) {
		
		  button.setEnabled(false);
		  
		  try{
				if(texttosave.getText().toString() != null && !texttosave.getText().toString() .equals("")){
					
					
					ClassFile sfile = new ClassFile();
					  
					sfile.SaveDataFile(texttosave.getText().toString());
					
					texttosave.setText("");
					
					
					 
					 Toast.makeText(Save_data_into_internal_file.this, "saved localy",Toast.LENGTH_LONG).show();
					 
				     
				
				}else{
					Toast.makeText(Save_data_into_internal_file.this, "text is required",Toast.LENGTH_LONG).show();
					
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