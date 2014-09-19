package com.qualcomm.QCARSamples.TextReco;
 
import java.util.ArrayList;
 
public class NumberPlate {
  
 private String name;
 private ArrayList<Details> detailList = new ArrayList<Details>();
  
 public NumberPlate(String name, ArrayList<Details> _details) {
  super();
  this.name = name;
  this.detailList = _details;
 }
 public String getName() {
  return name;
 }
 public void setName(String name) {
  this.name = name;
 }
 public ArrayList<Details> getDetailsList() {
  return detailList;
 }
 public void setDetailsList(ArrayList<Details> List) {
  this.detailList = List;
 };
  
 
}