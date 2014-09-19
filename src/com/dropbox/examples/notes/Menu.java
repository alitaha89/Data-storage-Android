package com.dropbox.examples.notes;


import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Menu extends ListActivity{

	
	String classess[] = {"Save data into internal file","Save data into online file","Save data into mysqllite database","Cloud dropbox storage"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		if( savedInstanceState != null ) {
		     Toast.makeText(this, savedInstanceState .getString("message"), Toast.LENGTH_LONG).show();
		  }
		setListAdapter(new ArrayAdapter<String>(Menu.this, android.R.layout.simple_list_item_1, classess));
		
		
	}
	
	@Override
	public void onSaveInstanceState(Bundle outState) {
	   super.onSaveInstanceState(outState);
	   outState.putString("message", "This is my message to be reloaded");
	}

	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		String itemClicked = classess[position].replace(" ","_");
		try{
			Class<?> ourClass = Class.forName("com.dropbox.examples.notes." + itemClicked);
			Intent ourIntent = new Intent(Menu.this,ourClass);
			startActivity(ourIntent);
		} catch(ClassNotFoundException e){
			e.printStackTrace();
			
		}
	}

}