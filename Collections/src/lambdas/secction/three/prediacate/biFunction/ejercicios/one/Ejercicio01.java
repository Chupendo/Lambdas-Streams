package lambdas.secction.three.prediacate.biFunction.ejercicios.one;


import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Ejercicio01 {

	public static void main(String[] args) {
		List<Empleado> listaEmpleados = Arrays.asList(
				new Empleado("Rodrigo",25,1500,"Cobranzas"),
				new Empleado("Alicia",25,1500,"Ventas"),
				new Empleado("Manolo",30,2500,"Ventas"),
				new Empleado("Cinthia",20,2500,"Mostrador"),
				new Empleado("Esteban",19,7000,"Ventas"),
				new Empleado("Dámaris",32,600,"Telemarketing"),
				new Empleado("Lina",25,2500,"Mostrador"),
				new Empleado("Nayeli",44,10000,"Ventas"),
				new Empleado("Flor",35,7000,"Compras"),
				new Empleado("German",20,1500,"Facturacion"));
		listaEmpleados.forEach(System.out::println);
				
		/*Incrementa el sarlio a los mayores de 25 un 5%*/
		//1º Obtenemos los empeleados mayores de 25
		System.out.println("-------------");
		System.out.println("Empleados mayores de 25");
		Evaluador eva = new Evaluador();
		List<Empleado> lEmpladosMayores25 = eva.evaluador(listaEmpleados, (empleado)->empleado.getEdad()>25);
		lEmpladosMayores25.forEach(System.out::println);
		//*Aplicmaos el incrmento
		System.out.println("Incrementa el sarlio a los mayores de 25 un 5%");
		Funciones func = new Funciones();
		for(Empleado empleado:lEmpladosMayores25) {
			Double nuevoSalario = func.incrementoSalario(empleado, 5.00, (sal,inc)-> sal+(sal*inc/100));
			empleado.setSalario(nuevoSalario);
		}
		lEmpladosMayores25.forEach(System.out::println);
		
	}	
}

