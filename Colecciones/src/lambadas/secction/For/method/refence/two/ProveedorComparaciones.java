package lambadas.secction.For.method.refence.two;

public class ProveedorComparaciones {
	public int comporadorPorNomber(Persona p1, Persona p2) {
		return p1.getName().compareTo(p2.getName());
	}
	
	public int comparadorPorEdad(Persona p1, Persona p2) {
		return p1.getEdad()-p2.getEdad();
	}
}
