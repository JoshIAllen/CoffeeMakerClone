import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertArrayEquals;
import org.junit.*;
import java.io.*;
//import org.junit;


public class CoffeeTest{       
  
  private ByteArrayOutputStream out = new ByteArrayOutputStream();
  @Before
  public void setUp(){
    System.setOut(new PrintStream(out));
  }
  
  @After
  public void tearDown(){
    System.setOut(null);
  }
  
// --------------------------------------------------------------------- Room Tests ---------------------------------------------------------------
  @Test
  public void testSetFirstString() {
    Room testRoom = new Room("ASDFG");
    testRoom.setFirst("abc123");
    assertEquals("failure, strings are not equal" , "abc123", testRoom.getFirst());
  }
  
  @Test
  public void testSetSecondString() {
    Room testRoom = new Room("test");
    testRoom.setSecond("abc123");
    assertEquals("failure, strings are not equal" , "abc123", testRoom.getSecond());
  }
  
  @Test
  public void testSetThirdString() {
    Room testRoom = new Room("test");
    testRoom.setThird("abc123");
    assertEquals("failure, strings are not equal" , "abc123", testRoom.getThird());
  }  
  
  @Test
  public void testSetFourthString() {
    Room testRoom = new Room("test");
    testRoom.setFourth("abc123");
    assertEquals("failure, strings are not equal" , "abc123", testRoom.getFourth());
  }
  
  @Test
  public void setRoomItem() {
    Room testRoom = new Room("test");
    testRoom.setItem("Thing123");
    assertEquals("failure, strings are not equal" , "Thing123", testRoom.getItem());
  }
  
  @Test
  public void checkItemFalse() {
    Room testRoom = new Room("test");
    assertFalse("failure, should be true", testRoom.checkItem());
  }
  
  @Test
  public void checkItemTrue() {
    Room testRoom = new Room("test");
    testRoom.setItem("Thing123");
    assertTrue("failure, should be true" ,testRoom.checkItem());
  }
  
  @Test  
  public void checkNorthFalse() {
    Room testRoom = new Room("test");
    assertFalse("failure, should be false", testRoom.checkNorth());
  }
  
  @Test  
  public void checkNorthTrue() {
    Room testRoom = new Room("test");
    testRoom.setNorth(true);
    assertTrue("failure, should be true", testRoom.checkNorth());
  }  
  
  @Test
  public void checkSouthFalse(){
    Room testRoom = new Room("test");
    assertFalse("failure, should be false", testRoom.checkSouth());
  }
  
  @Test
  public void checkSouthTrue(){
    Room testRoom = new Room("test");
    testRoom.setSouth(true);
    assertTrue("failure, should be true", testRoom.checkSouth());
  }
//----------------------------------------------------------------------- End of Room Tests -----------------------------------------------------------  
//------------------------------------------------------------------------Item Look Method Tests ----------------------------------------------------- 
  @Test
  public void testItemLookNull(){
    Boolean[] fakeInventory = {false, false, false};
    Boolean[] inventoryCheck = {false, false, false};
    Room testRoom = new Room("test");
    testRoom.setItem(null);
    assertArrayEquals("FAILURE: Arrays were not equal", CoffeeMaker.itemLook(testRoom, fakeInventory), inventoryCheck);
  }
  
  @Test
  public void testItemLookCoffee(){
    Boolean[] fakeInventory = {false, false, false};
    Boolean[] inventoryCheck = {true, false, false};
    Room testRoom = new Room("test");
    testRoom.setItem("Coffee");
    assertArrayEquals("FAILURE: Arrays were not equal", CoffeeMaker.itemLook(testRoom, fakeInventory), inventoryCheck);
    
  }
  
  @Test
  public void testItemLookCream(){
    Boolean [] fakeInventory = {false, false, false};
    Boolean[] inventoryCheck = {false, true, false};
    Room testRoom = new Room("test");
    testRoom.setItem("Cream");
    assertArrayEquals("FAILURE: Arrays were not equal", CoffeeMaker.itemLook(testRoom, fakeInventory), inventoryCheck);
    
  }
    
  @Test
  public void testItemLookSugar(){
    Boolean [] fakeInventory = {false, false, false};
    Boolean[] inventoryCheck = {false, false, true};
    Room testRoom = new Room("test");
    testRoom.setItem("Sugar"); 
    assertArrayEquals("FAILURE: Arrays were not equal", CoffeeMaker.itemLook(testRoom, fakeInventory), inventoryCheck);

  }
  
  @Test
  public void testItemLookDouble(){
    Boolean[] fakeInventory = {true, false, false};
    Boolean[] inventoryCheck = {true, false, false};
    Room testRoom = new Room("test");
    testRoom.setItem("Coffee");
    assertArrayEquals("FAILURE: Arrays were not equal", CoffeeMaker.itemLook(testRoom, fakeInventory), inventoryCheck);
  }
  
  //-------------------------------------------------------------------- End of Item Look---------------------------------------------------------------------------
  //-------------------------------------------------------------------- Drink Check ------------------------------------------------------------------------------
  @Test
  public void testDrinkCheckWin(){
    Boolean[] fakeInventory = {true, true, true};
    CoffeeMaker.drinkCheck(fakeInventory);
    assertEquals("FAILURE: Wrong message was printed", "You drink the beverage and are ready to study!\nYou win!!\n".trim() , out.toString().trim());
  }
  
  @Test
  public void testDrinkCheckFTF(){
    Boolean[] fakeInventory = {false, true, false};
    CoffeeMaker.drinkCheck(fakeInventory);
    assertEquals("FAILURE: Wrong message was printed", "You drink the cream, but without caffeine, you cannot study. \n You lose!\n".trim() , out.toString().trim());
  }
 
