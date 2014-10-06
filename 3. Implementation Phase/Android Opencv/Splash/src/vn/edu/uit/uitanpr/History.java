package vn.edu.uit.uitanpr;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import org.json.JSONObject;

import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.util.Log;
import android.view.Menu;
import android.widget.ExpandableListView;
import android.widget.SearchView;
import android.widget.Toast;

public class History extends Activity implements 
SearchView.OnQueryTextListener, SearchView.OnCloseListener{
	
	 private SearchView search;
	 private ListAdapter listAdapter;
	 private ExpandableListView myList;
	 private ArrayList<NumberPlate> numPlateList = new ArrayList<NumberPlate>();
	 ServiceClientWrapper RESTWrapper = new ServiceClientWrapper(); 	
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.detections);
	         
	        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
	  search = (SearchView) findViewById(R.id.search);
	  search.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
	  search.setIconifiedByDefault(false);
	  search.setOnQueryTextListener(this);
	  search.setOnCloseListener(this);
	   
	  //display the list
	  	try {
	  		displayList();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  //expand all Groups
	  //expandAll();
	 
	    }
	    public boolean onCreateOptionsMenu(Menu menu) {
	   //     getMenuInflater().inflate(R.menu.h, menu);
	       return true;
	    }
	     
	    //method to expand all groups
	 private void expandAll() {
	  int count = listAdapter.getGroupCount();
	  for (int i = 0; i < count; i++){
	   myList.expandGroup(i);
	  }
	 }
	  
	 //method to expand all groups
	 private void displayList() throws IOException {
	   
		 Log.e("I'm here", "ERRRRRRRRRRRRRRRROR");
	  //display the list
	  loadSomeData();
	  //get reference to the ExpandableListView
	  myList = (ExpandableListView) findViewById(R.id.expandableList);
	  //create the adapter by passing your ArrayList data
	 listAdapter = new ListAdapter(History.this, numPlateList);
	  //attach the adapter to the list
	  myList.setAdapter(listAdapter);
	   
	 
	 }
	 
	 private ArrayList<Detail> getVehicleDetails(String num)
	 {
		 //RESTWrapper = new ServiceClientWrapper();
		 Log.i("I'm here-------------------------------------", "GETTING Vechile Details: " + RESTWrapper); 
		 ArrayList<Detail> details = null;
		 try{
			 Log.i("I'm here-------------------------------------", "GETTING Vechile Details: " + RESTWrapper); 
			 if(RESTWrapper.vehicleFound(num) == true)
			 {
				 Log.i("After vehicle found Returns-------------------------------------", "Found?: " + RESTWrapper.vehicleFound(num));
				 details = new ArrayList<Detail>();
			 
				 int ownerID = RESTWrapper.getOwnerID(num);
				 int featureID = RESTWrapper.getFeatureID(num);
				 
				 JSONObject vehicle = RESTWrapper.getVehicleDetails(num);
				 JSONObject owner = RESTWrapper.getOwnerDetails(ownerID);
				 JSONObject features = RESTWrapper.getFeatureDetails(featureID);
				 Log.i("Details Found-------------------------------------", "Found?: " + ownerID+"-"+featureID +"-" + owner + "-" + vehicle + "-" + features);

				 Log.i("I'm here-------------------------------------", "SUCCESSFUL DATA RETRIEVAL"); 
				 
				 Detail nameDetail = new Detail("Name: ", owner.getString("name"));
				 details.add(nameDetail);
				 
				 Detail typeDetail = new Detail("Type: ", owner.getString("type"));
				 details.add(typeDetail);
				 
				 Detail idOrRegNumberDetail = new Detail("ID/Reg: ", owner.getString("idOrRegNumber"));
				 details.add(idOrRegNumberDetail);
				 
				 Detail stolenDetail = new Detail("Stolen?: ", vehicle.getString("stolen"));
				 details.add(stolenDetail);
				 
				 Detail finesDetail = new Detail("fines?: ", vehicle.getString("fines"));
				 details.add(finesDetail);
				 
				 Detail roadworthyDetail = new Detail("roadworthy?: ", vehicle.getString("roadworthy"));
				 details.add(roadworthyDetail);
	
				 Detail makeDetail = new Detail("Make: ", features.getString("make"));
				 details.add(makeDetail);
				 
				 Detail modelDetail = new Detail("Model: ", features.getString("model"));
				 details.add(modelDetail);
				 
				 Detail colourDetail = new Detail("Colour: ", features.getString("colour"));
				 details.add(colourDetail);
			 
			 
			 }
			 
			 //return details;
		 }catch(Exception e)
		 {
			 Log.e("I'm here", e.getLocalizedMessage()); 
		 }
		 
		 
		 return details;
	 }
	 
	 private void loadSomeData() throws IOException {
		 Log.i("I'm here", "LOADING SOME DATA"); 
		 try {
			BufferedReader reader = new BufferedReader(new FileReader(Environment.getExternalStorageDirectory() + "/NP-History.txt"));
			ArrayList<Detail> numPlateDetails;
			String line = "";
			while ((line = reader.readLine()) != null) {
				if(line.length() > 2)
				{
					numPlateDetails = getVehicleDetails(line);
					
					if(numPlateDetails == null)
					{
						numPlateDetails = new ArrayList<Detail>();
						Detail obj = new Detail("UNKNOWN PLATE: ","Reg Num not in DB.");
						numPlateDetails.add(obj);
						NumberPlate continent = new NumberPlate(line,numPlateDetails);
						numPlateList.add(continent);
					}
					else
					{
						//numPlateDetails.add(obj);
						NumberPlate continent = new NumberPlate(line,numPlateDetails);
						numPlateList.add(continent);
					}
					
					
					
				}
		    }
			
			Collections.reverse(numPlateList);
		 
		 } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			 Log.i("I'm here-------------------------------------", e.getLocalizedMessage()); 
		}
		    
		    //String line;
		    
		 
		 
		 
		  /*ArrayList<Detail> countryList = new ArrayList<Detail>();
		  Detail country = new Detail("BMU","Bermuda");
		  countryList.add(country);
		  country = new Detail("CAN","Canada");
		  countryList.add(country);
		  country = new Detail("USA","United States");
		  countryList.add(country);
		   
		  NumberPlate continent = new NumberPlate("North America",countryList);
		  numPlateList.add(continent);
		  
		  countryList = new ArrayList<Detail>();
		  country = new Detail("CHN","China");
		  countryList.add(country);
		  country = new Detail("JPN","Japan");
		  countryList.add(country);
		  country = new Detail("THA","Thailand");
		  countryList.add(country);
		   
		  continent = new NumberPlate("Asia",countryList);
		  numPlateList.add(continent);
		  
		  countryList = new ArrayList<Detail>();
		  country = new Detail("CHN","China");
		  countryList.add(country);
		  country = new Detail("JPN","Japan");
		  countryList.add(country);
		  country = new Detail("THA","Thailand");
		  countryList.add(country);
		   
		  continent = new NumberPlate("JOAS",countryList);
		  numPlateList.add(continent);*/
		  
		  
		 }
		 
		 
		 public boolean onClose() {
		  listAdapter.filterData("");
		  expandAll();
		  return false;
		 }
		 
		 
		 public boolean onQueryTextChange(String query) {
		  listAdapter.filterData(query);
		  expandAll();
		  return false;
		 }
		 
		 
		 public boolean onQueryTextSubmit(String query) {
		  listAdapter.filterData(query);
		  expandAll();
		  return false;
		 }
	  
}
