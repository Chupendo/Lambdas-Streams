package lamdas.secction.seven.ejercicio.one;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class OperacionesReduccion1 {

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
		
		// Suma de elementos
		int suma = 0;
		suma = Arrays.stream(numeros)
			.sum();
		System.out.println("Suma = "+suma);
		
		// Promedio
		double promedio = 0.0;
		promedio = Arrays.stream(numeros)
				.average()
				.orElse(0);
				
		System.out.println("Promedio 1= "+promedio);
		
		promedio = Arrays.stream(numeros)
				.mapToDouble(n->Integer.valueOf(n)).average().orElse(0);
		System.out.println("Promedio 2= "+promedio);
			
		// Máximo y mínimo
		int max = 0, min = 0;
		max = Arrays.stream(numeros)
			.max().orElse(0);
		min = Arrays.stream(numeros)
			.min().orElse(0);
		System.out.println("Maximo: "+max+", Minimo: "+min);
	
		// conteo
		int count = 0;
		count = (int) Arrays.stream(numeros)
				.count();
		System.out.println("Conteo: "+count);

		// Dada una lista de emepelados obenter el/la de mayor edad
		List<Empleado> lEmpleado = Empleado.empleados();
		
		Empleado emp = lEmpleado.stream().max((emp1,emp2)->emp1.getEdad()-emp2.getEdad()).orElse(null);
		System.out.println("Empleado de mayor edad: "+emp);

	}

}
