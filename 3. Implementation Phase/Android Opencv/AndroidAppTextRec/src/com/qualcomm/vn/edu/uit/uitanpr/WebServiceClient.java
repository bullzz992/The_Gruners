package com.qualcomm.vn.edu.uit.uitanpr;

//import org.json.JSONArray;
//import org.json.JSONObject;
import com.sun.jersey.api.client.*;
import org.json.*;


public class WebServiceClient {

	String NumberPlate;
	JSONArray vehicles = null;
	JSONArray owners = null;
	
	public WebServiceClient(String NumPlate)
	{
		NumberPlate = NumPlate;
	}
	
	public void executePOSTRequest() throws JSONException
	{
		Client client = new Client();
		WebResource res = client.resource("http://192.168.137.1:8080/WebServiceApplication/webresources/entity.owner");
		
		ClientResponse response = res.accept("application/json").get(ClientResponse.class);
		String output = response.getEntity(String.class);
		String s = output;
		
		owners = new JSONArray(output);
		
		/*for (int i = 0; i < projectArray.length(); i++) {
		    JSONObject proj = projectArray.getJSONObject(i);
		    
		    if(proj.getInt("ownerId")  == 1)
		    {
		    	System.out.println(proj);
		    }
		    
		}*/
		
		Client client2 = new Client();
		WebResource res2 = client2.resource("http://192.168.137.1:8080/WebServiceApplication/webresources/entity.vehicle");
		
		ClientResponse response2 = res2.accept("application/json").get(ClientResponse.class);
		String output2 = response2.getEntity(String.class);
		//String s = output;
		
		owners = new JSONArray(output2);
		
		
		
	}
	
	public JSONObject getOwnerDetails(int id) throws JSONException
	{
		JSONObject result = null;
		for (int i = 0; i < owners.length(); i++) {
		    JSONObject proj = owners.getJSONObject(i);
		    
		    if(proj.getInt("ownerId")  == 1)
		    {
		    	result = proj;
		    	break;
		    }
		    
		}
		return result;
	}
	
	public int getVehiclOwner(String numP)
	{
		return -1;
	}
}
