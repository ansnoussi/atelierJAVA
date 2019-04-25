import java.util.*;
import java.util.Collections;
import java.io.*;
import java.io.FileWriter;
import java.lang.*;
public class EX2ArrayList{
	public static void  main(String []args ){
	 
	ArrayList<Etudiant> a = new ArrayList<Etudiant>();  
	Etudiant e1 = new Etudiant("Barghouda","Mohamed",1,15);
	Etudiant e2 = new Etudiant("Snoussi","Anis",2,14);
	Etudiant e3 = new Etudiant("Jarrar","Tarek",3,16);
	Etudiant e4 = new Etudiant("Baccouche","Thameur",4,12);
        a.add(e1);
        a.add(e2);
        a.add(e3);
        a.add(e4);

Collections.sort(a);
System.out.println("a= " + a);
   
	}
}