package com.mentat;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

public class ResultViewMaker {
	
	public String makeResultWithPeriod(double result){
		String integ = "" + (int)result;
		Formatter formatter = new Formatter();
		String tail = getTail(result);
		formatter.format("%.10f", tail);
		System.out.println(formatter);
		//String digits = figureoutDigitsInPeriod(tail);
		//return integ + "." + makeTailViewWithPeriod(tail, digits);
		return null;
	}
	
	
	public String getTail(double result){
		String tail = "" + result;
		String integ = "" + (int)result;
		tail = tail.substring(integ.length()+1);
		if (tail.length() > 10) {
			tail = tail.substring(0, 10);
		}
		return tail;
	}
	
	
	public String figureoutDigitsInPeriod(String tail){
		
		String reversedPeriod = "";
		
		int[] mass = new int[tail.length()];
		for (int i = 0; i < tail.length(); i++){
			mass[i] = Integer.parseInt(tail.substring(i, i+1));
		}
		
		List<String> periods = new ArrayList<String>();
		
		int limit = mass.length/2;
		
		boolean match = false;
		outer: for (int i = 0; i < limit; limit--){
			reversedPeriod = "";
			for (int j = 0; j < limit; j++){
				if(mass[mass.length-1-j] != mass[mass.length-1-limit-j]){
					match = false;
					break;
				} else {
					match = true;
					reversedPeriod += mass[mass.length-1-limit-j];
				}
			}
			if (match) {
				periods.add(reversedPeriod);
			}
		}
		
		for (int i = periods.size()-1; i >= 0; i--){
			if (periods.get(i) != "") {
				reversedPeriod = periods.get(i);
				break;
			}
		}
		
		String rightOrderPeriod = getRightOrder(reversedPeriod);
		return rightOrderPeriod;

	}
	
	public String getRightOrder(String reversedPeriod){
		String rightOrderPeriod = "";
		for (int i = reversedPeriod.length()-1; i >= 0; i--){
			rightOrderPeriod += reversedPeriod.charAt(i);
		}
		return rightOrderPeriod; 
	}
	
	public String makeTailViewWithPeriod(String tail, String digits){
		String resultAsString = "";
		if (digits.equals("")){
			return tail;
		} else {
			
		outer: for (int i = 0; i < tail.length()-digits.length()*2+1; i++){
			for (int j = 0; j < digits.length(); j++){
				if ((tail.substring(i, i+digits.length()).equals(digits))
						&& (tail.substring(i+digits.length(), i+digits.length()*2).equals(digits))){
					resultAsString = tail.substring(0, i) + "(" + digits + ")";
					break outer;
				} else {
					digits = digits.substring(1) + digits.substring(0, 1);
				}
			}
		}
		}
		return resultAsString;
	}
	
	public static void main(String[] args) {
		ResultViewMaker ddm = new ResultViewMaker();
		System.out.println(ddm.makeResultWithPeriod(15.53212532123));
	}

}
