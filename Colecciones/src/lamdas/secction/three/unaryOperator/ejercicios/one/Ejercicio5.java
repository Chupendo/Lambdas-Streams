package lambadas.secction.three.unaryOperator.ejercicios.one;

import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Ejercicio5 {

	public static void main(String[] args) {
		// Instantiate the UnaryOperator interface
		UnaryOperator<Integer> xor = (x)->x^1;
		UnaryOperator<Integer> and = (x)->x&1;
		UnaryOperator<Integer> or = (x)->x|1;
		// Apply() method
		System.out.println("& 3->"+and.apply(3));
		System.out.println("XOR 1->"+xor.apply(1));
		System.out.println("OR 0->"+xor.apply(0));
		
		System.out.println("OR.XOR.COMPOSE(& 3)->"+xor.compose(and).andThen(or).apply(3));
	}
}
