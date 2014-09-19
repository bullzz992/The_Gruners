package com.qualcomm.QCARSamples.TextReco;
public class Detections {
	
	//private variables
	int _id;
	String _numberPlate;
	String _location;
	String _time;
	
	// Empty constructor
	public Detections(){
		
	}
	// constructor
	public Detections(int id,String np, String loc, String tim){
		this._id = id;
		this._numberPlate = np;
		this._location = loc;
		this._time = tim;
	}
	// getting palte
	public String getNumberPlate(){
		return this._numberPlate;
	}
	
	// setting plate
	public void setNumberPalte(String np){
		this._numberPlate = np;
	}
	// getting ID
		public int getID(){
			return this._id;
		}
		
		// setting id
		public void setID(int id){
			this._id = id;
		}
	
	// getting name
	public String getLocation(){
		return this._location;
	}
	
	// setting name
	public void setLocation(String loc){
		this._location = loc;
	}
	
	// getting phone number
	public String getTime(){
		return this._time;
	}
	
	// setting phone number
	public void setTime(String tim){
		this._time = tim;
	}
}
