package com.dropbox.examples.notes;


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

import com.dropbox.examples.notes.R;



import android.app.Activity;


import android.os.AsyncTask;
import android.os.Bundle;

import android.util.Log;
import android.widget.EditText;




 
public class view_online_file_data extends Activity {
 

  private EditText texttoview;
  HttpClient client;
  HttpPost post;

  @Override
  public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.view_online_file_data);
	client = new DefaultHttpClient();
	String url="http://192.168.16.113:8888/datastorage/data.php";
	post = new HttpPost(url);
	texttoview = (EditText) findViewById(R.id.texttoview);
	  new viewOnline().execute("");
	
	
	
  } 
  
  private class viewOnline extends AsyncTask<String, Void, JSONObject>{

	  

	  @Override
	  protected JSONObject doInBackground(String... params) {
	      Log.i("thread", "Doing Something...");
	     //authentication operation
	  try{

	      List<NameValuePair> pairs = new ArrayList<NameValuePair>();   
	      pairs.add(new BasicNameValuePair("exc","view"));   
	        
	      post.setEntity(new UrlEncodedFormEntity(pairs));   
	      HttpResponse response = client.execute(post);
	      int status=response.getStatusLine().getStatusCode();

	      if(status == 200)
	      {
	          HttpEntity e=response.getEntity();
	          String data=EntityUtils.toString(e);
	          texttoview.setText(data);
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