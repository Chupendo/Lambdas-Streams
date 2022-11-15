package lambadas.secction.For.method.refence.one;

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
		//Ordenar por edad, mediante una expresión lambada
		//Collections.sort(lpersonas,(p1,p2)-> p1.getEdad()-p2.getEdad());
		
		//Ordenar por edad, mediante una expresión llamando a un método existente               
		//Collections.sort(lpersonas,(p1,p2)->Persona.comparPorEda(p1, p2));
		
		//Ordenar por edad, mediante una expresión llamando compata o metodo refenciado
		// Eqivalnte al anteriro, pero no hace falta pasar arguemtnos de entrada
		Collections.sort(lpersonas,Persona::comparPorEda);
		System.out.println("Personas ordenadas por edad: ");
		lpersonas.forEach(System.out::println);
	}
}
