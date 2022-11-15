package lambdas.secction.three.unaryOperator.ejercicios.one;

import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Ejercicio2 {

	public static void main(String[] args) {
		// Instantiate the UnaryOperator interface
		UnaryOperator<Integer> xor = (x)->x^1;
		UnaryOperator<Integer> and = (x)->x&1;
		
		// Apply() method
		System.out.println("XOR 3->"+xor.apply(3));
		System.out.println("XOR 3 THEN (& XOR 3)->"+xor.andThen(and).apply(3));
	}
}
