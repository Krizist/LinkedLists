import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileOutputStream;
public class BallDriver{
   public static void main (String [] args){
      Scanner inputStream=null;
      PrintWriter outputStream=null;
      try
      {
      inputStream= new Scanner ( new FileInputStream("SJU.txt"));
      outputStream= new PrintWriter( new FileOutputStream("BBall_SortedOutput.txt"));
      }
      catch (FileNotFoundException e)
      {
      System.out.println("Problem not found");
      System.exit(0);
      }
      
      String firstName = null;
      String lastName = null;
      double avgPoints = 0.0;
      int heightFeet = 0;
      int heightInch = 0;
      
      BBallPlayer []array = new BBallPlayer[15];
      int i = 0;     
      while ((inputStream.hasNext())&&(i<array.length)) {
         firstName = inputStream.next();
         lastName = inputStream.next();
         avgPoints = inputStream.nextDouble();
         heightFeet = inputStream.nextInt();
         heightInch = inputStream.nextInt();
         array[i] = new BBallPlayer(firstName, lastName, avgPoints, heightFeet, heightInch);
         i++;
      }//end while
     Arrays.sort(array);{
     for (i=0; i<array.length; i++)
     outputStream.println(array[i]);
     }
     outputStream.close();
  }//end main
}//end class