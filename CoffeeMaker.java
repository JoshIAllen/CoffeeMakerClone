import java.util.*;
public class CoffeeMaker {
 private static int currentLocation = 0;
 private static Boolean alive = true;
 private static Boolean[] inventory = {false, false, false};
 
 public static void main(String[] args) {
// Creating all of the rooms
      Room room1 = new Room("room1");
      room1.setNorth(true);
      room1.setFirst("You see a Small room.");
      room1.setSecond("It has a Quaint sofa.");
      room1.setThird("A Magenta door leads North.");
      room1.setItem("Cream");
     
      Room room2 = new Room("room2");
      room2.setNorth(true);
      room2.setSouth(true);
      room2.setFirst("You see a Funny room.");
      room2.setSecond("It has a Sad record player.");
      room2.setThird("A Beige door leads North.");
      room2.setFourth("A Massive door leads South.");

      Room room3 = new Room("room3");
      room3.setNorth(true);
      room3.setSouth(true);
      room3.setFirst("You see a Refinanced room.");
      room3.setSecond("It has a Tight pizza.");
      room3.setThird("A Dead door leads North.");
      room3.setFourth("A Smart door leads South.");
      room3.setItem("Coffee");
      
      Room room4 = new Room("room4");
      room4.setNorth(true);
      room4.setSouth(true);
      room4.setFirst("You see a Dumb room.");
      room4.setSecond("It has a Flat energy drink.");
      room4.setThird("A Vivacious door leads North.");
      room4.setFourth("A Slim door leads South.");

      Room room5 = new Room("room5");
      room5.setNorth(true);
      room5.setSouth(true);
      room5.setFirst("You see a Bloodthirsty room.");
      room5.setSecond("It has a Beautiful bag of money.");
      room5.setThird("A Purple door leads North.");
      room5.setFourth("A Sandy door leads South.");
      
      Room room6 = new Room("room6");
      room6.setSouth(true);
      room6.setFirst("You see a Rough room.");
      room6.setSecond("It has a Perfect air hockey table.");
      room6.setThird("A Minimalist door leads South.");
      room6.setItem("Sugar");


      // Create an array holding all six rooms in order
      Room[] house = {room1, room2, room3, room4, room5, room6};
      // This int holds the current location in the array of rooms.
      //      int currentLocation = 0;
      // This array of booleans will serve as the players inventory. Index 0 = coffee, index 1 = cream, index 2 = sugar
      
      // This boolean is the status of the player
      //Boolean alive = true;
      // This string will hold the user input.
      String input;

      Scanner scanner = new Scanner(System.in);

      System.out.println("Coffee Maker Quest 1.1\n");
      
      // This while loop is what runs our game. It runs until the alive boolean is no longer true.
      while (alive == true){
      printRoom(house[currentLocation]);
      System.out.println( "INSTRUCTIONS (N,S,L,I,D,H) > \n");
      input = scanner.nextLine();
      interpretInput(input, house);
   

      }
   }

   
 public static void interpretInput(String input, Room[] house){
        if (input.equals("n") || input.equals("N")){
          if (house[currentLocation].checkNorth()){
           currentLocation += 1;
          }
          else {
                 System.out.println("You cannot go North. There is no North door. You did not change rooms.\n");
          }
      }
      else if (input.equals("s") || input.equals("S")){
          if (house[currentLocation].checkSouth()){
           currentLocation -= 1;
          } 
          else {
            System.out.println("You cannot go South. There is no South door. You did not change rooms.\n");
          }
      }
      else if (input.equals("H") || input.equals("h")){
          printHelp();
      }
      else if (input.equals("I") || input.equals("i")){
          inventoryCheck(inventory);
      }
      else if (input.equals("L") || input.equals("l")){
          inventory = itemLook(house[currentLocation], inventory);
      }
      else if (input.equals("D") || input.equals("d")){
          inventoryCheck(inventory);
          System.out.println();
          drinkCheck(inventory);
          System.out.println();
      }
      else{
       System.out.println("What?\n");
      }
 }


 public static void printRoom(Room thisRoom){
      System.out.println(thisRoom.getFirst());
      System.out.println(thisRoom.getSecond());
      System.out.println(thisRoom.getThird());
      
      if (thisRoom.getFourth() != null) {
          System.out.println(thisRoom.getFourth());
          System.out.println();
      }
      else{System.out.println();}
 }
 
 
 public static void printHelp(){
      System.out.println("Type N to move north.");
      System.out.println("Type S to move south.");
      System.out.println("Type L to look for an item.");
      System.out.println("Type I to check your inventory.");
      System.out.println("Type D to drink your coffee.\n");
 }
 
 public static void inventoryCheck(Boolean[] currentInv){
      if (currentInv[0] == true){System.out.println("You have a delicious cup of coffee.");}
      else {System.out.println("YOU HAVE NO COFFEE!");}
      
      if (currentInv[1] == true){System.out.println("You have some cream.");}    
      else {System.out.println("YOU HAVE NO CREAM!");}
      
      if (currentInv[2] == true){System.out.println("You have some sugar.\n");}    
      else {System.out.println("YOU HAVE NO SUGAR!\n");}
 }
 
 
 public static void drinkCheck(Boolean[] currentInv){
 
      if (currentInv[0] && currentInv[1] && currentInv[2]){
           System.out.println("You drink the beverage and are ready to study!\nYou win!!\n");
           alive = false;
      }
      else if (currentInv[0] == false && currentInv[1] && currentInv[2] == false){
           System.out.println("You drink the cream, but without caffeine, you cannot study. \n You lose!\n");
           alive = false;
      }
      else if (currentInv[0] && currentInv[1] == false && currentInv[2] == false){
           System.out.println("Without cream, you get an ulcer and cannot study. \n You lose!\n");
           alive = false;   
      }
      else if (currentInv[0] == false && currentInv[1] == false && currentInv[2]){
           System.out.println("You eat the sugar, but without caffeine, you cannot study.\n You lose!\n");
           alive = false;      
      }
      else if (currentInv[0] && currentInv[1] && currentInv[2] == false){
           System.out.println("Without sugar, the coffee is too bitter.  You cannot study.\nYou lose!\n");
           alive = false;   
      }
      else if (currentInv[0] == false && currentInv[1] && currentInv[2]){
           System.out.println("You drink the sweetened cream, but without caffeine, you cannot study.\nYou lose!\n");
           alive = false;    
      }
      else if (currentInv[0] && currentInv[1] == false && currentInv[2]){
           System.out.println("Without cream, you get an ulcer and cannot study.\nYou lose!\n");
           alive = false;         
      }
      else{
          System.out.println("You have no Coffee, Cream or Sugar!\n You Lose!!\n");
          alive = false;
      }
 }
 
 
 public static Boolean[] itemLook(Room currRoom, Boolean[] currInv){ 
     if (currRoom.getItem() == null){
           System.out.println("You don't see anything out of the ordinary.");
           return currInv;
     }
     else if (currRoom.getItem().equals("Cream")){
           System.out.println("There might be something here...");
           System.out.println("You found some creamy cream!\n");
           currInv[1] = true;
           return currInv;
     }
     else if(currRoom.getItem().equals("Coffee")){
           System.out.println("There might be something here...");
           System.out.println("You found some caffeinated coffee!\n");
           currInv[0] = true;
           return currInv;
     }
     
     else if(currRoom.getItem().equals("Sugar")){
          System.out.println("There might be soemthing here...");
          System.out.println("You found some sweet sugar!\n");
          currInv[2] = true;
          return currInv;
     }
     return currInv;
 }

 
}