package lamdas.secction.seven.ejercicio.one;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.IntBinaryOperator;
import java.util.stream.IntStream;

public class OperacionesReduccion2 {

	public static void main(String[] args) {
		int [] numeros = new int[10];
		
		//create
		int i = 0;
		while(i<numeros.length) {
			Random ram = new Random();
			numeros[i] = ram.nextInt(0, 100);
			i++;
		}
		
		System.out.print("Arrays: ");
		Arrays.stream(numeros).forEach(n-> System.out.print(n+", "));
		System.out.println();
		
		// Suma
		int suma = IntStream.of(numeros).reduce(0, new IntBinaryOperator() {
			
			@Override
			public int applyAsInt(int left, int right) {
				return left+right;
			}
		});
		System.out.println("Suma = "+ suma);
			

		int suma2 = IntStream.of(numeros).reduce(0, (num1,num2)->Integer.sum(num1, num2));
		System.out.println("Suma 2= "+ suma);
		
		int suma3 = IntStream.of(numeros).reduce(0, Integer::sum);
		System.out.println("Suma 3= "+ suma);
		// Dada una lista de emepelados obenter el/la de mayor edad
		List<Empleado> lEmpleado = Empleado.empleados();
		
	

	}

}
