package lambdas.secction.For.method.refence.For;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public class Ejercicio1 {

	public static void main(String[] args) {
		List<String> numeros = Arrays.asList("10","10","15","20","15","25","6","30","40","20");
		
		//metodo referneciado a consturctor
		//Opcion 1: Llamada al construcro dentro de la lambda
		Function<String, Integer> func =(dato)-> new Integer(dato);
		getResult(numeros, func).forEach(System.out::println);
		
		System.out.println();
		//Opicon 2: Metodo referenciado
		getResult(numeros, Integer::new).forEach(System.out::println);
	}
	
	public static List<Integer> getResult(List<String> datos,
			Function<String, Integer> func){
			List<Integer> result = new ArrayList<Integer>();
			datos.forEach(dato->result.add(func.apply(dato)));
		return result;
	}
}
