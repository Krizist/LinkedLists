/***************************************************
Congyao
CSC120
Lab10 part1
****************************************************/
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileOutputStream;

public class NumberCrunch {
   public static void main (String args[]) {
   Scanner inputStream=null;
   PrintWriter outputStream=null;
   try
   {
   inputStream= new Scanner ( new FileInputStream("numbers.txt"));
   outputStream= new PrintWriter( new FileOutputStream("output.txt"));
   }
   catch (FileNotFoundException e)
   {
   System.out.println("Problem not found");
   System.exit(0);
   }
   double number;
   double minValue=1000000, maxValue=0;
   while(inputStream.hasNext())
   {
   number=inputStream.nextDouble();
   outputStream.println("The square root of "+number+" is "+calcSqrt(number));
   minValue= Math.min(minValue, number);
   maxValue=Math.max(maxValue, number);
   outputStream.println("The maximum value is "+maxValue);
   outputStream.println("The minimum value is "+minValue);
   }
   inputStream.close();
   outputStream.close();
   }
   public static double calcSqrt(double number){
   return Math.sqrt(number);
   }
   public static double calcSquare(double x) {
   return x*x;
   }
   
}