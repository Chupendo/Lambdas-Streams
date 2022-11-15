package lambdas.secction.For.method.refence.three;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Ejercicio1 {

	public static void main(String[] args) {
		List<Persona> lpersonas = Arrays.asList(
				new Persona("Juan", 18, "juanito@hotamil.com"),
				new Persona("Mario", 17, "mario@hotamil.com"),
				new Persona("Arturo", 17, "arturito@hotamil.com"),
				new Persona("Maira", 15, "maria@hotamil.com"),
				new Persona("Beatriz", 14, "bety@hotamil.com"),
				new Persona("Olivia", 12, "olio@hotamil.com"),
				new Persona("Ángel", 25, "angelito@hotamil.com"),
				new Persona("Pamela", 28, "pamelita@hotamil.com"),
				new Persona("Sandee", 25, "sandecita@hotamil.com"),
				new Persona("Jared", 12, "jarecdcito@hotamil.com"),
				new Persona("Sebastian", 14, "sebastiancito@hotamil.com"),
				new Persona("Roberto", 20, "robertito@hotamil.com"),
				new Persona("Oyuki", 22, "oyukita@hotamil.com"),
				new Persona("Linda", 25, "lindita@hotamil.com")
				);
		
		System.out.println("Personas sin ordenar: ");
		lpersonas.forEach(System.out::println);
		System.out.println();
		
		// Metodo referenciado a una instancia arbitraria de un tipo especifico
		
		//Opcion 1: llamada a un metodo existente	
		Collections.sort(lpersonas,(p1,p2)->p1.comparPorEda2(p2)); 
		
		//Opcion 2: uso medotodo referenciado
		// Se especifica el tipo del obejto que invoca el metodo en lugar
		// del objeto, dado que se desconoce que objeto per1 o per2 invonca
		// al método, por esta razon se indica el nombre de clase.
		Collections.sort(lpersonas,Persona::comparPorEda2);
		
		System.out.println("Personas ordenadas por edad: ");
		lpersonas.forEach(System.out::println);
	}
}
