package lambdas.secction.three.comparator.one;

import java.util.Objects;

public class Persona implements Comparable<Persona>{
	private int id;
	private String nombre;
	
	public Persona(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(id, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Persona)) {
			return false;
		}
		Persona other = (Persona) obj;
		return id == other.id && Objects.equals(nombre, other.nombre);
	}

	@Override
	public int compareTo(Persona o) {
		if(this.id>o.getId()) {
			return 1;
		}
		if(this.id<o.getId()) {
			return -1;
		}
		return 0;
		
		// Mas eficiente:  -num si o1 < o2, +num si o1 > 02, 0 si o1=o2 
		//return this.id - o.getId();
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + "]";
	}
}
