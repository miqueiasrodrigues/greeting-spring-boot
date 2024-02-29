package br.com.rodrigues;

public class Convert {
	public static Double toDouble(String strNum) {
		if(strNum == null) return 0D;
		String number = strNum.replace(',', '.');	
		if(Validate.isNumeric(number)) return Double.parseDouble(number);
		
		return 0D;
	}
}
