/*
 @Author Chris Zheng
 @Version 1.0
 */

public class Passenger {

  //instance variables
  
  private String name;
  private String address;
  private int age;
  private int roomNumber;
  
  /* Constructor */
  /** No argument  constructor */
  
  public Passenger () {
  
  name = null;
  address = null;
  age = 0;
  roomNumber = 0;
  
  }
  
  /* Constructor */
  /** Full qualified */
  
  public Passenger (String str1, String str2, int a, int room){
  
    name = str1;
    address = str2;
    age = a;
    roomNumber = room;
    
    }
    
  /* Copy Constructor */
  
  public Passenger (Passenger aPassenger){
    
    name = aPassenger.name;
    address = aPassenger.address;
    age = aPassenger.age;
    roomNumber = aPassenger.roomNumber;
    
    }
    
  /** Create accessor methods    */
  
  public void setName (String str1) {
   
    this.name = str1;
    
    }
   
  public void setAddress (String str2) {
  
    this.address = str2;
    
    }
    
  public void setAge (int a) {
  
    this.age = a;
    
    }
    
  public void setRoomNumber (int room) {
  
    this.roomNumber = room;
    
    }
  
    
  /** Create accessor methods    */
   
  public String getName(){
  
    return name;
    
    }
    
  public String getAddress (){
  
    return address;
    
    }
    
  public int getAge () {
  
    return age;
    
    }
    
  public int getRoomNumber () {
    
    return roomNumber;
    
    }
    

  public String toString () {
  
    return ("Name: "+name+", Address: "+address+", Age: "+age+", Room Number: " + roomNumber);
    
    }
    
 public boolean equals(Passenger otherPassenger) {
   
   return ((name == otherPassenger.name)&&(address == otherPassenger.address)&&(age == otherPassenger.age)&&(roomNumber == otherPassenger.roomNumber));
   
   }
}