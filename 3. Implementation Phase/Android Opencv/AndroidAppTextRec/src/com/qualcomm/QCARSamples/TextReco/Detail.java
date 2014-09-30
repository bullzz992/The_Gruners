package com.qualcomm.QCARSamples.TextReco;

public class Detail {
	
	private String title = "";
	private String info = "";
	
	public Detail(String _title, String _info) {
		  super();
		  this.title = _title;
		  this.info = _info;
		 }
	
	public String getTitle() {
		  return title;
		 }
	public String getInfo() {
		  return info;
		 }
	
	public void setTitle(String _title) {
		  this.title = _title;
		 }
	public void setInfo(String _info) {
		  this.info = _info;
		 }

}
