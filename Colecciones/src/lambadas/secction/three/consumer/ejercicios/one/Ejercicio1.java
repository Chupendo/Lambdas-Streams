package lambadas.secction.three.consumer.ejercicios.one;

import java.util.function.Consumer;

public class Ejercicio1 {

	public static void main(String[] args) {
		Consumer<String> toUpper = x -> System.out.println("Dato recibido: "+x.toUpperCase());
		
		toUpper.accept("Andres");
	}
}
