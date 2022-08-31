package lambadas.secction.three.consumer.ejercicios.two;

public class Estudiante {
	private String nombre;
	private double calificacion;
	
	public Estudiante(String nom, double cal) {
		this.nombre = nom;
		this.calificacion = cal;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}

	@Override
	public String toString() {
		return "Estudiante [nombre=" + nombre + ", calificacion=" + calificacion + "]";
	}
	
	
}
