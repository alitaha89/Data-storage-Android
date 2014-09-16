package com.example.datastorageandroid;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



 
public class Save_data_into_online_file extends Activity {
 

  private EditText texttosave;
  private Button button;
  private Button buttonview;
  private Button buttonempty;
  HttpClient client;
  HttpPost post;
  @Override
  public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.save_data_into_online_file);
	
	
	
	
	texttosave = (EditText) findViewById(R.id.texttosave);
	button = (Button) findViewById(R.id.button);
	buttonview = (Button) findViewById(R.id.buttonview);
	buttonempty = (Button) findViewById(R.id.buttonempty);
	
	addListenerOnButtonview();
	client = new DefaultHttpClient();
	String url="http://192.168.16.113:8888/datastorage/data.php";
	post = new HttpPost(url);
	button.setOnClickListener(new View.OnClickListener() {

	    public void onClick(View arg0) {
	        new saveOnline().execute("");
	        Toast.makeText(Save_data_into_online_file.this, "saved online",Toast.LENGTH_LONG).show();
	    }
	});
	
	buttonempty.setOnClickListener(new View.OnClickListener() {

	    public void onClick(View arg0) {
	        new deleteOnline().execute("");
	        Toast.makeText(Save_data_into_online_file.this, "online file deleted",Toast.LENGTH_LONG).show();
	    }
	});
	
  } 

  public void addListenerOnButtonview()  {
		
	  buttonview.setOnClickListener(new OnClickListener() {
 
	  @Override
	  public void onClick(View v) {
		  try{
				Class<?> ourClass = Class.forName("com.example.datastorageandroid.view_online_file_data");
				Intent ourIntent = new Intent(Save_data_into_online_file.this,ourClass);
				startActivity(ourIntent);
			} catch(ClassNotFoundException e){
				e.printStackTrace();
				
			}
		 
	  }
 
	});
  }
  
  
  private class saveOnline extends AsyncTask<String, Void, JSONObject>{

	  

	  @Override
	  protected JSONObject doInBackground(String... params) {
	      Log.i("thread", "Doing Something...");
	     //authentication operation
	  try{

	      List<NameValuePair> pairs = new ArrayList<NameValuePair>();   
	      pairs.add(new BasicNameValuePair("data",texttosave.getText().toString()));   
	        
	      post.setEntity(new UrlEncodedFormEntity(pairs));   
	      HttpResponse response = client.execute(post);
	      int status=response.getStatusLine().getStatusCode();

	      if(status == 200)
	      {
	          HttpEntity e=response.getEntity();
	          String data=EntityUtils.toString(e);
	          JSONObject last=new JSONObject(data);
	          return last;

	      }

	  }

	    catch(Exception e)
	  {
	      e.printStackTrace();   

	  }

	      return null;
	  }

  }
  
  private class deleteOnline extends AsyncTask<String, Void, JSONObject>{

	  

	  @Override
	  protected JSONObject doInBackground(String... params) {
	      Log.i("thread", "Doing Something...");
	     //authentication operation
	  try{

	      List<NameValuePair> pairs = new ArrayList<NameValuePair>();   
	      pairs.add(new BasicNameValuePair("exc","del"));   
	        
	      post.setEntity(new UrlEncodedFormEntity(pairs));   
	      HttpResponse response = client.execute(post);
	      int status=response.getStatusLine().getStatusCode();

	      if(status == 200)
	      {
	          HttpEntity e=response.getEntity();
	          String data=EntityUtils.toString(e);
	          JSONObject last=new JSONObject(data);
	          return last;

	      }

	  }

	    catch(Exception e)
	  {
	      e.printStackTrace();   

	  }

	      return null;
	  }

  }

  
  
  
}