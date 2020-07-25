package com.ajira.dyforms.classes;

public class Utility {
	
	public static boolean isNum(String strNum) {
	    boolean isNum = true;
	    try {
	        Integer.parseInt(strNum);

	    }catch (NumberFormatException e) {
	    	isNum = false;
	    }
	    return isNum;
	}

}
