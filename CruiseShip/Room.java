public class Room {
   
   //instance variables
   
     private int roomNumber;
     private double cost;
     private boolean isOccupied;
     private Passenger aPassenger;
  /* Constructor */
  /** No argument  constructor */
  
  public Room(){
       roomNumber =0;
       cost = 0;
       isOccupied  = false;
   }

  /**  Constructor  when no Passenger                                                                *
   @ param room integer representing room number           *
 *    @ param c double representing cost of room               *
 *   @ param used boolean representing is the room occupied */

  public Room ( int room , double c, boolean used){
    roomNumber=room;
    cost=c;
    isOccupied=used;
    }
   
/** Constructor including Passenger                                                      *
    @param a Passenger object that will be assigned to this room       */

  public Room ( int room, double c, boolean used, Passenger a){
    roomNumber=room;
    cost=c;
    isOccupied=used;
    aPassenger= a;
    }

   
 /** Copy Constructor        */  
  public Room ( Room aRoom ){
     
    // make copies of all instance variables
    roomNumber = aRoom.roomNumber;
    cost = aRoom.cost;
    isOccupied = aRoom.isOccupied;
    aPassenger = aRoom.aPassenger;
   }
 
 /** Create accessor methods    */
  
    public int getRoom(){
      return roomNumber;
     }
     
   public double getCost(){
     return cost;
     }
   
   public boolean getIsOccupied() {
      return isOccupied;
      }
     
 /** create mutator methods  */    
/* add missing ones */     
     public  void setRoom (int roomNumber){
       this.roomNumber = roomNumber;
       }
       
     public void setCost (double cost) {
       this.cost = cost;
       }
       
     public void setIsOccupied(boolean isOccupied) {
       this.isOccupied = isOccupied;
       }
       
     public void setPassenger(Passenger p) {
       this.aPassenger = p;
       }
       
     public String toString( ){
        return ("Room Number: " + roomNumber + ", Cost: " + cost + ", Occupied: " + isOccupied);
   }
     
     public boolean equals(Room otherRoom) {
       
       return ( (roomNumber == otherRoom.roomNumber)&& (cost == otherRoom.cost)
                && (isOccupied == otherRoom.isOccupied) &&(aPassenger.equals(otherRoom.aPassenger)) );
   }

}
