package lambadas.secction.three.prediacate.biPredicate.ejercicios.one;


import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class Ejercicio01 {

	public static void main(String[] args) {
		Boolean answer;
		BiPredicate<Integer, Integer> bp = (x,y) -> x<y;
				
		answer = bp.test(8, 20);
		System.out.println("Is 8 lower that 20?: "+ answer);
		answer = bp.test(20, 8);
		System.out.println("Is 20 lower that 8?: "+ answer);
	}	
}

