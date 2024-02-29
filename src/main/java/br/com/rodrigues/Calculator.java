package br.com.rodrigues;

public class Calculator {
	private final double num1;
	private final double num2;
	
	
	public Calculator(double num1, double num2) {
		this.num1 = num1;
		this.num2 = num2;
	}
	
	public Double sum() {
		return this.num1 + this.num2;
	}
	
	public Double sub() {
		return this.num1 - this.num2;
	}
	
	public Double mult() {
		return this.num1 * this.num2;
	}
	
	public Double div() throws ArithmeticException {
        if (this.num2 == 0) {
            throw new ArithmeticException("Cannot divide by zero!");
        }
        return this.num1 / this.num2;
    }

}
