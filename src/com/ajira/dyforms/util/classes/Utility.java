package com.ajira.dyforms.util.classes;

public class Utility {
	
	public static int isNum(String strNum) {
	    int num = -1;
	    try {
	        num = Integer.parseInt(strNum);

	    }catch (NumberFormatException e) {
	    	num = -1;
	    }
	    return num;
	}

}
