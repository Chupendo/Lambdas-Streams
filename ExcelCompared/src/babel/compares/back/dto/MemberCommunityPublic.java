package babel.compares.back.dto;

import java.util.List;
import java.util.Objects;

public class MemberCommunityPublic extends MemberCommunity implements Comparable<Object> {

	// private Integer codEmployed;
	// private String name;
	// private String office;
	// private String category;
	// private String rol;
	// private String level;
	// private List<String> codeProject;
	// private List<String> project;
	private List<Integer> codResponsable;
	// private List<String> responsable;
	// private List<String> technology;
	// private List<String> certification;
	// private boolean low;

	// Constructors
	public MemberCommunityPublic() {
		super();
	}

	public MemberCommunityPublic(MemberCommunityPublic m) {
		super(m);
		// this.codEmployed = m.getCodEmployed();// codEmployed;
		// this.name = m.getName(); // name
		// this.office = m.getOffice(); // office;
		// this.category = m.getCategory(); // category;
		// this.rol = m.getRol(); // rol;
		// this.level = m.getLevel(); // level;
		// this.codeProject = m.getCodeProject(); // codeProject;
		// this.project = m.getProject(); // project;
		this.codResponsable = m.getCodResponsable(); // codResponsable;
		// this.responsable = m.getResponsable(); // responsable;
		// this.technology = m.getTechnology(); // technology;
		// this.certification = m.getCertification(); // certification;
		// this.low = m.isLow(); // low;
	}

	public MemberCommunityPublic(Integer codEmployed, String name, String office, String category, String rol,
			String level, List<String> codeProject, List<String> project, List<Integer> codResponsable,
			List<String> responsable, List<String> technology, List<String> certification, boolean low) {
		super(codEmployed, name, office, category, rol, level, codeProject, project, responsable, technology,
				certification, low);
		// this.codEmployed = codEmployed;
		// this.name = name;
		// this.office = office;
		// this.category = category;
		// this.rol = rol;
		// this.level = level;
		// this.codeProject = codeProject;
		// this.project = project;
		this.codResponsable = codResponsable;
		// this.responsable = responsable;
		// this.technology = technology;
		// this.certification = certification;
		// this.low = low;
	}

	/* hashCode, equal & toSTring */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(codResponsable);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		// mismo objeto?
		if (this == obj) {// Si
			return true;
		}

		// Objeto de la clase MemberCommunityManager?
		if (obj instanceof MemberCommunityManager) {// Si
			// Campos comunes iguales?
			if (super.equals(obj)) {// Si
				return true;
			}
		}

		// Objeto de la clase PersonDigitalCenters?
		//fields:: nº empleado, nombre, oficina, comunidad tecnologíaca (categoria), rol, nivel
		if (obj instanceof PersonDigitalCenters) {// Si
			PersonDigitalCenters other = (PersonDigitalCenters) obj;
			return  Objects.equals(getCodEmployed(), other.getCodEmployed())
					&& Objects.equals(getName(), other.getName()) && Objects.equals(getOffice(), other.getOffice())
					&& Objects.equals(getCategory(), other.getTechnologyComunity())
					&& Objects.equals(getRol(), other.getRol()) && Objects.equals(getLevel(), other.getDrefyfusLevel());
		}

		// Objecto de la misma clase?
		if (obj instanceof MemberCommunityPublic) {// Si
			// Campos coamunes diferentes?
			if (!super.equals(obj)) {// Si
				return false;
			} else {// No, son iguales, ¿campos especificoas de la case iguales? Si->True, No->False
				MemberCommunityPublic other = (MemberCommunityPublic) obj;
				return Objects.equals(codResponsable, other.codResponsable);
			}
		}

		// Resto de casos -> False
		return false;
	}

	@Override
	public String toString() {
		return "MemberCommunityPublic [" + super.toString() + " codResponsable=" + codResponsable + "]";
	}

	/* Getters && Setters */
	public List<Integer> getCodResponsable() {
		return codResponsable;
	}

	public void setCodResponsable(List<Integer> codResponsable) {
		this.codResponsable = codResponsable;
	}

	/*
	 * compareTo() method Compare the field "code emploeyed" of this class object
	 * (x) with other class specific objects (o) given as parameter. It returns the
	 * value: 0: if (x==o) -1: if (x < o) 1: if (x > o)
	 */
	@Override
	public int compareTo(Object o) {
		MemberCommunityPublic otra = (MemberCommunityPublic) o;
		return this.getCodEmployed().compareTo(otra.getCodEmployed());
	}

}
