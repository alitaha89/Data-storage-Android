package com.dropbox.examples.notes;

import com.dropbox.examples.notes.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

public class view_internal_file_data extends Activity {
 

  private EditText texttoview;


  @Override
  public void onCreate(Bundle savedInstanceState) {
	  
	super.onCreate(savedInstanceState);
	setContentView(R.layout.view_internal_file_data);
	texttoview = (EditText) findViewById(R.id.texttoview);
	ClassFile sfile = new ClassFile(); 
	sfile.ReadDataFile().toString();
	texttoview.setText(sfile.ReadDataFile().toString());
	
  } 

 

  
  
  
  

  
  
  



	


 
}