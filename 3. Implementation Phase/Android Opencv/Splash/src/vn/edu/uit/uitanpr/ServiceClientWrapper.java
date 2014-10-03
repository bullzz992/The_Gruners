package vn.edu.uit.uitanpr;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;


public class ServiceClientWrapper {
	
	public JSONArray owners;
	public JSONArray vehicles;
	public JSONArray features;
	public JSONArray detections;
	
	
	
	public ServiceClientWrapper()
	{
		//Populate Owner JSON Array
		try
		{
			String sampleURL = "http://192.168.43.226:8080/WebServiceApplication/webresources/entity.owner";
			
			HttpGet  get = new HttpGet(sampleURL);
			
			get.addHeader("accept", "application/json");
			
			HttpClient httpclient = new DefaultHttpClient();
			
	        HttpResponse response = httpclient.execute(get);
	       
			Scanner in = new Scanner(response.getEntity().getContent());
	        String line ="";
	            
	        while(in.hasNextLine()){
	            line += in.nextLine();
	        }
	            
	        owners = new JSONArray(line);
	        //Log.i("I'm here------------Features---------------", "Found: " + owners);
		}
		catch(Exception ex)
		{
			Log.i("I'm here------------Features---------------", "Found: " + owners + ex.getLocalizedMessage());
		}
		
		//Populate Vehicle JSON ARRAY
		try
		{
			String sampleURL = "http://192.168.43.226:8080/WebServiceApplication/webresources/entity.vehicle";
			
			HttpGet  get = new HttpGet(sampleURL);
			
			get.addHeader("accept", "application/json");
			
			HttpClient httpclient = new DefaultHttpClient();
			
	        HttpResponse response = httpclient.execute(get);
	       
			Scanner in = new Scanner(response.getEntity().getContent());
	        String line ="";
	            
	        while(in.hasNextLine()){
	            line += in.nextLine();
	        }
	            
	        vehicles = new JSONArray(line);
	        //Log.i("I'm here------------Features---------------", "Found: " + vehicles);
		}catch(Exception ex)
		{
			Log.i("I'm here------------Features---------------", "Found: " + vehicles + ex.getMessage());
		}
		
		
		
		//PopulateFeatures
		//http://localhost:8080/WebServiceApplication/webresources/entity.vehiclefeatures
		try
		{
			String sampleURL = "http://192.168.43.226:8080/WebServiceApplication/webresources/entity.vehiclefeatures";
			
			HttpGet  get = new HttpGet(sampleURL);
			
			get.addHeader("accept", "application/json");
			
			HttpClient httpclient = new DefaultHttpClient();
			
	        HttpResponse response = httpclient.execute(get);
	       
			Scanner in = new Scanner(response.getEntity().getContent());
	        String line ="";
	            
	        while(in.hasNextLine()){
	            line += in.nextLine();
	        }
	            
	        features = new JSONArray(line);
	        //Log.i("I'm here------------Features---------------", "Found: " + features);
		}catch(Exception ex)
		{
			Log.i("I'm here------------Features---------------", "Found: " + features + ex.getCause());
		}
		
		//PopulateDetections
		try
		{
			String sampleURL = "http://192.168.43.226:8080/WebServiceApplication/webresources/entity.detection";
			
			HttpGet  get = new HttpGet(sampleURL);
			
			get.addHeader("accept", "application/json");
			
			HttpClient httpclient = new DefaultHttpClient();
			
	        HttpResponse response = httpclient.execute(get);
	       
			Scanner in = new Scanner(response.getEntity().getContent());
	        String line ="";
	            
	        while(in.hasNextLine()){
	            line += in.nextLine();
	        }
	            
	        detections = new JSONArray(line);
	        //Log.i("I'm here------------Features---------------", "Found: " + features);
		}catch(Exception ex)
		{
			Log.i("I'm here------------Features---------------", "Found: " + features + ex.getCause());
		}
		
		
	}
	
	public JSONObject getOwnerDetails(int id) throws JSONException
	{
		JSONObject result = null;
		for (int i = 0; i < owners.length(); i++) {
		    JSONObject proj = owners.getJSONObject(i);
		    
		    if(proj.getInt("ownerId")  == id)
		    {
		    	result = proj;
		    	break;
		    }
		    
		}
		return result;
	}
	

