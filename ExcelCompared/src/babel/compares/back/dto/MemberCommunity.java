package babel.compares.back.dto;

import java.util.List;
import java.util.Objects;

public class MemberCommunity {
	// Employed Code (Código dej empleado)
	private Integer codEmployed;
	// Employed Name (Nombre del empleado)
	private String name;
	// Employed Office (Oficina del empleado)
	private String office;
	// Employed Category(Categoría del empleado)
	private String category;
	// Main Rol (Rol principal)
	private String rol;
	// Level D (Nivel D)
	private String level;
	// Project Code (Código del proyecto)
	private List<String> codeProject;
	// Project (Proyecto)
	private List<String> project;
	// Manager (Responsable)
	private List<String> responsable;
	// Tecnology/Ability (Tenología/Habilidad)
	private List<String> technology;
	// Certificiacion (Certificacion)
	private List<String> certification;
	// Low (Baja)
	private boolean low;

	public MemberCommunity() {
		// TODO Auto-generated constructor stub
	}
	
	public MemberCommunity(Integer codEmployed, String name, String office, String category, String rol, String level,
			List<String> codeProject, List<String> project, List<String> responsable, List<String> technology,
			List<String> certification, boolean low) {
		this.codEmployed = codEmployed;
		this.name = name;
		this.office = office;
		this.category = category;
		this.rol = rol;
		this.level = level;
		this.codeProject = codeProject;
		this.project = project;
		this.responsable = responsable;
		this.technology = technology;
		this.certification = certification;
		this.low = low;
	}
	
	public MemberCommunity(MemberCommunity m) {
		this.codEmployed = m.getCodEmployed();
		this.name = m.getName();
		this.office = m.getOffice();
		this.category = m.getCategory();
		this.rol = m.getRol();
		this.level = m.getLevel();
		this.codeProject = m.getCodeProject();
		this.project = m.getProject();
		this.responsable = m.getResponsable();
		this.technology = m.getTechnology();
		this.certification = m.getCertification();
		this.low = m.isLow();
	}

	// Casting MemberCommunityPublic to MemberCommunity, this method add only
	// commons fields
	public MemberCommunity(MemberCommunityPublic m) {
		this.codEmployed = m.getCodEmployed();
		this.name = m.getName();
		this.office = m.getOffice();
		this.category = m.getCategory();
		this.rol = m.getRol();
		this.level = m.getLevel();
		this.codeProject = m.getCodeProject();
		this.project = m.getProject();
		this.responsable = m.getResponsable();
		this.technology = m.getTechnology();
		this.certification = m.getCertification();
		this.low = m.isLow();
	}

	// Casting MemberCommunityManager to MemberCommunity, this method add only
	// commons fields
	public MemberCommunity(MemberCommunityManager m) {
		this.codEmployed = m.getCodEmployed();
		this.name = m.getName();
		this.office = m.getOffice();
		this.category = m.getCategory();
		this.rol = m.getRol();
		this.level = m.getLevel();
		this.codeProject = m.getCodeProject();
		this.project = m.getProject();
		this.responsable = m.getResponsable();
		this.technology = m.getTechnology();
		this.certification = m.getCertification();
		this.low = m.isLow();
	}

	//Methods Getters && Setters
	public Integer getCodEmployed() {
		return codEmployed;
	}

	public void setCodEmployed(Integer codEmployed) {
		this.codEmployed = codEmployed;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public List<String> getCodeProject() {
		return codeProject;
	}

	public void setCodeProject(List<String> codeProject) {
		this.codeProject = codeProject;
	}

	public List<String> getProject() {
		return project;
	}

	public void setProject(List<String> project) {
		this.project = project;
	}

	public List<String> getResponsable() {
		return responsable;
	}

	public void setResponsable(List<String> responsable) {
		this.responsable = responsable;
	}

	public List<String> getTechnology() {
		return technology;
	}

	public void setTechnology(List<String> technology) {
		this.technology = technology;
	}

	public List<String> getCertification() {
		return certification;
	}

	public void setCertification(List<String> certification) {
		this.certification = certification;
	}

	public boolean isLow() {
		return low;
	}

	public void setLow(boolean low) {
		this.low = low;
	}

	@Override
	public int hashCode() {
		return Objects.hash(category, certification, codEmployed, codeProject, level, low, name, office, project,
				responsable, rol, technology);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof MemberCommunity)) {
			return false;
		}
		MemberCommunity other = (MemberCommunity) obj;
		return Objects.equals(category, other.category) && Objects.equals(certification, other.certification)
				&& Objects.equals(codEmployed, other.codEmployed) && Objects.equals(codeProject, other.codeProject)
				&& Objects.equals(level, other.level) && low == other.low && Objects.equals(name, other.name)
				&& Objects.equals(office, other.office) && Objects.equals(project, other.project)
				&& Objects.equals(responsable, other.responsable) && Objects.equals(rol, other.rol)
				&& Objects.equals(technology, other.technology);
	}

	@Override
	public String toString() {
		return "codEmployed=" + codEmployed + ", name=" + name + ", office=" + office + ", category="
				+ category + ", rol=" + rol + ", level=" + level + ", codeProject=" + codeProject + ", project="
				+ project + ", responsable=" + responsable + ", technology=" + technology + ", certification="
				+ certification + ", low=" + low ;
	}

	
	
	
	
}
