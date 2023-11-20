package junit.tutorial;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

public class CalculatorTest {
	
	private Calculator calc;

	@BeforeEach
	public void setUp() throws Exception {
		calc = new Calculator();
		calc.init();
	}
	
	@AfterEach
	public void tearDown() throws Exception {
		calc.shutdown();
	}
		
	@Test
	public void multyplyで3と4の乗算結果が取得できる() {
		int expected = 12;
		
		int actual = calc.multiply(3, 4);
		
		assertThat(actual, is(expected)); // spock expected == actual
	}

	@Test
	public void multyplyで5と7の乗算結果が取得できる() {
		int expected = 35;
		int actual = calc.multiply(5, 7);
		assertThat(actual, is(expected)); // spock expected == actual
	}
/**
 * 	
	@Test
	def 'multiplyで#xと#yの計算結果が取得できる'() {
		setup:
			Calculator calc = new Calculator()			
		when:
			int actual = calc.multiply(x, y)
		then:
			actual == expected;
		where:
			x | y | expected
			3 | 4 | 12
			5 | 7 | 35
 */
	
	@Test
	public void divideで3と4の除算結果が取得できる() {
		double expected = 1.5;
		
		double actual = calc.divide(3, 2);
		
		assertThat(actual, is(expected)); // spock expected == actual
	}
	
	@Disabled
	@Test
	@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
	public void divideで2と1の除算結果が取得できる() {
		double expected = 2;
		
		try {
			// msec止める
			Thread.sleep(200L);
		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		double actual = calc.divide(2, 1);
		
		assertThat(actual, is(expected)); // spock expected == actual
	}
	
	@Test
	public void divideで5と0のときIllegalArgumentExceptionが発生する() throws IllegalArgumentException {
		
		IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
			calc.divide(5, 0);
		});
		
		assertThat(thrown.getMessage(), is("divide by zero."));
//		Assertions.assertEquals("divide by zero.", thrown.getMessage());
	}
	
	
	/**
	 * 
	 def 'divideで5と0のときIllegalArgumentExceptionが発生する'() {	 
		setup:
			Calculator calc = new Calculator()			
		when:
			int actual = calc.divide(5, 0)
		then:
			IllegalArgumentException e = thrown()
	 		e.getMessage() == "divide by zero."	 
	 }

	 */

}
