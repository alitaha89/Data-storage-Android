package com.dropbox.examples.notes;



public class Texttosavesqllite {
     
    //private variables
    int _id;
    String _text;

     
    // Empty constructor
    public Texttosavesqllite(){
         
    }
    // constructor
    public Texttosavesqllite(int id, String text){
        this._id = id;
        this._text += text;
  
    }
     
    // constructor
    public Texttosavesqllite(String text){
        this._text = text;
       
    }
    // getting ID
    public int getID(){
        return this._id;
    }
     
    // setting id
    public void setID(int id){
        this._id = id;
    }
     
    // getting text
    public String getText(){
        return this._text;
    }
     
    // setting text
    public void setText(String text){
        this._text = text;
    }

}