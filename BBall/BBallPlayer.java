public class BBallPlayer implements Comparable<BBallPlayer> {

   private String firstName;
   private String lastName;
   private double avgPoints;
   private int heightFeet;
   private int heightInch;
   
   public BBallPlayer(){
      firstName = "";
      lastName = "";
      avgPoints = 0;
      int heightFeet = 0;
      int heightInch = 0;
   }
   
   public BBallPlayer(String m, String n, double d, int i, int k){
      firstName = m;
      lastName = n;
      avgPoints = d;
      heightFeet = i;
      heightInch = k;
   }
   
   public void setfFirstName(String m){
     firstName = m;
   }
      
   public void setLastName(String n){
      lastName = n;
   }
   
   public void setAvgPoints(double d){
      avgPoints = d;
   }
   
   public void setHeightFeet(int i){
      heightFeet = i;
   }
   
   public void setHeightInch(int k){
      heightInch = k;
   }
   
   public String getFirstName(){
      return firstName;
   }
   
   public String getLastName(){
      return lastName;
   }
   
   public double getAvgPoints(){
      return avgPoints;
   }
   
   public int getHeightFeet(){
      return heightFeet;
   }
   
   public int getheightInch(){
      return heightInch;
   }
   
   //where is the compareTo
   public String toString(){
      return (firstName + " " + lastName + ":   "+ "Avg Points: " + avgPoints  +"      Height:  " + heightFeet + "ft" + heightInch + "in");
   }
   
   public int compareTo(BBallPlayer b){
      if(heightFeet > b.heightFeet)
         return 1;
      else if(heightFeet < b.heightFeet)
         return -1;
      else if(heightInch!=b.heightInch)
         return heightInch - b.heightInch;
     // else if (heightInch==b.heightInch)
         //return this.getLastName().compareToIgnoreCase (b.getLastName());
      else
         return this.getLastName().compareToIgnoreCase (b.getLastName());
   }
}