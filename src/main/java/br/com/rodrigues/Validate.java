package br.com.rodrigues;

public class Validate {

	
	public static boolean isNumeric(String strNum) {
		if(strNum == null) return false;
		String number = strNum.replace(',', '.');
		
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}

}
