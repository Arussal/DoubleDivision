package com.mentat;

import java.util.List;
import java.util.ArrayList;

/**
 * 
 * Makes dividing in column form
 * 
 * @version
 * @author Ruslan Askerov
 */
public class GraphicBuilder {

	private ResultViewMaker resultViewer;

	private int divider;
	private int dividend;
	private int originalDividend;
	private final int ORIGINAL_DIVIDEND_LENGTH;

	private String dividendAsString;
	private String dividerAsString;
	private String resultAsString;

	private List<String> output;

	public GraphicBuilder(int dividend, int divider) {

		this.dividend = dividend;
		this.divider = divider;
		this.originalDividend = dividend;
		
		dividendAsString = "" + dividend;
		dividerAsString = "" + divider;

		resultViewer = new ResultViewMaker();

		ORIGINAL_DIVIDEND_LENGTH = dividendAsString.length();
	}

	public String makeOutput() {
		String result = "";
		checkNumbers();
		for (String s : makeListOfLines()) {
			result += s + "\n";
		}
		return result;
	}

	public String getResult() {
		double result = originalDividend / (double) divider;
		return resultViewer.makeResultWithPeriod(result);
	}

	public void checkNumbers() {
		if (dividend < 1) {
			System.out.println("Dividend is 0 or less");
			System.exit(0);
		}
		if (divider < 0) {
			System.out.println("Divider is negative");
			System.exit(0);
		}
		if (divider == 0) {
			throw new ArithmeticException("/ by zero");
		}
	}

	public List<String> makeListOfLines() {
		
		resultAsString = getResult();
		
		while(dividend < divider){
			dividend *= 10;
		}
		dividendAsString = "" + dividend;
		output = new ArrayList<String>();
		output.add(" " + originalDividend + 
				printMargins(dividendAsString.length() - ORIGINAL_DIVIDEND_LENGTH, " ") + 
				"|" + dividerAsString);


		output.add("-"
				+ printMargins(dividendAsString.length(), " ")
				+ "|"
				+ ((dividerAsString.length() > resultAsString.length()) ? printMargins(
						dividerAsString.length(), "-") : printMargins(
						resultAsString.length(), "-")));
		if (resultAsString.length() == 1) {
			output.add(" " + dividendAsString + "|" + resultAsString);
			output.add(printMargins(dividendAsString.length() + 1, "-"));

		} else {

			output.add(getFirstDivisionLine());
			output.add(" " + printMargins(dividendAsString.length(), "-"));
			
			int subDividend = getSubDividend(dividend);
			String subDividendAsString = "" + subDividend;
			int restFromDividing = subDividend%divider;
			String restFromDividingAsString = "" + restFromDividing;
			int biginMargin = subDividendAsString.length()-restFromDividingAsString.length();
			
			dividend = getNextDividend(dividend);
			while(dividend < divider){
				dividend *= 10;
			}
			dividendAsString = "" + dividend;
			
			for (int i = 0; i < resultAsString.length(); i++){
				
				subDividend = getSubDividend(dividend);
				subDividendAsString = "" + subDividend;
				int subWhole = getSubWhole(subDividend);
				String subWholeAsString = "" + subWhole;
				output.add(printMargins(biginMargin, " ")
						+ "_" + subDividend);
				output.add(printMargins(biginMargin
								+ subDividendAsString.length()
								- subWholeAsString.length() + 1, " ")
						+ subWhole);
				output.add(printMargins(biginMargin, " ")
						+ printMargins(subDividendAsString.length() + 1, "-"));

				dividend = getNextDividend(dividend);
				while(dividend < divider){
					dividend *= 10;
				}
				dividendAsString = "" + dividend;
				restFromDividing = subDividend%divider;
				restFromDividingAsString = "" + restFromDividing;
				biginMargin += subDividendAsString.length()-restFromDividingAsString.length();
			}
		}
		
		return output;
	}

	public int getNextDividend(int dividend) {
		int subDividend = getSubDividend(dividend);
		int whole = subDividend - subDividend % divider;
		String subDividendAsString = "" + subDividend;
		String dividendAsString = "" + dividend;
		int nextDividend = dividend
				- whole
				* (int) Math.pow(10, dividendAsString.length()
						- subDividendAsString.length());
		return nextDividend;
	}

	// select the least number from previous dividend
	// which is able been divided to divider
	public int getSubDividend(int dividend) {
		int subDividend = 0;
		String dividendAsString = "" + dividend;
		String lastNumberAsString = "" + divider;
		for (int j = 0; j < dividendAsString.length(); j++) {
			subDividend = dividend
					/ (int) Math.pow(10, (dividendAsString.length()
							- lastNumberAsString.length() - j));
			if (subDividend >= divider) {
				break;
			}
		}
		return subDividend;
	}

	public int getSubWhole(int subDividend) {
		int whole = subDividend - subDividend % divider;
		return whole;
	}

	// print margins and delimiters
	public String printMargins(int length, String symbol) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			sb.append(symbol);
		}
		return sb.toString();
	}

	public String getFirstDivisionLine() {
		int subDividend = getSubDividend(dividend);
		String subDividendAsString = "" + subDividend;
		int whole = subDividend - subDividend % divider;
		String wholeAsString = whole + "";
		return (" "
				+ printMargins(
						subDividendAsString.length() - wholeAsString.length(),
						" ")
				+ whole
				+ printMargins(
						dividendAsString.length()
								- subDividendAsString.length(), " ") + "|" + getResult());
	}
}
