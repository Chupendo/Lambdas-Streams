package lambadas.secction.For.method.refence.two;

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
		
		// Metodo referenciado a una instancia en particular
		ProveedorComparaciones pcom = new ProveedorComparaciones(); //Objeto
		//Opcion 1: llamada a un metodo existente	
		Collections.sort(lpersonas,(p1,p2)->pcom.comparadorPorEdad(p1, p2)); 
		//Opcion 2:
		Collections.sort(lpersonas,pcom::comparadorPorEdad); //uso medotodo referenciado
		
		System.out.println("Personas ordenadas por edad: ");
		lpersonas.forEach(System.out::println);
	}
}
