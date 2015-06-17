package com.mentat;

public class OutputPrinter {
	public static void main(String[] args) {
		int dividend = 20;
		int divider = 6;
		GraphicBuilder dr = new GraphicBuilder(dividend, divider);
		System.out.println(dr.makeOutput());
	}
}
