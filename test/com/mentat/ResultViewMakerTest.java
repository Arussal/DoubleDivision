package com.mentat;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class ResultViewMakerTest {
	private static ResultViewMaker viewMaker;
	
	@BeforeClass
	public static void classLoad(){
		viewMaker = new ResultViewMaker();
	}
	
	@Test
	public void testGetTail() {
		assertEquals("152456097845", viewMaker.getTail(54.152456097845));
		assertEquals("013500000000", viewMaker.getTail(1271.0135));
		assertEquals("123547896543", viewMaker.getTail(0.123547896543215198795132597));
	}

	@Test
	public void testFigureoutDigitsInPeriod(){
		assertEquals("3", viewMaker.figureoutDigitsInPeriod("333333333333"));
		assertEquals("32", viewMaker.figureoutDigitsInPeriod("003232323232"));
		assertEquals("12534", viewMaker.figureoutDigitsInPeriod("341253412534"));
		assertEquals("716", viewMaker.figureoutDigitsInPeriod("129756716716"));
	}
	
	@Test
	public void testMakeTailViewWithPeriod(){
		assertEquals("(6)", viewMaker.makeTailViewWithPeriod("66666666666", "6"));
		assertEquals("00(32)", viewMaker.makeTailViewWithPeriod("003232323232", "32"));
		assertEquals("(34125)", viewMaker.makeTailViewWithPeriod("341253412534", "12534"));
		assertEquals("12975(671)", viewMaker.makeTailViewWithPeriod("129756716716", "716"));
		assertEquals("152456097845", viewMaker.makeTailViewWithPeriod("152456097845", ""));
		assertEquals("625897412358", viewMaker.makeTailViewWithPeriod("625897412358", ""));
	}
	
	@Test
	public void testMakeResultWithPeriod(){
		assertEquals("15.(6)", viewMaker.makeResultWithPeriod(15.666666666666));
		assertEquals("0.00(32)", viewMaker.makeResultWithPeriod(0.003232323232));
		assertEquals("1217.(34125)", viewMaker.makeResultWithPeriod(1217.341253412534));
		assertEquals("45.12975(671)", viewMaker.makeResultWithPeriod(45.129756716716));
		assertEquals("2.152456097845", viewMaker.makeResultWithPeriod(2.152456097845));
		assertEquals("18.625897412358", viewMaker.makeResultWithPeriod(18.625897412358));
	}
}
