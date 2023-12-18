package models;
public class Olona extends Table{
String nom;
Integer age;
String travail;
String adresse;

public String getNom(){
	return this.nom;
}
public void setNom(String nom){
	this.nom=nom;
}
public Integer getAge(){
	return this.age;
}
public void setAge(Integer age){
	this.age=age;
}
public String getTravail(){
	return this.travail;
}
public void setTravail(String travail){
	this.travail=travail;
}
public String getAdresse(){
	return this.adresse;
}
public void setAdresse(String adresse){
	this.adresse=adresse;
}


public Olona(){}
}