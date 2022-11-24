package lamdas.secction.seven.ejercicio.one;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.IntBinaryOperator;
import java.util.stream.IntStream;

public class OperacionesReduccion3 {

	public static void main(String[] args) {
		int suma = (int) IntStream
				.range(1, 99)
				.limit(10)
				.summaryStatistics()
				.getSum();
		System.out.println("Suma: "+suma);
	

	}

}
