package lambadas.secction.three.prediacate.ejercicios.two;


import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Ejercicio02 {

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
		
		Evaluador eva = new Evaluador();
		List<Empleado> lEmpladosMayores25 = eva.evaluador(listaEmpleados, (empleado)->empleado.getEdad()>25);
		lEmpladosMayores25.forEach(System.out::println);
		
		System.out.println("-------------");
		List<Empleado> lEmpladosInicianConA= eva.evaluador(listaEmpleados, (empleado)->empleado.getNombre().startsWith("A"));
		lEmpladosInicianConA.forEach(System.out::println);
		
	}	
}

