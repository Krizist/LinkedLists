/***************************************************
name: CongyaoZheng
date: 09/18/14
Lab: 3 
Part: 1
****************************************************/
import java.util.Scanner;
public class SquareRootPredictor {
   public static void main (String []args) {
   Scanner keyboard= new Scanner(System.in);
  
   int n;
   System.out.print("Enter number to be used: ");
   n= keyboard.nextInt();
   System.out.println();
   
   double guess, r;
   System.out.print("Enter your guess of the square root of "+n+": ");
   guess= keyboard.nextDouble();
   System.out.println();
  
   //1
   r=n/guess;
   guess=(guess+r)/2;
   //2
   r=n/guess;
   guess=(guess+r)/2;
   //3
   r=n/guess;
   guess=(guess+r)/2;
   //4
   r=n/guess;
   guess=(guess+r)/2;
   //5
   r=n/guess;
   guess=(guess+r)/2;
   //6
   //r=n/guess;
   //guess=(guess+r)/2;
   System.out.print("The answer to the square root of "+n+" is about ");
   System.out.printf("%.3f", r);
   }
   }