package training;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import introduction_to_programming.ITP1_01_B_X_Cubic;

public class ITP1_01_B_X_CubicTest {
	
	private PrintStream defaultPrintStream;
	private ByteArrayOutputStream byteArrayOutputStream; 
	private StandardInputSnatcher in = new StandardInputSnatcher();

	@Before
	public void setUp(){
		defaultPrintStream = System.out;
		byteArrayOutputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(new BufferedOutputStream(byteArrayOutputStream)));
		System.setIn(in);
	}
	
	@After
	public void tearDown(){
		System.setOut(defaultPrintStream);
		System.setIn(System.in);
	}

	@Test
	public void testMain() {
		in.inputln("3");
		ITP1_01_B_X_Cubic.main(null);
		System.out.flush();
		final String actual = byteArrayOutputStream.toString();
		
		final String expected = "27" + System.lineSeparator();
		
		assertThat(actual, is(expected));
	}

}
