package lambdas.secction.five.iteraccion;

import java.util.Arrays;
import java.util.List;

public class IteracionExterna {

	public static void main(String[] args) {
		// Suma de los numeros al curado de los numeros pares
		List<Integer> lNumeros = Arrays.asList(1, 2, 3, 4, 5);
		
		System.out.println("Suma de los numeros al curado de los numeros pares.");
		System.out.print("Lista: {");
		lNumeros.forEach(num->{
			System.out.print(" "+num);
		});
		System.out.println(" }");
		int suma = 0;
		for(Integer numero: lNumeros) {
			if(numero%2==1) {
				suma += (numero*numero);
			}
		}
		System.out.println("Resultado: "+suma);
	}
}
