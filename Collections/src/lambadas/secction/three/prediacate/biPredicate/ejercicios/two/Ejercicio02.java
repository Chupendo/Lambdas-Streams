package lambadas.secction.three.prediacate.biPredicate.ejercicios.two;


import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

import lambadas.secction.three.prediacate.biFunction.ejercicios.two.Empleado;

/**
 * Se requiere obtener un reporte con todos los empleados que cumpla con alguno de estos dos conjuntos de criterios:
 * 1)	25 años en adelante y que estén en el departamento de Ventas o
 * 2)	25 años en adelante y que estén en el mostrador
 * *
 * @author andres.rpenuela
 *
 */
public class Ejercicio02 {

	public static void main(String[] args) {
		BiPredicate<Integer, String> bp;
		List<Empleado> listaNueva;
		List<Empleado> listaEmpleados;
		Evaluator eva;
		
		listaEmpleados = Arrays.asList(
				new Empleado("Rodrigo",25,1500,"Cobranzas"),
				new Empleado("Alicia",25,1500,"Ventas"),
				new Empleado("Manolo",30,2500,"Ventas"),
				new Empleado("Cinthia",20,2500,"Mostrador"),
				new Empleado("Esteban",19,7000,"Ventas"),
				new Empleado("Dámaris",32,600,"Telemarketing"),
				new Empleado("Lina",25,2500,"Mostrador"),
				new Empleado("Nayeli",44,10000,"Ventas"),
				new Empleado("Flor",35,7000,"Compras"),
				new Empleado("German",20,1500,"Facturacion"),
				new Empleado("Maica",25,2750,"Mostrador"));
		System.out.println("Lista de empelados");
		listaEmpleados.forEach(System.out::println);
				
		System.out.println("Empelados mayors de 25 años de Ventas ");
		bp = ((edad,departamento)->{
			if(edad>=25 && departamento.equals("Ventas") )
				return true;
			else
				return false;
		});
		eva = new Evaluator();
		listaNueva = eva.evaluar(listaEmpleados, bp);
		listaNueva.forEach(System.out::println);
		
		System.out.println("Empelados mayors de 25 años de Mostrador ");
		bp = ((edad,departamento)->{
			if(edad>=25 && departamento.equals("Mostrador") )
				return true;
			else
				return false;
		});
		eva = new Evaluator();
		listaNueva = eva.evaluar(listaEmpleados, bp);
		listaNueva.forEach(System.out::println);
		
		System.out.println("Empelados mayors de 25 años de Ventas o Mostrador");
		bp = ((edad,departamento)->{
			if(edad>=25 && (departamento.equals("Mostrador") ||departamento.equals("Ventas") ))
				return true;
			else
				return false;
		});
		eva = new Evaluator();
		listaNueva = eva.evaluar(listaEmpleados, bp);
		listaNueva.forEach(System.out::println);	
	}
}

