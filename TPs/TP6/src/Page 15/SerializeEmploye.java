import java.io.*;
class SerializeEmployee{ 
public static void main(String[] args) {
 Employee e = new Employee();
 try{ File f = new File("employees.ser");      
   FileOutputStream of = new  FileOutputStream(f);        
  ObjectOutputStream objf = new ObjectOutputStream(of);         
  objf.writeObject(e);          
  objf.close(); 
}
 catch (Exception e1) {} 
}
 }