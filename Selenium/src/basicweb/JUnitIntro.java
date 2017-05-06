package basicweb;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JUnitIntro {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Executed before class..");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Executed afret class..");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Executed before test..");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Executed after test..");
	}

	@Test
	public void test() {
		System.out.println("test...");
	}
	
	@Test
	public void test1() {
		System.out.println("test1...");
	}

}
