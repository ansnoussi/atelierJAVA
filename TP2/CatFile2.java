import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CatFile2 {

public static void main(String args []){
BufferedReader bufferedreader = null;
    FileReader filereader = null;
    try {
      filereader = new FileReader(args[0]);
      bufferedreader = new BufferedReader(filereader);
      String strCurrentLine;
      while ((strCurrentLine = bufferedreader.readLine()) != null) {
        System.out.println(strCurrentLine);
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if (bufferedreader != null)
          bufferedreader.close();
        if (filereader != null)
          filereader.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}