package vn.edu.uit.uitanpr;

import java.util.ArrayList;

public class NumberPlate {
	
	private String numberPlate;
	 private ArrayList<Detail> detailList = new ArrayList<Detail>();
	  
	 public NumberPlate(String _numberPlate, ArrayList<Detail> _detailList) {
	  super();
	  this.numberPlate = _numberPlate;
	  this.detailList = _detailList;
	 }
	 public String getNumberPlate() {
		  return numberPlate;
		 }
	 public void setNumberPlate(String _numberPlate) {
		  this.numberPlate = _numberPlate;
		 }
	 public ArrayList<Detail> getDetailList() {
		  return detailList;
		 }
	public void setDetailList(ArrayList<Detail> _detailList) {
		  this.detailList = _detailList;
		 };
}
