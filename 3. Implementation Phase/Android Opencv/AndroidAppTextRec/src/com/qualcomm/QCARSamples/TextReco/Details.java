package com.qualcomm.QCARSamples.TextReco;
 
public class Details {
  
 private String code = "";
 private String name = "";
 private int population = 0;
  
 public Details(String code, String name, int population) {
  super();
  this.code = code;
  this.name = name;
  this.population = population;
 }
  
 public String getCode() {
  return code;
 }
 public void setCode(String code) {
  this.code = code;
 }
 public String getName() {
  return name;
 }
 public void setName(String name) {
  this.name = name;
 }
 public int getPopulation() {
  return population;
 }
 public void setPopulation(int population) {
  this.population = population;
 }
  
}