  @Test
  public void testDrinkCheckTFF(){
    Boolean[] fakeInventory = {true, false, false};
    CoffeeMaker.drinkCheck(fakeInventory);
    assertEquals("FAILURE: Wrong message was printed", "Without cream, you get an ulcer and cannot study. \n You lose!\n".trim() , out.toString().trim());
  }
  
  @Test
  public void testDrinkCheckFFT(){
    Boolean[] fakeInventory = {false, false, true};
    CoffeeMaker.drinkCheck(fakeInventory);
    assertEquals("FAILURE: Wrong message was printed", "You eat the sugar, but without caffeine, you cannot study.\n You lose!\n".trim() , out.toString().trim());
  }
  
  @Test
  public void testDrinkCheckTTF(){
    Boolean[] fakeInventory = {true, true, false};
    CoffeeMaker.drinkCheck(fakeInventory);
    assertEquals("FAILURE: Wrong message was printed", "Without sugar, the coffee is too bitter.  You cannot study.\nYou lose!\n".trim() , out.toString().trim());
  }
  @Test
  public void testDrinkCheckFTT(){
    Boolean[] fakeInventory = {false, true, true};
    CoffeeMaker.drinkCheck(fakeInventory);
    assertEquals("FAILURE: Wrong message was printed", "You drink the sweetened cream, but without caffeine, you cannot study.\nYou lose!\n".trim() , out.toString().trim());
  }
  
  @Test
  public void testDrinkCheckTFT(){
    Boolean[] fakeInventory = {true, false, true};
    CoffeeMaker.drinkCheck(fakeInventory);
    assertEquals("FAILURE: Wrong message was printed", "Without cream, you get an ulcer and cannot study.\nYou lose!\n".trim() , out.toString().trim());
  }
  
  @Test
  public void testDrinkCheckFFF(){
    Boolean[] fakeInventory = {false, false, false};
    CoffeeMaker.drinkCheck(fakeInventory);
    assertEquals("FAILURE: Wrong message was printed", "You have no Coffee, Cream or Sugar!\n You Lose!!\n".trim() , out.toString().trim());
  }
  
// ----------------------------------------------------------------------- End of Drink Check -------------------------------------------------------------------------
//--------------------------------------------------------------------- Inventory Ccheck Begin -------------------------------------------------------------------------
  @Test
  public void testInventoryCheckFFF(){
    Boolean[] fakeInventory = {false, false, false};
    CoffeeMaker.inventoryCheck(fakeInventory);
    assertEquals("FAILURE: Wrong message was printed", "YOU HAVE NO COFFEE!\nYOU HAVE NO CREAM!\nYOU HAVE NO SUGAR!\n".trim() , out.toString().trim());
  }
  
  @Test
  public void testInventoryCheckTFF(){
    Boolean[] fakeInventory = {true, false, false};
    CoffeeMaker.inventoryCheck(fakeInventory);
    assertEquals("FAILURE: Wrong message was printed", "You have a delicious cup of coffee.\nYOU HAVE NO CREAM!\nYOU HAVE NO SUGAR!\n".trim() , out.toString().trim());
  }
  
  @Test
  public void testInventoryCheckTTF(){
    Boolean[] fakeInventory = {true, true, false};
    CoffeeMaker.inventoryCheck(fakeInventory);
    assertEquals("FAILURE: Wrong message was printed", "You have a delicious cup of coffee.\nYou have some cream.\nYOU HAVE NO SUGAR!\n".trim() , out.toString().trim());
  }
  
  @Test
  public void testInventoryCheckTTT(){
    Boolean[] fakeInventory = {true, true, true};
    CoffeeMaker.inventoryCheck(fakeInventory);
    assertEquals("FAILURE: Wrong message was printed", "You have a delicious cup of coffee.\nYou have some cream.\nYou have some sugar.\n".trim() , out.toString().trim());
  }
  
  @Test
  public void testInventoryCheckFTT(){
    Boolean[] fakeInventory = {false, true, true};
    CoffeeMaker.inventoryCheck(fakeInventory);
    assertEquals("FAILURE: Wrong message was printed", "YOU HAVE NO COFFEE!\nYou have some cream.\nYou have some sugar.\n".trim() , out.toString().trim());
  }
  @Test
  public void testInventoryCheckTFT(){
    Boolean[] fakeInventory = {true, false, true};
    CoffeeMaker.inventoryCheck(fakeInventory);
    assertEquals("FAILURE: Wrong message was printed", "You have a delicious cup of coffee.\nYOU HAVE NO CREAM!\nYou have some sugar.\n".trim() , out.toString().trim());
  }
  @Test
  public void testInventoryCheckFTF(){
    Boolean[] fakeInventory = {false, true, false};
    CoffeeMaker.inventoryCheck(fakeInventory);
    assertEquals("FAILURE: Wrong message was printed", "YOU HAVE NO COFFEE!\nYou have some cream.\nYOU HAVE NO SUGAR!\n".trim() , out.toString().trim());
  }
  @Test
  public void testInventoryCheckFFT(){
    Boolean[] fakeInventory = {false, false, true};
    CoffeeMaker.inventoryCheck(fakeInventory);
    assertEquals("FAILURE: Wrong message was printed", "YOU HAVE NO COFFEE!\nYOU HAVE NO CREAM!\nYou have some sugar.\n".trim() , out.toString().trim());
  }
  @Test
  public void testPrintHelp(){
    CoffeeMaker.printHelp();
    assertEquals("FAILURE: Wrong message was printed", "Type N to move north.\nType S to move south.\nType L to look for an item.\nType I to check your inventory.\nType D to drink your coffee.".trim(), out.toString().trim());
  }  
  
}