package lambadas.secction.three.biConsumer.ejercicios.one;

import java.util.function.BiConsumer;

public class Ejercicio1 {

	public static void main(String[] args) {
		BiConsumer<String, Integer> biCons = (nombre,edad)-> System.out.println("Nombre: "+nombre+", Edad= "+edad);
		
		biCons.accept("Andres", 33);
	}
}
