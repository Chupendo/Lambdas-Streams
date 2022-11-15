package lambadas.secction.three.comparator.one;

import java.util.Comparator;

public class OrdenarPersonaByNombre implements Comparator<Persona> {

	@Override
	public int compare(Persona o1, Persona o2) {
		if(o1 instanceof Persona && o2 instanceof Persona) {
			return o1.getNombre().compareTo(o2.getNombre());
		}
		return 0;
	}
}
