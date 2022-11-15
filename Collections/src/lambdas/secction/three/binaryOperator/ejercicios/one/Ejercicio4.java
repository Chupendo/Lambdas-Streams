package lambdas.secction.three.binaryOperator.ejercicios.one;

import java.util.Comparator;
import java.util.function.BinaryOperator;

public class Ejercicio4 {

	public static void main(String[] args) {
		// Instantiate the BinaryOperator interface
		Comparator<Integer> com1 = Comparator.naturalOrder();
		BinaryOperator<Integer> max =  BinaryOperator.maxBy(com1);
		
		// Apply() method
		System.out.println("max->"+max.apply(3,4));
		
	}
}
