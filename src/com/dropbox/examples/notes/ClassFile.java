package com.dropbox.examples.notes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class ClassFile{

	public String RdFisle(String fileLocation){
		 String returnVal="";
		 int content;
		File file = new File(fileLocation);
		if(file.exists()){
			 try{
				FileInputStream fis = new FileInputStream(file);
	 
				
				 while ((content = fis.read()) != -1) {
					
					 // convert to char 
					 returnVal += (char) content;
					 
				 } 
				 fis.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
		return returnVal;
	}
	
	public String ReadDataFile(){
		
		
		return RdFisle("/data/data/com.example.datastorageandroid/data.txt");
		
	} 
	
	 public void deleteDataFile(){
		 
		
		 File file = new File("/data/data/com.example.datastorageandroid/data.txt");
		 file.delete();
	  }

	 
	 

		public void SaveDataFile(String text){
			
			 try {
				
				
	             File myFile = new File("/data/data/com.example.datastorageandroid/data.txt");
	             myFile.createNewFile();
	             FileOutputStream fOut = new FileOutputStream(myFile,true);
	             OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
	            
	             myOutWriter.append(text);
	             myOutWriter.close();
	             fOut.close();
	            
	         } catch (Exception e) {
	             
	         }
			
		}
		
}