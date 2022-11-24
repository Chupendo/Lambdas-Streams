package lamdas.secction.eightejercicio.one;

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
		
		
		// Devolver Hombre y que empieza por A
		System.out.println("Hombres y que empieze por A:");

		lEmpleados
			.stream()
			.filter(Empleado::esHombre)
			.filter(emp->emp.getNombre().startsWith("A"))
			.forEach(System.out::println);
		
		// Devolver personal femenino mayor de 25 y cobre mas de 23k
		System.out.println("Personal femenino mayor de 25 y cobre mas de 23k:");
		Predicate<Empleado> empFem = Empleado::esMujer;
		Predicate<Empleado> empMayor24 = em -> em.getEdad()>25;
		Predicate<Empleado> empInMayor23k = em -> em.getIngresos()>23000;
		Predicate<Empleado> empFemMayor24InMayor23K = empFem.and(empMayor24).and(empInMayor23k);
		
		lEmpleados
			.stream()
			.filter(empFemMayor24InMayor23K)
			.forEach(System.out::println);
		
		System.out.println("Numero total de empleadas mayroes de 25 y cue cobra mas de 23k: "+
				lEmpleados
				.stream()
				.filter(empFemMayor24InMayor23K)
				.count()
		);
		
	}
	
}
