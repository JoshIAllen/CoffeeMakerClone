import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
//import org.junit;


public class CoffeeTest{
  
//  private ByteArrayOutputStream out = new ByteArrayOutputStream();
  
//  @Before
//  public void setUp(){
//    System.setOut(new PrintStream(out));
//  }
  
//  @After
//  public void tearDown(){
//    System.setOut(null);
//  }
  
  
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
  public void testGetItem(){
    Room testRoom = new Room("test");
    testRoom.getItem("Things123");
    assertEquals("failure, should be true", testRoom.getItem());
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
    testRoom.setSouuth(true);
    assertTrue("failure, should be true", testRoom.checkSouth());
  }
  
  @Test
  public void testItemLook(){
    Boolean[] fakeInventory = {false, false, false};
    Room testRoom = new Room("test");
    testRoom.setItem("");
  }
  
  @Test
  public void testItemLook2(){
    Boolean[] checkInvenory = {true, false, false};
    Room testRoom = new Room("test");
    testRoom.setItem("");
    
  }
  
  @Test
  public void testItemLook3(){
    Boolean[] checkInvenory = {true, true, false};
    Room testRoom = new Room("test");
    testRoom.setItem("");
    
  }
    
  @Test
  public void testItemLook4(){
    Boolean[] checkInvenory = {true, true, true};
    Room testRoom = new Room("test");
    testRoom.setItem(""); 
    
  }
  
  @Test
  public void testItemLook5(){
    Boolean[] checkInvenory = {false, true, false};
    Room testRoom = new Room("test");
    testRoom.setItem(""); 
    
  }
  @Test
  public void testItemLook6(){
    Boolean[] checkInvenory = {false, false, true};
    Room testRoom = new Room("test");
    testRoom.setItem(""); 
    
  }
  
  @Test
  public void testItemLook7(){
    Boolean[] checkInvenory = {false, true, true};
    Room testRoom = new Room("test");
    testRoom.setItem(""); 
    
  }
  
  @Test
  public void testItemLook8(){
    Boolean[] checkInvenory = {true, false, true};
    Room testRoom = new Room("test");
    testRoom.setItem(""); 
    
  }
  
 // @TEST
  //PUBLIC VOID TESTINTERPRETSTRING(){
  //  COFFEEMAKER TESTSTRING = NEW COFFEEMAKER("N" || "N");
  //  TESTSTRING = COFFEEMAKER(TRUE);
  //  ASSERTEQUALS("INVALID INPUT", TESTSTRING());
  //}
  // I dont think im doing this right...
  // What happened to all of my test item looks?
  // What do you mean?
  // I had like 3 or 4 more test item look tests written
  // I dont know... I wouldn't have deleted them.
  // I don't know what's going on in that testInterperet string method
  // Me neither, I don't really understand how to write test codes. I was just trying to follow a similar format that you were doing for other tests.
  // Idk, don't worry about it, I'll work on it
  // Is there a way for us to actually see if it errors? When I wrote those two tests, compiled, and then ran I didn't get any errors.
  // I'm getting a lot of errors
  // You have to right click, run the code
  // Then use the compile command and the run command
  // Is this for sure due tomorrow?
  // I don't think he gave a due date yet.
  // I know the orginal pdf with the instructions said that the due date was "TBD"
  // I have a hunch it's due tomorrow but I can't work on this anymore today. I spent 2 hours writing those tests and they are gone now.
  // Shit, I honestly have no idea what happened to them, when I looked at this earlier this is what it had.
  // I'll try to accomplish some more tomorrow.
  // I'll keep working on this tonight, I'm sorry about those tests, I hope I didn't somehow delete them...
  
  
  
//  @Test
//  public void testPrintRoom(){
//    CoffeeMaker mockCoffeeMaker = mock(CoffeeMaker.class);
//    when (mockCoffeeMaker.printRoom()).thenReturn(1);
//    int val = printRoom(mockCoffeeMaker, 100);
//    assertEquals(val, 100);
    // Attempted Stub test.
  //}
  
}