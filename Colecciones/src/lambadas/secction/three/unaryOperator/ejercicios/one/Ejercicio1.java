package lambadas.secction.three.unaryOperator.ejercicios.one;

import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Ejercicio1 {

	public static void main(String[] args) {
		// Instantiate the UnaryOperator interface
		UnaryOperator<String> uo = UnaryOperator.identity();
		// Apply identify() method
		System.out.println("Identity: "+uo.apply("hola"));
	}
}
