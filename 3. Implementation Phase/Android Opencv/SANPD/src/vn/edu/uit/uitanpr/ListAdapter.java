package vn.edu.uit.uitanpr;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
 
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

public class ListAdapter extends BaseExpandableListAdapter{

	private Context context;
	private ArrayList<NumberPlate> numberPlateList;
	private ArrayList<NumberPlate> originalList;
	 
	public ListAdapter(Context context, ArrayList<NumberPlate> numberPlateList) {
		  this.context = context;
		  this.numberPlateList = new ArrayList<NumberPlate>();
		  this.numberPlateList.addAll(numberPlateList);
		  this.originalList = new ArrayList<NumberPlate>();
		  this.originalList.addAll(numberPlateList);
		 }
	 public Object getChild(int groupPosition, int childPosition) {
	  ArrayList<Detail> countryList = numberPlateList.get(groupPosition).getDetailList();
	  return countryList.get(childPosition);
	 }
	 
	 public long getChildId(int groupPosition, int childPosition) {
	  return childPosition;
	 }
	 public View getChildView(int groupPosition, int childPosition, boolean isLastChild, 
	   View view, ViewGroup parent) {
	   
	  Detail detail = (Detail) getChild(groupPosition, childPosition);
	  if (view == null) {
	   LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	   view = layoutInflater.inflate(R.layout.details, null);
	  }
	  TextView code = (TextView) view.findViewById(R.id.code);
	  TextView name = (TextView) view.findViewById(R.id.name);
	  TextView population = (TextView) view.findViewById(R.id.population);
	  code.setText(" ");
	  name.setText(detail.getTitle().trim());
	  population.setText(detail.getInfo().trim());
	   
	  return view;
	 }
	 
	 public int getChildrenCount(int groupPosition) {
	   
	  ArrayList<Detail> detailList = numberPlateList.get(groupPosition).getDetailList();
	  return detailList.size();
	 
	 }
	 
	 public Object getGroup(int groupPosition) {
	  return numberPlateList.get(groupPosition);
	 }
	 
	 public int getGroupCount() {
	  return numberPlateList.size();
	 }
	 
	 public long getGroupId(int groupPosition) {
	  return groupPosition;
	 }
	 
	 public View getGroupView(int groupPosition, boolean isLastChild, View view,
	   ViewGroup parent) {
	   
	  NumberPlate numberPlate = (NumberPlate) getGroup(groupPosition);
	  if (view == null) {
	   LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	   view = layoutInflater.inflate(R.layout.group, null);
	  }
	   
	  TextView heading = (TextView) view.findViewById(R.id.heading);
	  heading.setText(numberPlate.getNumberPlate().trim());
	   
	  return view;
	 }

	 public boolean hasStableIds() {
	  return true;
	 }
	 
	 public boolean isChildSelectable(int groupPosition, int childPosition) {
	  return true;
	 }
	  
	 public void filterData(String query){
	   
	  query = query.toLowerCase();
	  Log.v("ListAdapter", String.valueOf(numberPlateList.size()));
	  numberPlateList.clear();
	   
	  if(query.isEmpty()){
		  numberPlateList.addAll(originalList);
	  }
	  else {
	    
	   for(NumberPlate numberPlate: originalList){
	     
	    ArrayList<Detail> detailList = numberPlate.getDetailList();
	    ArrayList<Detail> newList = new ArrayList<Detail>();
	    for(Detail detail: detailList){
	     if(detail.getInfo().toLowerCase().contains(query) ||
	    		numberPlate.getNumberPlate().toLowerCase().contains(query) ||
	       detail.getTitle().toLowerCase().contains(query)){
	      newList.add(detail);
	     }
	    }
	    if(newList.size() > 0){
	     NumberPlate nContinent = new NumberPlate(numberPlate.getNumberPlate(),newList);
	     numberPlateList.add(nContinent);
	    }
	   }
	  }
	   
	  Log.v("ListAdapter", String.valueOf(numberPlateList.size()));
	  notifyDataSetChanged();
	   
	 }
}