	public JSONObject getFeatureDetails(int id) throws JSONException
	{
		JSONObject result = null;
		for (int i = 0; i < features.length(); i++) {
		    JSONObject proj = features.getJSONObject(i);
		    
		    if(proj.getInt("featureId")  == id)
		    {
		    	result = proj;
		    	break;
		    }
		    
		}
		return result;
	}
	
	
	public JSONObject getVehicleDetails(String num) throws JSONException
	{
		JSONObject result = null;
		for (int i = 0; i < vehicles.length(); i++) {
		    JSONObject proj = vehicles.getJSONObject(i);
		    
		    if(proj.getString("numberPlate").equalsIgnoreCase(num))
		    {
		    	result = proj;
		    	break;
		    }
		    
		}
		return result;
	}
	
	public int getOwnerID(String num) throws JSONException
	{
		int result = -1;
		for (int i = 0; i < vehicles.length(); i++) {
		    JSONObject proj = vehicles.getJSONObject(i);
		    
		    if(proj.getString("numberPlate").equalsIgnoreCase(num))
		    {
		    	result = proj.getInt("ownerId");
		    	break;
		    }
		    
		}
		return result;
	}
	
	public boolean somethingWrong(String num) throws JSONException
	{
		
		boolean result = false;
		
		for (int i = 0; i < vehicles.length(); i++) {

			JSONObject proj = vehicles.getJSONObject(i);

			if(proj.getString("numberPlate").equals(num))
		    {
				if(proj.getString("fines").equals("fines") || proj.getString("stolen").equals("stolen") || !proj.getString("roadworthy").equals("roadworthy"))
		    	result = true;
		    	break;
		    }
		    
		}
		return result;
	}
	
	public int getFeatureID(String num) throws JSONException
	{
		int result = -1;
		for (int i = 0; i < vehicles.length(); i++) {
		    JSONObject proj = vehicles.getJSONObject(i);
		    
		    if(proj.getString("numberPlate").equalsIgnoreCase(num))
		    {
		    	result = proj.getInt("featureId");
		    	break;
		    }
		    
		}
		return result;
	}
	
	public boolean vehicleFound(String num) throws JSONException
	{
		//Log.i("I'm here-------------------------------------", "Checking if vehicle is found: "+ vehicles + "--" + owners); 
		boolean result = false;
		//Log.i("I'm here------------Loop Count---------------", "Num Vehicles: " + vehicles.length());
		for (int i = 0; i < vehicles.length(); i++) {
			//Log.i("I'm here------------Loop Count---------------", "Found: " + result);
		    JSONObject proj = vehicles.getJSONObject(i);
		    //Log.i("I'm here------------Loop Count---------------", "Found: " + proj.getString("numberPlate") + " --- " + num);
		    if(proj.getString("numberPlate").equals(num))
		    {
		    	result = true;
		    	Log.i("Found Function-------------------------------------", "Found: " + result); 
		    	break;
		    }
		    
		}
		Log.i("OUT OF LOOP-------------------------------------", "Found: " + result);
		return result;
	}
	
	
	public int generateDetectionID()
	{
		Random rand = new Random();
		return detections.length()+ 1 + rand.nextInt();
	}
	
	public void inSertDetection(String time, String location, String deviceIP, String numPlate)
	{
		 List<NameValuePair> request = new ArrayList<NameValuePair>();
		 request.add(new BasicNameValuePair("detectionId", generateDetectionID() + ""));
		 request.add(new BasicNameValuePair("date", time));
		 request.add(new BasicNameValuePair("location", location));
		 request.add(new BasicNameValuePair("deviceIp", deviceIP));
		 request.add(new BasicNameValuePair("featureId", "-1"));
		 request.add(new BasicNameValuePair("numberplate", numPlate));
		 
		 DefaultHttpClient client = new DefaultHttpClient();
         HttpPost post = new HttpPost("http://192.168.43.226:8080/WebServiceApplication/webresources/entity.detection");
         
         UrlEncodedFormEntity entity;
		try {
			entity = new UrlEncodedFormEntity(request,HTTP.UTF_8);
			post.setEntity(entity);
	         
	         HttpResponse response = client.execute(post);
	         Scanner in = new Scanner(response.getEntity().getContent());
	            String line ="";
	            
	            while(in.hasNextLine()){
	                line += in.nextLine();
	            }
	         Log.i("Sent Request?:---------  ", line);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
	}
}
