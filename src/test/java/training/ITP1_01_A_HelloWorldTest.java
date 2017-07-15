package training;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import introduction_to_programming.ITP1_01_A_HelloWorld;

public class ITP1_01_A_HelloWorldTest {
	
	private PrintStream defaultPrintStream;
	private ByteArrayOutputStream byteArrayOutputStream; 

	@Before
	public void setUp(){
		defaultPrintStream = System.out;
		byteArrayOutputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(new BufferedOutputStream(byteArrayOutputStream)));
	}
	@Test
	public void testMain() {
		ITP1_01_A_HelloWorld.main(new String[]{});
		System.out.flush();
		final String actual = byteArrayOutputStream.toString();
		
		final String expected = "Hello World" + System.lineSeparator();
		
		assertThat(actual, is(expected));

	}
	@After
	public void tearDown(){
		System.setOut(defaultPrintStream);
	}
}
