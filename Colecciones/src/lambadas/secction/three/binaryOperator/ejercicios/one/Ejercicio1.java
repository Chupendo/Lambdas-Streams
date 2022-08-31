package lambadas.secction.three.binaryOperator.ejercicios.one;

import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Ejercicio1 {

	public static void main(String[] args) {
		// Instantiate the UnaryOperator interface
		BinaryOperator<String> bo = (x,y)->"hola "+x+" "+y;
		
		// Apply method
		System.out.println("Identity: "+bo.apply("Andres","Ruiz"));
	}
}
