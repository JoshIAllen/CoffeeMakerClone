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
  public void testSetFirstItem() {
    Room testRoom = new Room("ASDFG");
    testRoom.setFirst("abc123");
    assertEquals("failure, strings are not equal" , "abc123", testRoom.getFirst());
  }
  
  @Test
  public void testSetSecondItem() {
    Room testRoom = new Room("test");
    testRoom.setSecond("abc123");
    assertEquals("failure, strings are not equal" , "abc123", testRoom.getSecond());
  }
  
  @Test
  public void testSetThirdItem() {
    Room testRoom = new Room("test");
    testRoom.setThird("abc123");
    assertEquals("failure, strings are not equal" , "abc123", testRoom.getThird());
  }  
  
  @Test
  public void testSetFourthItem() {
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
  
//  @Test
//  public void testItemLook(){
//    Boolean[] checkInvenory = {false, true, false};
//    Room testRoom = new Room("test");
//    testRoom.setItem(""); 
//  }
  
  
 // @TEST
  //PUBLIC VOID TESTINTERPRETSTRING(){
  //  COFFEEMAKER TESTSTRING = NEW COFFEEMAKER("N" || "N");
  //  TESTSTRING = COFFEEMAKER(TRUE);
  //  ASSERTEQUALS("INVALID INPUT", TESTSTRING());
  //}


  
//  @Test
//  public void testPrintRoom(){
//    CoffeeMaker mockCoffeeMaker = mock(CoffeeMaker.class);
//    when (mockCoffeeMaker.printRoom()).thenReturn(1);
//    int val = printRoom(mockCoffeeMaker, 100);
//    assertEquals(val, 100);
    // Attempted Stub test.
  //}
  
}