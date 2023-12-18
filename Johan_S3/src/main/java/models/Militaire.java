package models;
public class Militaire extends Table{
String nom;
Integer vie;

public String getNom(){
	return this.nom;
}
public void setNom(String nom){
	this.nom=nom;
}
public Integer getVie(){
	return this.vie;
}
public void setVie(Integer vie){
	this.vie=vie;
}


public Militaire(){}
}