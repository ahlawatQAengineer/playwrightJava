package com.rahulshettyacademy.tests;

import com.rahulshettyacademy.base.BaseTest;
import com.rahulshettyacademy.pages.PracticePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class KeyWordTest extends BaseTest {
private PracticePage  practicePage2;

    @BeforeMethod
    @Override
    public void setUpTest() throws InterruptedException {
        super.setUpTest();
        navigateToPracticePage();
        practicePage2 = new PracticePage(page);
    }
@Test(enabled = false, priority = 0, description = "Test filling and clearing input fields")
public void inpUtFieldTest() throws InterruptedException {
    // test code

practicePage2.enterinput("Whats my name");
Thread.sleep(1000);
practicePage2.clearSuggestionInput();
Thread.sleep(2000);
practicePage2.enterinput("My name is Sheela");
System.out.println("My name is Sheela" );

}


@Test(enabled = false,priority = 1, description =  "Test type in Test Area")
    public void typeandFocus(){

        practicePage2.typeinInput("a", "b", "c", "d", 2);

}

@Test(enabled= false, priority  = 2, description  = "Test Keyboard Press")
    public void  keyBoardFnc() throws InterruptedException {
        practicePage2.clearSuggestionInput();
        practicePage2.pressButtons("A");
        Thread.sleep(2000);
        practicePage2.clearSuggestionInput();
        practicePage2.pressButtons("B");
        Thread.sleep(2000);
        practicePage2.clearSuggestionInput();
        practicePage2.pressButtons("C");
        Thread.sleep(2000);
        practicePage2.pressButtons("A");
        Thread.sleep(2000);
        practicePage2.pressButtons("T");
        practicePage2.focusSuggestionInput();
        Thread.sleep(1000);
}

@Test(enabled = false, priority =1 , description = "This is to fetch values")
    public void fetchAttributeValues(){
    practicePage2.fetchTestContent();

}


@Test( priority = 2, description = "This is to test the click")
    public void clickElelement() throws InterruptedException {
    practicePage2.clicksTest();
}


@Test(priority =  3, description = "Check right click on an eleemnt")
    public void rightClickTest() throws InterruptedException {

   practicePage2.rightClick();
   practicePage2.pressButtons("ArrowDown");
   Thread.sleep(2000);
   practicePage2.pressButtons("Enter");
   Thread.sleep(2000);


}


}
