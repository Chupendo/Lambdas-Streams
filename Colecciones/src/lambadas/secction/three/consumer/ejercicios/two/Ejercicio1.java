package lambadas.secction.three.consumer.ejercicios.two;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Ejercicio1 {

	public static void main(String[] args) {
		List<Estudiante> lestudiantes = new ArrayList<Estudiante>();
		lestudiantes.add(new Estudiante("John",6));
		lestudiantes.add(new Estudiante("Mark",5));
		lestudiantes.add(new Estudiante("Felix",5));
		lestudiantes.add(new Estudiante("Patrick",6));
		lestudiantes.add(new Estudiante("Jamex",3));
		lestudiantes.add(new Estudiante("Peter",10));
		lestudiantes.add(new Estudiante("James",5));
		lestudiantes.add(new Estudiante("Magdala",7));
		lestudiantes.add(new Estudiante("Javier",7));
		lestudiantes.add(new Estudiante("Amanda",8));
		lestudiantes.add(new Estudiante("Olivia",9));
		lestudiantes.add(new Estudiante("Cinthia",10));
		lestudiantes.add(new Estudiante("Arturo",2));
		lestudiantes.add(new Estudiante("Mancera",5));
		lestudiantes.add(new Estudiante("Abdlas",10));
		
		OperacionesEstudiantes op = new OperacionesEstudiantes();
		//Muestra por pantalla los estuidnates que recibe
		System.out.println("Lista de estudiantes ");
		Consumer<Estudiante> cons1 = e -> System.out.println(e.toString());
		op.aceptarTodos(cons1, lestudiantes);
		
		//Incrementa la calificacion un 15%
		System.out.println("Califaicones incrementas un 15%: ");
		Consumer<Estudiante> cons2 = e -> e.setCalificacion(e.getCalificacion()*1.15);
		op.aceptarTodos(cons2, lestudiantes);
		op.aceptarTodos(cons1, lestudiantes);
	}
}
