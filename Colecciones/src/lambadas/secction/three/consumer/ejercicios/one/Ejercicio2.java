package lambadas.secction.three.consumer.ejercicios.one;

import java.util.function.Consumer;

public class Ejercicio2 {

	public static void main(String[] args) {
		Consumer<String> show = x -> System.out.println("Dato recibido: "+x);
		
		show.accept("Andres");
	}
}
