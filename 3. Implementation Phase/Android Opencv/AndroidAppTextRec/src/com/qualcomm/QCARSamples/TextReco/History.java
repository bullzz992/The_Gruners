package com.qualcomm.QCARSamples.TextReco;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.view.Menu;
import android.widget.ExpandableListView;
import android.widget.SearchView;
import android.widget.Toast;

public class History extends Activity implements 
SearchView.OnQueryTextListener, SearchView.OnCloseListener{
	
	private SearchView search;
	 private ListAdapter listAdapter;
	 private ExpandableListView myList;
	 private ArrayList<NumberPlate> continentList = new ArrayList<NumberPlate>();
	  	
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
	  displayList();
	  //expand all Groups
	  expandAll();
	 
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
	 private void displayList() {
	   
	  //display the list
	  loadSomeData();
	  //get reference to the ExpandableListView
	  myList = (ExpandableListView) findViewById(R.id.expandableList);
	  //create the adapter by passing your ArrayList data
	 listAdapter = new ListAdapter(History.this, continentList);
	  //attach the adapter to the list
	  myList.setAdapter(listAdapter);
	   
	 
	 }
	 
	 private void loadSomeData() {
		   
		  ArrayList<Detail> countryList = new ArrayList<Detail>();
		  Detail country = new Detail("BMU","Bermuda");
		  countryList.add(country);
		  country = new Detail("CAN","Canada");
		  countryList.add(country);
		  country = new Detail("USA","United States");
		  countryList.add(country);
		   
		  NumberPlate continent = new NumberPlate("North America",countryList);
		  continentList.add(continent);
		  
		  countryList = new ArrayList<Detail>();
		  country = new Detail("CHN","China");
		  countryList.add(country);
		  country = new Detail("JPN","Japan");
		  countryList.add(country);
		  country = new Detail("THA","Thailand");
		  countryList.add(country);
		   
		  continent = new NumberPlate("Asia",countryList);
		  continentList.add(continent);
		  
		  countryList = new ArrayList<Detail>();
		  country = new Detail("CHN","China");
		  countryList.add(country);
		  country = new Detail("JPN","Japan");
		  countryList.add(country);
		  country = new Detail("THA","Thailand");
		  countryList.add(country);
		   
		  continent = new NumberPlate("JOAS",countryList);
		  continentList.add(continent);
		  
		  
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
