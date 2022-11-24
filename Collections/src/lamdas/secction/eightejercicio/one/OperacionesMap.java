package lamdas.secction.eightejercicio.one;

import java.util.List;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

public class OperacionesMap {

	public static void main(String[] args) {
		List<Empleado> lEmpleados = Empleado.empleados();
		
		// Devolver la edad de los empleados
		System.out.println("Edad de los empleados: ");
		lEmpleados.stream()
			.mapToInt(em->em.getEdad())
			.forEach(System.out::println);
		
		// Devolver el cuadrado de un numero
		System.out.println("Para elemento lo multiplica por si mismo: ");
		IntStream.rangeClosed(1, 5)
			.map(new IntUnaryOperator() {
				
				@Override
				public int applyAsInt(int operand) {
					return operand*operand;
				}
			}).forEach(System.out::println);
		
		// Ingreos poremadio de mujeres mayores de 16
		double promedio = lEmpleados.stream()
			.filter(Empleado::esMujer)
			.filter(em->em.getEdad()>16)
			.mapToDouble(em->em.getIngresos())
			.average().orElse(0);
		System.out.println("EL ingreso poremod de empleadas maoyres de 16: "+promedio);
	}

}
