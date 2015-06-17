package com.mentat;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class GraphicBuilderTest {
	private GraphicBuilder gBuilder;
	
	@BeforeClass
	public static void classLoad(){
		
	}
		
	
	@Test
	public void testGraphicBuilder() {
		fail("Not yet implemented");
	}

	@Test
	public void testMakeOutput() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetResult() {
		fail("Not yet implemented");
	}

	@Test (expected = ArithmeticException.class)
	public void testCheckNumbers() {
		gBuilder = new GraphicBuilder(1, 0);
		gBuilder.checkNumbers();
	}

	@Test
	public void testMakeListOfLines() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNextDividend() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSubDividend() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSubWhole() {
		fail("Not yet implemented");
	}

	@Test
	public void testPrintMargins() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFirstDivisionLine() {
		fail("Not yet implemented");
	}

}
