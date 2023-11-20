package junit.tutorial;

public class Calculator {
	
	public int multiply(int x, int y) {
		return x * y;
	}
	
	public double divide(int x, int y) throws IllegalArgumentException{
		if (y == 0) {
			throw new IllegalArgumentException("divide by zero.");
		}
		return (double)x / (double)y;
	}
	
	public void init() {
		System.out.println("call init");
	}
	
	public void shutdown() {
		System.out.println("call shutdown");
	}

}
