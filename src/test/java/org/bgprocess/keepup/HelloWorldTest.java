package org.bgprocess.keepup;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sun.jersey.test.framework.JerseyTest;


public class HelloWorldTest extends JerseyTest {
	public HelloWorldTest() {
		super("org.bgprocess.keepup");
	}
	
	@Test public void
	respondsWithHelloWorld() {
		assertEquals("Hello World!", resource().path("/hello").get(String.class));
	}
}
