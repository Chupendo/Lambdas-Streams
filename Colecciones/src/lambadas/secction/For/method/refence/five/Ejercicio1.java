package lambadas.secction.For.method.refence.five;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public class Ejercicio1 {

	public static void main(String[] args) {
		List<String> numeros = Arrays.asList("10","10","15","20","15","25","6","30","40","20");
		
		//Opicon 2: Metodo referenciado
		//Opcion 1:
		System.out.println("Opcion 1: Expresiones lamabda");
		getResult(numeros,(dato)->new Integer(dato)).forEach(dato->multiplicarPor10(dato));
		System.out.println("Opcion 2: Metodos referenciados");
		getResult(numeros, Integer::new).forEach(Ejercicio1::multiplicarPor10);
	}
	
	public static List<Integer> getResult(List<String> datos,
			Function<String, Integer> func){
			List<Integer> result = new ArrayList<Integer>();
			datos.forEach(dato->result.add(func.apply(dato)));
		return result;
	}
	
	public static void multiplicarPor10(Integer x){
		System.out.println("El nuevo valor del dato "+x+" es: "+(x*19));
	}
}
