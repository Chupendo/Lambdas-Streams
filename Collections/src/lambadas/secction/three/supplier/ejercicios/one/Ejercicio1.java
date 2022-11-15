package lambadas.secction.three.supplier.ejercicios.one;

import java.util.function.Supplier;

public class Ejercicio1 {

	public static void main(String[] args) {
		Supplier<String> sp = ()->"Andres";
		System.out.println("Su nombre es: "+sp.get());	
	}
}
