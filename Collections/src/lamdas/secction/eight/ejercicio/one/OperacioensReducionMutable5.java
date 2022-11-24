package lamdas.secction.eight.ejercicio.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OperacioensReducionMutable5 {

	// Apartir de una matriz de String obtener una List<String> mediante collect()
	public static void main(String[] args) {
		List<Empleado> lEmpleados = Empleado.empleados();
		System.out.println("Lista de empleados: ");
		lEmpleados.forEach(System.out::println);
		
		//Mapa<Id_Empleado,Nombre_Empleado>
		Map<Long, String> idNombreMapa = 
				lEmpleados.stream()
				.collect(Collectors.toMap(Empleado::getId, Empleado::getNombre));
		
		idNombreMapa.forEach((k,v)->System.out.println(k+": "+v));
		
		
		//Agrupa por genero
		Map<Genero,String> gneroAnombreMapa =
				lEmpleados.stream()
				.collect(
						Collectors.toMap(
								Empleado::getGenero, //key
								Empleado::getNombre, //value
								(nomb1,nomb2)->String.join(", ", nomb1, nomb2) //agurpar
								));
		gneroAnombreMapa.forEach((k,v)->System.out.println(k+": "+v));
	}
}
