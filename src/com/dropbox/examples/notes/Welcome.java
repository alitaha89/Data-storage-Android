package com.dropbox.examples.notes;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Welcome extends Activity{
	
	@Override
	protected void onCreate(Bundle AliTaha) {
		// TODO Auto-generated method stub
		super.onCreate(AliTaha);
		setContentView(R.layout.welcome);
		Thread timer  = new Thread(){
			public void run(){
				try{
					
					sleep(500);
					
				} catch (InterruptedException e){
					e.printStackTrace();
				}finally{
					
					
				
					
					Intent openStartingPoint = new Intent("com.dropbox.examples.MENU");
					startActivity(openStartingPoint);
					
				
					
					
				}
				
				
			}
			
			
		};
		timer.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
	
	

}
