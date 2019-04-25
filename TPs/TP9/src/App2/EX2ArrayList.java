import java.util.*;
import java.util.Collections;
import java.io.*;
import java.io.FileWriter;
import java.lang.*;

public class EX2ArrayList {

 public static String getArrayList(ArrayList < Etudiant > a) {
  String res = "";
  for (int i = 0; i < a.size(); i++) {
   Etudiant aux = a.get(i);
   res = res + aux.nom + ":" + aux.prenom + ":" + aux.id + ":" + aux.moy + " \n";
  }
  return res;
 }



 public static void main(String[] args) {

  ArrayList < Etudiant > a = new ArrayList < Etudiant > ();
  try {
   InputStream is = new FileInputStream("etudiants.txt");
   InputStreamReader s1 = new InputStreamReader(is);
   BufferedReader b = new BufferedReader(s1);
   String ligne = "";
   String[] s = new String[10];
   int l = 0, i = 0;
   while ((ligne = b.readLine()) != null) {
    s[i] = ligne;
    i++;
   }
   b.close();
   String[][] tokens = new String[i][4];

   for (int k = 0; k < tokens.length; k++) {
    tokens[k] = s[k].split(":");
   }
   for (l = 0; l < i; ++l) {
    Etudiant e;
    String nom = tokens[l][0];
    String prenom = tokens[l][1];
    int id = Integer.parseInt(tokens[l][2]);
    Double moy = Double.parseDouble(tokens[l][3]);
    e = new Etudiant(nom, prenom, id, moy);
    a.add(e);
   }
   l++;
  } catch (IOException e3) {
   System.out.println(e3.toString());
  }

  System.out.println("***** Collections initial *****\n");
  System.out.println("a= " + a);
  Collections.sort(a);
  System.out.println("\nSorting Collection .... \n");
  System.out.println("***** Collections final *****\n");
  System.out.println("a= " + a);
  File file = new File("sortedEtudiants.txt");
  try {
   PrintWriter writer = new PrintWriter(file);
   String res = getArrayList(a);
   writer.write(res);
   writer.close();
  } catch (FileNotFoundException e2) {
   System.out.println(e2.toString());
  }
 }
}
