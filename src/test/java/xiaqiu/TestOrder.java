package xiaqiu;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class TestOrder {
  @Test
  public void f1() {
	  System.out.println("test1");
	  
  }
  @Test
  public void f2() {
	  System.out.println("test2");
	  
  }
  @BeforeClass
  public void beforeClass() {
	  System.out.println("beforeClass");
	  
  }

}
