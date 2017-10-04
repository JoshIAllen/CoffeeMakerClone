public class Room {
public String roomName;
public String item = null;

public String firstString = null;
public String secondString = null;
public String thirdString = null;
public String fourthString = null;

public boolean hasItem = false;
public boolean hasNorth = false;
public boolean hasSouth = false;

 
 
 public Room(String name){
     roomName = name;
 }
 
 public void setFirst(String text){
    firstString = text;
 }
 
  public void setSecond(String text){
    secondString = text;
 }
 
  public void setThird(String text){
    thirdString = text;
 }
 
public void setFourth(String text){
    fourthString = text;
 }
 
 
 public void setItem(String thing){
  item = thing;
  hasItem = true;
 }
 
 public void setNorth(Boolean northDoor){
  hasNorth = northDoor;
 }
 
 public void setSouth(Boolean southDoor){
  hasSouth = southDoor;
 }
 
 
 
 public String getFirst(){ return firstString;}
 
 public String getSecond(){ return secondString;}
 
 public String getThird(){ return thirdString;}
 
 public String getFourth(){ return fourthString;}
 
 public String getItem(){ return item;}
 
 
 public boolean checkItem(){return hasItem;}
 
 public boolean checkNorth(){return hasNorth;}
 
 public boolean checkSouth(){return hasSouth;}
 
}