package lambadas.secction.three.consumer.ejercicios.two;

import java.util.List;
import java.util.function.Consumer;

public class OperacionesEstudiantes {
	public void aceptarTodos(Consumer<Estudiante> cons, List<Estudiante> estudiantes){
		for(Estudiante estudiante:estudiantes) {
			cons.accept(estudiante);
		}
	}
}
