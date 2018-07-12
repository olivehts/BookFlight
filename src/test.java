import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class test {

	@BeforeMethod()
	public void Beforetest1(){
		System.out.println("Beforetest1......");
	}	
	@Test
	public void test1(){
		System.out.println("Test 1 ......");
	}
	
	
	
	@BeforeMethod
	public void Beforetest2(){
		System.out.println("Beforetest2......");
	}	
	@Test
	public void test2(){
		System.out.println("Test 2 ......");
	}
}
