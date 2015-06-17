package com.mentat;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class GraphicBuilderTest {
	private static GraphicBuilder gBuilder;
	
	@Before
	public void classLoad(){
		gBuilder = new GraphicBuilder(17, 15);
	}

	@Test
	public void testMakeOutput() {
		String output = " 17|15\n" +
						"-  |------\n" +
						" 15|1.1(3)\n" +
						" --\n" +
						" _20\n" +
						"  15\n" +
						" ---\n" +
						"  _50\n" + 
						"   45\n" +
						"  ---\n" +
						"   _50\n" + 
						"    45\n" +
						"   ---\n" +
						"    _50\n" + 
						"     45\n" +
						"    ---\n" +
						"     _50\n" + 
						"      45\n" +
						"     ---\n" +
						"      _50\n" + 
						"       45\n" +
						"      ---\n";
		assertEquals(output, gBuilder.makeOutput());
		gBuilder = new GraphicBuilder(130, 14);
		output = 		" 130|14\n" +
						"-   |----------\n" +
						" 126|9.(285714)\n" +
						" ---\n" +
						"  _40\n" +
						"   28\n" +
						"  ---\n" +
						"  _120\n" + 
						"   112\n" +
						"  ----\n" +
						"    _80\n" + 
						"     70\n" +
						"    ---\n" +
						"    _100\n" + 
						"      98\n" +
						"    ----\n" +
						"      _20\n" + 
						"       14\n" +
						"      ---\n" +
						"       _60\n" + 
						"        56\n" +
						"       ---\n" +
						"        _40\n" +
						"         28\n" +
						"        ---\n" +
						"        _120\n" + 
						"         112\n" +
						"        ----\n" +
						"          _80\n" + 
						"           70\n" +
						"          ---\n" +
						"          _100\n" + 
						"            98\n" +
						"          ----\n";
		assertEquals(output, gBuilder.makeOutput());
		
	}

	@Test
	public void testGetResult() {
		assertEquals("1.1(3)", gBuilder.getResult());
		gBuilder = new GraphicBuilder(182, 9);
		assertEquals("20.(2)", gBuilder.getResult());
		gBuilder = new GraphicBuilder(173, 13);
		assertEquals("13.(307692)", gBuilder.getResult());
	}

	@Test (expected = ArithmeticException.class)
	public void testCheckNumbers() {
		gBuilder = new GraphicBuilder(1, 0);
		gBuilder.checkNumbers();
	}

	@Test
	public void testMakeListOfLines() {
		List <String> list = gBuilder.makeListOfLines();
		assertEquals(22, list.size());
	}

	@Test
	public void testGetNextDividend() {
		assertEquals(3, gBuilder.getNextDividend(18));
		assertEquals(60, gBuilder.getNextDividend(1260));
		assertEquals(4, gBuilder.getNextDividend(64));
	}

	@Test
	public void testGetSubDividend() {
		assertEquals(130, gBuilder.getSubDividend(13));
		assertEquals(20, gBuilder.getSubDividend(2));
		assertEquals(19, gBuilder.getSubDividend(19));
	}

	@Test
	public void testGetSubWhole() {
		assertEquals(15, gBuilder.getSubWhole(16));
		assertEquals(270, gBuilder.getSubWhole(276));
		assertEquals(45, gBuilder.getSubWhole(49));
	}

	@Test
	public void testPrintMargins() {
		assertEquals("     ", gBuilder.printMargins(5, " "));
		assertEquals("---", gBuilder.printMargins(3, "-"));
		assertEquals("-|--|--|--|-", gBuilder.printMargins(4, "-|-"));
	}

	@Test
	public void testGetFirstDivisionLine() {
		gBuilder = new GraphicBuilder(17, 15);
		assertEquals(" 15|1.1(3)", gBuilder.getFirstDivisionLine());
		gBuilder = new GraphicBuilder(13, 140);
		assertEquals(" 1260|0.092857142857", gBuilder.getFirstDivisionLine());
	}

}
