package lambadas.secction.three.binaryOperator.ejercicios.one;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Ejercicio2 {

	public static void main(String[] args) {
		// Instantiate the UnaryOperator interface
		BinaryOperator<Integer> pow = (a,b)-> {
			Integer resltado = a;
			for(int i=0;i<b;i++) {
				resltado=resltado*a;
			}
			return resltado;
		};
		BinaryOperator<Integer> and = (x,b)->x&b;
		Function<Integer, Integer> xor2 = (x)->x^1;
		
		// BiFunction.Apply() method
		System.out.println("POW 2^3->"+pow.apply(2,3));
		System.out.println("AND 2 & 3->"+and.apply(2,3));
		
		// BiFunction.apply() and then Fucntion.apply() 
		System.out.println("AND (2 & 3) AND THEN ^1->"+and.andThen(xor2).apply(3,2));
	
	}
}

