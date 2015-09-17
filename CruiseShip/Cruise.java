/*
 @Author Chris Zheng
 @Version 1.0
 */
import java.util.Scanner;
import java.util.Arrays;

public class Cruise {
   
   Scanner keyboard = new Scanner(System.in);
   
   //instance variables
   private String shipName;
   private int numRooms;
   private int numOccupiedRooms;
   private double roomCost;
   private int numPass;
   private int maxPass;
   //still need isOccupied or not
   private boolean isOccupied;
   
   Room shipRoom[];
   Passenger shipPass[];
   
   //constructors
   public Cruise() {
      shipName = "Queen";
      numRooms = 10;
      numOccupiedRooms = 0;
      roomCost = 150;
      numPass = 0;
      maxPass = 10;
     
     isOccupied = true;
   

     shipPass = new Passenger[maxPass];
     shipRoom = new Room[numRooms];
      
     for (int i = 0; i < shipRoom.length; i++) {
     shipRoom[i] = new Room(i, roomCost, false);
   }

   }

   //copy contructors
   public Cruise(Cruise c) {
   
      shipName = c.shipName;
      numRooms = c.numRooms;
      numOccupiedRooms = c.numOccupiedRooms;
      roomCost = c.roomCost;
      numPass = c.numPass;
      maxPass = c.maxPass;
      shipPass = c.shipPass;
      shipRoom = c.shipRoom;
      
    }
   
   //addPassenger
   
   public void addPassenger(Passenger p) {
     
      if (numPass <= maxPass) { 
         shipPass[numPass] = new Passenger(p);
         shipRoom[numOccupiedRooms].setIsOccupied(true);
         shipRoom[numPass].setPassenger(p);
         numPass++;
         numOccupiedRooms++;  
      }   
   }
         
   //find passenger
   public Passenger findPassenger(String name) {   
    
      for (int i = 0; i < numOccupiedRooms; i++) {
        if (name.equals(shipPass[i].getName())) {
            System.out.print( shipPass[i].getRoomNumber() );
            return shipPass[i];
          }
       }
   return null; 
   }
             
   public String toString()  {
   
      String str = "";
      str = str + "Ship Name: "+ shipName + "\n" + "________________________________________________________________" 
      + "\n" + "Number of Rooms: " + shipRoom.length + "\n";
  
      for (int i = 0; i < shipRoom.length; i++) {
          str = str + shipRoom[i].toString() + "\n";
          if (i==shipRoom.length-1)
          str = str + "________________________________________________________________" + "\n";
      }
      
      System.out.println( "________________________________________________________________" );
      
      for (int j = 0; j < numOccupiedRooms; j++) {
          if (j == 0 )
          str = str + "Number of Passengers: " + numPass + "\n";
          str = str + shipPass[j].toString() + "\n";
      }
      return str;
      }
   
   }