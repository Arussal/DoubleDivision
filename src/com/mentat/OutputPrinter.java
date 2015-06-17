package com.mentat;

public class OutputPrinter {
	public static void main(String[] args) {
		int dividend = 17;
		int divider = 15;
		GraphicBuilder dr = new GraphicBuilder(dividend, divider);
		System.out.println(dr.makeOutput());
	}
}
