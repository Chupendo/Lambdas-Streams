package lambdas.secction.three.prediacate.ejercicios.one;


import java.util.function.Predicate;

public class Ejercicio01 {

	public static void main(String[] args) {
		Predicate<Integer> predicado = x-> x>0;
		
		System.out.println("x>0?:  "+predicado.test(29));
		System.out.println("x>0?:  "+predicado.test(-6));
	}	
}

