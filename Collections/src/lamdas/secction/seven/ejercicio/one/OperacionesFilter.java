package lamdas.secction.seven.ejercicio.one;

import java.util.List;
import java.util.function.Predicate;

public class OperacionesFilter {

	public static void main(String[] args) {
		List<Empleado> lEmpleados = Empleado.empleados();
		
		//Devolver hombres
		System.out.println("Hombres:");

		lEmpleados
			.stream()
			.filter(new Predicate<Empleado>() {
				@Override
				public boolean test(Empleado t) {
				
					return t.esHombre();
				}
			})
			.forEach(System.out::println);

		//Devolver mayores de 20
		System.out.println("Mayores de 20:");

		lEmpleados
			.stream()
			.filter(empleado->empleado.getEdad()>20)
			.forEach(System.out::println);

		//Devolver Hombre y menroes de 26
		System.out.println("Hombres y menroes de 26:");

		lEmpleados
			.stream()
			.filter(empleado-> empleado.esHombre() && empleado.getEdad()<26)
			.forEach(System.out::println);
	}
	
}
