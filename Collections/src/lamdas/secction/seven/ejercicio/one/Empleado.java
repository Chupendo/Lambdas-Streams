package lamdas.secction.seven.ejercicio.one;

import java.util.ArrayList;
import java.util.List;

public class Empleado {
	private long id;
	private String nombre;
	private double ingresos;
	private Genero genero;
	private int edad;
		
	public Empleado(long id, String nombre, double ingresos, Genero genero, int edad) {
		this.id = id;
		this.nombre = nombre;
		this.ingresos = ingresos;
		this.genero = genero;
		this.edad = edad;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getIngresos() {
		return ingresos;
	}
	public void setIngresos(double ingresos) {
		this.ingresos = ingresos;
	}
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public static List<Empleado> empleados(){
		List<Empleado> lEmplados = new ArrayList<Empleado>();
		lEmplados.add(new Empleado(0, "Andres", 24500.2,Genero.HOMBRE, 30));
		lEmplados.add(new Empleado(0, "Ruth", 25300.5,Genero.MUJER, 35));
		lEmplados.add(new Empleado(0, "Ramon", 16528,Genero.HOMBRE, 18));
		lEmplados.add(new Empleado(0, "Paola", 22500,Genero.MUJER, 24));
		lEmplados.add(new Empleado(0, "Andres", 35000,Genero.HOMBRE, 24));
		
		return lEmplados;

	}
	
	public boolean esHombre() {
		return this.genero == Genero.HOMBRE;
	}
	
	public boolean esMujer() {
		return this.genero == Genero.MUJER;
	}
	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", ingresos=" + ingresos + ", genero=" + genero + ", edad="
				+ edad + "]";
	}	
	
	
}
