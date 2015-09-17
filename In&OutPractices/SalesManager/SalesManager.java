/***************************************************
Congyao
CSC120
Lab10 part2
****************************************************/
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileOutputStream;

public class SalesManager {

  public static final int BONUS=2000;
  public static final double COMMISSION=0.2;
  public static final double OVERHEAD=0.4;

     public static void main (String args[]) {
   
     Scanner inputStream=null;
     PrintWriter outputStream=null;
     try
     {
     inputStream= new Scanner ( new FileInputStream("salesData.txt"));
     outputStream= new PrintWriter( new FileOutputStream("salesoutput.txt"));
     }
     catch (FileNotFoundException e)
     {
     System.out.println("Problem not found");
     System.exit(0);
     }
     double salesAmount=0;
     String region=null;
     String salesMan=null;
     

     double profit, checkAmount=0;
     while (inputStream.hasNext()) {
           region= inputStream.next();
           salesMan= inputStream.next();
           salesAmount= inputStream.nextInt();
     
           double profitEast=0, profitWest=0, profitSouth=0, profitNorth=0;
           if (region.equals("East")){
              profitEast = profitEast+profit(salesAmount);
              outputStream.println("Profit of the East is "+profitEast);
              }
              
           if (region.equals("West")){
              profitWest = profitWest+profit(salesAmount);
              outputStream.println("Profit of the West is "+profitWest);
              }
                   
           if (region.equals("South")){
              profitSouth = profitSouth+profit(salesAmount);
              outputStream.println("Profit of the South is "+profitSouth);
              }
                        
           else {
           profitNorth = profitNorth+profit(salesAmount);
           outputStream.println("Profit of the North is "+profitNorth);
           }
                     
             
           if (salesAmount>10000)
           checkAmount=calcCheck(salesAmount, COMMISSION, BONUS);
           else
           checkAmount=calcCheck(salesAmount,COMMISSION);
     
           outputStream.println("The check for "+salesMan+" is "+checkAmount);
               
     
      
    /* outputStream.println("Profit of the East is "+profitEast);
     outputStream.println("Profit of the South is "+profitSouth);
     outputStream.println("Profit of the West is "+profitWest);
     outputStream.println("Profit of the North is "+profitNorth);*/
     }
     inputStream.close();
     outputStream.close();
   }
   public static double profit(double salesAmount){
   double profit=0;
   return salesAmount=salesAmount - (salesAmount *OVERHEAD);
   }
   
   public static double calcCheck(double salesAmount , double commission){
   double checkAmount=0;
   return salesAmount=salesAmount*COMMISSION;
   }
   
   public static double calcCheck( double salesAmount, double commission, double bonus) {
   double checkAmount=0;
   return salesAmount=salesAmount*COMMISSION+BONUS;

   }

   
  }
   