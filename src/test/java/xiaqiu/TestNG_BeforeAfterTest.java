package xiaqiu;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class TestNG_BeforeAfterTest {
  @Test
  public void test_5() {
	  System.out.println("test_5");
  }
  @Test
  public void test_6() {
	  System.out.println("test_6");
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("@BeforeMethod");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("@AfterMethod");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("@BeforeClass");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("@AfterClass");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("@BeforeTest");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("@AfterTest");
  }

}
//执行结果如下
//@BeforeTest
//@BeforeClass
//@BeforeMethod
//test_5
//@AfterMethod
//@BeforeMethod
//test_6
//@AfterMethod
//@AfterClass
//@AfterTest

