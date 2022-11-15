package lambdas.secction.three.function.ejercicios.three;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Ejercicio03 {

	public static void main(String[] args) {
		DatosComensales dComensal = new DatosComensales();
		List<Comensal> lComensal = Arrays.asList(new Comensal("Andres", "Ruiz",29),
				new Comensal("Juan", "Perez",35),
				new Comensal("Ramon", "Ruiz",17),
				new Comensal("Perico", "Sanchez",25)
				);
		//Expresiones lambdas
		Function<Comensal, Object> getName = x -> x.getName();
		Function<Comensal, Object> getNameFull = x -> x.getName()+" "+x.getSurname();
		Function<Comensal, Object> getEdad = x-> x.getEdad();
		
		List<String> lNameComensales = (List) dComensal.getDatosComensales(lComensal, getName);
		System.out.println("Nombres Comensale");
		System.out.println("-----------------");
		lNameComensales.forEach(System.out::println);
		
		List<String> lNameFullComensales = (List) dComensal.getDatosComensales(lComensal, getNameFull);
		System.out.println("Nombres Full Comensale");
		System.out.println("-----------------");
		lNameFullComensales.forEach(System.out::println);
		
		List<Integer> lEdadComensales = (List) dComensal.getDatosComensales(lComensal, getEdad);
		System.out.println("Edad Comensale");
		System.out.println("-----------------");
		lEdadComensales.forEach(System.out::println);

	}	
}
