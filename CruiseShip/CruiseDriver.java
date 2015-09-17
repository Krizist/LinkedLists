/*
 @Author Chris Zheng
 @Version 1.0
 */
import java.util.Scanner;

public class CruiseDriver {

   public static void main (String []args) {
      
      Scanner keyboard = new Scanner(System.in);
      
      Cruise cruise = new Cruise();
      
      Passenger p1 = new Passenger ("Tom Smith", "1000 St. Wayne PA", 45, 0 );
      Passenger p2 = new Passenger ("Jane Williams", "2000 St. San Jose CA", 25, 1);
      cruise.addPassenger( p1 );
      cruise.addPassenger( p2 );
      
      System.out.println( cruise );
      
      
      System.out.print( "Enter the name of the passenger: " );
      String name = keyboard.nextLine();
       
      System.out.print( name + "'s Room Number is: ");
      cruise.findPassenger( name );    
      
   }
}
 /*  Output  
  ----jGRASP exec: java CruiseDriver
 
 ________________________________________________________________
 Ship Name: Queen
 ________________________________________________________________
 Number of Rooms: 10
 Room Number: 0, Cost: 150.0, Occupied: true
 Room Number: 1, Cost: 150.0, Occupied: true
 Room Number: 2, Cost: 150.0, Occupied: false
 Room Number: 3, Cost: 150.0, Occupied: false
 Room Number: 4, Cost: 150.0, Occupied: false
 Room Number: 5, Cost: 150.0, Occupied: false
 Room Number: 6, Cost: 150.0, Occupied: false
 Room Number: 7, Cost: 150.0, Occupied: false
 Room Number: 8, Cost: 150.0, Occupied: false
 Room Number: 9, Cost: 150.0, Occupied: false
 ________________________________________________________________
 Number of Passengers: 2
 Name: Tom Smith, Address: 1000 St. Wayne PA, Age: 45, Room Number: 0
 Name: Jane Williams, Address: 2000 St. San Jose CA, Age: 25, Room Number: 1
 
 Enter the name of the passenger: Jane Williams
 Jane Williams's Room Number is: 1
  ----jGRASP: operation complete.
 */  