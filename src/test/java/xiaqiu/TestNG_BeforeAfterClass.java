package xiaqiu;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class TestNG_BeforeAfterClass {
  @Test
  public void test_1() {
	  System.out.println("test_1");
  }
  @Test
  public void test_2() {
	  System.out.println("test_2");
  }
  @BeforeClass
  public void beforeClass() {
	  
	  System.out.println("beforeclass");
  }

  @AfterClass
  public void afterClass() {
	  
	  System.out.println("afterClass");
  }

}
