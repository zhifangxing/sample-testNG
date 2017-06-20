package xiaqiu;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;


public class TestNG_BeforeAfterMethod {
  @Test
  public void test_3() {
	  System.out.println("test_3");
  }
  @Test
  public void test_4(){
	  System.out.println("test_4");
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("beforeMethod");
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

}
//测试结果如下
//BeforeClass
//BeforeMethod
//test_3
//AfterMethod
//BeforeMethod
//test_4
//AfterMethod
//AfterClass
//PASSED: test_3
//PASSED: test_4
