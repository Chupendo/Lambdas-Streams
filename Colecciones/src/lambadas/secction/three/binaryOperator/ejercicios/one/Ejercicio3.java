package lambadas.secction.three.binaryOperator.ejercicios.one;

import java.util.Comparator;
import java.util.function.BinaryOperator;

public class Ejercicio3 {

	public static void main(String[] args) {
		// Instantiate the BinaryOperator interface
		BinaryOperator<Integer> max =  BinaryOperator.minBy(Integer::compareTo);

		BinaryOperator<Integer> max2 =  BinaryOperator.minBy((Integer a1,Integer a2)->a1.compareTo(a2));
		// Apply() method
		System.out.println("min(3,4)->"+max.apply(3,4));
		System.out.println("min(2,1)->"+max.apply(2,1));
		
	}
}
